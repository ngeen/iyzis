package com.iyzis.apps.subscription.domain;

import com.iyzis.apps.subscription.domain.dto.SubscriptionDTO;
import com.iyzis.apps.subscription.domain.entity.Subscription;
import com.iyzis.core.domain.AbstractDTOBuilder;

import java.util.Date;

public class SubscriptionDTOBuilder extends AbstractDTOBuilder<SubscriptionDTO, Subscription> {
    private String id;
    private String customerId;
    private String serviceId;
    private String serviceType;
    private String period;
    private Date startDate;
    private Date endDate;
    private Date createdDate;

    public static SubscriptionDTOBuilder newInstance() {
        return new SubscriptionDTOBuilder();
    }

    @Override
    public SubscriptionDTOBuilder entity(Subscription subscription) {
        if (subscription != null) {
            this.id = subscription.getId();
            this.customerId = subscription.getCustomerId();
            this.serviceId = subscription.getServiceId();
            this.period = subscription.getPeriod();
            this.serviceType = subscription.getServiceType();
            this.startDate = subscription.getStartDate();
            this.endDate = subscription.getEndDate();
            this.createdDate = subscription.getCreatedDate();

        }
        return this;
    }

    public SubscriptionDTOBuilder id(String id) {
        this.id = id;
        return this;
    }

    public SubscriptionDTOBuilder customer(String customerId) {
        this.customerId = customerId;
        return this;
    }

    public SubscriptionDTOBuilder serviceId(String productId) {
        this.serviceId = productId;
        return this;
    }

    public SubscriptionDTOBuilder serviceType(String serviceType) {
        this.serviceType = serviceType;
        return this;
    }

    public SubscriptionDTOBuilder period(String period) {
        this.period = period;
        return this;
    }

    public SubscriptionDTOBuilder startDate(Date startDate) {
        this.startDate = startDate;
        return this;
    }

    public SubscriptionDTOBuilder endDate(Date endDate) {
        this.endDate = endDate;
        return this;
    }

    @Override
    public SubscriptionDTO build() {
        SubscriptionDTO subscriptionDTO = new SubscriptionDTO();
        subscriptionDTO.setId(this.id);
        subscriptionDTO.setCustomerId(this.customerId);
        subscriptionDTO.setServiceId(this.serviceId);
        subscriptionDTO.setServiceType(this.serviceType);
        subscriptionDTO.setPeriod(this.period);
        subscriptionDTO.setEndDate(this.endDate);
        subscriptionDTO.setStartDate(this.startDate);
        subscriptionDTO.setCreatedDate(this.createdDate);
        return subscriptionDTO;
    }
}
