package com.test.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.api.mapper.MyprescriptDetailMapper;
import com.test.api.model.PrescriptDTO;
import com.test.api.model.PrescriptDetailDTO;

@Service
public class MyprescriptDetailService {
	
	@Autowired
	MyprescriptDetailMapper prescriptdetailmapper;
	
	public List<PrescriptDetailDTO> prescriptList(int prescriptionID) {
		return prescriptdetailmapper.prescriptDetailList(prescriptionID);
	}

	public void insertPrescriptDetail(PrescriptDetailDTO pdd) {
		prescriptdetailmapper.insertPrescriptDetail(pdd);
	}
}
