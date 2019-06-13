package com.tailors.trynewmenu.service.customer;

import com.tailors.trynewmenu.domain.customer.Customer;
import com.tailors.trynewmenu.domain.customer.CustomerRepository;
import com.tailors.trynewmenu.service.customer.exception.CustomerNotFoundException;
import com.tailors.trynewmenu.service.customer.exception.EmailUsedException;
import com.tailors.trynewmenu.service.customer.exception.RemoveCustomerException;
import com.tailors.trynewmenu.ui.dto.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerSerivce {
    @Autowired
    CustomerRepository customerRepository;

    public Customer getById(UUID customerId) {
        return customerRepository.findById(customerId).orElseThrow(CustomerNotFoundException::new);
    }

    public Customer createNewCustomer(CustomerDto.CreateRequest request) {
        if (customerRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new EmailUsedException();
        }

        return customerRepository.save(request.toEntity());
    }

    public Customer updateCustomer(CustomerDto.UpdateRequest request) {
        return customerRepository.findById(request.getCustomerId()).map(c -> {
            c.update(request.toEntity());
            return customerRepository.save(c);
        }).orElseThrow(CustomerNotFoundException::new);
    }

    public void deleteCustomer(UUID customerId) {
        try {
            customerRepository.deleteById(customerId);
        } catch (Exception e) {
            throw new RemoveCustomerException(e);
        }
    }
}
