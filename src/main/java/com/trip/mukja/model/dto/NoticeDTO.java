package com.trip.mukja.model.dto;

<<<<<<< HEAD
import java.util.List;

import io.swagger.annotations.ApiModel;
=======
>>>>>>> origin/dev
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
<<<<<<< HEAD
@ApiModel(value="NoticeDTO (공지사항 정보)")
=======
>>>>>>> origin/dev
public class NoticeDTO {

	private int noticeId;
	private String userId;
	private String subject;
	private String content;
	private int hit;
	private String registerTime;
<<<<<<< HEAD
	
	private String userName;
	private List<FileInfoDTO> fileInfos;
=======
>>>>>>> origin/dev

}
