package com.iyzis.apps.billing.controller;

import com.iyzis.apps.billing.domain.dto.BillingDTO;
import com.iyzis.apps.billing.facade.BillingFacade;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BillingController {

    private BillingFacade billingFacade;

    public BillingController(BillingFacade billingFacade) {
        this.billingFacade = billingFacade;
    }

    @GetMapping(value = "/billings")
    public String productListPage(Model model) {
        List<BillingDTO> billingDTOS = billingFacade.findAll();
        model.addAttribute("billings", billingDTOS);
        return "billing";
    }

    @GetMapping(value = "/billings/save")
    public String saveProductPage(Model model) {
        return "billings-create";
    }
}
