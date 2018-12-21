package com.iyzis.apps.customer.domain.entity;

import com.iyzis.core.domain.AbstractEntity;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document
public class Customer extends AbstractEntity {
    @Id
    private String id;
    private String name;
    private String surname;
    private String email;
    private String companyName;
    private Integer companySize;
    private String country;
    private String phoneNumber;
    private Date createdDate = new Date();
    private Date updatedDate;

}
