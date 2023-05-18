package com.trip.mukja.model.dto;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@ApiModel(value="ReviewDTO (리뷰 정보)")
public class ReviewDTO {

	private int reviewId;
	private int placeId;
	private String userId;
	private String content;
	private int rating;
	private String registerTime;
	private String userName;

}
