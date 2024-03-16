package com.Ashish.BookMyShow.controller;

import com.Ashish.BookMyShow.dto.UserSignUpRequestDTO;
import com.Ashish.BookMyShow.model.User;
import com.Ashish.BookMyShow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/signUp")
    public ResponseEntity signUp(@RequestBody UserSignUpRequestDTO signUpDto) {

        User user = userService.signup(signUpDto.getName(), signUpDto.getEmail(), signUpDto.getPassword());

        return ResponseEntity.ok(user);
    }
}
