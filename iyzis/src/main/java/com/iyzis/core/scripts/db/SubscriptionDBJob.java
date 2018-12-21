package com.iyzis.core.scripts.db;

import com.iyzis.apps.subscription.domain.SubscriptionEntityBuilder;
import com.iyzis.apps.subscription.domain.entity.Subscription;
import com.iyzis.core.domain.enums.Period;
import com.iyzis.core.domain.enums.ServiceType;
import com.iyzis.core.utils.DateUtil;
import org.springframework.data.mongodb.core.MongoOperations;

import java.util.ArrayList;
import java.util.List;

public class SubscriptionDBJob implements DBJob {

    private List<Subscription> products = new ArrayList<>();
    MongoOperations dbOperation;

    public SubscriptionDBJob(MongoOperations dbOperation) {
        this.dbOperation = dbOperation;

        dbOperation.dropCollection(Subscription.class);

        Subscription subscription1 = SubscriptionEntityBuilder.newInstance()
                .id("1")
                .customer("1")
                .serviceId("1")
                .serviceType(ServiceType.PRODUCT.getServiceType())
                .period(Period.MONTHLY.getPeriod())
                .startDate(DateUtil.getNow())
                .endDate(DateUtil.addMonth(DateUtil.getNow(), 1))
                .build();

        Subscription subscription2 = SubscriptionEntityBuilder.newInstance()
                .id("2")
                .customer("2")
                .serviceId("2")
                .serviceType(ServiceType.PRODUCT.getServiceType())
                .period(Period.ANNUALLY.getPeriod())
                .startDate(DateUtil.getNow())
                .endDate(DateUtil.addMonth(DateUtil.getNow(), 1))
                .build();


        Subscription subscription3 = SubscriptionEntityBuilder.newInstance()
                .id("3")
                .customer("1")
                .serviceId("1")
                .serviceType(ServiceType.ADDON.getServiceType())
                .period(Period.INDEFINITE.getPeriod())
                .startDate(DateUtil.getNow())
                .build();

        products.add(subscription1);
        products.add(subscription2);
        products.add(subscription3);
    }


    @Override
    public void run() {
        this.products.forEach(subscription -> {
            this.dbOperation.insert(subscription);
            System.out.println(subscription.toString());
        });
    }
}
