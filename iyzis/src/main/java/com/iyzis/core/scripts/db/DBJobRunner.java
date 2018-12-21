package com.iyzis.core.scripts.db;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DBJobRunner {

    @Bean
    CommandLineRunner init(MongoOperations dbOperation) {
        List<DBJob> dbJobs = new ArrayList<>();

        // customer jobs
        dbJobs.add(new CustomerDBJob(dbOperation));

        // serviceId jobs
        dbJobs.add(new ProductDBJob(dbOperation));

        // addon jobs
        dbJobs.add(new AddonDBJob(dbOperation));

        // subscriptions
        dbJobs.add(new SubscriptionDBJob(dbOperation));

        // payments
        dbJobs.add(new PaymentDBJob(dbOperation));

        // billings
        dbJobs.add(new BillingDBJob(dbOperation));

        System.out.println("#Creating entities:");
        return args -> {
            dbJobs.forEach(dbJob -> {
                dbJob.run();
            });

        };
    }
}
