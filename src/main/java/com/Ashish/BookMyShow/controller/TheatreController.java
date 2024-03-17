package com.Ashish.BookMyShow.controller;

import com.Ashish.BookMyShow.dto.TheatreRequestDTO;
import com.Ashish.BookMyShow.model.Theatre;
import com.Ashish.BookMyShow.service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/theatre")
public class TheatreController {
    @Autowired
    private TheatreService theatreService;

    @PostMapping("/add")
    public ResponseEntity createTheatre(@RequestBody TheatreRequestDTO theatreRequestDTO) {
        Theatre theatre =  theatreService.saveTheatre(theatreRequestDTO.getName(), theatreRequestDTO.getAddress(), theatreRequestDTO.getCityId());
        return ResponseEntity.ok(theatre);
    }
}
