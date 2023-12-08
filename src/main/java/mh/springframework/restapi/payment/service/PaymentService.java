package mh.springframework.restapi.payment.service;

import mh.springframework.restapi.payment.model.Payment;
import mh.springframework.restapi.payment.model.exceptions.PaymentSystemLimitationReachedException;
import mh.springframework.restapi.payment.model.exceptions.UnexpectedPaymentAmountException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class PaymentService {

    public Payment proceed(Payment payment) {
        if (payment.amount() <= 0) {
            throw new UnexpectedPaymentAmountException("Payment amount should be greater than zero!");
        }
        if (payment.amount() >= 10000) {
            throw new PaymentSystemLimitationReachedException("Payment amount exceeds payment system limitations. System accepts payments up to 10000 ");
        }
        return new Payment(UUID.randomUUID().toString(), payment.amount(), LocalDateTime.now());
    }
}
