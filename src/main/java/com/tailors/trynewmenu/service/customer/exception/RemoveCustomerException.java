package com.tailors.trynewmenu.service.customer.exception;

public class RemoveCustomerException extends RuntimeException {
    public RemoveCustomerException(Throwable cause) {
        super("Removing customer failed", cause);
    }
}
