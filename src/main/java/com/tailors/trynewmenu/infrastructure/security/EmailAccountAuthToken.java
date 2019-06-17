package com.tailors.trynewmenu.infrastructure.security;

import com.tailors.trynewmenu.domain.account.Account;
import com.tailors.trynewmenu.domain.account.AccountAccess;
import com.tailors.trynewmenu.domain.account.EmailAccountAccess;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

public class EmailAccountAuthToken extends AbstractAuthenticationToken implements AccountAuthentication {

    private final String email;

    private final String password;

    private Account account;

    private EmailAccountAccess accountAccess;

    @Override
    public UUID getAccountID() {
        return Optional.ofNullable(account).map(Account::getAccountId).orElse(null);
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public EmailAccountAuthToken(String email, String password) {
        super(null);
        setAuthenticated(false);
        this.email = email;
        this.password = password;
    }

    public EmailAccountAuthToken(Account account, EmailAccountAccess accountAccess,
                                 Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        setAuthenticated(true);
        this.email = account.getEmail();
        this.account = account;
        this.password = accountAccess.getPassword();
        this.accountAccess = accountAccess;
    }

    @Override
    public Object getCredentials() {
        return accountAccess;
    }

    @Override
    public Object getPrincipal() {
        return account;
    }
}
