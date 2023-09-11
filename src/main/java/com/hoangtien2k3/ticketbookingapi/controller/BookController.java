package com.hoangtien2k3.ticketbookingapi.controller;

import com.hoangtien2k3.ticketbookingapi.request.BookRequest;
import com.hoangtien2k3.ticketbookingapi.service.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@Api(description = "Api booking-ticket")
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @ApiOperation(value = "Book movie tickets")
    @PostMapping("/create")
    public ResponseEntity<?> bookingTicket(Authentication authentication, @RequestBody BookRequest bookRequest) {
        return ResponseEntity.ok(bookService.bookTicket(authentication, bookRequest));
    }

    @ApiOperation(value = "Change seat status according to ticket")
    @PostMapping(value = "/confirm")
    public ResponseEntity<?> confirmTicket(Authentication authentication, @RequestBody HashMap<String, Integer> request) {
        return ResponseEntity.ok(bookService.updateStatus(authentication, request.get("bookId")));
    }

}
