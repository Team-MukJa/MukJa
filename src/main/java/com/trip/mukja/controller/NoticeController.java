package com.trip.mukja.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trip.mukja.model.dto.NoticeDTO;
import com.trip.mukja.service.NoticeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/notices")
@CrossOrigin("*")
//Swagger
@Api(tags = { "공지사항 관리" })
public class NoticeController {

	private final Logger logger = LoggerFactory.getLogger(NoticeController.class);

	private NoticeService noticeService;

	@Autowired
	public NoticeController(NoticeService noticeService) {
		super();
		this.noticeService = noticeService;
	}

//	@GetMapping("/list")
//	public String list() {
//		return "redirect:/assets/notice.html";
//	}

	// Swagger
	@ApiOperation(value = "공지사항 목록", notes = "공지사항 목록 API")
	@ApiResponses({ @ApiResponse(code = 200, message = "공지사항목록 OK"), @ApiResponse(code = 500, message = "서버오류") })
	// 리스트
	@GetMapping
	public ResponseEntity<?> noticeList() {
		logger.debug("noticelist call");
		try {
			List<NoticeDTO> list = noticeService.listNotice(null);
			if (list != null & !list.isEmpty()) {
				return new ResponseEntity<List<NoticeDTO>>(list, HttpStatus.OK);
			} else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}

		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}

	// Swagger
	@ApiOperation(value = "공지사항 작성", notes = "공지사항 작성 API")
	@ApiResponses({ @ApiResponse(code = 200, message = "공지사항 작성 OK"), @ApiResponse(code = 500, message = "서버오류") })
	// 작성
	@PostMapping
	public ResponseEntity<?> bookWrite(@RequestBody NoticeDTO noticeDTO) {
		logger.debug("noticeWrite noticeDTO : {}", noticeDTO);
		try {
			noticeService.writeNotice(noticeDTO);
			List<NoticeDTO> list = noticeService.listNotice(null);
			return new ResponseEntity<List<NoticeDTO>>(list, HttpStatus.OK);

		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}

	// Swagger
	@ApiOperation(value = "공지사항 상세보기", notes = "공지사항 상세보기 API")
	@ApiResponses({ @ApiResponse(code = 200, message = "공지사항 상세보기 OK"), @ApiResponse(code = 500, message = "서버오류") })
	@ApiImplicitParam(name = "noticeid", value = "글 번호", required = true, dataType = "int", paramType = "path")
	// 상세보기
//	@GetMapping(value = "/{noticeid}")
	@GetMapping("/{noticeid}")
	public ResponseEntity<?> noticeInfo(@PathVariable("noticeid") int noticeId) {
		logger.debug("noticeInfo noticeid : {}", noticeId);
		try {
			NoticeDTO noticeDTO = noticeService.getNotice(noticeId);
			if (noticeDTO != null) {
				return new ResponseEntity<NoticeDTO>(noticeDTO, HttpStatus.OK);
			} else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}

		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}

	// Swagger
	@ApiOperation(value = "공지사항 수정", notes = "공지사항 수정 API")
	@ApiResponses({ @ApiResponse(code = 200, message = "공지사항 수정 OK"), @ApiResponse(code = 500, message = "서버오류") })
	@ApiImplicitParam(name = "noticeid", value = "글 번호", required = true, dataType = "int", paramType = "path")
	// 업데이트
	@PutMapping(value = "/{noticeid}")
	public ResponseEntity<?> noticeModify(@RequestBody NoticeDTO noticeDTO) {
		logger.debug("noticeModify noticeDTO : {}", noticeDTO);
		try {
			noticeService.modifyNotice(noticeDTO);
			List<NoticeDTO> list = noticeService.listNotice(null);
			return new ResponseEntity<List<NoticeDTO>>(list, HttpStatus.OK);

		} catch (Exception e) {
			return exceptionHandling(e);
		}

	}

	// Swagger
	@ApiOperation(value = "공지사항 삭제", notes = "공지사항 삭제 API")
	@ApiResponses({ @ApiResponse(code = 200, message = "공지사항 삭제 OK"), @ApiResponse(code = 500, message = "서버오류") })
	@ApiImplicitParam(name = "noticeid", value = "글 번호", required = true, dataType = "int", paramType = "path")
	// 삭제
	@DeleteMapping(value = "/{noticeid}")
	public ResponseEntity<?> noticeDelete(@PathVariable("noticeid") int noticeId) {
		logger.debug("noticeDelete noticeid : {}", noticeId);
		try {
			noticeService.deleteNotice(noticeId);
			List<NoticeDTO> list = noticeService.listNotice(null);
			return new ResponseEntity<List<NoticeDTO>>(list, HttpStatus.OK);

		} catch (Exception e) {
			return exceptionHandling(e);
		}

	}

	private ResponseEntity<?> exceptionHandling(Exception e) {
		e.printStackTrace();
		return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
