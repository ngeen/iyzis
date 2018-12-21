package com.iyzis.apps.payment.api.model;

import lombok.Data;

@Data
public class PaymentRequestDTO {
    private PaymentCardDTO paymentCardDTO;
    private PaymentBillingAddressDTO paymentBillingAddressDTO;
    private PaymentCustomerDTO paymentCustomerDTO;
    private PaymentBasketItemDTO paymentBasketItemDTO;
}
