package com.trip.mukja.controller;

import com.trip.mukja.model.dto.plan.PlanCreateDTO;
import com.trip.mukja.model.dto.plan.PlanDTO;
import com.trip.mukja.model.dto.plan.PlanInfoDTO;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.trip.mukja.service.PlanService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/plans")
@CrossOrigin("*")
@Api(tags = {"여행 계획"})
@Slf4j
@RequiredArgsConstructor
public class PlanController {
    private final PlanService planService;


    // 사용자가 입력한 여행 계획 정보를 받아 플래너를 만들어준다.

    @ApiOperation(value = "여행 플래너 작성", notes = "여행 플래너 작성 API")
    @PostMapping
    public ResponseEntity<?> makePlanner(@RequestBody PlanDTO planDTO) {

        planDTO.getLocalDateTime();
        planService.makePlanner(planDTO);

        List<LocalDateTime> travelDates = planService.getDays(planDTO.getFDate(),planDTO.getLDate());

        log.info("여행일자 목록 : {}",travelDates.toString());
        // 플래너를 생성한다.

        // 시작과 끝 날짜를 계산하여 값을 넘겨준다.
        return ResponseEntity.ok().body(planDTO);
    }

    @ApiOperation(value = "여행 플래너 검색", notes = "여행 플래너 검색 API")
    @GetMapping("/search/{keyword}")
    public ResponseEntity<?> searchByKeyword(@PathVariable String keyword){
        if(keyword != null){
            List<PlanInfoDTO> list = planService.searchDestination(keyword);
            log.info("list : {}",list);
        return ResponseEntity.ok().body(list);
        }else
            return ResponseEntity.ok().body("검색 실패");

    }



}
