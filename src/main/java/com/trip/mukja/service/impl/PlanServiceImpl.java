package com.trip.mukja.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.trip.mukja.model.dto.PlanDTO;
import com.trip.mukja.service.PlanService;




public class PlanServiceImpl implements PlanService {
	private static PlanService planService = new PlanServiceImpl();
	
	
	public static PlanService getInstance() {
		return planService;
	}
	
	private PlanServiceImpl() {
	}
	
	
	public List<PlanDTO> getList(String keyword) throws SQLException{
		return null;

		
	}

}
