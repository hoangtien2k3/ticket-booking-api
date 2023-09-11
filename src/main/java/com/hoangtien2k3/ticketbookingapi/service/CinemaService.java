package com.hoangtien2k3.ticketbookingapi.service;

import com.hoangtien2k3.ticketbookingapi.entity.Cinema;
import com.hoangtien2k3.ticketbookingapi.model.ResponseData;
import com.hoangtien2k3.ticketbookingapi.repository.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class CinemaService {
    @Autowired
    private CinemaRepository cinemaRepository;

    public ResponseData<Cinema> getCinemaByScheduleId(Integer schedule_id){
        return new ResponseData(HttpStatus.OK, "successfully", cinemaRepository.getCinemasByIdSchedule(schedule_id));
    }
}
