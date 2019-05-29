package com.tailors.trynewmenu.service;

import com.tailors.trynewmenu.domain.customer.Customer;
import com.tailors.trynewmenu.domain.customer.CustomerNotFoundException;
import com.tailors.trynewmenu.domain.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    public Customer getById(Long id) {
        return customerRepository.findById(id).orElseThrow(CustomerNotFoundException::new);
    }

    public Customer create(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(Customer customer) {
        return customerRepository.findById(customer.getCustomerId()).map(c -> {
            c.setEmail(customer.getEmail());
            c.setDisplayName(customer.getDisplayName());
            c.setProfilePicture(customer.getProfilePicture());
            return customerRepository.save(c);
        }).orElseThrow(CustomerNotFoundException::new);
    }

    public boolean deleteById(Long id) {
        try {
            customerRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
