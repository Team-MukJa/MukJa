package com.trip.mukja.config;

//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//public class SecurityConfig {
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
//        return httpSecurity
//                // UI쪽으로 들어오는것을막는다
//                .httpBasic().disable()
//                // cross site 설정
//                .csrf().disable()
//                .cors().and()
//                .authorizeRequests()
//                .antMatchers("/members/**").permitAll()
//                .antMatchers("/members/user").permitAll()
//                .and()
//                .sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // jwt 사용하는 경우 씀
//                .and()
//                .build();
//    }
//}
