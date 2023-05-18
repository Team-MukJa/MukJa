package com.trip.mukja.model.dto.plan;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@ToString
public class PlanCalDTO {
    private List<LocalDate> days;
    private int planId;
    private String userId;
    private String subject;
}
