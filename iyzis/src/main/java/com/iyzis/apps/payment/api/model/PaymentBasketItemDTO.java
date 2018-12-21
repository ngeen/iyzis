package com.iyzis.apps.payment.api.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PaymentBasketItemDTO {
    private String id;
    private BigDecimal price;
    private String name;

}
