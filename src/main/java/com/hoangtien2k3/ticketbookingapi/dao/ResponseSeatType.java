package com.hoangtien2k3.ticketbookingapi.dao;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseSeatType {
    @JsonProperty("seat_id")
    private Integer seatId;
    @JsonProperty("seat_type")
    private String seatType;
    @JsonProperty("number")
    private Integer seatNumber;
    @JsonProperty("seat_status")
    private Integer seatStatus;
}
