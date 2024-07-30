package com.test.api.mapper;

import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.test.api.model.MypharmDTO;
import com.test.api.model.PrescriptDTO;

public interface MyprescriptMapper {

	// 전체 회원 목록 반환
	@Select("SELECT * FROM prescription WHERE expertNum = #{memberNum} ORDER by prescriptionID DESC")
	public List<PrescriptDTO> prescriptList(int memberNum);

	@Select("SELECT * FROM prescription WHERE prescriptionID = #{prescriptionID}")
	public PrescriptDTO getPrescript(int prescriptionID);

	@Delete("DELETE FROM prescription WHERE prescriptionID =#{prescriptionID}")
	public void delPrescript(int prescriptionID);

	public void insertPrescript(PrescriptDTO prescript);
	
	public int getPresriptID();
	
}
