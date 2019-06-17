package com.tailors.trynewmenu.infrastructure.security;

import com.tailors.trynewmenu.ui.dto.AccountDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class AccountSignInService {

    @Autowired
    AuthenticationManager manager;

    public String signIn(AccountDto.EmailSignInRequest request, HttpSession session) {
        String email = request.getEmail();
        String password = request.getPassword();

        AccountAuthentication token = (AccountAuthentication) manager.authenticate(new EmailAccountAuthToken(email, password));

        if (token.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(token);
        }

        session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, SecurityContextHolder.getContext());
        return session.getId();
    }
}