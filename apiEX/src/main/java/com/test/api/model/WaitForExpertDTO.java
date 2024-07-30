package com.test.api.model;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class WaitForExpertDTO {
	
	private int waitForExpertId;
	private int memberNum;
	private String memberName;
	private String fileName;
	private String fileType;
	private String uniqueName;
	private Timestamp created_at;
	
	


	public WaitForExpertDTO(int memberNum, String memberName, String fileName, String fileType, String uniqueName) {
		super();
		this.memberNum = memberNum;
		this.memberName = memberName;
		this.fileName = fileName;
		this.fileType = fileType;
		this.uniqueName = uniqueName;
	}
	
	
}


