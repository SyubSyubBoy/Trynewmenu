package com.tailors.trynewmenu.domain.customer.exception;

public class EmailEmptyException extends RuntimeException {
    public EmailEmptyException() {
        super("Email must not be empty");
    }
}
