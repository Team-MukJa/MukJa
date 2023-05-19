package com.trip.mukja.model.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@ApiModel(value="HotplaceDTO (핫플레이스 정보)")
public class HotplaceDTO {
//	public HotplaceDTO(String userId, String subject, LocalDate tripDay, String content, String placeName, String placeAddress, String placeX, String placeY) {
//		this.userId = userId;
//		this.subject = subject;
//		this.tripDay = tripDay;
//		this.content = content;
//		this.placeName = placeName;
//		this.placeAddress = placeAddress;
//		this.placeX = placeX;
//		this.placeY = placeY;
//	}

	private int placeId;
	private String userId;
	private String img;
	private String subject;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate tripDay;

	private String category;
	private String content;
	private int hit;
	private String registerTime;
	private int like;
	private String placeName;
	private String placeAddress;
	private String placeX;
	private String placeY;

	private List<FileInfoDTO> fileInfos;
	private String saveFile;

//	public void getLocalDateTime() {
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//		// selectedDate를 LocalDateTime으로 변환하여 반환
//		fDate =  LocalDateTime.parse(startDate+" 00:00:00",formatter);
//		lDate =  LocalDateTime.parse(endDate+" 00:00:00",formatter);
//	}


}
