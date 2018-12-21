package com.iyzis.apps.customer.domain;

import com.iyzis.apps.customer.domain.dto.CustomerDTO;
import com.iyzis.apps.customer.domain.entity.Customer;
import com.iyzis.core.domain.AbstractModelManager;
import org.springframework.stereotype.Component;

@Component
public class CustomerModelManager extends AbstractModelManager<Customer, CustomerDTO, CustomerEntityBuilder, CustomerDTOBuilder> {

    @Override
    public CustomerEntityBuilder getEntityBuilder() {
        return  CustomerEntityBuilder.newInstance();
    }

    @Override
    public CustomerDTOBuilder getDtoBuilder() {
        return CustomerDTOBuilder.newInstance();
    }

    @Override
    public Customer convert(CustomerDTO dto) {
        return getEntityBuilder().dto(dto).build();
    }

    @Override
    public CustomerDTO convert(Customer entity) {
        return getDtoBuilder().entity(entity).build();
    }
}
