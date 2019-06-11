package com.tailors.trynewmenu.service.product.exception;

public class RemoveProductException extends RuntimeException {
    public RemoveProductException(Throwable cause) {
        super("Removing product failed", cause);
    }
}
