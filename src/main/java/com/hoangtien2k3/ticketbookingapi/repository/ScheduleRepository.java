package com.hoangtien2k3.ticketbookingapi.repository;

import com.hoangtien2k3.ticketbookingapi.entity.Schedule;
import com.hoangtien2k3.ticketbookingapi.model.ResponseCinema;
import com.hoangtien2k3.ticketbookingapi.model.ResponseScheduleCinema;
import com.hoangtien2k3.ticketbookingapi.model.ResponseScheduleTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {
    @Query(name = "getResponseCinema", nativeQuery = true)
    List<ResponseCinema> getScheduleCinema(Integer movie_id, String schedule_date);

    @Query(name = "getScheduleFormat", nativeQuery = true)
    String getFormat(Integer movie_id, String schedule_date, Integer cinema_id);

    @Query(name = "getScheduleTimeByFilm", nativeQuery = true)
    List<ResponseScheduleTime>  getScheduleTimeByFilm(Integer movie_id, String schedule_date, Integer cinema_id);

    @Query(name = "showSchedule", nativeQuery = true)
    List<ResponseScheduleCinema>  getSchedule(Integer movie_id, String schedule_date);
}
