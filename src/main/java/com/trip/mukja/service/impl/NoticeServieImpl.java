package com.trip.mukja.service.impl;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.trip.mukja.config.PageNavigation;
import com.trip.mukja.config.SizeConstant;
import com.trip.mukja.model.dto.FileInfoDTO;
import com.trip.mukja.model.dto.MemberDTO;
import com.trip.mukja.model.dto.NoticeDTO;
import com.trip.mukja.model.mapper.NoticeMapper;
import com.trip.mukja.service.NoticeService;

@Service
public class NoticeServieImpl implements NoticeService {

//	private static NoticeService noticeService = new NoticeServieImpl();
//
//	public static NoticeService getNoticeService() {
//		return noticeService;
//	}

	private NoticeMapper noticeMapper;

	public NoticeServieImpl(NoticeMapper noticeMapper) {
		super();
		this.noticeMapper = noticeMapper;
	}

	@Override
	public void writeNotice(NoticeDTO noticeDTO) throws Exception {
//		noticeDao.writeNotice(noticeDTO);
		System.out.println("글입력 전 dto : " + noticeDTO);
		noticeMapper.writeNotice(noticeDTO);
		System.out.println("글입력 후 dto : " + noticeDTO);

//		List<FileInfoDTO> fileInfos = noticeDTO.getFileInfos();
//		if (fileInfos != null && !fileInfos.isEmpty()) {
//			noticeMapper.registerFile(noticeDTO);
//		}

	}

	@Override
	public List<NoticeDTO> listNotice(Map<String, String> map) throws Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		String key = map.get("key"); // write.jsp
		if ("userid".equals(key))
			key = "n.user_id";
		param.put("key", key == null ? "" : key);
		param.put("word", map.get("word") == null ? "" : map.get("word"));
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
		if ("userid".equals(key))
			key = "user_id";
		param.put("key", key == null ? "" : key);
		param.put("word", map.get("word") == null ? "" : map.get("word"));
		int totalCount = noticeMapper.getTotalNoticeCount(param);
		pageNavigation.setTotalCount(totalCount);
		int totalPageCount = (totalCount - 1) / sizePerPage + 1;
		pageNavigation.setTotalPageCount(totalPageCount);
		boolean startRange = currentPage <= naviSize;
		pageNavigation.setStartRange(startRange);
		boolean endRange = (totalPageCount - 1) / naviSize * naviSize < currentPage;
		pageNavigation.setEndRange(endRange);
		pageNavigation.makeNavigator();

		return pageNavigation;
		
	}

	@Override
	public NoticeDTO getNotice(int noticeId) throws Exception {
		return noticeMapper.getNotice(noticeId);
	}

	@Override
	public void updateHit(int noticeId) throws Exception {
		noticeMapper.updateHit(noticeId);
	}

	@Override
	public void modifyNotice(NoticeDTO noticeDTO) throws Exception {
		noticeMapper.modifyNotice(noticeDTO);
	}

	@Override
	public void deleteNotice(int noticeId) throws Exception {
		List<FileInfoDTO> fileList = noticeMapper.fileInfoList(noticeId);
		noticeMapper.deleteFile(noticeId);
		noticeMapper.deleteNotice(noticeId);

//		for(FileInfoDTO fileInfoDto : fileList) {
//			File file = new File(path + File.separator + fileInfoDto.getSaveFolder() + File.separator + fileInfoDto.getSaveFile());
//			file.delete();
//		}

	}

}
