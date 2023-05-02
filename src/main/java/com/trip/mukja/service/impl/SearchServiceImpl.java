package com.trip.mukja.service.impl;

import com.trip.mukja.model.dto.SearchDTO;
import com.trip.mukja.model.mapper.SearchMapper;
import com.trip.mukja.service.SearchService;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;


@Service
public class SearchServiceImpl implements SearchService {

	private SearchMapper searchMapper;

	public SearchServiceImpl(SearchMapper searchMapper) {
		this.searchMapper = searchMapper;
	}

	@Override
	public List<SearchDTO> getSearchList(Map<String,Integer> map) throws SQLException {
		return searchMapper.getSearchList(map);
	}

}
