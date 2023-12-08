package mh.springframework.restapi.payment.model.exceptions;

public class PaymentSystemLimitationReachedException extends RuntimeException {
    public PaymentSystemLimitationReachedException(String message) {
        super(message);
    }
}
