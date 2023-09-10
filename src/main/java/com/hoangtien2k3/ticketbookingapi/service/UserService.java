package com.hoangtien2k3.ticketbookingapi.service;

import com.hoangtien2k3.ticketbookingapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;



}
