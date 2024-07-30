package com.test.api.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.api.model.MemberDTO;
import com.test.api.model.PatientDTO;
import com.test.api.model.PrescriptDTO;
import com.test.api.model.PrescriptDetailDTO;
import com.test.api.service.MyPharmService;
import com.test.api.service.MyprescriptDetailService;
import com.test.api.service.MyprescriptService;
import com.test.api.service.PatientService;

@Controller
public class PrescriptDetailController {

	@Autowired
	PatientService patientService;
	
	@Autowired
	MyprescriptService prescriptService;
	
	@Autowired
	MyprescriptDetailService prescriptDetailService;
	
	@Autowired
	MyPharmService mypharmService;
	
	
	@GetMapping("/modifyprescript")
	public void getPrescript_detail(@RequestParam("prescriptionID") int prescriptionID,Model model ) {
		model.addAttribute("prescript",prescriptService.getPrescript(prescriptionID));
		model.addAttribute("prescriptDetail", prescriptDetailService.prescriptList(prescriptionID));
	}
	
	@GetMapping("/delprescript")
	public String delPrescript(@RequestParam("prescriptionID") int prescriptionID) {
		prescriptService.delPrescript(prescriptionID);
		return"redirect:/prescript";
	}
	
	@PostMapping("/insertprescript")
	public String insertPrescript(@RequestParam("mediID[]") int[] mediID, @RequestParam("itemName[]") String[] itemName,@RequestParam("pd[]") int[] perDays,@RequestParam("td[]") int[] totalDays,
			@RequestParam("patientName") String patientName,@RequestParam("SSN") String SSN,@RequestParam("phoneNum") String phoneNum,
			@RequestParam("prescribingInstitution")String prescribingInstitution,@RequestParam("prescribingDoctor")String prescribingDoctor,
			@RequestParam("pharmacistName")String pharmacistName,@RequestParam("prescriptedDate")int prescriptedDate,
			HttpSession session) {
		System.out.println("check info"+patientName);
		System.out.println("check info"+SSN);
		System.out.println("check info"+phoneNum);
		System.out.println("check info"+prescribingInstitution);
		System.out.println("check info"+prescribingDoctor);
		System.out.println("check info"+pharmacistName);
		System.out.println("check info"+prescriptedDate);
		int maxNum = 0;
		for(int med : mediID) {
			System.out.println("mediId check"+med);
		}
		for(String med : itemName) {
			System.out.println("mediname check"+med);
		}
		for(int med : perDays) {
			System.out.println("medipd check"+med);
		}
		for(int med : totalDays) {
			System.out.println("meditd check"+med);
			maxNum= Math.max(maxNum, med);
		}
		
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member_info");
		
		PatientDTO patient = patientService.getPatientBySSN(SSN);
		if (patient==null) {
			PatientDTO patient_ = new PatientDTO();
			patient_.setMemberName(patientName);
			patient_.setPhoneNum(phoneNum);
			patient_.setSsn(SSN);
			patientService.registerPatient(patient_);
			patient = patientService.getPatientBySSN(SSN);
		}
		System.out.println("멤버체크"+memberDTO.toString());
		PrescriptDTO prescriptDTO = new PrescriptDTO(patient.getMemberName(), patient.getSsn(),prescribingInstitution, prescribingDoctor, pharmacistName, prescriptedDate, memberDTO.getMemberNum());
		int prescriptId = prescriptService.insertPrescipt(prescriptDTO);
		
		for(int i = 0; i<mediID.length; i++) {
			
			int mid = mediID[i];
			String mn = itemName[i];
			int perD = perDays[i];
			int totD = totalDays[i];
			PrescriptDetailDTO pdd = new PrescriptDetailDTO(prescriptId, mid, mn, perD, totD);
			prescriptDetailService.insertPrescriptDetail(pdd);
			mypharmService.subtractMed(mid,perD*totD);
		}
		
		return "redirect:/prescript";
	}
}
