package com.iyzis.apps.customer.controller;

import com.iyzis.apps.customer.facade.CustomerFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerController {

    private CustomerFacade customerFacade;

    @Autowired
    public CustomerController(CustomerFacade customerFacade) {
        this.customerFacade = customerFacade;
    }


    @GetMapping(value = "/customers")
    public String customerListPage(Model model) {
        model.addAttribute("customers", customerFacade.findAll());
        return "customer";
    }
}
