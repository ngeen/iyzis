package com.iyzis.apps.subscription.domain;

import com.iyzis.apps.subscription.domain.dto.SubscriptionDTO;
import com.iyzis.apps.subscription.domain.entity.Subscription;
import com.iyzis.core.domain.AbstractEntityBuilder;

import java.util.Date;

public class SubscriptionEntityBuilder extends AbstractEntityBuilder<Subscription, SubscriptionDTO> {
    private String id;
    private String customerId;
    private String serviceId;
    private String serviceType;
    private String period;
    private Date startDate;
    private Date endDate;


    public SubscriptionEntityBuilder id(String id) {
        this.id = id;
        return this;
    }

    public SubscriptionEntityBuilder customer(String customerId) {
        this.customerId = customerId;
        return this;
    }

    public SubscriptionEntityBuilder serviceId(String productId) {
        this.serviceId = productId;
        return this;
    }

    public SubscriptionEntityBuilder serviceType(String serviceType) {
        this.serviceType = serviceType;
        return this;
    }

    public SubscriptionEntityBuilder period(String period) {
        this.period = period;
        return this;
    }

    public SubscriptionEntityBuilder startDate(Date startDate) {
        this.startDate = startDate;
        return this;
    }

    public SubscriptionEntityBuilder endDate(Date endDate) {
        this.endDate = endDate;
        return this;
    }

    @Override
    public SubscriptionEntityBuilder dto(SubscriptionDTO dto) {
        if (dto != null) {
            this.id = dto.getId();
            this.customerId = dto.getCustomerId();
            this.serviceId = dto.getServiceId();
            this.serviceType = dto.getServiceType();
            this.period = dto.getPeriod();
            this.startDate = dto.getStartDate();
            this.endDate = dto.getEndDate();
        }
        return this;
    }

    @Override
    public Subscription build() {
        Subscription subscription = new Subscription();
        subscription.setId(this.id);
        subscription.setCustomerId(this.customerId);
        subscription.setServiceId(this.serviceId);
        subscription.setServiceType(this.serviceType);
        subscription.setPeriod(this.period);
        subscription.setStartDate(this.startDate);
        subscription.setEndDate(this.endDate);
        return subscription;
    }

    public static SubscriptionEntityBuilder newInstance() {
        return new SubscriptionEntityBuilder();
    }
}
