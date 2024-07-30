package com.test.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.api.mapper.PatientMapper;
import com.test.api.model.PatientDTO;

@Service
public class PatientService {
	 
	@Autowired
	PatientMapper patientmapper;
	
	 public PatientDTO getPatientBySSN(String ssn) {
		 return patientmapper.findBySSN(ssn);
	 }

	public void registerPatient(PatientDTO patient) {
		patientmapper.registerPatient(patient);
	}
}
