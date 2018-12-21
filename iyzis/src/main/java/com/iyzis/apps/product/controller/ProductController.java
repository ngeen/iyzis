package com.iyzis.apps.product.controller;

import com.iyzis.apps.product.domain.dto.ProductDTO;
import com.iyzis.apps.product.facade.ProductFacade;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProductController {

    private ProductFacade productFacade;

    public ProductController(ProductFacade productFacade) {
        this.productFacade = productFacade;
    }

    @GetMapping(value = "/products")
    public String productListPage(Model model) {
        List<ProductDTO>  productDTOS = productFacade.findAll();
        model.addAttribute("products", productDTOS);
        return "product";
    }

    @GetMapping(value = "/products/save")
    public String saveProductPage(Model model) {
        return "product-create";
    }
}
