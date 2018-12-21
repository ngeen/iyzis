package com.iyzis.apps.customer.domain;

import com.iyzis.apps.customer.domain.dto.CustomerDTO;
import com.iyzis.apps.customer.domain.entity.Customer;
import com.iyzis.core.domain.AbstractEntityBuilder;

public class CustomerEntityBuilder extends AbstractEntityBuilder<Customer, CustomerDTO> {
    private String id;
    private String name;
    private String surname;
    private String email;
    private String companyName;
    private int companySize;
    private String country;
    private String phoneNumber;


    public CustomerEntityBuilder id(String id) {
        this.id = id;
        return this;
    }
    public CustomerEntityBuilder email(String email) {
        this.email = email;
        return this;
    }

    public CustomerEntityBuilder name(String name) {
        this.name = name;
        return this;
    }

    public CustomerEntityBuilder surname(String surname) {
        this.surname = surname;
        return this;
    }

    public CustomerEntityBuilder companyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public CustomerEntityBuilder companySize(int companySize) {
        this.companySize = companySize;
        return this;
    }

    public CustomerEntityBuilder country(String country) {
        this.country = country;
        return this;
    }

    public CustomerEntityBuilder phoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    @Override
    public CustomerEntityBuilder dto(CustomerDTO dto) {
        if (dto != null) {
            this.name = dto.getName();
            this.surname = dto.getSurname();
            this.email = dto.getEmail();
            this.companyName = dto.getCompanyName();
            this.companySize = dto.getCompanySize();
            this.country = dto.getCountry();
            this.phoneNumber = dto.getPhoneNumber();
        }
        return this;
    }

    @Override
    public Customer build() {
        Customer customer = new Customer();
        customer.setId(this.id);
        customer.setName(this.name);
        customer.setSurname(this.surname);
        customer.setEmail(this.email);
        customer.setCompanyName(this.companyName);
        customer.setCompanySize(this.companySize);
        customer.setCountry(this.country);
        customer.setPhoneNumber(this.phoneNumber);
        return customer;
    }

    public static CustomerEntityBuilder newInstance() {
        return new CustomerEntityBuilder();
    }
}
