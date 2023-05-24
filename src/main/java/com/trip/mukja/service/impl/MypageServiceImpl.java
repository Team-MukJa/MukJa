package com.trip.mukja.service.impl;

import com.trip.mukja.model.dto.HotplaceDTO;
import com.trip.mukja.model.dto.MemberDTO;
import com.trip.mukja.model.dto.NoticeDTO;
import com.trip.mukja.model.dto.ReviewDTO;
import com.trip.mukja.model.dto.plan.PlanDTO;
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
		return mypageMapper.getMyNotice(userId);
	}

	@Override
	public List<ReviewDTO> getMyReview(String userId) {
		return mypageMapper.getMyReview(userId);
	}

	@Override
	public List<PlanDTO> getMyPlans(String userId) {
		return mypageMapper.getMyPlans(userId);
	}

	@Override
	public List<String> getMyPlanImages(int planId) {
		return mypageMapper.getMyPlanImages(planId);
	}
}
