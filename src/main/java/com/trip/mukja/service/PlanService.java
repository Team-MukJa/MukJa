package com.trip.mukja.service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.trip.mukja.model.dto.plan.PlanCreateDTO;
import com.trip.mukja.model.dto.plan.PlanDTO;
import com.trip.mukja.model.dto.plan.PlanInfoDTO;


public interface PlanService {
	
	// 플래너 생성하기 
	int makePlanner(PlanDTO planDTO);

	// 플래너에 플랜 넣기 
	int addPlanDetail(PlanInfoDTO planInfoDTO);

	
	List<PlanDTO> getList(String keyword) throws SQLException;
	
	
	
	List<LocalDateTime> getDays(LocalDateTime fDate, LocalDateTime lDate);

}
