package com.tailors.trynewmenu.domain.product.exception;

public class SameProductCodeException extends RuntimeException {
    public SameProductCodeException(Throwable cause) {
        super("product code must be seperate", cause);
    }
}
