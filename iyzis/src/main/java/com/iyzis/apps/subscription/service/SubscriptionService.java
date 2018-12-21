package com.iyzis.apps.subscription.service;

import com.iyzis.apps.subscription.domain.entity.Subscription;
import com.iyzis.apps.subscription.repository.SubscriptionRepository;
import com.iyzis.core.repository.IRepository;
import com.iyzis.core.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionService extends AbstractService<Subscription, String> {

    private final SubscriptionRepository subscriptionRepository;

    @Autowired
    public SubscriptionService(SubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }

    @Override
    public IRepository getRepository() {
        return this.subscriptionRepository;
    }

    public Long totalSubscriptionCount() {
        return this.getRepository().count();
    }
}
