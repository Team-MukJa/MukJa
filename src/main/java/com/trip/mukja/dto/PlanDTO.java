package com.trip.mukja.dto;

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
	private String fDate;
	private String lDate;
	private String wDate;

}
