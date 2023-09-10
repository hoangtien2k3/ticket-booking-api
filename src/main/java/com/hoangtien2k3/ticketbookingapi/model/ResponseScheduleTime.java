package com.hoangtien2k3.ticketbookingapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseScheduleTime {
    @JsonProperty("schedule_id")
    private int scheduleId;
    @JsonProperty("schedule_start")
    private String scheduleStart;
    @JsonProperty("seat_empty")
    private String seatEmpty;
}
