package com.tailors.trynewmenu.domain.account;

import com.tailors.trynewmenu.domain.DomainEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "TRM_Account_Access")
@Access(AccessType.FIELD)
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "access_type")
@Getter
@NoArgsConstructor
public class AccountAccess extends DomainEntity {
    @ManyToOne(optional = false)
    @JoinColumn(name = "account_id")
    private Account account;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountAccessId;

    public AccountAccess(Account account) {
        this.account = account;
    }
}
