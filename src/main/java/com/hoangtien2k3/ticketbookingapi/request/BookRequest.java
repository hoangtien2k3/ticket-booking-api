package com.hoangtien2k3.ticketbookingapi.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookRequest {
    @NotNull(message = "Missing movie screening id")
    private int scheduleId;

    @NotNull(message = "Missing id seat")
    private int seatId;

    @NotNull(message = "Missing seat rack")
    private double price;

    @NotNull(message = "Missing seat status")
    private int seatStatus;
}
