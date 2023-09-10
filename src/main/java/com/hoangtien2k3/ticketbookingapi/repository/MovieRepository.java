package com.hoangtien2k3.ticketbookingapi.repository;

import com.hoangtien2k3.ticketbookingapi.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
    // lấy ra phim đang chiếu
    @Query(value = "SELECT `movie_id`,`movie_name`,`movie_description`,`movie_trailer`,`movie_cens`,`movie_genres`, DATE_FORMAT(`movie_release`, \"%d/%m/%Y\") as `movie_release`,`movie_lenght`,`movie_format`,`movie_poster` " +
            "FROM `movies` WHERE `movie_release` = CURRENT_DATE OR `movie_release` < CURRENT_DATE",
            nativeQuery = true
    )
    List<Movie> getMoviesNow();


    // lấy ra phim sắp chiếu
    @Query(value = "SELECT `movie_id`,`movie_name`,`movie_description`,`movie_trailer`,`movie_cens`,`movie_genres`,DATE_FORMAT(`movie_release`, \"%d/%m/%Y\") as `movie_release`,`movie_lenght`,`movie_format`,`movie_poster` " +
            "FROM `movies` WHERE `movie_release` > CURRENT_DATE",
            nativeQuery = true
    )
    List<Movie> getMoviesFuture();

}
