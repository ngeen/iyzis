package com.iyzis.apps.subscription.domain.entity;

import com.iyzis.core.domain.AbstractEntity;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@Document
public class Subscription extends AbstractEntity {
    @Id
    private String id;
    private String customerId;
    private String serviceId;
    private String serviceType;
    private String period;
    private Date startDate;
    private Date endDate;
    private Date createdDate = new Date();

}
