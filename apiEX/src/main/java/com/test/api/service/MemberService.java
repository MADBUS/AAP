package com.test.api.service;

import java.util.List;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.api.mapper.MemberMapper;
import com.test.api.model.MemberDTO;
import com.test.api.model.MemberType;
import com.test.api.model.WaitForExpertDTO;

@Service
public class MemberService {

	@Autowired
	MemberMapper memberMapper;

	public boolean isMem(String kakoEmail) {
		int count = memberMapper.isMem(kakoEmail);
		System.out.println("이거 count return값 찍히나?" + count);
		if (count == 1) {
			return true;
		}
		return false;
	}

	public MemberDTO getMember(String kakaoEmail) {
		return memberMapper.getMember(kakaoEmail);
	}

	public void registerMember(MemberDTO dto) {

		memberMapper.insertMember(dto);

	}

	public boolean emailPwCheck(String email, String pw) {

		java.util.List<String> pwCheck = memberMapper.emailPwCheck(email);
		for (String pw2 : pwCheck) {
			if (pw.equals(jasyptDecoding(pw2))) {

				System.out.println("입력한 비밀번호" + pw);
				System.out.println("DB 비밀번호" + jasyptDecoding(pw2));
				return true;
			}
			System.out.println("입력한 비밀번호" + pw);
			System.out.println("DB 비밀번호" + jasyptDecoding(pw2));
		}

		return false;
	}
	
	public void upload(WaitForExpertDTO wfeDTO) {
		memberMapper.uploadFile(wfeDTO);
		
	}
	
	public List<WaitForExpertDTO> waitforexpertList() {
		List<WaitForExpertDTO> list=  memberMapper.waitforexpertList();
		System.out.println("리턴 값 체크"+list.toString());
		return list;
	}

	public String jasyptDecoding(String encryptedValue) {
		String Key = "security";
		StandardPBEStringEncryptor pbeEnc = new StandardPBEStringEncryptor();
		pbeEnc.setAlgorithm("PBEWithMD5AndDES");
		pbeEnc.setPassword(Key);
		return pbeEnc.decrypt(encryptedValue);
	}

}
