package com.Ashish.BookMyShow.service;

import com.Ashish.BookMyShow.model.ShowSeat;
import com.Ashish.BookMyShow.repository.ShowSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowSeatService {
    @Autowired
    ShowSeatRepository showSeatRepository;

    public List<ShowSeat> getShowSeatsByIds(List<Integer> showSeatIds) {
        return showSeatRepository.findAllById(showSeatIds);
    }
}
