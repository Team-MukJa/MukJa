package com.trip.mukja.model.dto.plan;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlanCreateDTO {

    private String userId;
    private String subject;
    private String content;
    private String fDate;
    private String lDate;

}
