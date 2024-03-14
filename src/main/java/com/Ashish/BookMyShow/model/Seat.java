package com.Ashish.BookMyShow.model;

import com.Ashish.BookMyShow.model.constant.SeatStatus;
import com.Ashish.BookMyShow.model.constant.SeatType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Seat extends BaseModel{
    private int seatRow;
    private int col;
    private int seatNumber;

    @ManyToOne
    private Auditorium auditorium;

    @Enumerated(EnumType.STRING)
    private SeatType seatType;

    @Enumerated(EnumType.STRING)
    private SeatStatus seatStatus;
}
