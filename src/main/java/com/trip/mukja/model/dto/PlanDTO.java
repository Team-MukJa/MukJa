package com.trip.mukja.model.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PlanDTO {

	private int planId;
	private String userId; 
	private String subject;
	private String content;
	private int hit;
	private int like;
	private LocalDate fDate;
	private LocalDate lDate;
	private LocalDate wDate;
	
	private List<LocalDate> days;
	
	

}
