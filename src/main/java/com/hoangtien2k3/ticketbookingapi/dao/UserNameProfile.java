package com.hoangtien2k3.ticketbookingapi.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserNameProfile {
    private int userId;
    private String username;
    private String userAvatar;
    private String userFullname;
    private String userBirthday;
    private int userGender;
    private String userEmail;
    private String userCity;
    private String userPhone;
    private int userPoint;
}
