package com.iyzis.apps.payment.service;

import com.iyzis.apps.payment.domain.entity.Payment;
import com.iyzis.apps.payment.repository.PaymentRepository;
import com.iyzis.core.repository.IRepository;
import com.iyzis.core.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService extends AbstractService<Payment, String> {

    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public IRepository getRepository() {
        return this.paymentRepository;
    }

    public Long totalPaymentCount() {
        return this.getRepository().count();
    }
}
