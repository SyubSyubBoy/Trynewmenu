package com.tailors.trynewmenu.domain.customer.exception;

public class DisplayNameEmptyException extends RuntimeException {
    public DisplayNameEmptyException() {
        super("Display name must not be empty");
    }
}
