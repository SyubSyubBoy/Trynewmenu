package com.tailors.trynewmenu.domain.account;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountAccessRepository extends JpaRepository<AccountAccess, Long> {
    Optional<AccountAccess> findByAccount(Account account);
}
