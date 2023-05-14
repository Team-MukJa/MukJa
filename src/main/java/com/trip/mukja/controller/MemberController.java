package com.trip.mukja.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trip.mukja.model.dto.MemberDTO;
import com.trip.mukja.service.MemberService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/members")
@Slf4j
@Api(tags = { " 로그인/회원가입" })
public class MemberController {

	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	private MemberService memberService;

	public MemberController(MemberService memberService) {
		super();
		this.memberService = memberService;
	}

	@ApiOperation(value = "로그인", notes = "아이디와 비밀번호를 확인하여 로그인", response = Map.class)
	@PostMapping(value ="/login")
	public ResponseEntity<String> loginMember(@RequestBody MemberDTO memberDTO) {
		Map<String, Object> resultMap = new HashMap<>();

		String token = null;
		try {
			token = memberService.loginMember(memberDTO);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return ResponseEntity.ok().body(token);
	}

	@ApiOperation(value = "로그아웃", notes = "로그아웃", response = Map.class)
	@ApiImplicitParam(name = "userId", value = "사용자 아이디", required = true, dataType = "String", paramType = "path")
	@GetMapping(value = "/logout/{userId}")
	public ResponseEntity<?> logoutMember(@PathVariable("userId") String userid) {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.ACCEPTED;
		try {
			resultMap.put("message", SUCCESS);
			status = HttpStatus.ACCEPTED;
		} catch (Exception e) {
			log.error("로그아웃 실패 : {}", e);
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}

	// 회원 가입
	@ApiOperation(value = "회원가입", notes = "회원가입", response = Map.class)
	@PostMapping(value ="/join")
	public String joinMember(@RequestBody MemberDTO memberDTO) {
		try {
			log.info("memberDTO info : {}", memberDTO);
			int cnt = memberService.joinMember(memberDTO);
			return cnt + "";
		} catch (Exception e) {
			log.info("회원가입 실패 " +e.getMessage());
			return 0 + "";
		}
	}
	
	@ApiOperation(value = "회원탈퇴", notes = "회원탈퇴", response = Map.class)
	@ApiImplicitParam(name = "userId", value = "사용자 아이디", required = true, dataType = "String", paramType = "path")
	@DeleteMapping("/")
	public ResponseEntity<?> deleteMember(@PathVariable("userId") String userId) {
		log.debug("탈퇴 아이디 : " + userId);
		try {
			memberService.deleteMember(userId);
			return new ResponseEntity<String>("success", HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	

	
	@ApiOperation(value = "회원정보수정", notes = "회원정보수정", response = Map.class)
	@PutMapping(value ="/")
    @ApiImplicitParam(name = "userId", value = "사용자 아이디", required = true, dataType = "string", paramType = "path")
	public ResponseEntity<?> modifyMemberInfo(@RequestBody MemberDTO memberDTO) {
		try {
			log.info("memberDTO info : {}", memberDTO);
			int cnt = memberService.modifyInfo(memberDTO);
			return new ResponseEntity<String>("success", HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	@ApiOperation(value = "회원정보가져오기", notes = "회원정보가져오기", response = Map.class)
	@GetMapping(value ="/{userId}")
	@ApiImplicitParam(name = "userId", value = "사용자 아이디", required = true, dataType = "String", paramType = "path")
	public ResponseEntity<?> getMemberInfo(@PathVariable("userId") String userId) {
		try {
			MemberDTO memberDTO = memberService.getOne(userId);
			return new ResponseEntity<MemberDTO>(memberDTO,HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	private ResponseEntity<String> exceptionHandling(Exception e) {
		return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
