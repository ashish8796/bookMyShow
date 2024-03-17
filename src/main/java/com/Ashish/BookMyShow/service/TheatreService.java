package com.Ashish.BookMyShow.service;

import com.Ashish.BookMyShow.model.City;
import com.Ashish.BookMyShow.model.Theatre;
import com.Ashish.BookMyShow.repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheatreService {
    @Autowired
    private TheatreRepository theatreRepository;

    @Autowired
    private CityService cityService;

    public Theatre saveTheatre(String name, String address, int cityId) {
        Theatre theatre = new Theatre();
        theatre.setName(name);
        theatre.setAddress(address);
        theatre.setAuditoriums(new ArrayList<>());

        City city = cityService.getCityById(cityId);
        List<Theatre> theatres = city.getTheatres();
        theatres.add(theatre);
        city.setTheatres(theatres);
        cityService.saveCity(city);

        return theatreRepository.save(theatre);
    }

}
