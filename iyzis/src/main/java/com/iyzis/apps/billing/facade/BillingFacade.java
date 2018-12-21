package com.iyzis.apps.billing.facade;

import com.iyzis.apps.billing.domain.BillingModelManager;
import com.iyzis.apps.billing.domain.dto.BillingDTO;
import com.iyzis.apps.billing.domain.entity.Billing;
import com.iyzis.apps.billing.service.BillingService;
import com.iyzis.core.facade.AbstractFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BillingFacade extends AbstractFacade<BillingDTO, Billing> {

    private BillingService billingService;
    private BillingModelManager billingModelManager;

    @Autowired
    public BillingFacade(BillingService billingService, BillingModelManager billingModelManager) {
        this.billingService = billingService;
        this.billingModelManager = billingModelManager;
    }

    @Override
    public void create(BillingDTO dto) {
        Billing billing = billingModelManager.convert(dto);
        billingService.create(billing);
    }

    @Override
    public void create(List<BillingDTO> dtos) {
        List<Billing> billings = dtos.stream().map(billingModelManager::convert).collect(Collectors.toList());
        billingService.create(billings);
    }

    @Override
    public void update(BillingDTO dto) {
    }

    @Override
    public void update(List<BillingDTO> dtos) {
    }

    @Override
    public void delete(BillingDTO dto) {
    }

    @Override
    public void delete(List<BillingDTO> dtos) {
    }

    @Override
    public BillingDTO find(Serializable id) {
        Optional<Billing> product = billingService.find((String) id);
        return product.map(billingModelManager::convert).get();
    }

    @Override
    public List<BillingDTO> findAll() {
        Iterable<Billing> iterable = billingService.findAll();
        List<BillingDTO> billingDTOS = new ArrayList<>();

        iterable.forEach(c -> billingDTOS.add(billingModelManager.convert(c)));
        return billingDTOS;
    }
}
