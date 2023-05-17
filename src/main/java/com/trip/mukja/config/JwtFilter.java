package com.trip.mukja.config;

import com.trip.mukja.service.MemberService;
import com.trip.mukja.utils.JwtUtil;
import io.jsonwebtoken.Jwt;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@RequiredArgsConstructor
@Slf4j
public class JwtFilter extends OncePerRequestFilter {

    private final MemberService memberService;
    private final String secretKey;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        final String authoreization = request.getHeader(HttpHeaders.AUTHORIZATION);
        log.info("authoreization : {}",authoreization);

        // 권한 부여를 하지 않는다.
        // token 안보내면 블락
        if(authoreization == null || !authoreization.startsWith("Bearer ")){
            log.error("authoreization이 없습니다");
            filterChain.doFilter(request,response);
            return;
        }

        // Token 꺼내기
        String token = authoreization.split(" ")[1];

        // Token Expired되었는지 여부
        if (JwtUtil.isExpired(token,secretKey)){
            log.error("Token이 완료되었습니다.");
            filterChain.doFilter(request,response);
            return;
        }

        // UserId Token에서 꺼내기
        String memberId = JwtUtil.getMemberId(token,secretKey);
        log.info("memberid : {}",memberId);

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(memberId,null, Arrays.asList(new SimpleGrantedAuthority("USER")));

        authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        filterChain.doFilter(request,response);

    }
}
