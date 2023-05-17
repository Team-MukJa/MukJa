package com.trip.mukja.model.mapper;

import com.trip.mukja.model.dto.HotplaceDTO;
import com.trip.mukja.model.dto.MemberDTO;
import com.trip.mukja.model.dto.NoticeDTO;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;
import java.util.List;

@Mapper
public interface MypageMapper {

	MemberDTO getUser(String userId);
	List<HotplaceDTO> getMyHotplace(String userId);
	List<NoticeDTO> getMyNotice(String userId);
	
}
