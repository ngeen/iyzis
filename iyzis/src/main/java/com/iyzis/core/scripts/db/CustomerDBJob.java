package com.iyzis.core.scripts.db;

import com.iyzis.apps.customer.domain.CustomerEntityBuilder;
import com.iyzis.apps.customer.domain.entity.Customer;
import org.springframework.data.mongodb.core.MongoOperations;

import java.util.ArrayList;
import java.util.List;

public class CustomerDBJob implements DBJob {

    private List<Customer> customers = new ArrayList<>();
    MongoOperations dbOperation;

    public CustomerDBJob(MongoOperations dbOperation) {
        this.dbOperation = dbOperation;

        dbOperation.dropCollection(Customer.class);

        CustomerEntityBuilder entityBuilder = CustomerEntityBuilder.newInstance();
        Customer customer1 = entityBuilder
                .id("1")
                .name("Selcuk")
                .surname("Sozuer")
                .email("selcuk.sozuer@ozu.edu.tr")
                .companyName("Ozu-Master")
                .companySize(5)
                .phoneNumber("11111111111")
                .country("Turkey").build();

        Customer customer2 = entityBuilder
                .id("2")
                .name("Ahmet")
                .surname("Tavli")
                .email("ahmet.tavli@ozu.edu.tr")
                .companyName("Ozu-PhD")
                .companySize(10)
                .phoneNumber("000000000")
                .country("Turkey").build();

        customers.add(customer1);
        customers.add(customer2);
    }


    @Override
    public void run() {
        this.customers.forEach(customer -> {
            this.dbOperation.insert(customer);
            System.out.println(customer.toString());

        });
    }
}
