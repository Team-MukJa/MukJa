package com.trip.mukja.model.dto;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@ApiModel(value="GugunDTO (구군 정보)")
public class GugunDTO {
    private int gugunCode;
    private String gugunName;
}
