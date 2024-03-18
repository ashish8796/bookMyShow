package com.Ashish.BookMyShow.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class TicketRequestDTO {
    private double totalAmount;
    private int showId;
    private List<Integer> showSeatIds;
    private int userId;
}
