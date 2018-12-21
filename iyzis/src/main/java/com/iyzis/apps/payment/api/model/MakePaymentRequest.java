package com.iyzis.apps.payment.api.model;

import lombok.Data;

import javax.validation.constraints.NotNull;

public class MakePaymentRequest  {

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

    public MakePaymentRequest() {
    }

    public String getVendor() {
        return vendor;
    }

    public MakePaymentRequest setVendor(String vendor) {
        this.vendor = vendor;
        return this;
    }

    public String getPeriod() {
        return period;
    }

    public MakePaymentRequest setPeriod(String period) {
        this.period = period;
        return this;
    }

    public String getServiceType() {
        return serviceType;
    }

    public MakePaymentRequest setServiceType(String serviceType) {
        this.serviceType = serviceType;
        return this;
    }

    public PaymentRequestDTO getPaymentRequest() {
        return paymentRequest;
    }

    public MakePaymentRequest setPaymentRequest(PaymentRequestDTO paymentRequest) {
        this.paymentRequest = paymentRequest;
        return this;
    }
}
