package com.iyzis.apps.payment.api;

import com.iyzis.apps.payment.api.model.MakePaymentRequest;
import com.iyzis.apps.payment.api.model.PaymentResponse;
import com.iyzis.apps.payment.facade.PaymentFacade;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/iyzis/api/v1/payment")
public class PaymentApiRestController {

    private PaymentFacade paymentFacade;

    public PaymentApiRestController(PaymentFacade paymentFacade) {
        this.paymentFacade = paymentFacade;
    }

    @RequestMapping(value = "/make", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<PaymentResponse> makePayment(@RequestBody MakePaymentRequest request) {
        try {
            return this.paymentFacade.makePayment(request);
        } catch (Exception e) {
            PaymentResponse paymentResponse = new PaymentResponse();
            paymentResponse.setStatus(Boolean.FALSE);
            paymentResponse.setMessage(e.getMessage());
            return new ResponseEntity<>(paymentResponse, HttpStatus.BAD_REQUEST);
        }
    }

}
