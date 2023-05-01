package com.trip.mukja.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class NoticeDTO {

	private int noticeId;
	private String userId;
	private String subject;
	private String content;
	private int hit;
	private String registerTime;

}
