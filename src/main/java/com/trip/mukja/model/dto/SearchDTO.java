package com.trip.mukja.model.dto;


import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@ApiModel(value="SearchDTO (여행지 검색)")
public class SearchDTO {

	int contentId;
	int contentTypeId;
	String title;
	String addr1;
	String addr2;
	String zipcode;
	String tel;
	String firstImage;
	int sidoCode;
	int gugunCode;
	double latitude; // 위도
	double longitude; // 경도
	String overview;

}
