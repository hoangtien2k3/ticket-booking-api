package com.hoangtien2k3.ticketbookingapi.repository;

import com.hoangtien2k3.ticketbookingapi.entity.User;
import com.hoangtien2k3.ticketbookingapi.model.UserNameProfile;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    // lấy ra thông tin user bằng id
    @Query(name = "getUserNameProfile", nativeQuery = true)
    UserNameProfile getUserById(Integer user_id);

    // thêm user vào dữ liệu
    @Transactional  // bảo đảm tính nhất quán khi sửa đổi CSDL (nếu lỗi thì sẽ rollback và dữ liệu trong CSDL sẽ không bị ảnh hưởng)
    @Modifying      // thực hiện hành động sử đổi dữ liệu trong CSDL
    @Query(value = "INSERT INTO 'users'(`username`, `password`, `user_avatar`, `user_fullname`, `user_birthday`, `user_gender`, `user_email`, `user_city`, `user_phone`, `user_point`) " +
            "VALUES (?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8, ?9, 0)",
            nativeQuery = true
    )
    Integer registerUser(String username, String password, String user_avatar, String user_fullname, String user_birthday, Integer user_gender, String user_email, String user_city, String user_phone);


    // update user từ dữ liệu
    @Transactional
    @Modifying
    @Query(value = "UPDATE `users` SET `username`= ?1, `user_fullname`= ?2,`user_birthday`= ?3, `user_gender`= ?4, `user_email`= ?5, `user_city`= ?6,`user_phone`=?7 " +
            "WHERE `user_id`= ?8",
            nativeQuery = true
    )
    Integer updateUser(String username, String user_fullname, String user_birtday, Integer user_gender, String user_email, String user_city, String user_phone, Integer user_id);


    // update thông tin user
    @Transactional
    @Modifying
    @Query(value = "UPDATE `users` SET `user_point`=?1  WHERE `user_id`= ?2",
            nativeQuery = true
    )
    Integer addPoint(Double point, Integer user_id);


    // lấy ra user
    User findByUsername(String username);


    // lấy ra tất cả thông tin user
    @Query(nativeQuery = true, value = "SELECT * FROM `users` WHERE `user_email` = ?1")
    User findByEmail(String email);

    @Query(nativeQuery = true, value = "SELECT * FROM `users` WHERE `user_phone` = ?1")
    User findByPhone(String email);

    @Query(nativeQuery = true, value = "SELECT `user_id` FROM `users` WHERE `username` = ?1")
    Integer findIdByUsername(String username);

    @Query(value = "SELECT `user_point` FROM `users` WHERE `user_id` = ?1", nativeQuery = true)
    Double getPoint(Integer user_id);

}
