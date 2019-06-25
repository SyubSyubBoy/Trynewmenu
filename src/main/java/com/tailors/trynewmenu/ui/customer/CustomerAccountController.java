package com.tailors.trynewmenu.ui.customer;

import com.tailors.trynewmenu.domain.customer.Customer;
import com.tailors.trynewmenu.infrastructure.security.AccountAuthentication;
import com.tailors.trynewmenu.service.customer.CustomerSerivce;
import com.tailors.trynewmenu.ui.dto.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/customer/account")
public class CustomerAccountController {

    @Autowired
    CustomerSignUpService signupService;

    @Autowired
    CustomerSerivce customerSerivce;

    @RequestMapping(method = RequestMethod.GET)
    public CustomerDto.Response getInfo() {
        UUID accountId = ((AccountAuthentication)SecurityContextHolder.getContext()).getAccountID();
        Customer customer = customerSerivce.getById(accountId);
        return CustomerDto.Response.createResponse(customer);
    }

    @RequestMapping(method = RequestMethod.POST)
    public CustomerDto.Response createAccount
            (@Valid @RequestBody CustomerDto.CreateEmailAccountRequest request, BindingResult result) {
        if (result.hasErrors()) {
            throw new IllegalArgumentException();
        }

        return CustomerDto.Response.createResponse(signupService.createAccountByEmail(request));
    }
}
