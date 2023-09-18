package com.hoangtien2k3.ticketbookingapi.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResponseCinema {
    private int cinemaId;
    private String cinemaName;
    private String cinemaAddress;
}
