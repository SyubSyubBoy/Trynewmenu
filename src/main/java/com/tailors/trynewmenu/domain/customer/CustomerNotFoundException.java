package com.tailors.trynewmenu.domain.customer;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException() {
        super("customer not found");
    }
}
