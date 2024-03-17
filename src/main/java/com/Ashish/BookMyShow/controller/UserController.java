package com.Ashish.BookMyShow.controller;

import com.Ashish.BookMyShow.dto.UserLoginRequestDTO;
import com.Ashish.BookMyShow.dto.UserSignUpRequestDTO;
import com.Ashish.BookMyShow.exception.UserException.UserAlreadyExistsException;
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

    @PostMapping("/signup")
    public ResponseEntity signUp(@RequestBody UserSignUpRequestDTO userSignUpDto) {
        if(userService.userExists(userSignUpDto.getEmail())){
            throw new UserAlreadyExistsException("User with this email already exists.");
        }

        User user = userService.signup(userSignUpDto.getName(), userSignUpDto.getEmail(), userSignUpDto.getPassword());

        return ResponseEntity.ok(user);
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody UserLoginRequestDTO userLoginRequestDTO) {
        User user = userService.login(userLoginRequestDTO.getEmail(), userLoginRequestDTO.getPassword());
        return ResponseEntity.ok(user);
    }
}
