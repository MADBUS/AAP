package com.test.api.controller;

import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.map.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.JsonObject;
import com.test.api.model.PatientDTO;
import com.test.api.service.PatientService;

@Controller
public class PatientController {

	@Autowired
	private PatientService patientService; // Assuming you have a service to handle DB operations

	@GetMapping("/lookupPatient")
	@ResponseBody
	public Map<String, Object> lookupPatient(@RequestParam("SSN") String ssn, Model model) {
		Map<String, Object> response = new HashMap<>();
		PatientDTO patient = patientService.getPatientBySSN(ssn);
		if (patient != null) {
			System.out.println("patient찍히냐?" + patient);
			response.put("success", true);
			response.put("memberName", patient.getMemberName());
			response.put("phoneNum", patient.getPhoneNum());
		} else {
			response.put("success", false);
		}
		model.addAttribute("pateint", patient);
		return response;
	}
	
	@PostMapping("/registerpatient")
	@ResponseBody
	public boolean registerPatient(PatientDTO patient) {
		System.out.println("여기는 들어오나?");
		System.out.println("patient 찍어보기"+patient);
		if (patient.getMemberName()==null||patient.getPhoneNum()==null||patient.getSsn()==null) {
			return false;
		}
			patientService.registerPatient(patient);
			return true;
	}
	
}
