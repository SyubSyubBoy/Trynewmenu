package com.tailors.trynewmenu.domain.product.exception;

public class ProductViewsException extends RuntimeException {
    public ProductViewsException() {
        super("product views must be more than 0");
    }
}
