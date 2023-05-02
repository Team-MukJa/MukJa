package com.trip.mukja.model.mapper;

import java.sql.SQLException;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.trip.mukja.model.dto.MemberDTO;

@Mapper
public interface MemberMapper {
	
	MemberDTO loginMember(MemberDTO memberDTO )throws SQLException;
	
	int joinMember(MemberDTO memberDTO);
	int deleteMember(String userId);
	int modifyInfo(MemberDTO memberDTO);
	MemberDTO getOne(String userId);
	
	
}
