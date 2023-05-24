package com.trip.mukja.service.impl;

import com.trip.mukja.model.dto.plan.PlanCalDTO;
import com.trip.mukja.model.dto.plan.PlanDTO;
import com.trip.mukja.model.dto.plan.PlanInfoDTO;
import com.trip.mukja.model.mapper.PlanMapper;
import com.trip.mukja.service.PlanService;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

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

	@Override
	public List<PlanInfoDTO> searchDestination(String keyword) {
		return planMapper.searchDestination(keyword);
	}

	@Override
	public void registDetailPlan(List<PlanInfoDTO> planInfos) {

		planInfos = convertDayToDateTime(planInfos);
		planMapper.registDetailPlan(planInfos);
	}

	@Override
	public List<PlanDTO> getPlanners() {
		return planMapper.getPlanners();
	}

	@Override
	public List<String> getPlanImages(int planId) {

		return planMapper.getPlanImages(planId);
	}

	@Override
	public List<PlanInfoDTO> getDetailPlan(int planId) {
		return planMapper.getDetailPlan(planId);
	}

	@Override
	public PlanCalDTO getPlanDate(int planId) {
		return planMapper.getPlanDate(planId);
	}

	@Override
	public List<String> formatterDateToString(List<LocalDateTime> dates) {
		List<String> stringList = new ArrayList<>();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		for (LocalDateTime localDateTime : dates) {
			String formattedString = localDateTime.format(formatter);
			stringList.add(formattedString);
		}
		return stringList;
	}

	// String의 day 를 localDatetime으로 전환
	public static List<PlanInfoDTO> convertDayToDateTime(List<PlanInfoDTO> planInfos) {
		List<PlanInfoDTO> convertedPlanInfos = new ArrayList<>();

		for (PlanInfoDTO planInfo : planInfos) {
			String dayString = planInfo.getDay();
			LocalDateTime dateTime = LocalDateTime.parse(dayString, DateTimeFormatter.ISO_DATE_TIME);
			planInfo.setDayTime(dateTime);
			convertedPlanInfos.add(planInfo);
		}

		return convertedPlanInfos;
	}

}
