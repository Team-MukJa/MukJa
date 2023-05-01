package com.trip.mukja.model.mapper;

import java.sql.SQLException;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.trip.mukja.model.dto.MemberDTO;

@Mapper
public interface MemberMapper {
	
	MemberDTO loginMember(Map<String,String> map )throws SQLException;
	
	MemberDTO getOne(String userId);
	
	
}
