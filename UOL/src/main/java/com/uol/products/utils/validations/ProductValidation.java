package com.uol.products.utils.validations;

import com.uol.products.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductValidation {

    @Autowired
    private CommonsValidations validation;

    public void validate(Product product){

        validation.nullObject(product.getPrice(), "price");
        validation.nullObject(product.getDescription(), "description");
        validation.nullObject(product.getName(), "name");

        validation.stringIsDiffOfEmpty(product.getDescription());
        validation.validatePriceValue(product.getPrice());

    }

}
