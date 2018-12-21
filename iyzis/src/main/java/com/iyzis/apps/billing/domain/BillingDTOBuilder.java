package com.iyzis.apps.billing.domain;

import com.iyzis.apps.billing.domain.dto.BillingDTO;
import com.iyzis.apps.billing.domain.entity.Billing;
import com.iyzis.core.domain.AbstractDTOBuilder;

import java.util.Date;

public class BillingDTOBuilder extends AbstractDTOBuilder<BillingDTO, Billing> {
    private String id;
    private String subscriptionId;
    private String paymentId;
    private String name;
    private String lastName;
    private String country;
    private String city;
    private String address;
    private String zipCode;
    private Date createdDate;

    public static BillingDTOBuilder newInstance() {
        return new BillingDTOBuilder();
    }

    @Override
    public BillingDTOBuilder entity(Billing billing) {
        if (billing != null) {
            this.id = billing.getId();
            this.subscriptionId = billing.getSubscriptionId();
            this.paymentId = billing.getPaymentId();
            this.name = billing.getName();
            this.lastName = billing.getLastName();
            this.country = billing.getCountry();
            this.city = billing.getCity();
            this.address = billing.getAddress();
            this.zipCode = billing.getZipCode();
            this.createdDate = billing.getCreatedDate();

        }
        return this;
    }

    public BillingDTOBuilder id(String id) {
        this.id = id;
        return this;
    }

    public BillingDTOBuilder subscription(String subscriptionId) {
        this.subscriptionId = subscriptionId;
        return this;
    }

    public BillingDTOBuilder payment(String paymentId) {
        this.paymentId = paymentId;
        return this;
    }

    public BillingDTOBuilder name(String name) {
        this.name = name;
        return this;
    }

    public BillingDTOBuilder lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public BillingDTOBuilder country(String country) {
        this.country = country;
        return this;
    }

    public BillingDTOBuilder city(String city) {
        this.city = city;
        return this;
    }

    public BillingDTOBuilder address(String address) {
        this.address = address;
        return this;
    }

    public BillingDTOBuilder zipCode(String zipCode) {
        this.zipCode = zipCode;
        return this;
    }

    @Override
    public BillingDTO build() {
        BillingDTO billingDTO = new BillingDTO();
        billingDTO.setId(this.id);
        billingDTO.setSubscriptionId(this.subscriptionId);
        billingDTO.setPaymentId(this.paymentId);
        billingDTO.setName(this.name);
        billingDTO.setLastName(this.lastName);
        billingDTO.setCountry(this.country);
        billingDTO.setCity(this.city);
        billingDTO.setAddress(this.address);
        billingDTO.setZipCode(this.zipCode);
        billingDTO.setCreatedDate(this.createdDate);
        return billingDTO;
    }
}
