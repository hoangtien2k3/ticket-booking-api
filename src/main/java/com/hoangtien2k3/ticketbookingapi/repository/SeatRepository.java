package com.hoangtien2k3.ticketbookingapi.repository;

import com.hoangtien2k3.ticketbookingapi.entity.Seat;
import com.hoangtien2k3.ticketbookingapi.dao.ResponseSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SeatRepository extends JpaRepository<Seat, Integer> {
    //lấy ghế trống theo id film và id schedule
    @Query(name = "getSeatEmpty", nativeQuery = true)
    List<ResponseSeat> getSeatEmptyBySchedule(Integer schedule_id);
}
