package com.iyzis.apps.payment.api.model;

import lombok.Data;

@Data
public class PaymentCardDTO {
    private String cardHolderName;
    private String cardNumber;
    private String expireYear;
    private String expireMonth;
    private String cvc;
    private Integer registerCard;
}
