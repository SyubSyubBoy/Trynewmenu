package com.tailors.trynewmenu.domain.account.exception;

public class EmailValidationException extends RuntimeException {
    public EmailValidationException() {
        super("Not correct email");
    }
}
