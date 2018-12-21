package com.iyzis.apps.subscription.domain;

import com.iyzis.apps.subscription.domain.dto.SubscriptionDTO;
import com.iyzis.apps.subscription.domain.entity.Subscription;
import com.iyzis.core.domain.AbstractModelManager;
import org.springframework.stereotype.Component;

@Component
public class SubscriptionModelManager extends AbstractModelManager<Subscription, SubscriptionDTO, SubscriptionEntityBuilder, SubscriptionDTOBuilder> {

    @Override
    public SubscriptionEntityBuilder getEntityBuilder() {
        return  SubscriptionEntityBuilder.newInstance();
    }

    @Override
    public SubscriptionDTOBuilder getDtoBuilder() {
        return SubscriptionDTOBuilder.newInstance();
    }

    @Override
    public Subscription convert(SubscriptionDTO dto) {
        return getEntityBuilder().dto(dto).build();
    }

    @Override
    public SubscriptionDTO convert(Subscription entity) {
        return getDtoBuilder().entity(entity).build();
    }
}
