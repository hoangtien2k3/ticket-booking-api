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
public class ResponseFormatFilm {
    @JsonProperty("format_film")
    private String formatFilm;
    @JsonProperty("format_data")
    private ArrayList<ResponseScheduleTime> formatData;
}
