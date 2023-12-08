package mh.springframework.restapi.payment.controller;


import mh.springframework.restapi.payment.model.Payment;
import mh.springframework.restapi.payment.service.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

import static org.springframework.http.HttpStatus.ACCEPTED;

@RestController
public class PaymentController {

    private final Logger logger = Logger.getLogger(PaymentController.class.getName());
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/payment")
    public ResponseEntity<Payment> makePayment(@RequestHeader String requestId, @RequestBody Payment payment) {
        logger.info("Request id = " + requestId + "; Received payment request: " + payment);
        Payment result = paymentService.proceed(payment);
        logger.info("Request id= " + requestId + "; Payment response: " + result);
        return ResponseEntity.status(ACCEPTED).body(result);
    }
}
