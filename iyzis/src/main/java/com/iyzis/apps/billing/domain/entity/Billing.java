package com.iyzis.apps.billing.domain.entity;

import com.iyzis.core.domain.AbstractEntity;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document
public class Billing extends AbstractEntity {
    @Id
    private String id;
    private String subscriptionId;
    private String paymentId;
    private String name;
    private String lastName;
    private String country;
    private String city;
    private String address;
    private String zipCode;
    private Date createdDate = new Date();


}
