package com.tailors.trynewmenu.domain;

import com.tailors.trynewmenu.domain.account.Account;
import com.tailors.trynewmenu.domain.account.AccountAccessRepository;
import com.tailors.trynewmenu.domain.account.AccountRepository;
import com.tailors.trynewmenu.domain.account.EmailAccountAccess;
import com.tailors.trynewmenu.domain.customer.Customer;
import com.tailors.trynewmenu.domain.customer.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Transaction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

@Slf4j
@RunWith(SpringRunner.class)
@DataJpaTest
public class AccountTests {

    @Autowired
    CustomerRepository repository;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    AccountAccessRepository accountAccessRepository;

    @Autowired
    EntityManagerFactory entityManagerFactory;

    @Test
    public void account_test() {
        Customer c = Customer.builder()
                .email("test@test.com")
                .displayName("test")
                .build();
        Customer customer = repository.save(c);

        Account a = new Account(customer);
        Account account = accountRepository.save(a);

        EmailAccountAccess aA = new EmailAccountAccess(account, "test@test.com", "kkkk1234");
        EmailAccountAccess accountAccess = accountAccessRepository.save(aA);

        assertThat(customer.getCustomerId(), is(account.getCustomer().getCustomerId()));
        assertThat(account.getAccountId(), is(accountAccess.getAccount().getAccountId()));
        assertThat(accountAccess.getAccountAccessId(), is(accountAccessRepository.findByAccount(account).get().getAccountAccessId()));
    }

    @Test
    public void em_test() {
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Customer c = Customer.builder()
                .email("test123@test.com")
                .displayName("test")
                .build();

        em.persist(c);
        log.info("Customer Id: " + c.getCustomerId().toString());
        Account account = new Account(c);
        em.persist(account);
        log.info("Em has account? " + em.contains(account));

        transaction.commit();
    }
}
