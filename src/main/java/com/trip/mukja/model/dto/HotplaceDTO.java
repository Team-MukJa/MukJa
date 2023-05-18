package com.trip.mukja.model.dto;

import java.time.LocalDateTime;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@ApiModel(value="HotplaceDTO (핫플레이스 정보)")
public class HotplaceDTO {

	private int placeId;
	private String userId;
	private String img;
	private String subject;
	private LocalDateTime tripDay;
	private String category;
	private String content;
	private int hit;
	private String registerTime;
	private int like;
	private String placeName;
	private String placeAddress;
	private String placeX;
	private String placeY;


}
