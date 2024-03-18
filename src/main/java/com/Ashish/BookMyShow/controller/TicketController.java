package com.Ashish.BookMyShow.controller;

import com.Ashish.BookMyShow.dto.TicketRequestDTO;
import com.Ashish.BookMyShow.model.Ticket;
import com.Ashish.BookMyShow.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ticket")
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @GetMapping("/{id}")
    public ResponseEntity getTicketById(@PathVariable("id") int ticketId) {
        Ticket ticket = ticketService.getTicketById(ticketId);
        return ResponseEntity.ok(ticket);
    }

    @PostMapping("/create")
    public ResponseEntity bookTicket(@RequestBody TicketRequestDTO ticketRequestDTO) {
        Ticket ticket = ticketService.bookTicket(ticketRequestDTO.getTotalAmount(), ticketRequestDTO.getShowId(), ticketRequestDTO.getShowSeatIds(), ticketRequestDTO.getUserId());
        return ResponseEntity.ok(ticket);
    }

}
