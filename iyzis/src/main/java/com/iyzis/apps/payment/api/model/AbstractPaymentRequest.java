package com.iyzis.apps.payment.api.model;

import lombok.Data;

import javax.validation.Valid;

@Data
@Valid
public abstract class AbstractPaymentRequest {

    // vendor
    private String vendor;

    // subscription period
    private String period;

    // service type
    private String serviceType;

    // payment request
    private PaymentRequestDTO paymentRequestDTO;

}
