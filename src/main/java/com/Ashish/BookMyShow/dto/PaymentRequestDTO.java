package com.Ashish.BookMyShow.dto;

import com.Ashish.BookMyShow.model.constant.PaymentMode;
import lombok.Getter;

@Getter
public class PaymentRequestDTO {
    private double amount;
    private int ticketId;
    private PaymentMode paymentMode;
}
