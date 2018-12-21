package com.iyzis.apps.payment.domain.entity;

import com.iyzis.core.domain.AbstractEntity;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document
public class Payment extends AbstractEntity {
    @Id
    private String id;
    private String subscriptionId;
    private String vendor;
    private Double amount;
    private Date createdDate = new Date();

}
