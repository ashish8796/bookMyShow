package com.Ashish.BookMyShow.controller;

import com.Ashish.BookMyShow.service.AuditoriumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuditoriumController {
    @Autowired
    private AuditoriumService auditoriumService;

}
