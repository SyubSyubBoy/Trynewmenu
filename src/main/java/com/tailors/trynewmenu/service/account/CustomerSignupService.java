package com.tailors.trynewmenu.service.account;

import com.tailors.trynewmenu.domain.account.*;
import com.tailors.trynewmenu.domain.customer.Customer;
import com.tailors.trynewmenu.service.customer.CustomerSerivce;
import com.tailors.trynewmenu.ui.dto.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class CustomerSignupService {

    @Autowired
    CustomerSerivce customerSerivce;

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.SERIALIZABLE)
    public Account createAccountByEmail(CustomerDto.CreateEmailAccountRequest request) {
        Customer customer = Customer.builder()
                .email(request.getEmail())
                .displayName(request.getDisplayName())
                .profilePicture(request.getProfilePicture())
                .build();
        AccountAccess accountAccess = new EmailAccountAccess(customer, request.getPassword());
        customer.addAccountAccess(accountAccess);
        return customerSerivce.createNewCustomer(customer);
    }
}
