package com.trip.mukja.service.impl;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.trip.mukja.model.dto.plan.PlanCreateDTO;
import org.springframework.stereotype.Service;

import com.trip.mukja.model.dto.plan.PlanDTO;
import com.trip.mukja.model.dto.plan.PlanInfoDTO;
import com.trip.mukja.model.mapper.PlanMapper;
import com.trip.mukja.service.PlanService;

@Service
public class PlanServiceImpl implements PlanService {
	
	private PlanMapper planMapper;
	
	public PlanServiceImpl(PlanMapper planMapper) {
		super();
		this.planMapper = planMapper;
	}

	public List<PlanDTO> getList(String keyword) throws SQLException{
		return null;
	}

	@Override
	public int makePlanner(PlanDTO planDTO) {
		// TODO Auto-generated method stub
		return planMapper.makePlanner(planDTO);
	}

	@Override
	public int addPlanDetail(PlanInfoDTO planInfoDTO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<LocalDateTime> getDays(LocalDateTime fDate, LocalDateTime lDate) {
		List<LocalDateTime> datesInRange = new ArrayList<>();
		LocalDateTime currentDate = fDate;

		while (!currentDate.isAfter(lDate)) {
			datesInRange.add(currentDate);
			currentDate = currentDate.plusDays(1);
		}
		return datesInRange;
	}




}
