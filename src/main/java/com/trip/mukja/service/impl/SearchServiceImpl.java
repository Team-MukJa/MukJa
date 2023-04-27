package com.trip.mukja.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.trip.mukja.dto.SearchDTO;
import com.trip.mukja.service.SearchService;


public class SearchServiceImpl implements SearchService {

	private static SearchService searchService = new SearchServiceImpl();
	public static SearchService getInstance() {
		return searchService;
	}
	private SearchServiceImpl() {
	}
	@Override
	public List<SearchDTO> getSearchList(int areaCode, int contentTypeId, String keyword) throws SQLException {
		// TODO Auto-generated method stub
		
		return null;
	}

}
