package com.trip.mukja.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.trip.mukja.MukjaApplication;

import lombok.extern.slf4j.Slf4j;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = MukjaApplication.class)
@Slf4j
class PlanServiceImplTest {

	@Autowired
	private PlanServiceImpl planServiceImpl;
	
	@Test
	void testGetDays() {
		LocalDate fDate = LocalDate.now();
		LocalDate lDate = fDate.plusDays(3);
		
		List<LocalDate> list =planServiceImpl.getDays(fDate, lDate);
		
		for (LocalDate localDate : list) {
			log.debug(localDate.toString());
		}
	}

}
