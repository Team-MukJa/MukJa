package com.trip.mukja.service.impl;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.trip.mukja.model.dto.PlanDTO;
import com.trip.mukja.model.dto.PlanInfoDTO;
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
	public List<LocalDate> getDays(LocalDate fDate, LocalDate lDate) {
		List<LocalDate> days = new ArrayList<>();
		// Period를 이용하여 두날짜의 차이를 구할 수 있다.
		int size = Period.between(fDate, lDate).getDays();
		for(int i = 0; i<= size; i++) {
			days.add(fDate.plusDays(i));
		}
		return days;
	}

	

}
