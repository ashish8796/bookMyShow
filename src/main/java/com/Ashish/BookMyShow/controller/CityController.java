package com.Ashish.BookMyShow.controller;

import com.Ashish.BookMyShow.dto.CityRequestDTO;
import com.Ashish.BookMyShow.model.City;
import com.Ashish.BookMyShow.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/city")
public class CityController {
    @Autowired
    CityService cityService;

    @GetMapping("/all")
    public ResponseEntity getAllCities(){
        List<City> cities = cityService.getAllCities();
        return ResponseEntity.ok(cities);
    }

    @GetMapping("/{name}")
    public ResponseEntity getCityByName(@PathVariable("name") String cityName) {
        City city = cityService.getCityByName(cityName);
        return ResponseEntity.ok(city);
    }

    @PostMapping("/save")
    public ResponseEntity createCity(@RequestBody CityRequestDTO cityRequestDTO) {
        City city = cityService.saveCity(cityRequestDTO.getName());

        return ResponseEntity.ok(city);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCity(@PathVariable("id") int cityId) {
        boolean isDeleted = cityService.deleteCity(cityId);
        return ResponseEntity.ok(isDeleted);
    }
}
