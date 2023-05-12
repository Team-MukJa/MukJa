package com.trip.mukja.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trip.mukja.model.dto.PlanDTO;
import com.trip.mukja.service.PlanService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/plans")
public class PlanController {

	private PlanService planService ;
	
	public PlanController(PlanService planService) {
		super();
		this.planService = planService;
	}

	// 여행계획
	@PostMapping()
	public ResponseEntity<?> makePlanner(@RequestBody PlanDTO planDTO){
//		List<LocalDate> days = planService.get
		return null;
	}
	

}
