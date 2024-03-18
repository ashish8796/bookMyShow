package com.Ashish.BookMyShow.service;

import com.Ashish.BookMyShow.model.Payment;
import com.Ashish.BookMyShow.model.constant.PaymentMode;
import com.Ashish.BookMyShow.model.constant.PaymentStatus;
import com.Ashish.BookMyShow.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PaymentService {
    @Autowired
    PaymentRepository paymentRepository;

    public Payment makePayment(double amount, int TicketId, PaymentMode paymentMode) {
        Payment payment = new Payment();
        payment.setAmount(amount);
        payment.setPaymentTime(LocalDateTime.now());

        payment.setPaymentStatus(PaymentStatus.INPROGRESS);
    }
}
