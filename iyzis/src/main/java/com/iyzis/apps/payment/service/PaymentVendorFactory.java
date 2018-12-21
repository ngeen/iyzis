package com.iyzis.apps.payment.service;

import com.iyzis.core.domain.enums.PaymentVendor;

public class PaymentVendorFactory {

   public static IVendorAdapter create(String paymentVendor) throws Exception {
        if (PaymentVendor.IYZICO.getVendorName().equalsIgnoreCase(paymentVendor)) {
            return new IyzicoVendorAdapter();
        } else {
            throw new Exception("Could not find any vendor adapter!");
        }
    }
}
