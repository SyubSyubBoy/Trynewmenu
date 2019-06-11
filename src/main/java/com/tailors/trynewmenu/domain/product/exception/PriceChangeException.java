package com.tailors.trynewmenu.domain.product.exception;

public class PriceChangeException extends RuntimeException {
    public PriceChangeException() {
        super("Price must be more than 0");
    }
}
