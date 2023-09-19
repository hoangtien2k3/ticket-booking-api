package com.hoangtien2k3.ticketbookingapi.service;

import com.hoangtien2k3.ticketbookingapi.config.JwtToken;
import com.hoangtien2k3.ticketbookingapi.entity.User;
import com.hoangtien2k3.ticketbookingapi.dao.ResponseData;
import com.hoangtien2k3.ticketbookingapi.dao.UserNameProfile;
import com.hoangtien2k3.ticketbookingapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtToken token;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public ResponseData<Integer> registerUser(@RequestBody User user) {
        if (userRepository.findByUsername(user.getUsername()) != null) {
            return new ResponseData(HttpStatus.OK, "Register failed, user existed", 0);
        }
        if (userRepository.findByUsername(user.getUserEmail()) != null) {
            return new ResponseData(HttpStatus.OK, "Register failed, email existed", 0);
        }
        if (userRepository.findByUsername(user.getUserPhone()) != null) {
            return new ResponseData(HttpStatus.OK, "Register failed, phone existed", 0);
        }

        String avatar;
        if (user.getUserGender() == 1) {
            avatar = "https://github.com/hoangtien2k3qx1/ticket-booking-api/blob/master/image/male.png";
        } else {
            avatar = "https://github.com/hoangtien2k3qx1/ticket-booking-api/blob/master/image/female.png";
        }

        return new ResponseData(HttpStatus.OK, "success", userRepository.registerUser(user.getUsername(), passwordEncoder.encode(user.getPassword()), avatar, user.getUserFullname(), user.getUserBirthday(), user.getUserGender(), user.getUserEmail(), user.getUserCity(), user.getUserPhone()));
    }

    public ResponseData<String> loginUser(String username, String password) {

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = token.generateToken((UserDetails) authentication.getPrincipal());

        return new ResponseData(HttpStatus.OK, "successfully", jwt);
    }

    public ResponseData<String> updateUser(Authentication authentication, UserNameProfile userNameProfile) {

        Integer userId = userRepository.findIdByUsername(authentication.getName());

        Integer rs = userRepository.updateUser(userNameProfile.getUsername(),
                userNameProfile.getUserFullname(),
                userNameProfile.getUserBirthday(),
                userNameProfile.getUserGender(),
                userNameProfile.getUserEmail(),
                userNameProfile.getUserCity(),
                userNameProfile.getUserPhone(),
                userId
        );

        return new ResponseData(HttpStatus.OK, "successfully", rs);
    }

    public ResponseData<User> getInfo(Authentication authentication) {
        return new ResponseData(HttpStatus.OK, "successfully", userRepository.findByUsername(authentication.getName()));
    }

}
