package com.iyzis.core.scripts.db;

import com.iyzis.apps.payment.domain.PaymentEntityBuilder;
import com.iyzis.apps.payment.domain.entity.Payment;
import com.iyzis.core.domain.enums.PaymentVendor;
import org.springframework.data.mongodb.core.MongoOperations;

import java.util.ArrayList;
import java.util.List;

public class PaymentDBJob implements DBJob {

    private List<Payment> payments = new ArrayList<>();
    MongoOperations dbOperation;

    public PaymentDBJob(MongoOperations dbOperation) {
        this.dbOperation = dbOperation;

        dbOperation.dropCollection(Payment.class);

        Payment payment1 = PaymentEntityBuilder.newInstance()
                .id("1")
                .subscription("1")
                .vendor(PaymentVendor.IYZICO.getVendorName())
                .amount(30.00)
                .build();

        Payment payment2 = PaymentEntityBuilder.newInstance()
                .id("2")
                .subscription("2")
                .vendor(PaymentVendor.IYZICO.getVendorName())
                .amount(480.00)
                .build();

        Payment payment3 = PaymentEntityBuilder.newInstance()
                .id("3")
                .subscription("3")
                .vendor(PaymentVendor.IYZICO.getVendorName())
                .amount(500.00)
                .build();

        payments.add(payment1);
        payments.add(payment2);
        payments.add(payment3);
    }


    @Override
    public void run() {
        this.payments.forEach(payment -> {
            this.dbOperation.insert(payment);
            System.out.println(payment.toString());
        });
    }
}
