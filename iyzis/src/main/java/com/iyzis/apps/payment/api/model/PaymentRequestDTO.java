package com.iyzis.apps.payment.api.model;

import lombok.Data;

import javax.validation.constraints.NotNull;

public class PaymentRequestDTO {
    @NotNull
    private PaymentCardDTO paymentCard;
    @NotNull
    private PaymentBillingAddressDTO paymentBillingAddress;
    @NotNull
    private PaymentCustomerDTO paymentCustomer;
    @NotNull
    private PaymentBasketItemDTO paymentBasketItem;

    public PaymentRequestDTO() {
    }

    public PaymentCardDTO getPaymentCard() {
        return paymentCard;
    }

    public PaymentRequestDTO setPaymentCard(PaymentCardDTO paymentCard) {
        this.paymentCard = paymentCard;
        return this;
    }

    public PaymentBillingAddressDTO getPaymentBillingAddress() {
        return paymentBillingAddress;
    }

    public PaymentRequestDTO setPaymentBillingAddress(PaymentBillingAddressDTO paymentBillingAddress) {
        this.paymentBillingAddress = paymentBillingAddress;
        return this;
    }

    public PaymentCustomerDTO getPaymentCustomer() {
        return paymentCustomer;
    }

    public PaymentRequestDTO setPaymentCustomer(PaymentCustomerDTO paymentCustomer) {
        this.paymentCustomer = paymentCustomer;
        return this;
    }

    public PaymentBasketItemDTO getPaymentBasketItem() {
        return paymentBasketItem;
    }

    public PaymentRequestDTO setPaymentBasketItem(PaymentBasketItemDTO paymentBasketItem) {
        this.paymentBasketItem = paymentBasketItem;
        return this;
    }
}
