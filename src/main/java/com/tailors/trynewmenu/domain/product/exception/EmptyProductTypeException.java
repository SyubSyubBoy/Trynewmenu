package com.tailors.trynewmenu.domain.product.exception;

public class EmptyProductTypeException extends RuntimeException {
    public EmptyProductTypeException() {
        super("Product type must not be empty");
    }
}
