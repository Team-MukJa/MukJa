package com.trip.mukja.controller;

import com.trip.mukja.model.dto.HotplaceDTO;
import com.trip.mukja.model.dto.NoticeDTO;
import com.trip.mukja.service.HotplaceService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/places")
@CrossOrigin("*")
@Api(tags = { "Hotplace 관리" })
public class HotplaceController {

    private final Logger logger = LoggerFactory.getLogger(HotplaceController.class);

    private HotplaceService hotplaceService;

    @Autowired
    public HotplaceController(HotplaceService hotplaceService) {
        this.hotplaceService = hotplaceService;
    }

    // Swagger
    @ApiOperation(value = "핫플레이스 목록", notes = "핫플레이스 목록 API")
    @ApiResponses({ @ApiResponse(code = 200, message = "핫플레이스 목록 OK"), @ApiResponse(code = 500, message = "서버오류") })
    // 리스트
    @GetMapping
    public ResponseEntity<?> hotplaceList() {
        logger.debug("hotplaceList call");
        try {
            List<HotplaceDTO> list = hotplaceService.listHotplace(null);
            if (list != null & !list.isEmpty()) {
                return new ResponseEntity<List<HotplaceDTO>>(list, HttpStatus.OK);
            } else {
                return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
            }

        } catch (Exception e) {
            return exceptionHandling(e);
        }
    }

    // Swagger
    @ApiOperation(value = "핫플레이스 작성", notes = "핫플레이스 작성 API")
    @ApiResponses({ @ApiResponse(code = 200, message = "핫플레이스 작성 OK"), @ApiResponse(code = 500, message = "서버오류") })
    // 작성
    @PostMapping
    public ResponseEntity<?> hotplaceWrite(@RequestBody HotplaceDTO hotplaceDTO) {
        logger.debug("hotplaceWrite hotplaceDTO : {}", hotplaceDTO);
        try {
            hotplaceService.writeHotplace(hotplaceDTO);
            List<HotplaceDTO> list = hotplaceService.listHotplace(null);
            return new ResponseEntity<List<HotplaceDTO>>(list, HttpStatus.OK);

        } catch (Exception e) {
            return exceptionHandling(e);
        }
    }

    // Swagger
    @ApiOperation(value = "핫플레이스 상세보기", notes = "핫플레이스 상세보기 API")
    @ApiResponses({ @ApiResponse(code = 200, message = "핫플레이스 상세보기 OK"), @ApiResponse(code = 500, message = "서버오류") })
    @ApiImplicitParam(name = "placeid", value = "게시물 번호", required = true, dataType = "int", paramType = "path")
    // 상세보기
    @GetMapping("/{placeid}")
    public ResponseEntity<?> hotplaceInfo(@PathVariable("placeid") int placeId) {
        logger.debug("hotplaceInfo placeid : {}", placeId);
        try {
            HotplaceDTO hotplaceDTO = hotplaceService.getHotplace(placeId);
            if (hotplaceDTO != null) {
                return new ResponseEntity<HotplaceDTO>(hotplaceDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
            }

        } catch (Exception e) {
            return exceptionHandling(e);
        }
    }

    // Swagger
    @ApiOperation(value = "핫플레이스 수정", notes = "핫플레이스 수정 API")
    @ApiResponses({ @ApiResponse(code = 200, message = "핫플레이스 수정 OK"), @ApiResponse(code = 500, message = "서버오류") })
    @ApiImplicitParam(name = "placeid", value = "게시물 번호", required = true, dataType = "int", paramType = "path")
    // 업데이트
    @PutMapping(value = "/{placeid}")
    public ResponseEntity<?> hotplaceModify(@RequestBody HotplaceDTO hotplaceDTO) {
        logger.debug("hotplaceModify hotplaceDTO : {}", hotplaceDTO);
        try {
            hotplaceService.modifyHotplace(hotplaceDTO);
            List<HotplaceDTO> list = hotplaceService.listHotplace(null);
            return new ResponseEntity<List<HotplaceDTO>>(list, HttpStatus.OK);

        } catch (Exception e) {
            return exceptionHandling(e);
        }

    }

    // Swagger
    @ApiOperation(value = "핫플레이스 삭제", notes = "핫플레이스 삭제 API")
    @ApiResponses({ @ApiResponse(code = 200, message = "핫플레이스 삭제 OK"), @ApiResponse(code = 500, message = "서버오류") })
    @ApiImplicitParam(name = "placeid", value = "게시물 번호", required = true, dataType = "int", paramType = "path")
    // 삭제
    @DeleteMapping(value = "/{placeid}")
    public ResponseEntity<?> hotplaceDelete(@PathVariable("placeid") int placeId) {
        logger.debug("hotplaceDelete placeid : {}", placeId);
        try {
            hotplaceService.deleteHotplace(placeId);
            List<HotplaceDTO> list = hotplaceService.listHotplace(null);
            return new ResponseEntity<List<HotplaceDTO>>(list, HttpStatus.OK);

        } catch (Exception e) {
            return exceptionHandling(e);
        }

    }

    private ResponseEntity<?> exceptionHandling(Exception e) {
        e.printStackTrace();
        return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
