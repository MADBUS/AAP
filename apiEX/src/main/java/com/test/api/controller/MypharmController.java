package com.test.api.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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

@Controller
public class MypharmController {

	private final String MYPHARM = "redirect:/mypharm";

	@Autowired
	private MyPharmService mypharm;

	@GetMapping("/NewFile")
	public void newFile() {
		System.out.println("newfile 잡기");
	}

	@GetMapping("/mypharm")
	public void myPharm(Model model, HttpSession session) {
		MemberDTO memberDto = (MemberDTO) session.getAttribute("member_info");
		List<MypharmDTO> list = mypharm.myPharmList(memberDto.getMemberNum());
		System.out.println(list.toString());
		model.addAttribute("myPharm", list);
	}

	@GetMapping("/mypharmsearch")
	public void myPharmSearch(HttpSession session, Model model, @RequestParam("itemName") String itemName) {
		System.out.println("controller 에 itemName 찍힘" + itemName);
		List<MypharmDTO> list = mypharm.searchedMedi(itemName);
		System.out.println("controller 의 반환 체크" + list.toString());
		model.addAttribute("searchedMedi", list);

	}

	@GetMapping("/deletemedi")
	public String delamountPharm(HttpSession session, @RequestParam("mediID") int mediID) {

		System.out.println(mediID);
		mypharm.delPharm(mediID);
		return MYPHARM;
	}

	@GetMapping("/modifymed")
	public void getMedInfo(HttpSession session, Model model, @RequestParam("mediID") int mediID) {
		System.out.println("컨트롤러 MediID:" + mediID);
		MypharmDTO DTO = mypharm.getByMediID(mediID);
		model.addAttribute("medi", DTO);
	}

	@GetMapping("/modsuccess")
	public String modMedInfo(HttpSession session, @RequestParam("dueDate") String dueDate,
			@RequestParam("amount") int amount, @RequestParam("mediID") int mediID) {
		System.out.println("dueDate개같이 찍히냐?" + dueDate);
		mypharm.modMedInfo(dueDate, amount, mediID);
		return MYPHARM;
	}

	@PostMapping("/addPharm")
	public String addPharm(HttpServletRequest request,HttpSession session) {
		String entpName = request.getParameter("entpName");
		String itemName = request.getParameter("itemName");
		String itemSeq = request.getParameter("itemSeq");
		String date_ = request.getParameter("dueDate");
		System.out.println("날짜 뭘로 찍히나?:" + date_);
		String amount_ = request.getParameter("amount");
		int amount = Integer.parseInt(amount_);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
		String itemSeq_ = itemSeq.trim();
		MemberDTO memberDto = (MemberDTO)session.getAttribute("member_info");
		List<MypharmDTO> list = mypharm.getBySeq(itemSeq_,memberDto.getMemberNum());
		System.out.println("리스트 체크"+ list.toString());
		Date date = null;
		try {
			date = formatter.parse(date_);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (list.size()==0) {
			
			MypharmDTO mypharmDTO = new MypharmDTO(itemSeq_, itemName, entpName, date, amount);
			mypharmDTO.setMemberNum(memberDto.getMemberNum());
			mypharm.addPharm(mypharmDTO);
			System.out.println("당연히 이것도 널이겠지:" + entpName);
		}else {
			for (MypharmDTO dto : list) {
			System.out.println("list체크"+dto.toString());
			
		
				System.out.println("날짜체크" + dto.getDueDate());
				System.out.println("날짜체크 2" + date);
				if (date.equals(dto.getDueDate())) {
					System.out.println("여기안들어가지?");
					mypharm.addAmount(itemSeq_, amount);
				} else {
					MypharmDTO mypharmDTO = new MypharmDTO(itemSeq_, itemName, entpName, date, amount);
					mypharmDTO.setMemberNum(memberDto.getMemberNum());
					mypharm.addPharm(mypharmDTO);
				}
			}
		}
		return"redirect:/mypharm";
}

}
