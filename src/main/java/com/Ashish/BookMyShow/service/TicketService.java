package com.Ashish.BookMyShow.service;

import com.Ashish.BookMyShow.model.MovieShow;
import com.Ashish.BookMyShow.model.ShowSeat;
import com.Ashish.BookMyShow.model.Ticket;
import com.Ashish.BookMyShow.model.User;
import com.Ashish.BookMyShow.model.constant.TicketStatus;
import com.Ashish.BookMyShow.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    MovieShowService movieShowService;

    @Autowired
    ShowSeatService showSeatService;

    @Autowired
    UserService userService;

    public Ticket getTicketById(int ticketId) {
        return ticketRepository.findById(ticketId).get();
    }

    public Ticket createTicket(double totalAmount, int showId, List<Integer> showSeatIds, int userId) {
        Ticket ticket  = new Ticket();
        ticket.setTimeOfBooking(LocalDateTime.now());
        ticket.setTotalAmount(totalAmount);
        ticket.setTicketStatus(TicketStatus.INPROGRESS);

        MovieShow movieShow = movieShowService.getMovieShowById(showId);
        ticket.setMovieShow(movieShow);

        List<ShowSeat> showSeats = showSeatService.getShowSeatsByIds(showSeatIds);
        ticket.setShowSeats(showSeats);

        Ticket savedTicket = ticketRepository.save(ticket);

        // adding ticket in the ticket array of a particular user
        User user = userService.getUserById(userId);
        user.addTicket(ticket);

        return savedTicket;
    }

    public boolean deleteTicket(int ticketId) {
        ticketRepository.deleteById(ticketId);
        return true;
    }
}
