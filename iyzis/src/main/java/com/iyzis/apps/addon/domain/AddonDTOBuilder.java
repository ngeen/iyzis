package com.iyzis.apps.addon.domain;

import com.iyzis.apps.addon.domain.dto.AddonDTO;
import com.iyzis.apps.addon.domain.entity.Addon;
import com.iyzis.core.domain.AbstractDTOBuilder;

import java.util.Date;

public class AddonDTOBuilder extends AbstractDTOBuilder<AddonDTO, Addon> {
    private String id;
    private String name;
    private String description;
    private Double price;
    private Date createdDate;
    private Date updatedDate;

    public static AddonDTOBuilder newInstance() {
        return new AddonDTOBuilder();
    }

    @Override
    public AddonDTOBuilder entity(Addon addon) {
        if (addon != null) {
            this.id = addon.getId();
            this.name = addon.getName();
            this.description = addon.getDescription();
            this.createdDate = addon.getCreatedDate();
            this.price = addon.getPrice();
            this.updatedDate = addon.getUpdatedDate();
        }
        return this;
    }

    public AddonDTOBuilder name(String name) {
        this.name = name;
        return this;
    }

    public AddonDTOBuilder description(String description) {
        this.description = description;
        return this;
    }

    public AddonDTOBuilder price(Double price) {
        this.price = price;
        return this;
    }

    @Override
    public AddonDTO build() {
        AddonDTO addonDTO = new AddonDTO();
        addonDTO.setId(this.id);
        addonDTO.setName(this.name);
        addonDTO.setDescription(this.description);
        addonDTO.setPrice(this.price);
        addonDTO.setCreatedDate(this.createdDate);
        addonDTO.setUpdatedDate(this.updatedDate);
        return addonDTO;
    }
}
