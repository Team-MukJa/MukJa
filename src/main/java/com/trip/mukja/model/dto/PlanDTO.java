package com.trip.mukja.model.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import springfox.documentation.annotations.ApiIgnore;

@Getter
@Setter
@ToString
@ApiModel(value="PlanDTO (여행 플래너 정보)")
public class PlanDTO {

	private int planId;
	private String userId; 
	private String subject;
	private String content;
	private int hit;
	private int like;
	private LocalDateTime fDate;
	private LocalDateTime lDate;
	private LocalDateTime wDate;


	

}
