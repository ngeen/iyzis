package com.iyzis.apps.addon.service;

import com.iyzis.apps.addon.domain.entity.Addon;
import com.iyzis.apps.addon.repository.AddonRepository;
import com.iyzis.core.repository.IRepository;
import com.iyzis.core.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddonService extends AbstractService<Addon, String> {

    private final AddonRepository addonRepository;

    @Autowired
    public AddonService(AddonRepository addonRepository) {
        this.addonRepository = addonRepository;
    }

    @Override
    public IRepository getRepository() {
        return this.addonRepository;
    }
}
