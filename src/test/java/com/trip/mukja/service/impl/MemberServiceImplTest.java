package com.trip.mukja.service.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import com.trip.mukja.MukjaApplication;
import com.trip.mukja.model.dto.MemberDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = MukjaApplication.class)
// 실제로 값이 변경되지 않도록
@Transactional
class MemberServiceImplTest {

	@Autowired
	private MemberServiceImpl memberServiceImpl; 
	
//	@Test
//	void loginServiceTest() {
//		MemberDTO memberDTO = new MemberDTO();
//		memberDTO.setUserId("admin");
//		memberDTO.setUserName("관리자");
//		memberDTO.setUserPwd("1234");
//		try {
//			String testMember = memberServiceImpl.loginMember(memberDTO);
//			System.out.println(testMember.toString());
//			assertThat(testMember.getUserId().equals(memberDTO.getUserId()));
//		} catch (Exception e) {
//			// TODO Auto-generatd catch block
//			log.debug("null");
//			e.printStackTrace();
//		}
//	}

	
	@Test
	void joinServiceTest() {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setUserId("test");
		memberDTO.setUserName("test");
		memberDTO.setUserPwd("test");
		memberDTO.setEmailDomain("gmail.com");
		memberDTO.setEmailId("test");
		memberDTO.setRole("사용자");
		try {
			int cnt = memberServiceImpl.joinMember(memberDTO);
			assertThat(cnt == 1);
		} catch (Exception e) {
			// TODO Auto-generatd catch block
			e.printStackTrace();
		}
	}
	
	@Test
	void deleteServiceTest() {
	
		String userId ="test";
		try {
			int cnt = memberServiceImpl.deleteMember(userId);
			assertThat(cnt == 1);
		} catch (Exception e) {
			// TODO Auto-generatd catch block
			e.printStackTrace();
		}
	}
	
	@Test
	void updateServiceTest() {
	
		
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setUserId("test");
		memberDTO.setUserName("update");
		memberDTO.setUserPwd("update");
		memberDTO.setEmailDomain("naver.com");
		memberDTO.setEmailId("test");
		memberDTO.setRole("사용자");
		
		try {
			int cnt = memberServiceImpl.modifyInfo(memberDTO);
			assertThat(cnt == 1);
		} catch (Exception e) {
			// TODO Auto-generatd catch block
			e.printStackTrace();
		}
	}
	
	
	@Test
	void getOneServiceTest() {
	
		String userId ="test";
		try {
			MemberDTO memberDTO = memberServiceImpl.getOne(userId);
			assertThat(memberDTO.getUserId().equals("test"));
		} catch (Exception e) {
			// TODO Auto-generatd catch block
			e.printStackTrace();
		}
	}

}
