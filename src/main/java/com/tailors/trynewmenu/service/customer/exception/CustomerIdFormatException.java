package com.tailors.trynewmenu.service.customer.exception;

public class CustomerIdFormatException extends RuntimeException {
    public CustomerIdFormatException(Throwable cause) {
        super("CustomerId is not uuid format", cause);
    }
}
