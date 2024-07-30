package com.test.api.controller;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.inject.Inject;
import javax.mail.internet.MimeMessage;
import javax.naming.Context;
import javax.naming.NameParser;
import javax.naming.NamingException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.test.api.model.KaKaoOauthResponse;
import com.test.api.model.KaKaoTokenResponse;
import com.test.api.model.KakaoEmailDTO;
import com.test.api.model.KakaoUserResponse;
import com.test.api.model.MemberDTO;
import com.test.api.model.MemberType;
import com.test.api.model.MypharmDTO;
import com.test.api.model.WaitForExpertDTO;
import com.test.api.service.KakaoService;
import com.test.api.service.MemberService;
import com.test.api.service.MyPharmService;
import com.test.api.service.WaitForExpertService;

import lombok.Data;
import lombok.extern.log4j.Log4j;
import net.nurigo.sdk.NurigoApp;
import net.nurigo.sdk.message.exception.NurigoMessageNotReceivedException;
import net.nurigo.sdk.message.model.Message;
import net.nurigo.sdk.message.service.DefaultMessageService;

@Controller
@Log4j
public class KakaoLoginController {

	
	private boolean isLogin = false; // 로그인 상태를 나타내는 변수

	@Autowired
	JavaMailSenderImpl mailSender;
	
	@Autowired
	WaitForExpertService waitForExpertService;

	@Autowired
	MyPharmService mypharmService;
	
	@Autowired
	KakaoService kakaoService;

	@Autowired
	MemberService memberService;

	@GetMapping("/loginkakao")
	public void loginkakao() {
	}

	@GetMapping("/login")
	public void login() {
	}

	@GetMapping("/register")
	public void register() {
	}

	@GetMapping("/oauth")
	public String oauthResult(KaKaoOauthResponse response, Model model, HttpSession session,
			RedirectAttributes redirectAttributes) throws NamingException {
		log.info("이거null임?" + response.getCode());

		KaKaoTokenResponse token = kakaoService.getToken(response);

		if (token != null && token.getAccess_token() != null) {
			// 토큰 정상 발급
			isLogin = true;

			// 사용자 정보 가져오기

			KakaoUserResponse userInfo = kakaoService.getUserInfo(token.getAccess_token());
			String kakaoEmail = userInfo.getKakao_account().getEmail();

			System.out.println("이메일 체크" + kakaoEmail);

			Boolean check = memberService.isMem(kakaoEmail);
			System.out.println("컨트롤러 ismem 체크" + check);

			if (check) {

				System.out.println("이거 유저 인포임:" + userInfo.getId());
				if (userInfo != null) {
					session.setAttribute("userInfo", userInfo);
					log.info("사용자 정보: " + userInfo);
				}
				model.addAttribute("kakaoEmail", kakaoEmail);
				session.setAttribute("isLogin", isLogin);
				session.setAttribute("kakaoEmail", kakaoEmail);
				MemberDTO memberDto = memberService.getMember(kakaoEmail);
				session.setAttribute("member_info", memberDto);
				System.out.println("얘네 멤버타입 받아옴?" + memberDto);
				/*
				 * context.bind("kakaoEmail", kakaoEmail);
				 * if(context.getNameParser("kakaoEmail")!=null) { NameParser kakao =
				 * context.getNameParser("kakaoEmail"); log.info("test>>>>>>>"+kakao); }
				 */

				log.info("사용자 로그인성공");
				session.setAttribute("membertype", memberDto.getMemberType());

				redirectAttributes.addFlashAttribute("message", "로그인 성공");
				System.out.println(token);
				/*
				 * DefaultMessageService messageService =
				 * NurigoApp.INSTANCE.initialize("NCSGZXZLKLWSHU08",
				 * "GGEZ6IIHKXSUSAMD1BQBRFNL1VZ9UP48", "https://api.coolsms.co.kr"); // Message
				 * 패키지가 중복될 경우 net.nurigo.sdk.message.model.Message로 치환하여 주세요 Message message =
				 * new Message(); message.setFrom("01043731710"); message.setTo("01043731710");
				 * message.setText("유통기한이 임박한 약 목록입니다."); // message.setSubject("문자 제목 입력"); //
				 * LMS, MMS 전용 옵션, SMS에서 해당 파라미터 추가될 경우 자동으로 // LMS로 변환됩니다!
				 * 
				 * try { // send 메소드로 ArrayList<Message> 객체를 넣어도 동작합니다!
				 * messageService.send(message); } catch (NurigoMessageNotReceivedException
				 * exception) { // 발송에 실패한 메시지 목록을 확인할 수 있습니다!
				 * System.out.println(exception.getFailedMessageList());
				 * System.out.println(exception.getMessage()); } catch (Exception exception) {
				 * System.out.println(exception.getMessage()); }
				 */
				
							List<MypharmDTO> list=mypharmService.ListDue(memberDto.getMemberNum());
							
							
							String setfrom = "pyun9704@gmail.com";
							String tomail = "pyun9704@gmail.com"; // 받는사람
							String title = "[AAP]유통기한이 임박한 약들 입니다.";
							
							String content = System.getProperty("line.separator") + "안녕하세요 회원님";
									
							for(MypharmDTO med : list) {
								content+=System.getProperty("line.separator")+med.toString();
							}
									

							try {
								MimeMessage message = mailSender.createMimeMessage();
								MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "utf-8");

								messageHelper.setFrom(setfrom);
								messageHelper.setTo(tomail);
								messageHelper.setSubject(title);
								messageHelper.setText(content);

								mailSender.send(message);
							} catch (Exception e) {
								System.out.println(e.getMessage());
							}

					
			} else {
				session.setAttribute("kakaoEmail", kakaoEmail);
				return "redirect:/register";
			}
		} else {
			log.info("로그인 실패");
			session.setAttribute("isLogin", isLogin);
			redirectAttributes.addFlashAttribute("error", "로그인 실패");
		}
		return "redirect:/login";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		isLogin = false;
		System.out.println("로그아웃 안됨?");
		session.invalidate();
		return "redirect:/login";
	}
	
	
}