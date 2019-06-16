package com.tailors.trynewmenu.domain.customer;

import com.tailors.trynewmenu.domain.account.Account;
import com.tailors.trynewmenu.domain.customer.exception.DisplayNameEmptyException;
import lombok.*;
import org.springframework.util.StringUtils;

import javax.persistence.*;
import java.util.Optional;
import java.util.UUID;

@Entity
@Table(name = "TRM_Customer")
@Access(AccessType.FIELD)
@DiscriminatorValue(Account.CUSTOMER)
@Getter
@NoArgsConstructor
public class Customer extends Account {
    @Column(name = "display_name", nullable = false)
    private String displayName;

    @Column(name = "profile_picture")
    private String profilePicture;

    public void changeDisplayName(String displayName) {
        if (StringUtils.isEmpty(displayName)) {
            throw new DisplayNameEmptyException();
        }

        this.displayName = displayName;
    }

    public void changeProfilePicture(String newProfilePicture) {
        this.profilePicture = newProfilePicture;
    }

    public void update(Customer customer) {
        Optional.ofNullable(customer.getEmail()).ifPresent(this::changeDisplayName);
        Optional.ofNullable(customer.getDisplayName()).ifPresent(this::changeDisplayName);
        Optional.ofNullable(customer.getProfilePicture()).ifPresent(this::changeProfilePicture);
    }

    @Builder
    public Customer(UUID accountId, String email, String displayName, String profilePicture) {
        this.accountId = accountId;
        this.email = email;
        this.displayName = displayName;
        this.profilePicture = profilePicture;
    }
}
