package com.trip.mukja.controller;

import com.trip.mukja.model.dto.HotplaceDTO;
import com.trip.mukja.model.dto.MemberDTO;
import com.trip.mukja.model.dto.NoticeDTO;
import com.trip.mukja.model.dto.ReviewDTO;
import com.trip.mukja.model.dto.plan.PlanDTO;
import com.trip.mukja.service.MemberService;
import com.trip.mukja.service.MypageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/my")
@Slf4j
@Api(tags = { " 마이 페이지 " })
public class MypageController {

	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	private MypageService mypageService;

	public MypageController(MypageService mypageService) {
		super();
		this.mypageService = mypageService;
	}
	
	@ApiOperation(value = "회원정보 가져오기", notes = "회원정보가져오기", response = Map.class)
	@GetMapping(value ="/user/{userId}")
	@ApiImplicitParam(name = "userId", value = "사용자 아이디", required = true, dataType = "String", paramType = "path")
	public ResponseEntity<?> getUser(@PathVariable("userId") String userId) {
		try {
			MemberDTO memberDTO = mypageService.getUser(userId);
			return new ResponseEntity<MemberDTO>(memberDTO, HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}

	@ApiOperation(value = "핫플레이스 목록 가져오기", notes = "핫플레이스 목록 가져오기", response = Map.class)
	@GetMapping(value ="/place/{userId}")
	@ApiImplicitParam(name = "userId", value = "사용자 아이디", required = true, dataType = "String", paramType = "path")
	public ResponseEntity<?> getHotplace(@PathVariable("userId") String userId) {
		try {
			List<HotplaceDTO> hotplaceDTO = mypageService.getMyHotplace(userId);
			return new ResponseEntity<List<HotplaceDTO>>(hotplaceDTO, HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}

	@ApiOperation(value = "여행계획 목록 가져오기", notes = "여행계획 목록 가져오기", response = Map.class)
	@GetMapping(value ="/plan/{userId}")
	@ApiImplicitParam(name = "userId", value = "사용자 아이디", required = true, dataType = "String", paramType = "path")
	public ResponseEntity<?> getPlan(@PathVariable("userId") String userId) {
		try {
			List<PlanDTO> plans = mypageService.getMyPlans(userId);
			for(PlanDTO plan : plans){
				plan.setRepresentativeImage(mypageService.getMyPlanImages(plan.getPlanId()));
			}
			return new ResponseEntity<List<PlanDTO>>(plans, HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}

	@ApiOperation(value = "리뷰 목록 가져오기", notes = "리뷰 목록 가져오기", response = Map.class)
	@GetMapping(value ="/review/{userId}")
	@ApiImplicitParam(name = "userId", value = "사용자 아이디", required = true, dataType = "String", paramType = "path")
	public ResponseEntity<?> getReview(@PathVariable("userId") String userId) {
		try {
			List<ReviewDTO> reviewDTO = mypageService.getMyReview(userId);
			return new ResponseEntity<List<ReviewDTO>>(reviewDTO, HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}

	@ApiOperation(value = "문의사항 목록 가져오기", notes = "문의사항 목록 가져오기", response = Map.class)
	@GetMapping(value ="/notice/{userId}")
	@ApiImplicitParam(name = "userId", value = "사용자 아이디", required = true, dataType = "String", paramType = "path")
	public ResponseEntity<?> getNotice(@PathVariable("userId") String userId) {
		try {
			List<NoticeDTO> noticeDTO = mypageService.getMyNotice(userId);
			return new ResponseEntity<List<NoticeDTO>>(noticeDTO, HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	private ResponseEntity<String> exceptionHandling(Exception e) {
		return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
