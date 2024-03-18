package com.Ashish.BookMyShow.controller;

import com.Ashish.BookMyShow.dto.PaymentRequestDTO;
import com.Ashish.BookMyShow.model.Payment;
import com.Ashish.BookMyShow.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pay")
public class PaymentController {
    @Autowired
    PaymentService paymentService;

    @PostMapping("/")
    public ResponseEntity makePayment(@RequestBody PaymentRequestDTO paymentRequestDTO) {
        Payment payment = paymentService.makePayment(paymentRequestDTO.getAmount(), paymentRequestDTO.getTicketId(), paymentRequestDTO.getPaymentMode());
        return ResponseEntity.ok(payment);
    }


    @GetMapping("/payment/{id}")
    public ResponseEntity getPaymentById(@PathVariable("id") int paymentId) {
        Payment payment = paymentService.getByPaymentId(paymentId);
        return ResponseEntity.ok(payment);
    }

}
