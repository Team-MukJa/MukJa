package com.trip.mukja.model.mapper;

import com.trip.mukja.model.dto.SearchDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface SearchMapper {

    List<SearchDTO> getSearchList(Map<String,Integer> map);
}
