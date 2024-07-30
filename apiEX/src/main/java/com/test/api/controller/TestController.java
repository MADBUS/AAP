package com.test.api.controller;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.api.model.MedicieResponse;
import com.test.api.model.MypharmDTO;
import com.test.api.service.MyPharmService;
import com.test.api.service.TestService;

@Controller
public class TestController {

	@Autowired
	private TestService testService;

	@Autowired
	private MyPharmService mypharm;

	@RequestMapping(value = "/medisearch", method = RequestMethod.GET)
	public String wholelist(Model model) {
		System.out.println("컨트롤러 체크");
		// Model : 뷰에 데이터를 전달하여 사용자에게 표시하는데 사용 set attribute 랑 비슷(하지만 단타성)
		// model.addAttribute("testData","이거 전달됨?");
		// HttpServletResponse : HTTP 응답을 설정하는데 사용, 상태코드, 헤더, 리다이렉트 등을 설정
		List<MedicieResponse> r = testService.medicineSearch();
		model.addAttribute("testapi", r);

		return "medisearch"; // test.jsp 로 이동
	}

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String testlist(Model model) {
		System.out.println("컨트롤러 체크");
		// Model : 뷰에 데이터를 전달하여 사용자에게 표시하는데 사용 set attribute 랑 비슷(하지만 단타성)
		// model.addAttribute("testData","이거 전달됨?");
		// HttpServletResponse : HTTP 응답을 설정하는데 사용, 상태코드, 헤더, 리다이렉트 등을 설정
		MedicieResponse r = TestService.apiTest();
		model.addAttribute("testapi", r);
		return "test"; // test.jsp 로 이동
	}

	@ResponseBody
	@RequestMapping(value = "/medsearch", method = RequestMethod.GET)
	public void medicineSearch(Model model) throws UnsupportedEncodingException {
		System.out.println("컨트롤러 리퀘스트 체크:");

	}

	@ResponseBody // ajax로 호출되는 url 과 매핑된 경우 필수로 작성
	@RequestMapping(value = "/ajaxTest", method = RequestMethod.GET)
	public MedicieResponse ajaxTest() {
		System.out.println("ajax 버튼 클릭시 컨트롤러 이동");
		return testService.apiTest();
	}

	@GetMapping("/addmedi")
	public void addmedi(@RequestParam String entpName, @RequestParam String itemName, @RequestParam String itemSeq,
			@RequestParam String efcyQesitm, @RequestParam String useMethodQesitm, @RequestParam String intrcQesitm,
			@RequestParam String seQesitm, @RequestParam String depositMethodQesitm, @RequestParam String itemImage,
			@RequestParam String bizrno, Model model) {

		System.out.println("이거설마 %@%@ 찍힘? " + entpName);

		model.addAttribute("entpName", entpName).addAttribute("itemName", itemName).addAttribute("itemSeq", itemSeq)
				.addAttribute("efcyQesitm", efcyQesitm).addAttribute("useMethodQesitm", useMethodQesitm)
				.addAttribute("intrcQesitm", intrcQesitm).addAttribute("seQesitm", seQesitm)
				.addAttribute("depositMethodQesitm", depositMethodQesitm).addAttribute("itemImage", itemImage)
				.addAttribute("bizrno", bizrno);

	}

	/*
	 * @GetMapping("/addmedi/view") public String addmediView(@RequestParam String
	 * entpName,
	 * 
	 * @RequestParam String itemName,
	 * 
	 * @RequestParam String itemSeq, Model model) {
	 * System.out.println("GET 요청 받음, 업체명: " + entpName);
	 * model.addAttribute("entpName", entpName); model.addAttribute("itemName",
	 * itemName); model.addAttribute("itemSeq", itemSeq); return
	 * "redirect:/addmedi"; // Return the name of the view template }
	 */

	

}
