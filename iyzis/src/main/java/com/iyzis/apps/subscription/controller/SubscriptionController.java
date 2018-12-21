package com.iyzis.apps.subscription.controller;

import com.iyzis.apps.subscription.domain.dto.SubscriptionDTO;
import com.iyzis.apps.subscription.facade.SubscriptionFacade;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class SubscriptionController {

    private SubscriptionFacade subscriptionFacade;

    public SubscriptionController(SubscriptionFacade subscriptionFacade) {
        this.subscriptionFacade = subscriptionFacade;
    }

    @GetMapping(value = "/subscriptions")
    public String productListPage(Model model) {
        List<SubscriptionDTO> subscriptionDTOS = subscriptionFacade.findAll();
        model.addAttribute("subscriptions", subscriptionDTOS);
        return "subscription";
    }

    @GetMapping(value = "/subscriptions/save")
    public String saveProductPage(Model model) {
        return "subscription-create";
    }
}
