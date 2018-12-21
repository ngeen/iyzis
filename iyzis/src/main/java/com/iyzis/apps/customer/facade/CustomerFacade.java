package com.iyzis.apps.customer.facade;

import com.iyzis.apps.customer.domain.CustomerModelManager;
import com.iyzis.apps.customer.domain.dto.CustomerDTO;
import com.iyzis.apps.customer.domain.entity.Customer;
import com.iyzis.apps.customer.service.CustomerService;
import com.iyzis.core.facade.AbstractFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerFacade extends AbstractFacade<CustomerDTO, Customer> {

    private CustomerService customerService;
    private CustomerModelManager customerModelManager;

    @Autowired
    public CustomerFacade(CustomerService customerService, CustomerModelManager customerModelManager) {
        this.customerService = customerService;
        this.customerModelManager = customerModelManager;
    }

    public Long totalCustomerCount() {
        return this.customerService.totalCustomerCount();
    }

    @Override
    public CustomerDTO create(CustomerDTO dto) {
        Customer customer = customerModelManager.convert(dto);
        customer = customerService.create(customer);
        return this.customerModelManager.convert(customer);
    }

    @Override
    public void create(List<CustomerDTO> dtos) {
        List<Customer> customers = dtos.stream().map(customerModelManager::convert).collect(Collectors.toList());
        customerService.create(customers);
    }

    @Override
    public void update(CustomerDTO dto) {
    }

    @Override
    public void update(List<CustomerDTO> dtos) {
    }

    @Override
    public void delete(CustomerDTO dto) {
    }

    @Override
    public void delete(List<CustomerDTO> dtos) {
    }

    @Override
    public CustomerDTO find(Serializable id) {
        Optional<Customer> customer = customerService.find((String) id);
        return customer.map(customerModelManager::convert).get();
    }

    @Override
    public List<CustomerDTO> findAll() {
        Iterable<Customer> iterable = customerService.findAll();
        List<CustomerDTO> customerDTOS = new ArrayList<>();

        iterable.forEach(c -> customerDTOS.add(customerModelManager.convert(c)));
        return customerDTOS;
    }
}
