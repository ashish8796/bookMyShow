package com.Ashish.BookMyShow.model;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@MappedSuperclass
public abstract class BaseModel {
    @Getter
    @Id // tells that the attribute private int id is the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;
    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt;
    @Column(name = "CREATED_BY")
    private String createdBy;
    @Column(name = "UPDATED_AT")
    private LocalDateTime updatedAt;
    @Column(name = "UPDATED_BY")
    private String updatedBy;
}
