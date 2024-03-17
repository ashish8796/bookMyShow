package com.Ashish.BookMyShow.service;

import com.Ashish.BookMyShow.model.City;
import com.Ashish.BookMyShow.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityService {
    @Autowired
    private CityRepository cityRepository;

    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    public City getCityByName(String cityName) {
        return cityRepository.findCityByName(cityName);
    }

    public City saveCity(String cityName) {
        City city = new City();
        city.setName(cityName);
        city.setTheatres(new ArrayList<>());

        return cityRepository.save(city);
    }

    public City getCityById(int cityId) {
        return cityRepository.findById(cityId).get();
    }

    public City saveCity(City city) {
        return cityRepository.save(city);
    }

    public boolean deleteCity(int cityId) {
        cityRepository.deleteById(cityId);
        return true;
    }

}
