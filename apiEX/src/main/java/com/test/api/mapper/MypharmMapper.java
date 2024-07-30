package com.test.api.mapper;

import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.hibernate.annotations.Parent;

import com.test.api.model.MypharmDTO;
import com.test.api.model.PrescriptDTO;

public interface MypharmMapper {

	// 전체 회원 목록 반환
	@Select("SELECT * FROM pharmacy WHERE memberNum = #{memberNum} ORDER BY itemSeq")
	public List<MypharmDTO> getAllMedicine(int memberNum);
	
	public void addPharmByID(MypharmDTO mypharmDTO);

	public void delPharmByID(int mediID);

	public List<MypharmDTO> getNameMedicine(String itemName);

	public List<MypharmDTO> modMedi(@Param("itemSeq") int itemSeq, @Param("memberNum") int memberNum);

	public void modMediInfo(@Param("dueDate")LocalDate dueDate,@Param("amount") int amount,@Param("mediID") int mediID);

	public void addAmount(@Param("itemSeq") int itemSeq, @Param("amount") int amount);

	@Select("SELECT * FROM pharmacy WHERE mediID =#{mediID}")
	public MypharmDTO getByMediID(int mediID);
	
	public void subtractMed(@Param("mid") int mid,@Param("tot") int tot);

	public List<MypharmDTO> dueMedList(int memberNum);
	
	
	
}
