package com.trip.mukja.service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import com.trip.mukja.model.dto.PlanDTO;
import com.trip.mukja.model.dto.PlanInfoDTO;


public interface PlanService {
	
	// 플래너 생성하기 
	int makePlanner(PlanDTO planDTO);

	// 플래너에 플랜 넣기 
	int addPlanDetail(PlanInfoDTO planInfoDTO);
	
	List<PlanDTO> getList(String keyword) throws SQLException;
	
	
	
	List<LocalDate> getDays(LocalDate fDate, LocalDate lDate);
}
