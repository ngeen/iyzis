package com.iyzis.apps.payment.service;

import com.iyzis.apps.payment.api.model.PaymentRequestDTO;
import com.iyzis.apps.payment.api.model.PaymentResultDTO;

public interface IVendorAdapter {
    PaymentResultDTO makePayment(PaymentRequestDTO paymentRequestDTO) throws Exception;
}
