package com.Ashish.BookMyShow.controller;

import com.Ashish.BookMyShow.service.InitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InitController {
    @Autowired
    InitService initService;

    @GetMapping("/")
    public ResponseEntity healthCheck() {
        return ResponseEntity.ok("Welcome to BookMyShow API.");
    }

}
