package com.tailors.trynewmenu.service.customer.exception;

public class EmailUsedException extends RuntimeException {
    public EmailUsedException() {
        super("Email already used");
    }
}
