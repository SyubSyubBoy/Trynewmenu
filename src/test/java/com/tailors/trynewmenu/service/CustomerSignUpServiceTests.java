package com.tailors.trynewmenu.service;

import com.tailors.trynewmenu.domain.account.Account;
import com.tailors.trynewmenu.ui.customer.CustomerSignUpService;
import com.tailors.trynewmenu.ui.dto.CustomerDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerSignUpServiceTests {

    @Autowired
    CustomerSignUpService customerSignupService;

    @Test
    public void signin_test() {
        CustomerDto.CreateEmailAccountRequest request =
                new CustomerDto.CreateEmailAccountRequest();
        request.setEmail("kokoa123@naver.com");
        request.setDisplayName("haha");
        request.setPassword("12345678");

        Account account = customerSignupService.createAccountByEmail(request);
        assertThat(account.getAccountId(), is(notNullValue()));
    }
}
