package com.test.api.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.api.model.MemberDTO;
import com.test.api.model.MypharmDTO;
import com.test.api.service.MyPharmService;
import com.test.api.service.MyprescriptService;

@Controller
public class MyprescriptController {
	
	@Autowired
	private MyPharmService mypharmService;
	
	@Autowired
	private MyprescriptService myprescript; 
	
	
	@GetMapping("/prescript")
	public void prescrptList(Model model, HttpSession session) {
		MemberDTO memberDto = (MemberDTO)session.getAttribute("member_info");
		model.addAttribute("prescriptList",myprescript.prescriptList(memberDto.getMemberNum()));
	}
	
	@GetMapping("/writeprescript")
	public void registerprescript(Model model, HttpSession session) {
		MemberDTO memberDto = (MemberDTO)session.getAttribute("member_info");
		model.addAttribute("myPharm",mypharmService.myPharmList(memberDto.getMemberNum()));
	}
	
	@PostMapping("/controller")
	public String handleFormSubmit(@RequestParam("name[]") String[] names, @RequestParam("age[]") String[] ages) {
		for (int i = 0; i < names.length; i++) {
			System.out.println("Name: " + names[i] + ", Age: " + ages[i]);
	// 데이터베이스에 저장하거나 다른 로직 수행
		}
		return "success";
	}

	
}
