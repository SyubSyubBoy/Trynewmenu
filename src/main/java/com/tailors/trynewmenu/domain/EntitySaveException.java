package com.tailors.trynewmenu.domain;

public class EntitySaveException extends RuntimeException {
    public EntitySaveException(Throwable cause) {
        super("entity save failed" ,cause);
    }
}
