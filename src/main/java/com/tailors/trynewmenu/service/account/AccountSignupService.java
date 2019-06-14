package com.tailors.trynewmenu.service.account;

import com.tailors.trynewmenu.domain.account.*;
import com.tailors.trynewmenu.domain.customer.Customer;
import com.tailors.trynewmenu.domain.customer.CustomerRepository;
import com.tailors.trynewmenu.service.customer.CustomerSerivce;
import com.tailors.trynewmenu.ui.dto.EmailAccountDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@Slf4j
@Service
public class AccountSignupService {

    @Autowired
    CustomerSerivce customerSerivce;

    @Autowired
    AccountRepository repository;

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.SERIALIZABLE)
    public Account createAccountByEmail(EmailAccountDto.CreateAccountRequest request) {
        Customer customer = customerSerivce.createNewCustomer(Customer.builder()
                                    .email(request.getEmail())
                                    .displayName(request.getDisplayName())
                                    .build());
        Account account = new Account(customer);
        account.getAccountAccessList().add(new EmailAccountAccess(account, request.getEmail(), request.getPassword()));
        repository.save(account);

        return account;
    }
}
