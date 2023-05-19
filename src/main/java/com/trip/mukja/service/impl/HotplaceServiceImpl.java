package com.trip.mukja.service.impl;

import com.trip.mukja.config.PageNavigation;
import com.trip.mukja.config.SizeConstant;
import com.trip.mukja.model.dto.FileInfoDTO;
import com.trip.mukja.model.dto.HotplaceDTO;
import com.trip.mukja.model.mapper.HotplaceMapper;
import com.trip.mukja.service.HotplaceService;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HotplaceServiceImpl implements HotplaceService {

    private HotplaceMapper hotplaceMapper;

    public HotplaceServiceImpl(HotplaceMapper hotplaceMapper) {
        this.hotplaceMapper = hotplaceMapper;
    }

    @Override
    public void writeHotplace(HotplaceDTO hotplaceDTO) {

        System.out.println("글입력 전 dto : " + hotplaceDTO);
        hotplaceMapper.writeHotplace(hotplaceDTO);
        System.out.println("글입력 후 dto : " + hotplaceDTO);

		List<FileInfoDTO> fileInfos = hotplaceDTO.getFileInfos();
		if (fileInfos != null && !fileInfos.isEmpty()) {
            System.out.println("리스트 : ");
            System.out.println(fileInfos);

			hotplaceMapper.registerFile(hotplaceDTO);
		}
    }

    @Override
    public List<HotplaceDTO> listHotplace(Map<String, Object> map) {
        Map<String, Object> param = new HashMap<String, Object>();
//		String key = map.get("key"); // write.jsp
//		if ("userid".equals(key))
//			key = "n.user_id";
//		param.put("key", key == null ? "" : key);
//		param.put("word", map.get("word") == null ? "" : map.get("word"));
//		int pgno = Integer.parseInt(map.get("pgno"));
//		int start = pgno * SizeConstant.LIST_SIZE - SizeConstant.LIST_SIZE;
//		param.put("start", start);
//		param.put("listsize", SizeConstant.LIST_SIZE);
        return hotplaceMapper.listHotplace(param);
    }

    @Override
    public HotplaceDTO getHotplace(int placeId) {
        return hotplaceMapper.getHotplace(placeId);
    }

    @Override
    public void modifyHotplace(HotplaceDTO hotplaceDTO) {
        hotplaceMapper.modifyHotplace(hotplaceDTO);
    }

    @Override
    public void deleteHotplace(int placeId) {
      List<FileInfoDTO> fileList = hotplaceMapper.fileInfoList(placeId);
		hotplaceMapper.deleteFile(placeId);
        hotplaceMapper.deleteHotplace(placeId);

//		for(FileInfoDTO fileInfoDto : fileList) {
//			File file = new File(path + File.separator + fileInfoDto.getSaveFolder() + File.separator + fileInfoDto.getSaveFile());
//			file.delete();
//		}
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
        int totalCount = hotplaceMapper.getTotalHotplaceCount(param);
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
    public void updateHit(int placeId) {
        hotplaceMapper.updateHit(placeId);
    }


}
