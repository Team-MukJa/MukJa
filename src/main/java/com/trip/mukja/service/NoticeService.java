package com.trip.mukja.service;

import java.util.List;
import java.util.Map;

import com.trip.mukja.config.PageNavigation;
import com.trip.mukja.model.dto.NoticeDTO;



public interface NoticeService {
	void writeNotice(NoticeDTO noticeDTO) throws Exception;
	List<NoticeDTO> listNotice(Map<String, String> map) throws Exception;
	PageNavigation makePageNavigation(Map<String, String> map) throws Exception;
	NoticeDTO getNotice(int noticeId) throws Exception;
	void updateHit(int noticeId) throws Exception;
	
	void modifyNotice(NoticeDTO noticeDTO) throws Exception;
	void deleteNotice(int noticeId) throws Exception;
}
