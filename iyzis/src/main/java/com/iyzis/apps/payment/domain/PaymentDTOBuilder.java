package com.iyzis.apps.payment.domain;

import com.iyzis.apps.payment.domain.dto.PaymentDTO;
import com.iyzis.apps.payment.domain.entity.Payment;
import com.iyzis.core.domain.AbstractDTOBuilder;

import java.util.Date;

public class PaymentDTOBuilder extends AbstractDTOBuilder<PaymentDTO, Payment> {
    private String id;
    private String subscriptionId;
    private String vendor;
    private Double amount;
    private Date createdDate;

    public static PaymentDTOBuilder newInstance() {
        return new PaymentDTOBuilder();
    }

    @Override
    public PaymentDTOBuilder entity(Payment payment) {
        if (payment != null) {
            this.id = payment.getId();
            this.subscriptionId = payment.getSubscriptionId();
            this.vendor = payment.getVendor();
            this.createdDate = payment.getCreatedDate();
            this.amount = payment.getAmount();
        }

        return this;
    }

    public PaymentDTOBuilder id(String id) {
        this.id = id;
        return this;
    }

    public PaymentDTOBuilder subscription(String subscriptionId) {
        this.subscriptionId = subscriptionId;
        return this;
    }

    public PaymentDTOBuilder vendor(String vendor) {
        this.vendor = vendor;
        return this;
    }

    public PaymentDTOBuilder amount(Double amount) {
        this.amount = amount;
        return this;
    }

    @Override
    public PaymentDTO build() {
        PaymentDTO paymentDTO = new PaymentDTO();
        paymentDTO.setId(this.id);
        paymentDTO.setSubscriptionId(this.subscriptionId);
        paymentDTO.setVendor(this.vendor);
        paymentDTO.setAmount(this.amount);
        paymentDTO.setCreatedDate(this.createdDate);
        return paymentDTO;
    }
}
