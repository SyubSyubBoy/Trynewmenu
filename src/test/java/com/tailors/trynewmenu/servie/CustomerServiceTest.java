package com.tailors.trynewmenu.servie;

import com.tailors.trynewmenu.domain.customer.Customer;
import com.tailors.trynewmenu.service.CustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceTest {

    @Autowired
    CustomerService customerService;

    @Test
    public void customerCrud() {
        Customer customer = Customer.builder()
                .email("hodol@gmail.com")
                .displayName("kooo")
                .build();
        Customer saved = customerService.create(customer);

        assertThat(customerService.getById(saved.getCustomerId()).getEmail(), is(customer.getEmail()));

        saved.setEmail("hodol2@dgsw.hs.kr");
        customerService.updateCustomer(saved);

        assertThat(customerService.getById(saved.getCustomerId()).getEmail(), is(customer.getEmail()));
        customerService.deleteById(saved.getCustomerId());
        assertThat(customerService.getAll().size(), is(0));
    }
}
