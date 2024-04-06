package com.example.demo.controllers;

import com.example.demo.domain.Product;
import com.example.demo.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BuyNowController {

    private ProductService productService;

    private static Product product;

    public BuyNowController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/buyNow")
    public String buyProduct(@RequestParam("productID") int productId, Model theModel) {
        Product product1 = productService.findById(productId);
        product = product1;

        if (product != null && product.getInv() > 0) {
            product.setInv(product.getInv() - 1);
            productService.save(product);

            return "confirmationbuynow";
        }
        else {
            return "buynowerror";
        }
    }
}