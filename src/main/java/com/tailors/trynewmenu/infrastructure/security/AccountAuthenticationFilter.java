package com.tailors.trynewmenu.infrastructure.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

@Slf4j
@Component
public class AccountAuthenticationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        HttpSession session = request.getSession();

        AccountAuthentication accountAuthentication = Optional
                .ofNullable(session.getAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY))
                .map(c -> (AccountAuthentication) ((SecurityContext)c).getAuthentication()).orElse(null);

        Optional.ofNullable(accountAuthentication).ifPresent(ac -> {
            log.info("UUID: " + ac.getAccountID());
            SecurityContextHolder.getContext().setAuthentication(accountAuthentication);
        });

        filterChain.doFilter(request, response);
    }
}
