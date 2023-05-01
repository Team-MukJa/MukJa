package com.trip.mukja.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FileInfoDTO {

	private String saveFolder;
	private String originalFile;
	private String saveFile;
	private int placeId;

}
