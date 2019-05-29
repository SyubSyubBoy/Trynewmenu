package com.tailors.trynewmenu.domain.product.exception;

public class EmptyProductCodeException extends RuntimeException {
    public EmptyProductCodeException() {
        super("dto code must not be empty");
    }
}
