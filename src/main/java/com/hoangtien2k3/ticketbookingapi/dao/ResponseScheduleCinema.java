package com.hoangtien2k3.ticketbookingapi.dao;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.IOException;
import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseScheduleCinema {
    @JsonProperty("cinema_id")
    private int cinemaId;
    @JsonProperty("cinema_name")
    private String cinemaName;
    @JsonProperty("cinema_data")
    private ArrayList<ResponseScheduleTime> cinemaData;

    public ResponseScheduleCinema(int cinemaId, String cinemaName, Object cinemaData) {
        this.cinemaId = cinemaId;
        this.cinemaName = cinemaName;
        if (cinemaData != null) {
            ObjectMapper mapper = new ObjectMapper();
            try {
                this.cinemaData = mapper.readValue((String) cinemaData, new TypeReference<ArrayList<ResponseScheduleTime>>(){});
            } catch (IOException e) {
                this.cinemaData = null;
            }
        }
    }
}
