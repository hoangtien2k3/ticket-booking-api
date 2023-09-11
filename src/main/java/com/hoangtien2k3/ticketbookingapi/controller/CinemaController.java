package com.hoangtien2k3.ticketbookingapi.controller;

import com.hoangtien2k3.ticketbookingapi.service.CinemaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(description = "Api cinemas")
@RequestMapping("/cinema")
public class CinemaController {
    @Autowired
    private CinemaService cinemaService;

    @ApiOperation(value = "Get theaters by showtime")
    @GetMapping("/{schedule_id}")
    public ResponseEntity<?> getCinemaScheduleId(@PathVariable Integer schedule_id) {
        return ResponseEntity.ok(cinemaService.getCinemaByScheduleId(schedule_id));
    }
}
