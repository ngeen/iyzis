package com.iyzis.apps.customer.domain.dto;

import com.iyzis.core.domain.AbstractDTO;
import lombok.Data;

import java.util.Date;

@Data
public class CustomerDTO extends AbstractDTO {
    private String id;
    private String name;
    private String surname;
    private String email;
    private String companyName;
    private Integer companySize;
    private String country;
    private String phoneNumber;
    private Date createdDate;
    private Date updatedDate;
}
