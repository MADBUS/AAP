package com.test.api.mapper;

import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.test.api.model.KakaoEmailDTO;
import com.test.api.model.MemberDTO;
import com.test.api.model.MypharmDTO;
import com.test.api.model.PrescriptDTO;
import com.test.api.model.WaitForExpertDTO;

public interface MemberMapper {
	
	public void insertMember(MemberDTO dto);	

	
	public int isMem(@Param("kakaoEmail") String kakaoEmail);
	
	@Select("SELECT memberNum,memberPw,memberName,memberBday,memberAddress,memberEmail,memberType,memberTel FROM member WHERE memberEmail like #{kakaoEmail}")
	public MemberDTO getMember(String kakaoEmail);

	public void uploadFile(WaitForExpertDTO wfeDTO);

	public List<String> emailPwCheck(String email);
	
	public List<WaitForExpertDTO> waitforexpertList();
}
