package com.hoangtien2k3.ticketbookingapi.service;

import com.hoangtien2k3.ticketbookingapi.entity.Movie;
import com.hoangtien2k3.ticketbookingapi.dao.ResponseData;
import com.hoangtien2k3.ticketbookingapi.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public ResponseData<Movie> getAllMovie(){
        return new ResponseData(HttpStatus.OK, "success", movieRepository.findAll());
    }

    // phim đang công chiếu
    public ResponseData<Movie> getMoviesNow(){
        List<Movie> rs = movieRepository.getMoviesNow();
        if(CollectionUtils.isEmpty(rs)){
            return new ResponseData<>(HttpStatus.NOT_FOUND, "failed", null);
        }else{
            return new ResponseData(HttpStatus.OK, "successfully", rs);
        }
    }

    // phim sắp ra mắt
    public ResponseData<Movie> getMoviesFuture(){
        List<Movie> rs = movieRepository.getMoviesFuture();
        if(CollectionUtils.isEmpty(rs)){
            return new ResponseData<>(HttpStatus.NOT_FOUND, "failed", null);
        }else{
            return new ResponseData(HttpStatus.OK, "successfully", rs);
        }
    }

}
