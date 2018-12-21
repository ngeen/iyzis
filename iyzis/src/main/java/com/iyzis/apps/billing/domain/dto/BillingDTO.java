package com.iyzis.apps.billing.domain.dto;

import com.iyzis.core.domain.AbstractDTO;
import lombok.Data;

import java.util.Date;

@Data
public class BillingDTO extends AbstractDTO {
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
