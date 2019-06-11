package com.tailors.trynewmenu.service.product.exception;

public class SameProductCodeException extends RuntimeException {
    public SameProductCodeException() {
        super("Product code must not be same");
    }
}
