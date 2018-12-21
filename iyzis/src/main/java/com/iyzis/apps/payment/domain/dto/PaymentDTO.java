package com.iyzis.apps.payment.domain.dto;

import com.iyzis.core.domain.AbstractDTO;
import lombok.Data;

import java.util.Date;

@Data
public class PaymentDTO extends AbstractDTO {
    private String id;
    private String subscriptionId;
    private String vendor;
    private Double amount;
    private Date createdDate = new Date();
}
