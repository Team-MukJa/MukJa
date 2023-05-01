package com.trip.mukja.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class HotplaceDTO {

	private int placeId;
	private String userId;
	private String img;
	private String subject;
	private String tripDay;
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
