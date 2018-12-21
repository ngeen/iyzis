package com.iyzis.apps.addon.domain.entity;

import com.iyzis.core.domain.AbstractEntity;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document
public class Addon extends AbstractEntity {
    @Id
    private String id;
    private String name;
    private String description;
    private Double price;
    private Date createdDate = new Date();
    private Date updatedDate;

}
