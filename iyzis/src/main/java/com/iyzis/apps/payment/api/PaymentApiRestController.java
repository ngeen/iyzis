package com.iyzis.apps.payment.api;

import com.iyzis.apps.payment.api.model.MakePaymentRequest;
import com.iyzis.apps.payment.api.model.PaymentResponse;
import com.iyzis.apps.payment.facade.PaymentFacade;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController(value = "/api/v1/payment")
public class PaymentApiRestController {

    private PaymentFacade paymentFacade;

    public PaymentApiRestController(PaymentFacade paymentFacade) {
        this.paymentFacade = paymentFacade;
    }


    @PostMapping(value = "/make", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<PaymentResponse> makePayment(MakePaymentRequest request, HttpServletRequest servletRequest) {
        return this.paymentFacade.makePayment(request);
    }

    private static String getClientIp(HttpServletRequest request) {

        String remoteAddr = "";
        if (request != null) {
            remoteAddr = request.getHeader("X-FORWARDED-FOR");
            if (remoteAddr == null || "".equals(remoteAddr)) {
                remoteAddr = request.getRemoteAddr();
            }
        }
        return remoteAddr;
    }
}
