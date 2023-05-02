package com.trip.mukja.service;

import java.util.List;
import java.util.Map;

import com.trip.mukja.model.dto.FileInfoDTO;
import com.trip.mukja.model.dto.HotplaceDTO;

public interface HotplaceService {

	void writeHotplace(HotplaceDTO hotplaceDTO);

	List<HotplaceDTO> listHotplace(Map<String, Object> param);

//	int getTotalHotplaceCount(Map<String, Object> param);

	HotplaceDTO getHotplace(int placeId);

	void updateHit(int placeId);

	void modifyHotplace(HotplaceDTO hotplaceDTO);

	void deleteHotplace(int placeId);

	// 파일 설정
	void registerFile(HotplaceDTO hotplaceDTO);

	void deleteFile(int placeId);

	List<FileInfoDTO> fileInfoList(int placeId);

}
