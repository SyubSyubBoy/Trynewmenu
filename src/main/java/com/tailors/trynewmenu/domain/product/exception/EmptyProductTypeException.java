package com.tailors.trynewmenu.domain.product.exception;

public class EmptyProductTypeException extends RuntimeException {
    public EmptyProductTypeException() {
        super("product type must not be empty");
    }
}
