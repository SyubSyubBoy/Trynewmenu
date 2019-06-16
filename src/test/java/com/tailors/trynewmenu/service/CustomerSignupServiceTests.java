package com.tailors.trynewmenu.service;

import com.tailors.trynewmenu.domain.account.Account;
import com.tailors.trynewmenu.service.customer.CustomerSignupService;
import com.tailors.trynewmenu.ui.dto.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerSignupServiceTests {

    @Autowired
    CustomerSignupService customerSignupService;

    @Test
    public void signin_test() {
        CustomerDto.CreateEmailAccountRequest request =
                new CustomerDto.CreateEmailAccountRequest();
        request.setEmail("kokoa123@naver.com");
        request.setDisplayName("haha");
        request.setPassword("12345678");

        Account account = customerSignupService.createAccountByEmail(request);
        log.info(account.toString());
        log.info(account.getAccountAccessList().size() + "");
    }
}
