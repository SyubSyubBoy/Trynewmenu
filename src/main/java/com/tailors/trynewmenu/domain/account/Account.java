package com.tailors.trynewmenu.domain.account;

import com.tailors.trynewmenu.domain.DomainEntity;
import com.tailors.trynewmenu.domain.customer.Customer;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TRM_Account")
@Access(AccessType.FIELD)
@Getter
@NoArgsConstructor
public class Account extends DomainEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long account_id;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = false, orphanRemoval = true)
    @JoinColumn(name = "customer_id", columnDefinition = "BINARY(16)", unique = true)
    private Customer customer;

    @Column(name = "is_enable")
    private boolean isEnable;

    public Account(Customer customer) {
        this.customer = customer;
    }
}
