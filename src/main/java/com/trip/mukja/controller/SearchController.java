package com.trip.mukja.controller;

import com.trip.mukja.model.dto.SearchDTO;
import com.trip.mukja.service.SearchService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/search")
@Api(tags = { "여행지 검색" })

public class SearchController {

    private SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }


    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name = "sidoCode", value = "지역 코드", required = true, dataType = "int", paramType = "path"),
                    @ApiImplicitParam(name = "gunguCode", value = "구군 코드", required = true, dataType = "int", paramType = "path"),
                    @ApiImplicitParam(name = "contentTypeId", value = "관광지 타입 코드", required = true, dataType = "int", paramType = "path"),
                    @ApiImplicitParam(name = "keyword", value = "검색어", required = true, dataType = "String", paramType = "path")

            })
    @GetMapping("/{sidoCode}/{gunguCode}/{contentTypeId}/{keyword}")
    public ResponseEntity<?> map(@PathVariable("sidoCode") int areaCode
            , @PathVariable("gunguCode") int sigunguCode
            , @PathVariable("contentTypeId") int contentTypeId
            , @PathVariable("keyword") String keyword) {

        try {
            log.info("contentTypeId : " + contentTypeId);
            Map<String, Integer> map = new HashMap<String, Integer>();
            map.put("areaCode", areaCode);
            map.put("sigunguCode", sigunguCode);
            map.put("contentTypeId", contentTypeId);
            List<SearchDTO> list = searchService.getSearchList(map);
            log.debug("tourList : {} ", list);
            if (list != null) {
                return new ResponseEntity<List<SearchDTO>>(list, HttpStatus.OK);
            } else {
                return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return exceptionHandling(e);
        }
    }

    private ResponseEntity<String> exceptionHandling(Exception e) {
        return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
