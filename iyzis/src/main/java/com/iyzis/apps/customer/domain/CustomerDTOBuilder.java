package com.iyzis.apps.customer.domain;

import com.iyzis.apps.customer.domain.dto.CustomerDTO;
import com.iyzis.apps.customer.domain.entity.Customer;
import com.iyzis.core.domain.AbstractDTOBuilder;
import org.springframework.stereotype.Component;

import java.util.Date;

public class CustomerDTOBuilder extends AbstractDTOBuilder<CustomerDTO, Customer> {
    private String id;
    private String name;
    private String surname;
    private String email;
    private String companyName;
    private Integer companySize;
    private String country;
    private String phoneNumber;
    private Date createdDate;
    private Date updatedDate;

    public static CustomerDTOBuilder newInstance() {
        return new CustomerDTOBuilder();
    }

    @Override
    public CustomerDTOBuilder entity(Customer customer) {
        if (customer != null) {
            this.id = customer.getId();
            this.name = customer.getName();
            this.surname = customer.getSurname();
            this.email = customer.getEmail();
            this.companyName = customer.getCompanyName();
            this.companySize = customer.getCompanySize();
            this.country = customer.getCountry();
            this.phoneNumber = customer.getPhoneNumber();
            this.createdDate = customer.getCreatedDate();
            this.updatedDate = customer.getUpdatedDate();
        }
        return this;
    }

    public CustomerDTOBuilder name(String name) {
        this.name = name;
        return this;
    }

    public CustomerDTOBuilder surname(String surname) {
        this.surname = surname;
        return this;
    }

    public CustomerDTOBuilder companyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public CustomerDTOBuilder companySize(int companySize) {
        this.companySize = companySize;
        return this;
    }

    public CustomerDTOBuilder country(String country) {
        this.country = country;
        return this;
    }

    public CustomerDTOBuilder phoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    @Override
    public CustomerDTO build() {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(this.id);
        customerDTO.setName(this.name);
        customerDTO.setSurname(this.surname);
        customerDTO.setEmail(this.email);
        customerDTO.setCompanyName(this.companyName);
        customerDTO.setCompanySize(this.companySize);
        customerDTO.setCountry(this.country);
        customerDTO.setPhoneNumber(this.phoneNumber);
        customerDTO.setCreatedDate(this.createdDate);
        customerDTO.setUpdatedDate(this.updatedDate);
        return customerDTO;
    }
}
