package com.trip.mukja.model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.trip.mukja.model.dto.FileInfoDTO;
import com.trip.mukja.model.dto.NoticeDTO;

@Mapper
public interface NoticeMapper {
	
	void writeNotice(NoticeDTO noticeDTO);
	
	void registerFile(NoticeDTO noticeDTO);
	
	List<NoticeDTO> listNotice(Map<String, Object> param);
	
	int getTotalNoticeCount(Map<String, Object> param);

	NoticeDTO getNotice(int noticeId);
	
	void updateHit(int noticeId);
	
	void modifyNotice(NoticeDTO noticeDTO);
	
	void deleteFile(int noticeId);
	
	void deleteNotice(int noticeId);
	
	List<FileInfoDTO> fileInfoList(int noticeId);
}
