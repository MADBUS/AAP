package com.test.api.mapper;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.test.api.model.PatientDTO;

public interface PatientMapper {
	
	@Select ("SELECT * FROM patient WHERE ssn LIKE #{ssn}")
	public PatientDTO findBySSN(String ssn);

	public void registerPatient(PatientDTO patient);
	
	
}
