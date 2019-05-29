package com.tailors.trynewmenu.domain.product.exception;

public class SameProductCodeException extends RuntimeException {
    public SameProductCodeException() {
        super("dto code must be seperate");
    }
}
