package com.tailors.trynewmenu.domain.account;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @Transient
    public static final String EMAIL = "email";

    @JsonIgnore
    @ManyToOne(optional = false)
    @JoinColumn(name = "account_id", columnDefinition = "BINARY(16)")
    private Account account;

    @Id
    @Column(name = "account_access_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountAccessId;

    public AccountAccess(Account account) {
        this.account = account;
    }
}
