package com.iyzis.apps.billing.service;

import com.iyzis.apps.billing.domain.entity.Billing;
import com.iyzis.apps.billing.repository.BillingRepository;
import com.iyzis.core.repository.IRepository;
import com.iyzis.core.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillingService extends AbstractService<Billing, String> {

    private final BillingRepository billingRepository;

    @Autowired
    public BillingService(BillingRepository billingRepository) {
        this.billingRepository = billingRepository;
    }

    @Override
    public IRepository getRepository() {
        return this.billingRepository;
    }
}
