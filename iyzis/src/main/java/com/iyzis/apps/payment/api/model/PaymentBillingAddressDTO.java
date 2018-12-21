package com.iyzis.apps.payment.api.model;

import lombok.Data;

@Data
public class PaymentBillingAddressDTO {
    private String address;
    private String zipCode;
    private String contactName;
    private String city;
    private String country;
}
