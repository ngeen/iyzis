package com.iyzis.apps.subscription.domain.dto;

import com.iyzis.core.domain.AbstractDTO;
import lombok.Data;

import java.util.Date;

@Data
public class SubscriptionDTO extends AbstractDTO {
    private String id;
    private String customerId;
    private String serviceId;
    private String serviceType;
    private String period;
    private Date startDate;
    private Date endDate;
    private Date createdDate;
}
