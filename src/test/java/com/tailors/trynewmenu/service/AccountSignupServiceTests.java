package com.tailors.trynewmenu.service;

import com.tailors.trynewmenu.domain.account.Account;
import com.tailors.trynewmenu.service.account.AccountSignupService;
import com.tailors.trynewmenu.ui.dto.EmailAccountDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountSignupServiceTests {

    @Autowired
    AccountSignupService accountSignupService;

    @Test
    public void signin_test() {
        EmailAccountDto.CreateAccountRequest request = new EmailAccountDto.CreateAccountRequest();
        request.setEmail("teestt@naver.com");
        request.setEmail("kokoa123");
        request.setDisplayName("코코아");

        Account account = accountSignupService.createAccountByEmail(request);
        log.info(account.toString());
        log.info(account.getAccountAccessList().size() + "");
    }
}
