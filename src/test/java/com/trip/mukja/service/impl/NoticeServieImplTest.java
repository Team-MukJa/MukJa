package com.trip.mukja.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import com.trip.mukja.model.dto.NoticeDTO;
import com.trip.mukja.service.NoticeService;

@SpringBootTest(properties = { "notice_id=1", "subject=spring test ing...", "content=스프링 테스트중!!!", "userid=ssafy",
		"hit=0" })
class NoticeServieImplTest {

	private Logger log = LoggerFactory.getLogger(NoticeServieImplTest.class);

	@Autowired
	private NoticeService noticeService;

	@Value("${notice_id}")
	private int noticeId;

	@Value("${subject}")
	private String subject;

	@Value("${content}")
	private String content;

	@Value("${userid}")
	private String userId;

	@Value("${hit}")
	private int hit;

	@Test
	@DisplayName("게시판 글작정 테스트")
	void testWriteNotice() {

		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setNoticeId(noticeId);
		noticeDTO.setUserId(userId);
		noticeDTO.setSubject(subject);
		noticeDTO.setContent(content);
		noticeDTO.setHit(hit);

		try {
			noticeService.writeNotice(noticeDTO);
		} catch (Exception e) {
			fail("게시글 작성 실패!!!");
		}

	}

//	@Test
//	void testListNotice() throws Exception {
//		
//		Map<String, String> map = new HashMap<String, String>();
//		map.put("pgno", "1");
//		map.put("key", "");
//		map.put("word", "");
//		List<NoticeDTO> list = noticeService.listNotice(map);
//		assertEquals(3, list.size());
//		log.debug("list : {}", list);
//		log.debug("list size : {}", list.size());
//		fail("Not yet implemented");
//	}

//	@Test
//	void testGetNotice() throws Exception {
//		
//		NoticeDTO noticeDTO = noticeService.getNotice(3);
//		assertEquals("ssafy", noticeDTO.getUserId());
//		log.debug("DTO : {}", noticeDTO);
//
////		fail("Not yet implemented");
//	}
//
//
//	@Test
//	void testModifyNotice() {
//		NoticeDTO noticeDTO = new NoticeDTO();
//		noticeDTO.setNoticeId(3);
//		noticeDTO.setSubject("수정 제목########");
//		noticeDTO.setContent("수정 내용@@@@@@@@@");
//		try {
//			noticeService.modifyNotice(noticeDTO);
//			
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			fail("Not yet implemented");
//		}
//	}
//
//	@Test
//	void testDeleteNotice() {
//		try {
//			noticeService.deleteNotice(1);
//		} catch (Exception e) {
//			// TODO: handle exception
//			fail("Not yet implemented");
//		}
//	}

}
