package com.tailors.trynewmenu.domain;

import com.tailors.trynewmenu.domain.account.Account;
import com.tailors.trynewmenu.domain.account.AccountAccessRepository;
import com.tailors.trynewmenu.domain.account.AccountRepository;
import com.tailors.trynewmenu.domain.account.EmailAccountAccess;
import com.tailors.trynewmenu.domain.customer.Customer;
import com.tailors.trynewmenu.domain.customer.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AccountTests {

    @Autowired
    CustomerRepository repository;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    AccountAccessRepository accountAccessRepository;

    @Test
    public void account_test() {
        Customer c = Customer.builder()
                .email("test@test.com")
                .displayName("test")
                .build();
        Customer customer = repository.save(c);

        Account account = new Account(customer);
        accountRepository.save(account);

        EmailAccountAccess accountAccess = new EmailAccountAccess(account, "test@test.com", "kkkk1234");
        accountAccessRepository.save(accountAccess);
    }
}
