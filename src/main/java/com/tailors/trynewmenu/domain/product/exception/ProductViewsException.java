package com.tailors.trynewmenu.domain.product.exception;

public class ProductViewsException extends RuntimeException {
    public ProductViewsException() {
        super("Product views must be more than 0");
    }
}
