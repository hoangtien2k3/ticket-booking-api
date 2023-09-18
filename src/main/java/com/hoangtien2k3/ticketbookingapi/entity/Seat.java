package com.hoangtien2k3.ticketbookingapi.entity;

import com.hoangtien2k3.ticketbookingapi.dao.ResponseSeat;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@SqlResultSetMappings({
        @SqlResultSetMapping(
                name = "ResponseSeatEmpty",
                classes = @ConstructorResult(
                        targetClass = ResponseSeat.class,
                        columns = {
                                @ColumnResult(name = "row"),
                                @ColumnResult(name = "seats", type = String.class)
                        }
                )
        )
})
@NamedNativeQuery(name = "getSeatEmpty", resultSetMapping = "ResponseSeatEmpty",
        query = "SELECT d.seat_row as row, JSON_ARRAYAGG(JSON_OBJECT('seat_id', d.seat_id, 'seat_type', d.seat_type, 'number', d.seat_number, 'seat_status', d.seat_status)) seats " +
        "FROM (" +
        "SELECT `seats`.`seat_id`, `seats`.`seat_type`,`seats`.`seat_row`, `seats`.`seat_number`, `booking`.`seat_status` FROM `schedule`, `seats` " +
        "LEFT JOIN `booking` ON `seats`.`seat_id` = `booking`.`seat_id` " +
        "WHERE `schedule`.`room_id` = `seats`.`room_id` AND `schedule`.`schedule_id` = ?1) d GROUP BY d.seat_row"
)

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "seats")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "seat_id")
    private int seatId;
    @Column(name = "seat_type")
    private int seatType;
    @Column(name = "room_id")
    private int roomId;
    @Column(name = "seat_row")
    private String seatRow;
    @Column(name = "seat_number")
    private int seatNumber;
}
