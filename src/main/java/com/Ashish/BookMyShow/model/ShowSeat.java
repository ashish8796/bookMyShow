package com.Ashish.BookMyShow.model;

import com.Ashish.BookMyShow.model.constant.ShowSeatStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ShowSeat extends BaseModel{
    private int price;
    @ManyToOne
    private Auditorium auditorium;
    @ManyToOne
    private Seat seat;
    @ManyToOne
    private MovieShow movieShow;
    @Enumerated(EnumType.STRING)
    private ShowSeatStatus showSeatStatus;
}
