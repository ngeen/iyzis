package com.iyzis.apps.payment.domain;

import com.iyzis.apps.payment.domain.dto.PaymentDTO;
import com.iyzis.apps.payment.domain.entity.Payment;
import com.iyzis.core.domain.AbstractModelManager;
import org.springframework.stereotype.Component;

@Component
public class PaymentModelManager extends AbstractModelManager<Payment, PaymentDTO, PaymentEntityBuilder, PaymentDTOBuilder> {

    @Override
    public PaymentEntityBuilder getEntityBuilder() {
        return  PaymentEntityBuilder.newInstance();
    }

    @Override
    public PaymentDTOBuilder getDtoBuilder() {
        return PaymentDTOBuilder.newInstance();
    }

    @Override
    public Payment convert(PaymentDTO dto) {
        return getEntityBuilder().dto(dto).build();
    }

    @Override
    public PaymentDTO convert(Payment entity) {
        return getDtoBuilder().entity(entity).build();
    }
}
