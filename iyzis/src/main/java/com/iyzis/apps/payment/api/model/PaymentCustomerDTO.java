package com.iyzis.apps.payment.api.model;

public class PaymentCustomerDTO {
    private String id;
    private String name;
    private String surname;
    private String identityNumber;
    private String email;
    private String gsmNumber;
    private String registrationDate;
    private String lastLoginDate;
    private String registrationAddress;
    private String city;
    private String country;
    private String zipCode;
    private String ip;

    public PaymentCustomerDTO() {
    }

    public String getId() {
        return id;
    }

    public PaymentCustomerDTO setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public PaymentCustomerDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public PaymentCustomerDTO setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public PaymentCustomerDTO setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public PaymentCustomerDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getGsmNumber() {
        return gsmNumber;
    }

    public PaymentCustomerDTO setGsmNumber(String gsmNumber) {
        this.gsmNumber = gsmNumber;
        return this;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public PaymentCustomerDTO setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
        return this;
    }

    public String getLastLoginDate() {
        return lastLoginDate;
    }

    public PaymentCustomerDTO setLastLoginDate(String lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
        return this;
    }

    public String getRegistrationAddress() {
        return registrationAddress;
    }

    public PaymentCustomerDTO setRegistrationAddress(String registrationAddress) {
        this.registrationAddress = registrationAddress;
        return this;
    }

    public String getCity() {
        return city;
    }

    public PaymentCustomerDTO setCity(String city) {
        this.city = city;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public PaymentCustomerDTO setCountry(String country) {
        this.country = country;
        return this;
    }

    public String getZipCode() {
        return zipCode;
    }

    public PaymentCustomerDTO setZipCode(String zipCode) {
        this.zipCode = zipCode;
        return this;
    }

    public String getIp() {
        return ip;
    }

    public PaymentCustomerDTO setIp(String ip) {
        this.ip = ip;
        return this;
    }
}
