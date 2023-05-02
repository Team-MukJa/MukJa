package com.trip.mukja.model.mapper;

import java.util.List;
import java.util.Map;

import com.trip.mukja.model.dto.FileInfoDTO;
import com.trip.mukja.model.dto.HotplaceDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HotplaceMapper {

	void writeHotplace(HotplaceDTO hotplaceDTO);

	void registerFile(HotplaceDTO hotplaceDTO);

	List<HotplaceDTO> listHotplace(Map<String, Object> param);

	int getTotalHotplaceCount(Map<String, Object> param);

	HotplaceDTO getHotplace(int placeId);

	void updateHit(int placeId);

	void modifyHotplace(HotplaceDTO hotplaceDTO);

	void deleteFile(int placeId);

	void deleteHotplace(int placeId);

	List<FileInfoDTO> fileInfoList(int placeId);

}
