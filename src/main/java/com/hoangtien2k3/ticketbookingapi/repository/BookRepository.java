package com.hoangtien2k3.ticketbookingapi.repository;

import com.hoangtien2k3.ticketbookingapi.entity.Book;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    // insert thoong tin booking
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO `booking`(`user_id`, `schedule_id`, `seat_id`, `price`, `seat_status`) " +
            "VALUES (?1, ?2, ?3, ?4, ?5)",
            nativeQuery = true
    )
    Integer bookTicket(Integer user_id, Integer schedule_id, Integer seat_id, Double price, Integer seat_status);

    // update thông tin booking
    @Transactional
    @Modifying
    @Query(value = "UPDATE `booking` SET `seat_status`= '1' WHERE `user_id`= ?1 AND `booking_id`= ?2",
            nativeQuery = true
    )
    Integer updateStatus(Integer user_id, Integer booking_id);

}
