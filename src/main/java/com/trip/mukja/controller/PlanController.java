package com.trip.mukja.controller;

import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import com.trip.mukja.model.dto.PlanDTO;
import com.trip.mukja.service.PlanService;

@RestController
@RequestMapping("/plans")
@CrossOrigin("*")
@Api(tags = {"여행 계획"})
@Slf4j
public class PlanController {
    private final Logger logger = LoggerFactory.getLogger(PlanController.class);
    private PlanService planService;

    public PlanController(PlanService planService) {
        super();
        this.planService = planService;
    }


    // 사용자가 입력한 여행 계획 정보를 받아 플래너를 만들어준다.

    @ApiOperation(value = "여행 플래너 작성", notes = "여행 플래너 작성 API")
    @PostMapping
    public ResponseEntity<?> makePlanner(@RequestBody PlanDTO planDTO, Authentication authentication) {


        logger.debug("test"+planDTO.toString());
        // 플래너를 생성한다.
        planService.makePlanner(planDTO);

        // 시작과 끝 날짜를 계산하여 값을 넘겨준다.

        return ResponseEntity.ok().body(authentication.getName()+"님의 등록이 완료 되었습니다.");
    }


}
