package com.trip.mukja.controller;

import com.google.gson.Gson;
import com.trip.mukja.model.dto.MemberDTO;
import com.trip.mukja.service.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// Mock Test
// controller 전용 테스트
@WebMvcTest
class MemberControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    MemberService memberService;

    @Test
    @DisplayName("로그인 성공")
    void login_success() throws Exception{
        String userId = "test_security";
        String password = "test";

        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setUserId(userId);
        memberDTO.setUserPwd(password);

        Gson gson = new Gson();
        String content = gson.toJson(memberDTO);

        when(memberService.loginMember(any()))
        .thenReturn(null);

        mockMvc.perform(post("/members/user")
                        .with(csrf())
                .contentType(MediaType.APPLICATION_JSON)
                .content(content))
                .andDo(print())
                .andExpect(status().isAccepted());
    }
    @Test
    @DisplayName("로그인 실패 - userName이 없음")
    void login_fail1() throws Exception{
        String userId = "test_security";
        String password = "test";

        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setUserId(userId);
        memberDTO.setUserPwd(password);

        Gson gson = new Gson();
        String content = gson.toJson(memberDTO);

        when(memberService.loginMember(any()))
                .thenReturn(null);

        mockMvc.perform(post("/members/user")
                        .with(csrf())

                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content))
                .andDo(print())
                .andExpect(status().isAccepted());
    }

    @Test
    @DisplayName("로그인 실패 - password가 틀림")
    void login_fail2() throws Exception{
        String userId = "test_security";
        String password = "test";

        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setUserId(userId);
        memberDTO.setUserPwd(password);

        Gson gson = new Gson();
        String content = gson.toJson(memberDTO);

        when(memberService.loginMember(any()))
                .thenReturn(null);

        mockMvc.perform(post("/members/user")
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content))
                .andDo(print())
                .andExpect(status().isAccepted());

    }



}