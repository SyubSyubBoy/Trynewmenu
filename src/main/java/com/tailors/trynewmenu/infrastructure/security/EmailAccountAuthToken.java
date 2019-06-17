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

    private String email;

    private String password;

    private Account account;

    private EmailAccountAccess accountAccess;

    @Override
    public UUID getAccountID() {
        return Optional.ofNullable(account).map(Account::getAccountId).orElse(null);
    }

    public String getEmail() {
        return account.getEmail();
    }

    public String getPassword() {
        return accountAccess.getPassword();
    }

    public EmailAccountAuthToken(String email, String password) {
        super(null);
        setAuthenticated(false);
        setAuthenticated(false);
        this.email = email;
        this.password = password;
    }

    public EmailAccountAuthToken(Account account, EmailAccountAccess accountAccess,
                                 Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        setAuthenticated(true);
        this.account = account;
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
