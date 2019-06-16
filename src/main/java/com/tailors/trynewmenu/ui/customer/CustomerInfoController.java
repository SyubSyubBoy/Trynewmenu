package com.tailors.trynewmenu.ui.customer;

import com.tailors.trynewmenu.domain.customer.Customer;
import com.tailors.trynewmenu.service.customer.CustomerSerivce;
import com.tailors.trynewmenu.ui.dto.BooleanResult;
import com.tailors.trynewmenu.ui.dto.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/customer")
public class CustomerInfoController {

    @Autowired
    CustomerSerivce customerSerivce;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Customer info(@PathVariable("id") String id) {
        return customerSerivce.getById(UUID.fromString(id));
    }
}
