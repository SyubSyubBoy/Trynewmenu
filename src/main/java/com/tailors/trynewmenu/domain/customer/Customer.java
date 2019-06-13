package com.tailors.trynewmenu.domain.customer;

import com.tailors.trynewmenu.domain.DomainEntity;
import com.tailors.trynewmenu.domain.customer.exception.DisplayNameEmptyException;
import com.tailors.trynewmenu.domain.customer.exception.EmailEmptyException;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.util.StringUtils;

import javax.persistence.*;
import java.util.Optional;
import java.util.UUID;

@Entity
@Table(name = "TRM_Customer")
@Access(AccessType.FIELD)
@Getter
@NoArgsConstructor
public class Customer extends DomainEntity {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "customer_id", columnDefinition = "BINARY(16)")
    private UUID customerId;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "display_name", nullable = false)
    private String displayName;

    @Column(name = "profile_picture")
    private String profilePicture;

    public Customer update(Customer c) {
        Optional.ofNullable(c.getEmail()).map(this::changeEmail);
        Optional.ofNullable(c.getDisplayName()).map(this::changeDisplayName);
        Optional.ofNullable(c.getProfilePicture()).map(this::changeProfilePicture);
        return this;
    }

    public Customer changeEmail(String email) {
        if (StringUtils.isEmpty(email)) {
            throw new EmailEmptyException();
        }

        this.email = email;
        return this;
    }

    public Customer changeDisplayName(String displayName) {
        if (StringUtils.isEmpty(displayName)) {
            throw new DisplayNameEmptyException();
        }

        this.displayName = displayName;
        return this;
    }

    public Customer changeProfilePicture(String newProfilePicture) {
        this.profilePicture = profilePicture;
        return this;
    }

    @Builder
    public Customer(UUID customerId, String email, String displayName, String profilePicture) {
        this.customerId = customerId;
        this.email = email;
        this.displayName = displayName;
        this.profilePicture = profilePicture;
    }
}
