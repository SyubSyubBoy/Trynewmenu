package com.tailors.trynewmenu.domain.account;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "TRM_Account_Access_Email")
@Access(AccessType.FIELD)
@DiscriminatorValue(AccountAccess.EMAIL)
@Getter
@NoArgsConstructor
public class EmailAccountAccess extends AccountAccess {
    @Column(name = "password")
    private String password;

    @Builder
    public EmailAccountAccess(Account account, String password) {
        super(account);
        this.password = password;
    }
}