package com.trip.mukja.model.dto.plan;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;
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

	private String startDate;
	private String endDate;

	public void getLocalDateTime() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		// selectedDate를 LocalDateTime으로 변환하여 반환
		fDate =  LocalDateTime.parse(startDate+" 00:00:00",formatter);
		lDate =  LocalDateTime.parse(endDate+" 00:00:00",formatter);
	}
	

}
