package com.iyzis.apps.payment.api.model;

import java.math.BigDecimal;

public class PaymentBasketItemDTO {
    private String id;
    private BigDecimal price;
    private String name;

    public PaymentBasketItemDTO() {
    }

    public String getId() {
        return id;
    }

    public PaymentBasketItemDTO setId(String id) {
        this.id = id;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public PaymentBasketItemDTO setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getName() {
        return name;
    }

    public PaymentBasketItemDTO setName(String name) {
        this.name = name;
        return this;
    }
}
