package com.iyzis.core.scripts.db;

import com.iyzis.apps.billing.domain.BillingEntityBuilder;
import com.iyzis.apps.billing.domain.entity.Billing;
import com.iyzis.apps.subscription.domain.SubscriptionEntityBuilder;
import com.iyzis.apps.subscription.domain.entity.Subscription;
import com.iyzis.core.domain.enums.Period;
import com.iyzis.core.domain.enums.ServiceType;
import com.iyzis.core.utils.DateUtil;
import org.springframework.data.mongodb.core.MongoOperations;

import java.util.ArrayList;
import java.util.List;

public class BillingDBJob implements DBJob {

    private List<Billing> products = new ArrayList<>();
    MongoOperations dbOperation;

    public BillingDBJob(MongoOperations dbOperation) {
        this.dbOperation = dbOperation;

        dbOperation.dropCollection(Billing.class);

        Billing billing1 = BillingEntityBuilder.newInstance()
                .id("1")
                .subscription("1")
                .payment("1")
                .name("Selcuk")
                .lastName("Sozuer")
                .country("Turkey")
                .city("Istanbul")
                .address("Maltepe")
                .zipCode("1234")
                .build();

        Billing billing2 = BillingEntityBuilder.newInstance()
                .id("2")
                .subscription("2")
                .payment("2")
                .name("Ahment")
                .lastName("Tavli")
                .country("Turkey")
                .city("Istanbul")
                .address("Cekmekoy")
                .zipCode("1234")
                .build();


        Billing billing3 = BillingEntityBuilder.newInstance()
                .id("3")
                .subscription("3")
                .payment("3")
                .name("Selcuk")
                .lastName("Sozuer")
                .country("Turkey")
                .city("Istanbul")
                .address("Maltepe")
                .zipCode("1234")
                .build();

        products.add(billing1);
        products.add(billing2);
        products.add(billing3);
    }


    @Override
    public void run() {
        this.products.forEach(billing -> {
            this.dbOperation.insert(billing);
            System.out.println(billing.toString());
        });
    }
}
