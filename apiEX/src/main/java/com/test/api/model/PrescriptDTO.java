package com.test.api.model;

import java.util.Date;

import lombok.Data;

@Data
public class PrescriptDTO {
	private int prescriptionID;
	private Date issueDate;
	private String memberName;
	private String ssn;
	private String prescribingInstitution;
	private String prescribingDoctor;
	private String pharmacistName;
	private int prescriptedDate;
	private int expertNum;
	
	public PrescriptDTO(){}
	
	public PrescriptDTO(String memberName, String ssn, String prescribingInstitution, String prescribingDoctor,
			String pharmacistName, int prescriptedDate, int expertNum) {
		super();
		this.memberName = memberName;
		this.ssn = ssn;
		this.prescribingInstitution = prescribingInstitution;
		this.prescribingDoctor = prescribingDoctor;
		this.pharmacistName = pharmacistName;
		this.prescriptedDate = prescriptedDate;
		this.expertNum = expertNum;
	}
	
	
	
}
