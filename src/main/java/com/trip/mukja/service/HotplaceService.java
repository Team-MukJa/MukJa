package com.trip.mukja.service;

import java.util.List;
import java.util.Map;

import com.trip.mukja.config.PageNavigation;
import com.trip.mukja.model.dto.FileInfoDTO;
import com.trip.mukja.model.dto.HotplaceDTO;


public interface HotplaceService {

	void writeHotplace(HotplaceDTO hotplaceDTO);

	List<HotplaceDTO> listHotplace(Map<String, Object> param);

	HotplaceDTO getHotplace(int placeId);


	void modifyHotplace(HotplaceDTO hotplaceDTO);

	void deleteHotplace(int placeId);

	PageNavigation makePageNavigation(Map<String, String> map) throws Exception;
	void updateHit(int placeId);


}
