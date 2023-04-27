package com.trip.mukja.service;

import java.sql.SQLException;
import java.util.List;

import com.trip.mukja.dto.SearchDTO;


public interface SearchService {
	List<SearchDTO> getSearchList(int areaCode, int contentTypeId, String keyword) throws SQLException;
}
