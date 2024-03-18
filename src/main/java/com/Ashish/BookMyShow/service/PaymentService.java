package com.Ashish.BookMyShow.service;

import com.Ashish.BookMyShow.model.Payment;
import com.Ashish.BookMyShow.model.Ticket;
import com.Ashish.BookMyShow.model.constant.PaymentMode;
import com.Ashish.BookMyShow.model.constant.PaymentStatus;
import com.Ashish.BookMyShow.model.constant.TicketStatus;
import com.Ashish.BookMyShow.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.concurrent.*;

@Service
public class PaymentService {
    @Autowired
    PaymentRepository paymentRepository;

    @Autowired
    TicketService ticketService;

    private final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

    public Payment makePayment(double amount, int ticketId, PaymentMode paymentMode) {
        Payment payment = new Payment();
        payment.setAmount(amount);
        payment.setPaymentTime(LocalDateTime.now());
        payment.setPaymentStatus(PaymentStatus.INPROGRESS);
        payment.setPaymentMode(paymentMode);

        CompletableFuture<Payment> future = new CompletableFuture<>();

        Ticket ticket = ticketService.getTicketById(ticketId);

        scheduler.schedule(() -> {
            try{
                Thread.sleep(5000);
            } catch(InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            payment.setPaymentStatus(PaymentStatus.PAID);
            ticket.setTicketStatus(TicketStatus.BOOKED);

            payment.setTicket(ticket);
            Payment savedPayment = paymentRepository.save(payment);

            future.complete(savedPayment);
        }, 5, TimeUnit.SECONDS);

        try {
            return future.get();
        } catch (InterruptedException | ExecutionException e) {
            return null;
        }
    }

    public Payment getByPaymentId(int paymentId) {
        return paymentRepository.findById(paymentId).get();
    }
}
