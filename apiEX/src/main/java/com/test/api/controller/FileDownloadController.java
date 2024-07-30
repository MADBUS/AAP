package com.test.api.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.net.http.HttpHeaders;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.test.api.model.MemberDTO;
import com.test.api.model.WaitForExpertDTO;
import com.test.api.service.MemberService;

@Controller
public class FileDownloadController {
    
	private final String uploadFolder = "C:\\test\\upload";
    
	@Autowired
	MemberService memberService;
	
    @GetMapping("waitforexpert")
    public void waitforexpert(Model model) {
    	System.out.println("waitforexpert 여기 안들어오나?");
    	model.addAttribute("waitforexpertlist", memberService.waitforexpertList());
    }
    
    @GetMapping("/download")
    public void downloadFile(@RequestParam("fileName") String fileName, @RequestParam("originalFileName") String originalFileName, HttpServletResponse response, HttpServletRequest request) throws IOException {
    	// globals.properties
    	  File file = new File(uploadFolder, fileName+".jpeg");
    	  BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));

    	  //User-Agent : 어떤 운영체제로  어떤 브라우저를 서버( 홈페이지 )에 접근하는지 확인함
    	  String header = request.getHeader("User-Agent");
    	  String fileName_;

    	  if ((header.contains("MSIE")) || (header.contains("Trident")) || (header.contains("Edge"))) {
    	    //인터넷 익스플로러 10이하 버전, 11버전, 엣지에서 인코딩 
    	    fileName_ = URLEncoder.encode(originalFileName, "UTF-8");
    	  } else {
    	    //나머지 브라우저에서 인코딩
    	    fileName_ = new String(originalFileName.getBytes("UTF-8"), "iso-8859-1");
    	  }
    	  //형식을 모르는 파일첨부용 contentType
    	  response.setContentType("application/octet-stream");
    	  //다운로드와 다운로드될 파일이름
    	  response.setHeader("Content-Disposition", "attachment; filename=\""+ fileName+".jpeg" + "\"");
    	  //파일복사
    	  FileCopyUtils.copy(in, response.getOutputStream());
    	  in.close();
    	  response.getOutputStream().flush();
    	  response.getOutputStream().close();
    }
    
    


	public String jasyptEncoding(String value) {
		String Key = "security";
		StandardPBEStringEncryptor pbeEnc = new StandardPBEStringEncryptor();
		pbeEnc.setAlgorithm("PBEWithMD5AndDES");
		pbeEnc.setPassword(Key);
		return pbeEnc.encrypt(value);

	}
}
