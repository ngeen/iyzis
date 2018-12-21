package com.iyzis.apps.billing.domain;

import com.iyzis.apps.billing.domain.dto.BillingDTO;
import com.iyzis.apps.billing.domain.entity.Billing;
import com.iyzis.core.domain.AbstractModelManager;
import org.springframework.stereotype.Component;

@Component
public class BillingModelManager extends AbstractModelManager<Billing, BillingDTO, BillingEntityBuilder, BillingDTOBuilder> {

    @Override
    public BillingEntityBuilder getEntityBuilder() {
        return  BillingEntityBuilder.newInstance();
    }

    @Override
    public BillingDTOBuilder getDtoBuilder() {
        return BillingDTOBuilder.newInstance();
    }

    @Override
    public Billing convert(BillingDTO dto) {
        return getEntityBuilder().dto(dto).build();
    }

    @Override
    public BillingDTO convert(Billing entity) {
        return getDtoBuilder().entity(entity).build();
    }
}
