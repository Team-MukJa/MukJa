package com.trip.mukja.model.dto.plan;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
public class PlanCalDTO {
    private LocalDateTime fDate;
    private LocalDateTime lDate;

}
