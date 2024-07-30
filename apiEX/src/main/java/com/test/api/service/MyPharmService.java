package com.test.api.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.api.mapper.MypharmMapper;
import com.test.api.model.MypharmDTO;
import com.test.api.model.PrescriptDTO;

@Service
public class MyPharmService {
	
	@Autowired
	MypharmMapper mypharmmapper;
	

	public List<MypharmDTO> myPharmList(int memberNum) {
		return mypharmmapper.getAllMedicine(memberNum);
	}
	
	
	public void addPharm(MypharmDTO mypharmDTO) {
		System.out.println("여기서 에러나는거지?");
		mypharmmapper.addPharmByID(mypharmDTO);
	}
	
	public void delPharm(int mediID) {
		mypharmmapper.delPharmByID(mediID);
	}


	public List<MypharmDTO> searchedMedi(String itemName) {
		System.out.println("service 에 itemName 찍힘"+itemName);
		
		List<MypharmDTO> list =	mypharmmapper.getNameMedicine(itemName);
		System.out.println("서브시 리스트 결과물"+list.toString());
		return list;
	}


	public List<MypharmDTO> getBySeq(String itemSeq ,int memberNum) {
		// TODO Auto-generated method stub
		System.out.println("getBySeq"+ itemSeq);
		System.out.println("getBySeq인데 여기서 에러남?");
		int itemSeqint=Integer.parseInt(itemSeq);
		
		List<MypharmDTO> dto= mypharmmapper.modMedi(itemSeqint,memberNum);
		System.out.println("서비스 DTO 결과물"+dto);
		return dto;
	}


	public void modMedInfo(String dueDate, int amount, int mediID) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/M/d");
		LocalDate DD = LocalDate.parse(dueDate, formatter);
		mypharmmapper.modMediInfo(DD,amount,mediID);
		
	}


	public void addAmount(String itemSeq, int amount) {
		int itemSeq_ = Integer.parseInt(itemSeq);
		mypharmmapper.addAmount(itemSeq_,amount);
		
	}


	public MypharmDTO getByMediID(int mediID) {
		System.out.println("getByMediID"+ mediID);
		MypharmDTO dto= mypharmmapper.getByMediID(mediID);
		System.out.println("서비스 DTO 결과물"+dto);
		return dto;
	}


	public void subtractMed(int mid, int tot) {
		MypharmDTO dto = getByMediID(mid);
		if (dto.getAmount()-tot<=0) {
			delPharm(mid);
		}else {
			mypharmmapper.subtractMed(mid,tot);
		}
		
	}
	
	public List<MypharmDTO> ListDue(int memberNum){
		return mypharmmapper.dueMedList(memberNum);
	}


}
