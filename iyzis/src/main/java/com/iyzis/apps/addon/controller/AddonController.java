package com.iyzis.apps.addon.controller;

import com.iyzis.apps.addon.domain.dto.AddonDTO;
import com.iyzis.apps.addon.facade.AddonFacade;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AddonController {

    private AddonFacade addonFacade;

    public AddonController(AddonFacade addonFacade) {
        this.addonFacade = addonFacade;
    }

    @GetMapping(value = "/addons")
    public String productListPage(Model model) {
        List<AddonDTO> addonDTOS = addonFacade.findAll();
        model.addAttribute("addons", addonDTOS);
        return "addon";
    }

    @GetMapping(value = "/addons/save")
    public String saveProductPage(Model model) {
        return "addon-create";
    }
}
