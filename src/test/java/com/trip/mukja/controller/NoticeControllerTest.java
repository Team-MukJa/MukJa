package com.trip.mukja.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = {
		
})
class NoticeControllerTest {
	
	private Logger log = LoggerFactory.getLogger(NoticeControllerTest.class);
	
	@Autowired
	private NoticeController noticeController;

	@Test
	void testNoticeList() {
		fail("Not yet implemented");
	}

	@Test
	void testBookWrite() {
		fail("Not yet implemented");
	}

	@Test
	void testNoticeInfo() {
		fail("Not yet implemented");
	}

	@Test
	void testNoticeModify() {
		fail("Not yet implemented");
	}

	@Test
	void testNoticeDelete() {
		fail("Not yet implemented");
	}

}
