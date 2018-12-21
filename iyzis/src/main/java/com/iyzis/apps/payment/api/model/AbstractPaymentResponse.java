package com.iyzis.apps.payment.api.model;

import lombok.Data;


@Data
public abstract class AbstractPaymentResponse {
    private Boolean status;
    private String message;
}
