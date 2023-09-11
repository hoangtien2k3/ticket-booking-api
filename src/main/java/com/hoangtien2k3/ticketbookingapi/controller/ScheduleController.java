package com.hoangtien2k3.ticketbookingapi.controller;

import com.hoangtien2k3.ticketbookingapi.service.CinemaService;
import com.hoangtien2k3.ticketbookingapi.service.ScheduleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(description = "Api schedule")
@RequestMapping("/schedule")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;
    @Autowired
    private CinemaService cinemaService;

    @ApiOperation(value = "Get theaters by showtime")
    @GetMapping("/{schedule_id}")
    public ResponseEntity<?> getCinemaByScheduleId(@PathVariable Integer schedule_id){
        return ResponseEntity.ok(cinemaService.getCinemaByScheduleId(schedule_id));
    }

    @ApiOperation(value = "Get the screening")
    @GetMapping("/{movie_id}/{schedule_date}")
    public ResponseEntity<?> getScheduleCinema(@PathVariable Integer movie_id, @PathVariable String schedule_date){
        return ResponseEntity.ok(scheduleService.getScheduleCinema(movie_id, schedule_date));
    }

}
