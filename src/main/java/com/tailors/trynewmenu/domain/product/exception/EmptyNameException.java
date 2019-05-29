package com.tailors.trynewmenu.domain.product.exception;

public class EmptyNameException extends RuntimeException {
    public EmptyNameException() {
        super("product name must not be empty");
    }
}
