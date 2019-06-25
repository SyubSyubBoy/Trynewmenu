package com.tailors.trynewmenu.infrastructure.security;

import com.tailors.trynewmenu.domain.account.EmailAccountAccess;
import com.tailors.trynewmenu.domain.customer.CustomerRepository;
import com.tailors.trynewmenu.service.customer.exception.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Component;

@Component
public class EmailAccountProvider implements AuthenticationProvider {

    @Autowired
    CustomerRepository repository;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        EmailAccountAuthToken token = (EmailAccountAuthToken)authentication;

        EmailAccountAuthToken validated = repository.findByEmail(token.getEmail())
                .map(customer -> {
                    EmailAccountAccess accountAccess = (EmailAccountAccess)
                            customer.getAccountAccessList().stream()
                            .filter(ac -> ac instanceof EmailAccountAccess)
                            .findFirst()
                            .orElse(null);

                    if (accountAccess.getPassword().equals(token.getPassword())) {
                        return new EmailAccountAuthToken(customer, accountAccess,
                                AuthorityUtils.createAuthorityList("ROLE_CUSTOMER"));
                    } else {
                        throw new IllegalArgumentException();
                    }
                }).orElseThrow(CustomerNotFoundException::new);


        return validated;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(EmailAccountAuthToken.class);
    }
}
