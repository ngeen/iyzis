package com.iyzis.apps.dashboard.controller;

import com.iyzis.apps.dashboard.facade.DashboardFacade;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    private DashboardFacade dashboardFacade;

    public DashboardController(DashboardFacade dashboardFacade) {
        this.dashboardFacade = dashboardFacade;
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        Long customerCount = this.dashboardFacade.totalCustomerCount();
        Long subscriptionCount = this.dashboardFacade.totalSubscriptionCount();
        Long paymentCount = this.dashboardFacade.totalPaymentCount();

        model.addAttribute("customerCount", customerCount);
        model.addAttribute("subscriptionCount", subscriptionCount);
        model.addAttribute("paymentCount", paymentCount);

        return "dashboard";
    }
}
