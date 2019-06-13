package com.tailors.trynewmenu.domain.account;

import com.tailors.trynewmenu.domain.DomainEntity;
import com.tailors.trynewmenu.domain.customer.Customer;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "TRM_Account")
@Access(AccessType.FIELD)
@Getter
@NoArgsConstructor
public class Account extends DomainEntity {
    @Id
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = false, orphanRemoval = true)
    @JoinColumn(name = "customer_id", columnDefinition = "BINARY(16)")
    private Customer customer;

    @Column(name = "is_enable")
    private boolean isEnable;
}
