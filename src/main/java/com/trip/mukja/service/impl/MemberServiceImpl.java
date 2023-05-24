package com.trip.mukja.service.impl;

import com.trip.mukja.exception.AppException;
import com.trip.mukja.exception.ErrorCode;
import com.trip.mukja.model.dto.MemberDTO;

import com.trip.mukja.utils.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.trip.mukja.model.mapper.MemberMapper;
import com.trip.mukja.service.MemberService;

@Service
// final로 선언된 필드들의 생성자를 만들어준다.
@RequiredArgsConstructor
@Slf4j
public class MemberServiceImpl implements MemberService {
	
	
	private final MemberMapper memberMapper;
	private final BCryptPasswordEncoder encoder;

	@Value("${jwt.secret}")
	private String key;

	// 한시간
	private Long expireTimeMs = 1000 * 60 * 60L;


	@Override
	public int idCheck(String userId) throws Exception {
		return 1;

	}

	@Override
	public int joinMember(MemberDTO memberDTO) throws Exception {
		// encoder를 통하여 비밀번호를 암호화 시켜준다.
		memberDTO.setUserPwd(encoder.encode(memberDTO.getUserPwd()));
		return memberMapper.joinMember(memberDTO);

	}

	@Override
	public String loginMember(MemberDTO memberDTO) throws Exception {
		// userName 없음
		MemberDTO selectedMember = memberMapper.getOne(memberDTO.getUserId());
		if (selectedMember == null) throw new AppException(ErrorCode.MEMBERID_NOT_FOUND, memberDTO.getUserId()+"가 없습니다");

		log.info("selectdPw:{} pw:{}",selectedMember.getUserPwd(),memberDTO.getUserPwd());
		// password 틀림
		if(!encoder.matches( memberDTO.getUserPwd(),selectedMember.getUserPwd())){
			throw new AppException(ErrorCode.INVALID_PASSWORD,"패스워드를 잘못 입력하였습니다.");
		}
		// 앞에서 Exception안났으면 토큰 발행
		String token = JwtUtil.createJwt(selectedMember.getUserId(),key,expireTimeMs);

		return token;

	}

	@Override
	public int modifyInfo(MemberDTO memberDTO) {
		// encoder를 통하여 비밀번호를 암호화 시켜준다.
		if(memberDTO.getUserPwd() != null) memberDTO.setUserPwd(encoder.encode(memberDTO.getUserPwd()));
		return memberMapper.modifyInfo(memberDTO);
	}

	@Override
	public int deleteMember(String userId) {
		return memberMapper.deleteMember(userId);
		
	}

	@Override
	public MemberDTO getOne(String userId) {
		return memberMapper.getOne(userId);
	}

}
