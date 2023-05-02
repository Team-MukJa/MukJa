package com.trip.mukja;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.SQLException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import com.trip.mukja.model.dto.MemberDTO;
import com.trip.mukja.model.mapper.MemberMapper;

import lombok.extern.slf4j.Slf4j;


@ExtendWith(SpringExtension.class)
@MybatisTest
@Slf4j	
// 실제로 데이터베이스를 테스트 하기 위한 어노테이션
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
public class dbTest {
	
	@Autowired
	private MemberMapper memberMapper;
	
	@Test
    @DisplayName("login Mapper Test")
	public void loginDB() {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setUserId("admin");
		memberDTO.setUserName("관리자");
		memberDTO.setUserPwd("1234");
		
		log.debug("test");
		MemberDTO testMember;
		try {
			testMember = memberMapper.loginMember(memberDTO);
			System.out.println(testMember.toString());
			log.debug(testMember.toString());
			assertThat(testMember.getUserId().equals(memberDTO.getUserId()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.debug("fail");
			e.printStackTrace();
		}
	}
	
	@Test
    @DisplayName("join Mapper Test")
	public void joinDB() {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setUserId("test");
		memberDTO.setUserName("test");
		memberDTO.setUserPwd("test");
		memberDTO.setEmailDomain("gmail.com");
		memberDTO.setEmailId("test");
		memberDTO.setRole("사용자");
		
		MemberDTO testMember;
		int cnt = memberMapper.joinMember(memberDTO);
		assertThat(cnt == 1);
	}
	
	@Test
    @DisplayName("delete Mapper Test")
	public void deleteDB() {

		String userId = "test";
		int cnt = memberMapper.deleteMember(userId);
		assertThat(cnt == 1);
	}
	
}
