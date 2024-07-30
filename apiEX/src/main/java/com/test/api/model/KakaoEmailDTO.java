package com.test.api.model;

import lombok.Data;

@Data
public class KakaoEmailDTO {
	private String Email;
	private String name;
	
	public KakaoEmailDTO() {}
	
	public KakaoEmailDTO(String email, String name) {
		super();
		Email = email;
		this.name = name;
	}
	
	
}
