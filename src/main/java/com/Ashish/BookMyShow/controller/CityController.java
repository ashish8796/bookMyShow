package com.Ashish.BookMyShow.controller;

import com.Ashish.BookMyShow.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityController {
    @Autowired
    CityService cityService;

    @GetMapping("/hello")
    public ResponseEntity getHello() {
        String helloData  = cityService.getHello();
        return ResponseEntity.ok(helloData);
    }
}
