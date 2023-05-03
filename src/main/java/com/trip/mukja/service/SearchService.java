package com.trip.mukja.service;

import com.trip.mukja.model.dto.SearchDTO;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;


public interface SearchService {
	List<SearchDTO> getSearchList(Map<String,Integer> map)  throws SQLException;
	}
