package com.trip.mukja.controller;

import com.trip.mukja.model.dto.plan.PlanCreateDTO;
import com.trip.mukja.model.dto.plan.PlanDTO;
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

        log.info("전 : planDto : {}",planDTO);

        planDTO.getLocalDateTime();
        log.info("후 : planDto : {}",planDTO);

        planService.makePlanner(planDTO);

        List<LocalDateTime> travelDates = planService.getDays(planDTO.getFDate(),planDTO.getLDate());

        log.info("여행일자 목록 : {}",travelDates.toString());
        // 플래너를 생성한다.

        // 시작과 끝 날짜를 계산하여 값을 넘겨준다.
        return ResponseEntity.ok().body("글등록 완료 등록이 완료 되었습니다.");
    }


}
