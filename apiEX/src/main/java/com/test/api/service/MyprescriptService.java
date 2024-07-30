package com.test.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.api.mapper.MyprescriptMapper;
import com.test.api.model.PrescriptDTO;

@Service
public class MyprescriptService {

	@Autowired
	MyprescriptMapper myprescriptMapper;
	
	public List<PrescriptDTO> prescriptList(int memberNum) {
		return myprescriptMapper.prescriptList(memberNum);
	}

	public int insertPrescipt(PrescriptDTO prescript) {
		myprescriptMapper.insertPrescript(prescript);
		return myprescriptMapper.getPresriptID();
	}
	
	public PrescriptDTO getPrescript(int prescriptionID) {
		return myprescriptMapper.getPrescript(prescriptionID);
	}

	public void delPrescript(int prescriptionID) {
		myprescriptMapper.delPrescript(prescriptionID);
		
	}
	
	
}
