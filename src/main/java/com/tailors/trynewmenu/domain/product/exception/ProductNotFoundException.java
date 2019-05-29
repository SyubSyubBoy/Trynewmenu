package com.tailors.trynewmenu.domain.product.exception;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException() {
        super("product not found");
    }
}
