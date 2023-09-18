package com.hoangtien2k3.ticketbookingapi.entity;

import com.hoangtien2k3.ticketbookingapi.dao.UserNameProfile;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

// ánh xạ kết quả của câu truy vấn SQL vào các đối tượng Java hay vào lớp `UserNameProfile`
@SqlResultSetMappings({
        @SqlResultSetMapping(
                name = "UserNameProfile",
                classes = @ConstructorResult(
                        targetClass = UserNameProfile.class,
                        columns = {
                                @ColumnResult(name = "user_id", type = Integer.class),
                                @ColumnResult(name = "username", type = String.class),
                                @ColumnResult(name = "user_avatar", type = String.class),
                                @ColumnResult(name = "user_fullname", type = String.class),
                                @ColumnResult(name = "user_birthday", type = String.class),
                                @ColumnResult(name = "user_gender", type = Integer.class),
                                @ColumnResult(name = "user_email", type = String.class),
                                @ColumnResult(name = "user_city", type = String.class),
                                @ColumnResult(name = "user_phone", type = String.class),
                                @ColumnResult(name = "user_point", type = Integer.class)
                        }
                )
        )
})

/*
    SELECT
        user_id, username, user_avatar, user_fullname, DATE_FORMAT(STR_TO_DATE(user_birthday, '%Y-%m-%d'), '%d/%m/%Y') as user_birthday,
        user_gender, user_email, user_city, user_phone, user_point
    FROM
        users
    WHERE
        user_id = ?1
*/
@NamedNativeQuery(name = "getUserNameProfile", resultSetMapping = "UserNameProfile",
        query = "SELECT `user_id`,`username`,`user_avatar`,`user_fullname`,DATE_FORMAT(`user_birthday`, \"%d/%m/%Y\") as `user_birthday`,`user_gender`,`user_email`,`user_city`,`user_phone`,`user_point` FROM `users` WHERE `user_id` = ?1")


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int userId;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "user_avatar")
    private String userAvatar;
    @Column(name = "user_fullname")
    private String userFullname;
    @Column(name = "user_birthday")
    private String userBirthday;
    @Column(name = "user_gender")
    private int userGender;
    @Column(name = "user_email")
    private String userEmail;
    @Column(name = "user_phone")
    private String userPhone;
    @Column(name = "user_city")
    private String userCity;
}
