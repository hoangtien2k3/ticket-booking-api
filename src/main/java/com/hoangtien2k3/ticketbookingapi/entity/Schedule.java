package com.hoangtien2k3.ticketbookingapi.entity;

import com.hoangtien2k3.ticketbookingapi.model.ResponseCinema;
import com.hoangtien2k3.ticketbookingapi.model.ResponseFormat;
import com.hoangtien2k3.ticketbookingapi.model.ResponseScheduleCinema;
import com.hoangtien2k3.ticketbookingapi.model.ResponseScheduleTime;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@SqlResultSetMappings({
        @SqlResultSetMapping(
                name = "ResponseScheduleTime",
                classes = @ConstructorResult(
                        targetClass = ResponseScheduleTime.class,
                        columns = {
                                @ColumnResult(name = "schedule_id", type = Integer.class),
                                @ColumnResult(name = "schedule_start", type = String.class)
                        }
                )
        ),
        @SqlResultSetMapping(
                name = "ResponseFormat",
                classes = @ConstructorResult(
                        targetClass = ResponseFormat.class,
                        columns = {
                                @ColumnResult(name = "movie_format")
                        }
                )
        ),
        @SqlResultSetMapping(
                name = "ResponseCinema",
                classes = @ConstructorResult(
                        targetClass = ResponseCinema.class,
                        columns = {
                                @ColumnResult(name = "cinema_id"),
                                @ColumnResult(name = "cinema_name"),
                                @ColumnResult(name = "cinema_address")
                        }
                )
        ),
        @SqlResultSetMapping(
                name = "showSchedule",
                classes = @ConstructorResult(
                        targetClass = ResponseScheduleCinema.class,
                        columns = {
                                @ColumnResult(name = "cinema_id"),
                                @ColumnResult(name = "cinema_name"),
                                @ColumnResult(name = "cinema_data", type = String.class)
                        }
                )
        )
})

/*
    SELECT
        schedule.schedule_id, schedule.schedule_start
    FROM
        movies, schedule, room, cinemas
    WHERE
        movies.movie_id = schedule.movie_id
        AND schedule.room_id = room.room_id
        AND room.cinema_id = cinemas.cinema_id
        AND movies.movie_id = ?1
        AND schedule.schedule_date = ?2
        AND cinemas.cinema_id = ?3
*/
@NamedNativeQuery(name = "getScheduleTimeByFilm", resultSetMapping = "ResponseScheduleTime",
        query = "SELECT `schedule`.`schedule_id`, `schedule`.`schedule_start` " +
                "FROM `movies`,`schedule`,`room`,`cinemas` " +
                "WHERE `movies`.`movie_id` = `schedule`.`movie_id` AND `schedule`.`room_id` = `room`.`room_id`AND `room`.`cinema_id` = `cinemas`.`cinema_id` AND `movies`.`movie_id` = ?1 AND `schedule`.`schedule_date` = ?2 AND `cinemas`.`cinema_id` = ?3"
)

/*
    SELECT
        movies.movie_format
    FROM
        movies, schedule, room, cinemas
    WHERE
        movies.movie_id = schedule.movie_id
        AND schedule.room_id = room.room_id
        AND room.cinema_id = cinemas.cinema_id
        AND movies.movie_id = ?1
        AND schedule.schedule_date = ?2
        AND cinemas.cinema_id = ?3
    GROUP BY
        movies.movie_format
*/
@NamedNativeQuery(name = "getScheduleFormat", resultSetMapping = "ResponseFormat",
        query = "SELECT `movies`.`movie_format` " +
                "FROM `movies`,`schedule`,`room`,`cinemas` " +
                "WHERE `movies`.`movie_id` = `schedule`.`movie_id` AND `schedule`.`room_id` = `room`.`room_id`AND `room`.`cinema_id` = `cinemas`.`cinema_id` AND `movies`.`movie_id` = ?1 AND `schedule`.`schedule_date` = ?2 AND `cinemas`.`cinema_id` = ?3 " +
                "GROUP BY `movies`.`movie_format`"
)

/*
    SELECT
        cinemas.*
    FROM
        cinemas,
        schedule,
        room
    WHERE
        schedule.room_id = room.room_id
        AND room.cinema_id = cinemas.cinema_id
        AND schedule.movie_id = ?1
        AND schedule.schedule_date = ?2
*/
@NamedNativeQuery(name = "getResponseCinema", resultSetMapping = "ResponseCinema",
        query = "SELECT `cinemas`.* " +
                "FROM `cinemas`, `schedule`, `room` " +
                "WHERE `schedule`.`room_id` = `room`.`room_id` AND `room`.`cinema_id` = `cinemas`.`cinema_id` AND `schedule`.`movie_id` = ?1 AND `schedule`.`schedule_date` = ?2"
)

/*
    SELECT
        d.cinema_id,
        d.cinema_name,
        JSON_ARRAYAGG(
            JSON_OBJECT(
                'schedule_id', d.schedule_id,
                'schedule_start', TIME_FORMAT(schedule_start, '%H:%i'),
                'seat_empty', d.seatempty
            )
        ) as cinema_data
    FROM (
        SELECT
            sdl.schedule_id,
            sdl.schedule_start,
            cinemas.cinema_id,
            cinemas.cinema_name,
            (
                SELECT
                    COUNT(seats.seat_id)
                FROM
                    seats
                WHERE
                    seats.room_id = room.room_id
                    AND seats.seat_id NOT IN (
                        SELECT
                            booking.seat_id
                        FROM
                            booking
                        WHERE
                            booking.schedule_id = sdl.schedule_id
                    )
            ) as seatempty
        FROM
            schedule sdl
            INNER JOIN room room ON sdl.room_id = room.room_id
            INNER JOIN cinemas cinemas ON cinemas.cinema_id = room.cinema_id
        WHERE
            sdl.movie_id = ?1
            AND sdl.schedule_date = ?2
    ) d
    GROUP BY
        d.cinema_id,
        d.cinema_name
*/
@NamedNativeQuery(name = "showSchedule", resultSetMapping = "showSchedule",
        query = "SELECT d.cinema_id, d.cinema_name, (JSON_ARRAYAGG(JSON_OBJECT('schedule_id', d.schedule_id, 'schedule_start', TIME_FORMAT(schedule_start, '%H:%i'), 'seat_empty', d.seatempty))) as cinema_data " +
                "FROM ( " +
                "SELECT sdl.schedule_id, sdl.schedule_start, cinemas.cinema_id, cinemas.cinema_name, (SELECT COUNT(seats.seat_id) slots FROM seats seats WHERE seats.room_id = room.room_id AND seats.seat_id NOT IN (SELECT booking.seat_id FROM booking booking WHERE booking.schedule_id = sdl.schedule_id)) as seatempty FROM schedule sdl INNER JOIN room room ON sdl.room_id = room.room_id INNER JOIN cinemas cinemas ON cinemas.cinema_id = room.cinema_id WHERE sdl.movie_id = ?1 AND sdl.schedule_date = ?2) d " +
                "GROUP BY d.cinema_id, d.cinema_name"
)

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "schedule")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "schedule_id")
    private int scheduleId;

    @Column(name = "movie_id")
    private int movieId;

    @Column(name = "room_id")
    private int roomId;

    @Column(name = "schedule_date")
    private String scheduleDate;

    @Column(name = "schedule_start")
    private String scheduleStart;

    @Column(name = "schedule_end")
    private String scheduleEnd;
}
