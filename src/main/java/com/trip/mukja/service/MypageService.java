package com.trip.mukja.service;


import com.trip.mukja.model.dto.HotplaceDTO;
import com.trip.mukja.model.dto.MemberDTO;
import com.trip.mukja.model.dto.NoticeDTO;

import java.util.List;

public interface MypageService {
	
	MemberDTO getUser(String userId);
	List<HotplaceDTO> getMyHotplace(String userId);
	List<NoticeDTO> getMyNotice(String userId);
}
