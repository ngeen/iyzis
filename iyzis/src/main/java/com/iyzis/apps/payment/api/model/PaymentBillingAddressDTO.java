package com.iyzis.apps.payment.api.model;

public class PaymentBillingAddressDTO {
    private String address;
    private String zipCode;
    private String contactName;
    private String city;
    private String country;

    public PaymentBillingAddressDTO() {
    }

    public String getAddress() {
        return address;
    }

    public PaymentBillingAddressDTO setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getZipCode() {
        return zipCode;
    }

    public PaymentBillingAddressDTO setZipCode(String zipCode) {
        this.zipCode = zipCode;
        return this;
    }

    public String getContactName() {
        return contactName;
    }

    public PaymentBillingAddressDTO setContactName(String contactName) {
        this.contactName = contactName;
        return this;
    }

    public String getCity() {
        return city;
    }

    public PaymentBillingAddressDTO setCity(String city) {
        this.city = city;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public PaymentBillingAddressDTO setCountry(String country) {
        this.country = country;
        return this;
    }
}
