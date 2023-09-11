package com.hoangtien2k3.ticketbookingapi.controller;

import com.hoangtien2k3.ticketbookingapi.service.SeatService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(description = "Api seat")
@RequestMapping("/seat")
public class SeatController {
    @Autowired
    private SeatService seatService;

    @ApiOperation(value = "Get empty seats according to screening time")
    @GetMapping("/{schedule_id}/seat-empty")
    public ResponseEntity<?> getSeatEmpty(@PathVariable Integer schedule_id){
        return ResponseEntity.ok(seatService.getSeatEmpty(schedule_id));
    }

}
