package com.test.api.model;

import lombok.Data;

@Data
public class KaKaoOauthResponse {
	private String code;
	private String error;
	private String error_description;
	private String state;
	
}
