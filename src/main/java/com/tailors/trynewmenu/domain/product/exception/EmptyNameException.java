package com.tailors.trynewmenu.domain.product.exception;

public class EmptyNameException extends RuntimeException {
    public EmptyNameException() {
        super("Product name must not be empty");
    }
}
