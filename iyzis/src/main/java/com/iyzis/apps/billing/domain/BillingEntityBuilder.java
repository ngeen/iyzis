package com.iyzis.apps.billing.domain;

import com.iyzis.apps.billing.domain.dto.BillingDTO;
import com.iyzis.apps.billing.domain.entity.Billing;
import com.iyzis.core.domain.AbstractEntityBuilder;

public class BillingEntityBuilder extends AbstractEntityBuilder<Billing, BillingDTO> {
    private String id;
    private String subscriptionId;
    private String paymentId;
    private String name;
    private String lastName;
    private String country;
    private String city;
    private String address;
    private String zipCode;

    public BillingEntityBuilder id(String id) {
        this.id = id;
        return this;
    }

    public BillingEntityBuilder subscription(String subscriptionId) {
        this.subscriptionId = subscriptionId;
        return this;
    }

    public BillingEntityBuilder payment(String paymentId) {
        this.paymentId = paymentId;
        return this;
    }

    public BillingEntityBuilder name(String name) {
        this.name = name;
        return this;
    }

    public BillingEntityBuilder lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public BillingEntityBuilder country(String country) {
        this.country = country;
        return this;
    }

    public BillingEntityBuilder city(String city) {
        this.city = city;
        return this;
    }

    public BillingEntityBuilder address(String address) {
        this.address = address;
        return this;
    }

    public BillingEntityBuilder zipCode(String zipCode) {
        this.zipCode = zipCode;
        return this;
    }

    @Override
    public BillingEntityBuilder dto(BillingDTO dto) {
        if (dto != null) {
            this.id = dto.getId();
            this.subscriptionId = dto.getSubscriptionId();
            this.paymentId = dto.getPaymentId();
            this.name = dto.getName();
            this.lastName = dto.getLastName();
            this.country = dto.getCountry();
            this.city = dto.getCity();
            this.address = dto.getAddress();
            this.zipCode = dto.getZipCode();
        }
        return this;
    }

    @Override
    public Billing build() {
        Billing billing = new Billing();
        billing.setId(this.id);
        billing.setSubscriptionId(this.subscriptionId);
        billing.setPaymentId(this.paymentId);
        billing.setName(this.name);
        billing.setLastName(this.lastName);
        billing.setCountry(this.country);
        billing.setCity(this.city);
        billing.setAddress(this.address);
        billing.setZipCode(this.zipCode);

        return billing;
    }

    public static BillingEntityBuilder newInstance() {
        return new BillingEntityBuilder();
    }
}
