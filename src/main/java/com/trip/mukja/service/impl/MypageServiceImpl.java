package com.trip.mukja.service.impl;

import com.trip.mukja.model.dto.HotplaceDTO;
import com.trip.mukja.model.dto.MemberDTO;
import com.trip.mukja.model.dto.NoticeDTO;
import com.trip.mukja.model.mapper.MemberMapper;
import com.trip.mukja.model.mapper.MypageMapper;
import com.trip.mukja.service.MemberService;
import com.trip.mukja.service.MypageService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MypageServiceImpl implements MypageService {


	private MypageMapper mypageMapper;

	public MypageServiceImpl(MypageMapper mypageMapper) {
		super();
		this.mypageMapper = mypageMapper;
	}

	@Override
	public MemberDTO getUser(String userId) {
		return mypageMapper.getUser(userId);
	}

	@Override
	public List<HotplaceDTO> getMyHotplace(String userId) {
		return mypageMapper.getMyHotplace(userId);
	}

	@Override
	public List<NoticeDTO> getMyNotice(String userId) {
		System.out.println("service");
		return mypageMapper.getMyNotice(userId);
	}
}
