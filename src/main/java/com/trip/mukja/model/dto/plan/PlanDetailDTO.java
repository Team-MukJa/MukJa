package com.trip.mukja.model.dto.plan;

import lombok.Data;

import java.time.LocalDateTime;


@Data
public class PlanDetailDTO {

    private int infoNo;
    private int planId;
    private String img;
    private String content;
    private int contentId;
    private String addr;
    private String subject;

    private String x;
    private String y;

    private String day;
    private String time;

    private String memo;



}
