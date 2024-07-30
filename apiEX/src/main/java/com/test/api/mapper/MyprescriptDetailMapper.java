package com.test.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.test.api.model.MypharmDTO;
import com.test.api.model.PrescriptDTO;
import com.test.api.model.PrescriptDetailDTO;

public interface MyprescriptDetailMapper {

	// 전체 회원 목록 반환
	@Select("SELECT * FROM prescription_detail WHERE prescriptionID = #{prescriptionID}")
	public List<PrescriptDetailDTO> prescriptDetailList(int prescriptionID);

	public void insertPrescriptDetail(PrescriptDetailDTO pdd);
}
