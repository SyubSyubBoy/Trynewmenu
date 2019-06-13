package com.tailors.trynewmenu.domain.account;

import com.tailors.trynewmenu.domain.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByCustomer(Customer customer);
}
