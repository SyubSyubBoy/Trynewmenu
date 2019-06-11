package com.tailors.trynewmenu.domain.product.exception;

public class EmptyProductCodeException extends RuntimeException {
    public EmptyProductCodeException() {
        super("Product code must not be empty");
    }
}
