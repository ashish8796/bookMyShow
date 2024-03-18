package com.Ashish.BookMyShow.dto;

import com.Ashish.BookMyShow.model.constant.AuditoriumFeature;
import lombok.Getter;

import java.util.List;

@Getter
public class AuditoriumRequestDTO {
    private String name;
    private int capacity;
    private List<AuditoriumFeature> auditoriumFeatures;
}
