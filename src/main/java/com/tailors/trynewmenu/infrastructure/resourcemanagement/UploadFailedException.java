package com.tailors.trynewmenu.infrastructure.resourcemanagement;

public class UploadFailedException extends RuntimeException {
    public UploadFailedException(Throwable cause) {
        super("File upload failed", cause);
    }
}
