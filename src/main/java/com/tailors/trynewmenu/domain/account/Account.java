package com.tailors.trynewmenu.domain.account;

import com.tailors.trynewmenu.domain.DomainEntity;
import com.tailors.trynewmenu.domain.customer.Customer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TRM_Account")
@Access(AccessType.FIELD)
@Getter
@NoArgsConstructor
public class Account extends DomainEntity implements Serializable {
    @Id
    @Column(name = "account_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;

    @OneToOne(cascade = CascadeType.ALL , fetch = FetchType.EAGER, optional = false, orphanRemoval = true)
    @JoinColumn(name = "customer_id", columnDefinition = "BINARY(16)", unique = true)
    private Customer customer;

    @Column(name = "is_enable")
    private boolean isEnable;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "account")
    List<AccountAccess> accountAccessList = new ArrayList<>();

    public Account(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
