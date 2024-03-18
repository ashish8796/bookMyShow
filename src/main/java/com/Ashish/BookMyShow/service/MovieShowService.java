package com.Ashish.BookMyShow.service;

import com.Ashish.BookMyShow.model.MovieShow;
import com.Ashish.BookMyShow.repository.MovieShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieShowService {

    @Autowired
    MovieShowRepository movieShowRepository;
    public MovieShow getMovieShowById(int showId) {
        return movieShowRepository.findById(showId).get();
    }
}
