package com.hoangtien2k3.ticketbookingapi.repository;

import com.hoangtien2k3.ticketbookingapi.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {

}
