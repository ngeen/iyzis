package com.iyzis.apps.payment.api.model;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
@Valid
public abstract class AbstractPaymentRequest {

    // vendor
    @NotNull
    private String vendor;

    // subscription period
    @NotNull
    private String period;

    // service type
    @NotNull
    private String serviceType;

    // payment request
    @NotNull
    private PaymentRequestDTO paymentRequest;

}
