package com.iyzis.apps.addon.domain;

import com.iyzis.apps.addon.domain.dto.AddonDTO;
import com.iyzis.apps.addon.domain.entity.Addon;
import com.iyzis.core.domain.AbstractEntityBuilder;

import java.util.Date;

public class AddonEntityBuilder extends AbstractEntityBuilder<Addon, AddonDTO> {
    private String id;
    private String name;
    private String description;
    private Double price;
    private Date updatedDate;


    public AddonEntityBuilder id(String id) {
        this.id = id;
        return this;
    }

    public AddonEntityBuilder name(String name) {
        this.name = name;
        return this;
    }

    public AddonEntityBuilder description(String description) {
        this.description = description;
        return this;
    }

    public AddonEntityBuilder price(Double price) {
        this.price = price;
        return this;
    }

    public AddonEntityBuilder updatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
        return this;
    }

    @Override
    public AddonEntityBuilder dto(AddonDTO dto) {
        if (dto != null) {
            this.id = dto.getId();
            this.name = dto.getName();
            this.description = dto.getDescription();
            this.price = dto.getPrice();
            this.updatedDate = dto.getUpdatedDate();
        }
        return this;
    }

    @Override
    public Addon build() {
        Addon addon = new Addon();
        addon.setId(this.id);
        addon.setName(this.name);
        addon.setDescription(this.description);
        addon.setPrice(this.price);
        addon.setUpdatedDate(this.updatedDate);
        return addon;
    }

    public static AddonEntityBuilder newInstance() {
        return new AddonEntityBuilder();
    }
}
