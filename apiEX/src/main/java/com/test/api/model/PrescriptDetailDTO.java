package com.test.api.model;

import lombok.Data;

@Data
public class PrescriptDetailDTO {
	private int prescriptionDetailID;
	private int prescriptionID;
	private int mediID;
	private String itemName;
	private int perDays;
	private int totalDays;
	
	public PrescriptDetailDTO() {}

	public PrescriptDetailDTO(int prescriptionID, int mediID, String itemName, int perDays, int totalDays) {
		super();
		this.prescriptionID = prescriptionID;
		this.mediID = mediID;
		this.itemName = itemName;
		this.perDays = perDays;
		this.totalDays = totalDays;
	}
	
	
	
}
