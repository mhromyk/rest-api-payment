package mh.springframework.restapi.payment.model.exceptions;

public class UnexpectedPaymentAmountException extends RuntimeException{
    public UnexpectedPaymentAmountException(String message) {
        super(message);
    }
}
