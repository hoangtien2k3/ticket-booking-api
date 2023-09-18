package com.hoangtien2k3.ticketbookingapi.controller;

import com.hoangtien2k3.ticketbookingapi.entity.User;
import com.hoangtien2k3.ticketbookingapi.dao.UserNameProfile;
import com.hoangtien2k3.ticketbookingapi.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.HashMap;

@RestController
@Api(value = "API User")
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @ApiOperation(value = "User Register")
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody User user){
        return ResponseEntity.ok(userService.registerUser(user));
    }

    @ApiOperation(value = "Update later")
    @PostMapping("/update")
    public ResponseEntity<?> updateUser(Authentication authentication, @Valid @RequestBody UserNameProfile user) throws ParseException {
        return ResponseEntity.ok(userService.updateUser(authentication, user));
    }

    @ApiOperation(value = "Login - Get Token Login")
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@Valid @RequestBody HashMap<String, String> request){
        return ResponseEntity.ok(userService.loginUser(request.get("username"), request.get("password")));
    }

    @GetMapping("/info")
    public ResponseEntity<?> getInfo(Authentication authentication){
        return ResponseEntity.ok(userService.getInfo(authentication));
    }
}
