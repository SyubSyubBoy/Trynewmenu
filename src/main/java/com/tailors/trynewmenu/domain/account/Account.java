package com.tailors.trynewmenu.domain.account;

import com.tailors.trynewmenu.domain.DomainEntity;
import com.tailors.trynewmenu.domain.account.exception.EmailValidationException;
import com.tailors.trynewmenu.domain.customer.Customer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.commons.validator.routines.EmailValidator;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "TRM_Account")
@Access(AccessType.FIELD)
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "account_type")
@Getter
@NoArgsConstructor
public abstract class Account extends DomainEntity implements Serializable {

    @Transient
    public static final String CUSTOMER = "customer";
    @Transient
    public static final String ADMIN = "admin";
    @Transient
    public static final String MANAGER = "manager";

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "account_id", columnDefinition = "BINARY(16)")
    protected UUID accountId;

    @Column(name = "email", nullable = false, unique = true)
    protected String email;

    @Column(name = "is_enable")
    protected boolean isEnable = true;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "account")
    protected List<AccountAccess> accountAccessList = new ArrayList<>();

    public void changeEmail(String email) {
        if (!EmailValidator.getInstance().isValid(email)) {
            throw new EmailValidationException();
        }
    }

    public void setAccountAccessList(List<AccountAccess> accountAccessList) {
        this.accountAccessList = accountAccessList;
    }

    public void addAccountAccess(AccountAccess accountAccess) {
        this.accountAccessList.add(accountAccess);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
