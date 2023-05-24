package com.trip.mukja.model.mapper;

import java.sql.SQLException;
import java.util.List;

import com.trip.mukja.model.dto.plan.PlanCalDTO;
import org.apache.ibatis.annotations.Mapper;

import com.trip.mukja.model.dto.plan.PlanDTO;
import com.trip.mukja.model.dto.plan.PlanInfoDTO;

@Mapper
public interface PlanMapper {

	int makePlanner(PlanDTO planDTO);

	// 플래너에 플랜 넣기 
	int addPlanDetail(PlanInfoDTO planInfoDTO);
	
	List<PlanDTO> getList(String keyword) throws SQLException;

    List<PlanInfoDTO> searchDestination(String keyword);

	void registDetailPlan(List<PlanInfoDTO> planInfos);

    List<PlanDTO> getPlanners();

    List<String> getPlanImages(int planId);

	List<PlanInfoDTO> getDetailPlan(int planId);

	PlanCalDTO getPlanDate(int planId);
}
