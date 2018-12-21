package com.iyzis.apps.customer.service;

import com.iyzis.apps.customer.domain.entity.Customer;
import com.iyzis.apps.customer.repository.CustomerRepository;
import com.iyzis.core.repository.IRepository;
import com.iyzis.core.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService extends AbstractService<Customer, String> {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public IRepository getRepository() {
        return this.customerRepository;
    }

    public Long totalCustomerCount() {
        return this.getRepository().count();
    }
}
