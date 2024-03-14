package com.Ashish.BookMyShow.model;

import com.Ashish.BookMyShow.model.constant.TicketStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class Ticket extends BaseModel{
    private LocalDateTime timeOfBooking;
    private double totalAmount;

    @ManyToOne
    private MovieShow movieShow;

    @OneToMany
    private List<ShowSeat> showSeats;

    @Enumerated(EnumType.STRING)
    private TicketStatus ticketStatus;
}
