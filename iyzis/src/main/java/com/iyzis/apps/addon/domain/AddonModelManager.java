package com.iyzis.apps.addon.domain;

import com.iyzis.apps.addon.domain.dto.AddonDTO;
import com.iyzis.apps.addon.domain.entity.Addon;
import com.iyzis.core.domain.AbstractModelManager;
import org.springframework.stereotype.Component;

@Component
public class AddonModelManager extends AbstractModelManager<Addon, AddonDTO, AddonEntityBuilder, AddonDTOBuilder> {

    @Override
    public AddonEntityBuilder getEntityBuilder() {
        return  AddonEntityBuilder.newInstance();
    }

    @Override
    public AddonDTOBuilder getDtoBuilder() {
        return AddonDTOBuilder.newInstance();
    }

    @Override
    public Addon convert(AddonDTO dto) {
        return getEntityBuilder().dto(dto).build();
    }

    @Override
    public AddonDTO convert(Addon entity) {
        return getDtoBuilder().entity(entity).build();
    }
}
