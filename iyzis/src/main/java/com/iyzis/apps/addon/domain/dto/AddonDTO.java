package com.iyzis.apps.addon.domain.dto;

import com.iyzis.core.domain.AbstractDTO;
import lombok.Data;

import java.util.Date;

@Data
public class AddonDTO extends AbstractDTO {
    private String id;
    private String name;
    private String description;
    private Double price;
    private Date createdDate;
    private Date updatedDate;
}
