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

	//위도 
	double latitude;
	// 경도 
	double longitude;

	// 이미지
	String first_img;
	// 제목
	String title;
	// 주소  1
	String addr1;
	// 주소 2
	String addr2;
	
	
}
