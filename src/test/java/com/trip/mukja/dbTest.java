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

import com.trip.mukja.model.dto.NoticeDTO;
import com.trip.mukja.model.mapper.NoticeMapper;

import lombok.extern.slf4j.Slf4j;


@ExtendWith(SpringExtension.class)
@MybatisTest
@Slf4j    
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class dbTest {
    
    @Autowired
    private NoticeMapper noticeMapper;
    
    @Test
    @DisplayName("Order Mapper Test")
    public void test() {
    	NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setNoticeId(2);
//		noticeDTO.setUserId("test");
//		noticeDTO.setSubject("db연결");
//		noticeDTO.setContent("dbdbdb");
//		noticeDTO.setHit(0);
        
        log.debug("test");
        NoticeDTO testNotice;
        testNotice = noticeMapper.getNotice(1);
		System.out.println(testNotice.toString());
		log.debug(testNotice.toString());
		assertThat(testNotice.getNoticeId()==(noticeDTO.getNoticeId()));
    }
    
}