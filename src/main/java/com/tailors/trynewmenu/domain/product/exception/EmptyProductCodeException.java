package com.tailors.trynewmenu.domain.product.exception;

public class EmptyProductCodeException extends RuntimeException {
    public EmptyProductCodeException() {
        super("product code must not be empty");
    }
}
