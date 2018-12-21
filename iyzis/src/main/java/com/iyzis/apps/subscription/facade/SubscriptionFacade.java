package com.iyzis.apps.subscription.facade;

import com.iyzis.apps.subscription.domain.SubscriptionModelManager;
import com.iyzis.apps.subscription.domain.dto.SubscriptionDTO;
import com.iyzis.apps.subscription.domain.entity.Subscription;
import com.iyzis.apps.subscription.service.SubscriptionService;
import com.iyzis.core.facade.AbstractFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SubscriptionFacade extends AbstractFacade<SubscriptionDTO, Subscription> {

    private SubscriptionService subscriptionService;
    private SubscriptionModelManager subscriptionModelManager;

    @Autowired
    public SubscriptionFacade(SubscriptionService subscriptionService, SubscriptionModelManager subscriptionModelManager) {
        this.subscriptionService = subscriptionService;
        this.subscriptionModelManager = subscriptionModelManager;
    }

    @Override
    public SubscriptionDTO create(SubscriptionDTO dto) {
        Subscription subscription = subscriptionModelManager.convert(dto);
        subscription = subscriptionService.create(subscription);
        return this.subscriptionModelManager.convert(subscription);
    }

    @Override
    public void create(List<SubscriptionDTO> dtos) {
        List<Subscription> subscriptions = dtos.stream().map(subscriptionModelManager::convert).collect(Collectors.toList());
        subscriptionService.create(subscriptions);
    }

    @Override
    public void update(SubscriptionDTO dto) {
    }

    @Override
    public void update(List<SubscriptionDTO> dtos) {
    }

    @Override
    public void delete(SubscriptionDTO dto) {
    }

    @Override
    public void delete(List<SubscriptionDTO> dtos) {
    }

    @Override
    public SubscriptionDTO find(Serializable id) {
        Optional<Subscription> product = subscriptionService.find((String) id);
        return product.map(subscriptionModelManager::convert).get();
    }

    @Override
    public List<SubscriptionDTO> findAll() {
        Iterable<Subscription> iterable = subscriptionService.findAll();
        List<SubscriptionDTO> subscriptionDTOS = new ArrayList<>();

        iterable.forEach(c -> subscriptionDTOS.add(subscriptionModelManager.convert(c)));
        return subscriptionDTOS;
    }

    public Long totalSubscriptionCount() {
        return this.subscriptionService.totalSubscriptionCount();
    }
}
