package com.example.demo.validators;

import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.service.PartService;
import com.example.demo.service.PartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 *
 *
 *
 */
public class InventoryValidator implements ConstraintValidator<ValidInventory, Product> {
    @Autowired
    private ApplicationContext context;

    public static  ApplicationContext myContext;
    @Override
    public void initialize(ValidInventory constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Product product, ConstraintValidatorContext constraintValidatorContext) {
        if(context==null) return true;
        if(context!=null)myContext=context;
        ProductService productService = myContext.getBean(ProductServiceImpl.class);
        boolean valid = true;
        if (product.getId() != 0) {
            Product myProduct = new Product();
            try {
                myProduct = productService.findById((int) product.getId());
            } catch (Exception e) {
                System.out.println("Error Message " + e.getMessage());
            }
            for (Part p : myProduct.getParts()) {
                if (p.getInv() < p.getMinInv()) {
                    valid = false;
                    break;
                }
            }
        }
        return valid;
    }
}
