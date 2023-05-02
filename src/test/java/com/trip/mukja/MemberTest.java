package com.trip.mukja;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.google.gson.Gson;
import com.trip.mukja.controller.MemberController;
import com.trip.mukja.model.dto.MemberDTO;
import com.trip.mukja.service.MemberService;



@ExtendWith(SpringExtension.class)
@WebMvcTest(
		controllers = MemberController.class,
		excludeAutoConfiguration = SecurityAutoConfiguration.class)

public class MemberTest {


	
	@Autowired
	private MockMvc mockMvc;

	private int port = 80;

	@MockBean
	private MemberService memberService;
	
	
	@Test
	void loginControllerTest() throws Exception {

		// given
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setUserId("admin");
		memberDTO.setUserName("관리자");
		memberDTO.setUserPwd("1234");

		Gson gson = new Gson();
		String content = gson.toJson(memberDTO);
		String url = "http://localhost:" + port + "/members/user";
		

		// when
		mockMvc.perform(get(url).contentType(MediaType.APPLICATION_JSON).content(content))
				.andExpect(status().isAccepted())
				.andDo(print());
		
		verify(memberService).loginMember(memberDTO);
	}
	
	@Test
	void joinControllerTest() throws Exception {

		// given
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setUserId("test1");
		memberDTO.setUserName("test");
		memberDTO.setUserPwd("test");
		memberDTO.setEmailDomain("gmail.com");
		memberDTO.setEmailId("test");
		memberDTO.setRole("사용자");

		Gson gson = new Gson();
		String content = gson.toJson(memberDTO);
		String url = "http://localhost:" + port + "/members/user";
		

		// when
		mockMvc.perform(post(url).contentType(MediaType.APPLICATION_JSON).content(content))
				.andDo(print());
		
		// then
		verify(memberService).joinMember(memberDTO);
	}
	
	
	@Test
	void deleteControllerTest() throws Exception {
		// given
		
		String userId = "test";
		Gson gson = new Gson();
		String content = gson.toJson(userId);
//		String url = "http://localhost:" + port + "/members/user/{userId}";
		

		// when
		mockMvc.perform(delete("/members/user/{userId}",userId).contentType(MediaType.APPLICATION_JSON).content(content))
				.andDo(print());
		
		verify(memberService).deleteMember(userId);
	}

}
