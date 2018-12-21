package com.iyzis.apps.payment.domain;

import com.iyzis.apps.payment.domain.dto.PaymentDTO;
import com.iyzis.apps.payment.domain.entity.Payment;
import com.iyzis.core.domain.AbstractEntityBuilder;

public class PaymentEntityBuilder extends AbstractEntityBuilder<Payment, PaymentDTO> {
    private String id;
    private String subscriptionId;
    private String vendor;
    private Double amount;

    public PaymentEntityBuilder id(String id) {
        this.id = id;
        return this;
    }

    public PaymentEntityBuilder subscription(String subscriptionId) {
        this.subscriptionId = subscriptionId;
        return this;
    }

    public PaymentEntityBuilder vendor(String vendor) {
        this.vendor = vendor;
        return this;
    }

    public PaymentEntityBuilder amount(Double amount) {
        this.amount = amount;
        return this;
    }


    @Override
    public PaymentEntityBuilder dto(PaymentDTO dto) {
        if (dto != null) {
            this.id = dto.getId();
            this.subscriptionId = dto.getSubscriptionId();
            this.vendor = dto.getVendor();
            this.amount = dto.getAmount();
        }
        return this;
    }

    @Override
    public Payment build() {
        Payment payment = new Payment();
        payment.setId(this.id);
        payment.setSubscriptionId(this.subscriptionId);
        payment.setVendor(this.vendor);
        payment.setAmount(this.amount);

        return payment;
    }

    public static PaymentEntityBuilder newInstance() {
        return new PaymentEntityBuilder();
    }
}
