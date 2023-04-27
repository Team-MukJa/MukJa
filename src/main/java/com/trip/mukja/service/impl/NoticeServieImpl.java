package com.trip.mukja.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.trip.mukja.config.PageNavigation;
import com.trip.mukja.config.SizeConstant;
import com.trip.mukja.dto.NoticeDTO;
import com.trip.mukja.service.NoticeService;

public class NoticeServieImpl implements NoticeService {
	
	private static NoticeService noticeService = new NoticeServieImpl();
	
	
	
	public static NoticeService getNoticeService() {
		return noticeService;
	}

	@Override
	public void writeNotice(NoticeDTO noticeDTO) throws Exception {
//		noticeDao.writeNotice(noticeDTO);
	}

	@Override
	public List<NoticeDTO> listNotice(Map<String, String> map) throws Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		String key = map.get("key");
//		if("userid".equals(key))
//			key = "user_id";
		param.put("key", key.isEmpty() ? "" : key);
		param.put("word", map.get("word").isEmpty() ? "" : map.get("word"));
		int pgno = Integer.parseInt(map.get("pgno"));
		int start = pgno * SizeConstant.LIST_SIZE - SizeConstant.LIST_SIZE;
		param.put("start", start);
		param.put("listsize", SizeConstant.LIST_SIZE);
		return null;
	}

	@Override
	public PageNavigation makePageNavigation(Map<String, String> map) throws Exception {
		PageNavigation pageNavigation = new PageNavigation();

		int naviSize = SizeConstant.NAVIGATION_SIZE;
		int sizePerPage = SizeConstant.LIST_SIZE;
		int currentPage = Integer.parseInt(map.get("pgno"));

		pageNavigation.setCurrentPage(currentPage);
		pageNavigation.setNaviSize(naviSize);
		Map<String, Object> param = new HashMap<String, Object>();
		String key = map.get("key");
//		if ("userid".equals(key))
//			key = "user_id";
		param.put("key", key.isEmpty() ? "" : key);
		param.put("word", map.get("word").isEmpty() ? "" : map.get("word"));
//		int totalCount = noticeDao.getTotalNoticeCount(param);
//		pageNavigation.setTotalCount(totalCount);
//		int totalPageCount = (totalCount - 1) / sizePerPage + 1;
//		pageNavigation.setTotalPageCount(totalPageCount);
//		boolean startRange = currentPage <= naviSize;
//		pageNavigation.setStartRange(startRange);
//		boolean endRange = (totalPageCount - 1) / naviSize * naviSize < currentPage;
//		pageNavigation.setEndRange(endRange);
//		pageNavigation.makeNavigator();

		return pageNavigation;
	}

	@Override
	public NoticeDTO getNotice(int noticeNo) throws Exception {
//		return noticeDao.getNotice(noticeNo);
		return null;
	}

	@Override
	public void updateHit(int noticeNo) throws Exception {
//		noticeDao.updateHit(noticeNo);
	}

	@Override
	public void modifyNotice(NoticeDTO noticeDTO) throws Exception {
//		noticeDao.modifyNotice(noticeDTO);
	}

	@Override
	public void deleteNotice(int noticeNo) throws Exception {
//		noticeDao.deleteNotice(noticeNo);
	}

}
