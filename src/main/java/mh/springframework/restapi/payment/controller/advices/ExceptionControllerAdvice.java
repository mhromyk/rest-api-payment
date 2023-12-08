package mh.springframework.restapi.payment.controller.advices;


import mh.springframework.restapi.payment.model.errors.ErrorDetails;
import mh.springframework.restapi.payment.model.exceptions.PaymentSystemLimitationReachedException;
import mh.springframework.restapi.payment.model.exceptions.UnexpectedPaymentAmountException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(value = {PaymentSystemLimitationReachedException.class, UnexpectedPaymentAmountException.class})
    public ResponseEntity<ErrorDetails> handlingBadRequest(RuntimeException exception) {
        return ResponseEntity.status(BAD_REQUEST).body(new ErrorDetails(exception.getMessage()));
    }

}