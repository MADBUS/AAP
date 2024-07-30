package com.test.api.controller;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.UUID;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.cj.Session;
import com.test.api.model.MemberDTO;
import com.test.api.model.MemberType;
import com.test.api.model.WaitForExpertDTO;
import com.test.api.service.KakaoService;
import com.test.api.service.MemberService;

@Controller
public class RegisterController {

	@Autowired
	MemberService memberService;


	@Autowired
	KakaoService kakaoService;

	@PostMapping("/user/register")
	public String register(@RequestParam("file") MultipartFile file,
	                       @RequestParam("memberName") String memberName,
	                       @RequestParam("memberAddress") String memberAddress,
	                       @RequestParam("memberPhone") String memberPhone, 
	                       @RequestParam("memberEmail") String memberEmail,
	                       @RequestParam("memberPw") String memberPw,
	                       HttpSession session) {

	    System.out.println("여기에 들어오냐?");
	    MemberDTO dto = new MemberDTO(MemberType.MEMBER, jasyptEncoding(memberPw), memberName, memberAddress, memberPhone, memberEmail);
	    System.out.println("dto체크" + dto.toString());
	    memberService.registerMember(dto);

	    String fileRealName = file.getOriginalFilename(); // 파일명을 얻어낼 수 있는 메서드!
	    long size = file.getSize(); // 파일 사이즈

	    System.out.println("파일명 : " + fileRealName);
	    System.out.println("용량크기(byte) : " + size);
	    
	    // 서버에 저장할 파일이름 fileextension으로 .jsp이런식의 확장자 명을 구함
	    String fileExtension = fileRealName.substring(fileRealName.lastIndexOf("."), fileRealName.length());
	    String uploadFolder = "C:\\test\\upload";
	    
	    UUID uuid = UUID.randomUUID();
	    System.out.println(uuid.toString());
	    String[] uuids = uuid.toString().split("-");

	    String uniqueName = uuids[0];
	    System.out.println("생성된 고유문자열" + uniqueName);
	    System.out.println("확장자명" + fileExtension);
	    
	    MemberDTO mem =	memberService.getMember(memberEmail);
	    WaitForExpertDTO wfeDTO = new WaitForExpertDTO(mem.getMemberNum(), memberName, fileRealName, fileExtension, uniqueName);
	    memberService.upload(wfeDTO);

	    // 파일 업로드 처리
	    File saveFile = new File(uploadFolder + "\\" + uniqueName + fileExtension); // 적용 후
	    try {
	        file.transferTo(saveFile); // 실제 파일 저장메서드(filewriter 작업을 손쉽게 한방에 처리해준다.)
	    } catch (IllegalStateException | IOException e) {
	        e.printStackTrace();
	    }
	    
	    return "redirect:/login";
	}

	@GetMapping("/loginidpw")
	public void idpw() {
	}

	@PostMapping("/loginidpw")
	public String idpwcheck(@RequestParam("memberEmail") String memberEmail, @RequestParam("pw") String pw) {
		Boolean check = memberService.emailPwCheck(memberEmail, pw);
		if (check) {
			System.out.println("로그인된거야? yes");
			return "redirect:/mypharm";
		}
		System.out.println("로그아웃된거야? yes");
		return "redirect:/logout";
	}

	@GetMapping("/applyExpert")
	public void form() {
	}

	@GetMapping("/index")
	public void index() {
	}
	
	
	public String jasyptEncoding(String value) {
		String Key = "security";
		StandardPBEStringEncryptor pbeEnc = new StandardPBEStringEncryptor();
		pbeEnc.setAlgorithm("PBEWithMD5AndDES");
		pbeEnc.setPassword(Key);
		return pbeEnc.encrypt(value);

	}
}
