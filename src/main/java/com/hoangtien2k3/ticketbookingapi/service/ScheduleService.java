package com.hoangtien2k3.ticketbookingapi.service;

import com.hoangtien2k3.ticketbookingapi.dao.ResponseData;
import com.hoangtien2k3.ticketbookingapi.dao.ResponseScheduleCinema;
import com.hoangtien2k3.ticketbookingapi.repository.CinemaRepository;
import com.hoangtien2k3.ticketbookingapi.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private CinemaRepository cinemaRepository;

    public ResponseData<ResponseScheduleCinema> getScheduleCinema(Integer movie_id, String schedule_date) {
        List<ResponseScheduleCinema> rs = scheduleRepository.getSchedule(movie_id, schedule_date);
        if (CollectionUtils.isEmpty(rs)) {  // CollectionUtils.isEmpty(rs): kiếm tra cả null lẫn empty
            return new ResponseData(HttpStatus.NOT_FOUND,"Not found schedule", null);
        } else {
            return new ResponseData(HttpStatus.OK,"successfully", scheduleRepository.getSchedule(movie_id, schedule_date));
        }
    }

}
