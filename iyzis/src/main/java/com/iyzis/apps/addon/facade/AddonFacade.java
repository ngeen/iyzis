package com.iyzis.apps.addon.facade;

import com.iyzis.apps.addon.domain.AddonModelManager;
import com.iyzis.apps.addon.domain.dto.AddonDTO;
import com.iyzis.apps.addon.domain.entity.Addon;
import com.iyzis.apps.addon.service.AddonService;
import com.iyzis.core.facade.AbstractFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AddonFacade extends AbstractFacade<AddonDTO, Addon> {

    private AddonService addonService;
    private AddonModelManager addonModelManager;

    @Autowired
    public AddonFacade(AddonService addonService, AddonModelManager addonModelManager) {
        this.addonService = addonService;
        this.addonModelManager = addonModelManager;
    }

    @Override
    public AddonDTO create(AddonDTO dto) {
        Addon addon = addonModelManager.convert(dto);
        addon = addonService.create(addon);
        return  this.addonModelManager.convert(addon);
    }

    @Override
    public void create(List<AddonDTO> dtos) {
        List<Addon> addons = dtos.stream().map(addonModelManager::convert).collect(Collectors.toList());
        addonService.create(addons);
    }

    @Override
    public void update(AddonDTO dto) {
    }

    @Override
    public void update(List<AddonDTO> dtos) {
    }

    @Override
    public void delete(AddonDTO dto) {
    }

    @Override
    public void delete(List<AddonDTO> dtos) {
    }

    @Override
    public AddonDTO find(Serializable id) {
        Optional<Addon> product = addonService.find((String) id);
        return product.map(addonModelManager::convert).get();
    }

    @Override
    public List<AddonDTO> findAll() {
        Iterable<Addon> iterable = addonService.findAll();
        List<AddonDTO> addonDTOS = new ArrayList<>();

        iterable.forEach(c -> addonDTOS.add(addonModelManager.convert(c)));
        return addonDTOS;
    }
}
