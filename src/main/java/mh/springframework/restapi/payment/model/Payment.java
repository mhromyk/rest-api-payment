package mh.springframework.restapi.payment.model;

import java.time.LocalDateTime;

public record Payment(String paymentId, double amount, LocalDateTime paymentDate) {
}
