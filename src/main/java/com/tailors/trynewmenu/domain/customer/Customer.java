package com.tailors.trynewmenu.domain.customer;

import com.tailors.trynewmenu.domain.DomainEntity;
import lombok.*;
import org.springframework.beans.factory.annotation.Configurable;

import javax.persistence.*;

@Entity
@Table(name = "customers")
@Getter
@Setter
@NoArgsConstructor
@Configurable
public class Customer extends DomainEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "display_name", nullable = false)
    private String displayName;

    @Column(name = "profile_picture")
    private String profilePicture;

    @Builder
    public Customer(String email, String displayName, String profilePicture) {
        this.email = email;
        this.displayName = displayName;
        this.profilePicture = profilePicture;
    }
}
