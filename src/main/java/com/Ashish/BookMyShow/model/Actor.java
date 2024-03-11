package com.Ashish.BookMyShow.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Actor extends BaseModel{
    private String name;
    @ManyToMany
    private List<Movie> movies;
}

/* Actor            Movie
    1                 M
    M                 1
 */