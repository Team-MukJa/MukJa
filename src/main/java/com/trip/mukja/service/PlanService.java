package com.trip.mukja.service;

import java.sql.SQLException;
import java.util.List;

import com.trip.mukja.model.dto.PlanDTO;


public interface PlanService {
 List<PlanDTO> getList(String keyword) throws SQLException;

}
