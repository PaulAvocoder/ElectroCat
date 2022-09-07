package com.pavel.electroCat.errorHandler;

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(Long id) {
        super("Product id not found : " + id);
    }

}
