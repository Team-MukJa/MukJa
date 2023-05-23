package com.trip.mukja.controller;

import com.trip.mukja.model.dto.ReviewDTO;
import com.trip.mukja.model.dto.SearchDTO;
import com.trip.mukja.model.dto.SidoGugunCodeDto;
import com.trip.mukja.service.ReviewService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Swagger 주소
// http://localhost/swagger-ui/index.html
@RestController
@RequestMapping("/tour")
@CrossOrigin("*")
@Api(tags = { " 관광지 조회 및 리뷰 관리" })
public class ReviewController {

    private final Logger logger = LoggerFactory.getLogger(ReviewController.class);

    private ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }


    @ApiOperation(value = "시도 정보", notes = "전국의 시도를 반환한다.", response = List.class)
    @GetMapping("/sido")
    public ResponseEntity<List<SidoGugunCodeDto>> sido() throws Exception {
        logger.info("sido - 호출");
        return new ResponseEntity<List<SidoGugunCodeDto>>(reviewService.getSido(), HttpStatus.OK);
    }

    @ApiOperation(value = "구군 정보", notes = "전국의 구군을 반환한다.", response = List.class)
    @GetMapping("/gugun")
    public ResponseEntity<List<SidoGugunCodeDto>> gugun(
            @RequestParam("sido") @ApiParam(value = "시도코드.", required = true) String sido) throws Exception {
        logger.info("gugun - 호출");
        return new ResponseEntity<List<SidoGugunCodeDto>>(reviewService.getGugunInSido(sido), HttpStatus.OK);
    }
    @ApiOperation(value = "구군 조회", notes = "구군 조회 API")
    @ApiResponses({ @ApiResponse(code = 200, message = "구군 조회 OK"), @ApiResponse(code = 500, message = "서버오류") })
    @ApiImplicitParam(name = "sidoCode", value = "시도 코드", required = true, dataType = "int", paramType = "path")
    @GetMapping("/gugun/{sidoCode}")
    public ResponseEntity<?> getGugun(@PathVariable("sidoCode") int sidoCode) {
        logger.debug("getGugun sidoCode : {}", sidoCode);
        try {
            List<SidoGugunCodeDto> gugunDTO = reviewService.getGugun(sidoCode);
            if (gugunDTO != null) {
                return new ResponseEntity<List<SidoGugunCodeDto>>(gugunDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
            }

        } catch (Exception e) {
            return exceptionHandling(e);
        }
    }

    @ApiOperation(value = "관광지 검색", notes = "관광지 검색 API")
    @ApiResponses({ @ApiResponse(code = 200, message = "관광지 검색 OK"), @ApiResponse(code = 500, message = "서버오류") })
    @ApiImplicitParams({@ApiImplicitParam(name = "sidoCode", value = "시도 코드", dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "gugunCode", value = "구군 코드", dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "contentTypeId", value = "관광지 유형", dataType = "List<Integer>", paramType = "path"),
            @ApiImplicitParam(name = "keyword", value = "검색 키워드", dataType = "String", paramType = "path")})
    @GetMapping("/review/{sidoCode}/{gugunCode}/{contentTypeId}/{keyword}")
    public ResponseEntity<?> getSearchList(@PathVariable("sidoCode") int sidoCode, @PathVariable("gugunCode") int gugunCode,
                                           @PathVariable("contentTypeId") List<Integer> contentTypeId, @PathVariable("keyword") String keyword) {
        logger.debug("getSearchList sidoCode : {}, gugunCode : {}, contentTypeId : {}, keyword : {}", sidoCode, gugunCode, contentTypeId, keyword);
        try {
            Map<String, Object> map = new HashMap<>();
            map.put("sidoCode", sidoCode);
            map.put("gugunCode", gugunCode);
            map.put("contentTypeId", contentTypeId);
            map.put("keyword", keyword);
            List<SearchDTO> searchDTO = reviewService.getSearchList(map);
            if (searchDTO != null) {
                return new ResponseEntity<List<SearchDTO>>(searchDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return exceptionHandling(e);
        }
    }

    @ApiOperation(value = "평점평균 조회", notes = "평점평균 조회 API")
    @ApiResponses({ @ApiResponse(code = 200, message = "평점평균 조회 OK"), @ApiResponse(code = 500, message = "서버오류") })
    @ApiImplicitParam(name = "contentId", value = "장소 아이디", required = true, dataType = "int", paramType = "path")
    @GetMapping("/review/avg/{contentId}")
    public ResponseEntity<?> getAvgRating(@PathVariable("contentId") int contentId) {
        logger.debug("getAvgRating contentId : {}", contentId);
        try {
            int cnt = reviewService.getRatingCount(contentId);
            int result = 0;
            if(cnt == 0){
                result = 0;
            }else{
                result = reviewService.getAvgRating(contentId);
            }
            return new ResponseEntity<Integer>(result, HttpStatus.OK);

        } catch (Exception e) {
            return exceptionHandling(e);
        }
    }

    @ApiOperation(value = "관광지 상세 조회", notes = "관광지 상세 조회 API")
    @ApiResponses({ @ApiResponse(code = 200, message = "관광지 상세 조회 OK"), @ApiResponse(code = 500, message = "서버오류") })
    @ApiImplicitParam( name = "contentId", value = "장소 아이디", required = true, dataType = "int", paramType = "path")
    @GetMapping("/{contentId}")
    public ResponseEntity<?> getTour(@PathVariable("contentId") int contentId) {
        logger.debug("getTour contentId : {}", contentId);
        try {
            SearchDTO result = reviewService.getTour(contentId);
            if (result != null) {
                return new ResponseEntity<SearchDTO>(result, HttpStatus.OK);
            } else {
                return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return exceptionHandling(e);
        }
    }

    @ApiOperation(value = "리뷰 목록 조회", notes = "리뷰 목록 조회 API")
    @ApiResponses({ @ApiResponse(code = 200, message = "리뷰 목록 조회 OK"), @ApiResponse(code = 500, message = "서버오류") })
    @ApiImplicitParam(name = "contentId", value = "장소 아이디", required = true, dataType = "int", paramType = "path")
    @GetMapping("/review/{contentId}")
    public ResponseEntity<?> getReviewList(@PathVariable("contentId") int contentId) {
        logger.debug("getReviewList contentId : {}", contentId);
        try {
            List<ReviewDTO> reviewDTO = reviewService.getReviewList(contentId);
            if (reviewDTO != null) {
                return new ResponseEntity<List<ReviewDTO>>(reviewDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return exceptionHandling(e);
        }
    }

    @ApiOperation(value = "자신의 리뷰 조회", notes = "자신의 리뷰 조회 API")
    @ApiResponses({ @ApiResponse(code = 200, message = "자신의 리뷰 받아오기 OK"), @ApiResponse(code = 500, message = "서버오류") })
    @ApiImplicitParams({@ApiImplicitParam( name = "contentId", value = "장소 아이디", required = true, dataType = "int", paramType = "path"), @ApiImplicitParam( name = "userId", value = "유저 아이디", required = true, dataType = "String", paramType = "path")})
    @GetMapping("/review/{contentId}/{userId}")
    public ResponseEntity<?> getMyReview(@PathVariable("contentId") int contentId, @PathVariable("userId") String userId) {
        logger.debug("getMyReview contentId : {} userId : {}", contentId, userId);
        try {
            Map<String, Object> map = new HashMap<>();
            map.put("contentId", contentId);
            map.put("userId", userId);
            ReviewDTO result = reviewService.getMyReview(map);
            if (result != null) {
                return new ResponseEntity<ReviewDTO>(result, HttpStatus.OK);
            } else {
                return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return exceptionHandling(e);
        }
    }

    @ApiOperation(value = "리뷰 작성", notes = "리뷰 작성 API")
    @ApiResponses({ @ApiResponse(code = 200, message = "리뷰 작성 OK"), @ApiResponse(code = 500, message = "서버오류") })
    @PostMapping("/review")
    public ResponseEntity<?> reviewWrite(@RequestBody ReviewDTO reviewDTO) {
        logger.debug("reviewWrite reviewDTO : {}", reviewDTO);
        try {
            reviewService.writeReview(reviewDTO);
            List<ReviewDTO> list = reviewService.getReviewList(reviewDTO.getPlaceId());
            return new ResponseEntity<List<ReviewDTO>>(list, HttpStatus.OK);
        } catch (Exception e) {
            return exceptionHandling(e);
        }
    }

    @ApiOperation(value = "리뷰 수정", notes = "리뷰 수정 API")
    @ApiResponses({ @ApiResponse(code = 200, message = "리뷰 수정 OK"), @ApiResponse(code = 500, message = "서버오류") })
    @PutMapping(value = "/review")
    public ResponseEntity<?> reviewModify(@RequestBody ReviewDTO reviewDTO) {
        logger.debug("reviewModify reviewDTO : {}", reviewDTO);
        try {
            reviewService.modifyReview(reviewDTO);
            List<ReviewDTO> list = reviewService.getReviewList(reviewDTO.getPlaceId());
            return new ResponseEntity<List<ReviewDTO>>(list, HttpStatus.OK);
        } catch (Exception e) {
            return exceptionHandling(e);
        }
    }

    @ApiOperation(value = "리뷰 삭제", notes = "리뷰 삭제 API")
    @ApiResponses({ @ApiResponse(code = 200, message = "리뷰 삭제 OK"), @ApiResponse(code = 500, message = "서버오류") })
    @ApiImplicitParam(name = "reviewId", value = "리뷰 번호", required = true, dataType = "int", paramType = "path")
    @DeleteMapping(value = "/review/{reviewId}")
    public ResponseEntity<?> reviewDelete(@PathVariable("reviewId") int reviewId) {
        logger.debug("reviewDelete reviewId : {}", reviewId);
        try {
            int placeId = reviewService.getReview(reviewId).getPlaceId();
            reviewService.deleteReview(reviewId);
            List<ReviewDTO> list = reviewService.getReviewList(placeId);
            return new ResponseEntity<List<ReviewDTO>>(list, HttpStatus.OK);
        } catch (Exception e) {
            return exceptionHandling(e);
        }
    }

/*    @ApiOperation(value = "핫플레이스 상세보기", notes = "핫플레이스 상세보기 API")
    @ApiResponses({ @ApiResponse(code = 200, message = "핫플레이스 상세보기 OK"), @ApiResponse(code = 500, message = "서버오류") })
    @ApiImplicitParam(name = "placeid", value = "게시물 번호", required = true, dataType = "int", paramType = "path")
    // 상세보기
    @GetMapping("/{placeid}")
    public ResponseEntity<?> hotplaceInfo(@PathVariable("placeid") int placeId) {
        logger.debug("hotplaceInfo placeid : {}", placeId);
        try {
            HotplaceDTO hotplaceDTO = hotplaceService.getHotplace(placeId);
            hotplaceService.updateHit(placeId);
            if (hotplaceDTO != null) {
                return new ResponseEntity<HotplaceDTO>(hotplaceDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
            }

        } catch (Exception e) {
            return exceptionHandling(e);
        }
    }*/

    private ResponseEntity<?> exceptionHandling(Exception e) {
        e.printStackTrace();
        return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
