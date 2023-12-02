package com.hoangtien2k3.ticketbookingapi.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "booking")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private int bookingId;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "schedule_id")
    private int scheduleId;

    @Column(name = "seat_id")
    private int seatId;

    @Column(name = "price")
    private double price;

    @Column(name = "seat_status")
    private int seatStatus;
}
