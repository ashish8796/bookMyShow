package com.Ashish.BookMyShow.service;

import com.Ashish.BookMyShow.repository.AuditoriumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuditoriumService {
    @Autowired
    private AuditoriumRepository auditoriumRepository;
}
