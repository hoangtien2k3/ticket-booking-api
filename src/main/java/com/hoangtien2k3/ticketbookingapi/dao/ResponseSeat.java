package com.hoangtien2k3.ticketbookingapi.dao;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseSeat {
    @JsonProperty("row")
    private String seatRow;
    @JsonProperty("seats")
    private ArrayList<ResponseSeatType> data;
}
