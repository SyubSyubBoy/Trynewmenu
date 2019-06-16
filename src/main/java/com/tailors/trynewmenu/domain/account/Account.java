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
import java.util.UUID;

@Entity
@Table(name = "TRM_Account")
@Access(AccessType.FIELD)
@Getter
@NoArgsConstructor
public class Account extends DomainEntity implements Serializable {
    @Id
    @Column(name = "account_id", columnDefinition = "BINARY(16)", nullable = false, unique = true)
    private UUID accountId;

    @OneToOne(cascade = CascadeType.ALL , fetch = FetchType.EAGER, optional = false, orphanRemoval = true)
    @JoinColumn(name = "account_id", referencedColumnName = "customer_id",
            columnDefinition = "BINARY(16)", unique = true)
    @MapsId
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
