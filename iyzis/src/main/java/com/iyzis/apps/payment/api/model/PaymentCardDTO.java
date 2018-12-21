package com.iyzis.apps.payment.api.model;

public class PaymentCardDTO {
    private String cardHolderName;
    private String cardNumber;
    private String expireYear;
    private String expireMonth;
    private String cvc;
    private Integer registerCard;

    public PaymentCardDTO() {
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public PaymentCardDTO setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
        return this;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public PaymentCardDTO setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
        return this;
    }

    public String getExpireYear() {
        return expireYear;
    }

    public PaymentCardDTO setExpireYear(String expireYear) {
        this.expireYear = expireYear;
        return this;
    }

    public String getExpireMonth() {
        return expireMonth;
    }

    public PaymentCardDTO setExpireMonth(String expireMonth) {
        this.expireMonth = expireMonth;
        return this;
    }

    public String getCvc() {
        return cvc;
    }

    public PaymentCardDTO setCvc(String cvc) {
        this.cvc = cvc;
        return this;
    }

    public Integer getRegisterCard() {
        return registerCard;
    }

    public PaymentCardDTO setRegisterCard(Integer registerCard) {
        this.registerCard = registerCard;
        return this;
    }
}
