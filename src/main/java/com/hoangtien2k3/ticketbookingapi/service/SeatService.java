package com.hoangtien2k3.ticketbookingapi.service;

import com.hoangtien2k3.ticketbookingapi.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.hoangtien2k3.ticketbookingapi.dao.ResponseData;


@Service
public class SeatService {
    @Autowired
    private SeatRepository seatRepository;

    public ResponseData<Integer> getSeatEmpty(Integer schedule_id) {
        if (seatRepository.getSeatEmptyBySchedule(schedule_id).isEmpty()) {
            return new ResponseData<>(HttpStatus.NOT_FOUND, "failed", null);
        } else {
            return new ResponseData(HttpStatus.OK, "successfully", seatRepository.getSeatEmptyBySchedule(schedule_id));
        }
    }
}
