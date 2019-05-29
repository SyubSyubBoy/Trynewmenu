package com.tailors.trynewmenu.domain.product.exception;

public class SameProductCodeException extends RuntimeException {
    public SameProductCodeException() {
        super("product code must be seperate");
    }
}
