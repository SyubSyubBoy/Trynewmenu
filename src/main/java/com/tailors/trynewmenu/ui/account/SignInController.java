package com.tailors.trynewmenu.ui.account;

import com.tailors.trynewmenu.infrastructure.security.AccountSignInService;
import com.tailors.trynewmenu.ui.dto.AccountDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@RestController
@RequestMapping("/account")
public class SignInController {

    @Autowired
    AccountSignInService service;

    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public AccountDto.SignInResult signIn(@Valid @RequestBody AccountDto.EmailSignInRequest request,
                                          HttpSession session, BindingResult result) {
        if (result.hasErrors()) {
            throw new IllegalArgumentException();
        }

        String token = service.signIn(request, session);
        return new AccountDto.SignInResult(token);
    }
}
