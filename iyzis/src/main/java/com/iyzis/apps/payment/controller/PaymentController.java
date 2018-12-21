package com.iyzis.apps.payment.controller;

import com.iyzis.apps.payment.domain.dto.PaymentDTO;
import com.iyzis.apps.payment.facade.PaymentFacade;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PaymentController {

    private PaymentFacade paymentFacade;

    public PaymentController(PaymentFacade paymentFacade) {
        this.paymentFacade = paymentFacade;
    }

    @GetMapping(value = "/payments")
    public String productListPage(Model model) {
        List<PaymentDTO> paymentDTOS = paymentFacade.findAll();
        model.addAttribute("payments", paymentDTOS);
        return "payment";
    }

    @GetMapping(value = "/payments/save")
    public String saveProductPage(Model model) {
        return "payment-create";
    }
}
