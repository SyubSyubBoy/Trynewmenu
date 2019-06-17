package com.tailors.trynewmenu.infrastructure.security;

import org.springframework.security.core.Authentication;

import java.util.UUID;

public interface AccountAuthentication extends Authentication {
    UUID getAccountID();
}
