package com.test.api.model;

import java.util.Date;

import lombok.Data;

@Data
public class MypharmDTO {
	private int mediID;
	private String itemSeq;
	private String itemName;
	private String entpName;
	private Date dueDate;
	private Integer amount;
	private int memberNum;
	
	public MypharmDTO() {

	} 
	
	
	public MypharmDTO(String itemSeq, String itemName, String entpName, Date dueDate, int amount) {
		this.itemSeq = itemSeq;
		this.itemName = itemName;
		this.entpName = entpName;
		this.dueDate = dueDate;
		this.amount = amount;
	}


	public MypharmDTO(int mediID, String itemSeq, String itemName, String entpName, Date dueDate, Integer amount) {
		super();
		this.mediID = mediID;
		this.itemSeq = itemSeq;
		this.itemName = itemName;
		this.entpName = entpName;
		this.dueDate = dueDate;
		this.amount = amount;
	}


	
}
