package com.test.api.model;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class MemberDTO {
	private int memberNum;
	private String memberPw;
	private String memberName;
	private Timestamp memberBday;
	private String memberAddress;
	private String memberEmail;
	private String memberTel;
	private MemberType memberType;
	
	public MemberDTO() {}
	
	public MemberDTO(MemberType memberType, String memberPw, String memberName, String memberAddress, String memberTel,String memberEmail) {
		super();
		this.memberType = memberType;
		this.memberPw = memberPw;
		this.memberName = memberName;
		this.memberAddress = memberAddress;
		this.memberEmail = memberEmail;
		this.memberType = memberType;
		this.memberTel = memberTel;
	}
	
	
}
