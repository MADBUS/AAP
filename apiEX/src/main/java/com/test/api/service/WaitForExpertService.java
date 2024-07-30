package com.test.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.api.mapper.WaitForExpertMapper;
import com.test.api.model.WaitForExpertDTO;


@Service
public class WaitForExpertService {

	@Autowired
	WaitForExpertMapper waitForExpertMapper;
	
	public WaitForExpertDTO getExpertInfo(int memberNum) {
		return waitForExpertMapper.getExpertInfo(memberNum);
	}

	

}
