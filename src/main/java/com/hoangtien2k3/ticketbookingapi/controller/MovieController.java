package com.hoangtien2k3.ticketbookingapi.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hoangtien2k3.ticketbookingapi.service.MovieService;

@RestController
@Api(description = "Api movie")
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    private MovieService movieSevice;

    @ApiOperation(value = "Get the list of movies")
    @GetMapping("")
    public ResponseEntity<?> getAllMovies(){
        return ResponseEntity.ok(movieSevice.getAllMovie());
    }

    @ApiOperation(value = "Get the list of currently showing movies")
    @GetMapping("/now")
    public ResponseEntity<?> getMoviesNow(){
        return ResponseEntity.ok(movieSevice.getMoviesNow());
    }

    @ApiOperation(value = "Get the list of upcoming movies")
    @GetMapping("/future")
    public ResponseEntity<?> getMoviesFuture(){
        return ResponseEntity.ok(movieSevice.getMoviesFuture());
    }

}
