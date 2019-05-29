package com.tailors.trynewmenu.domain.customer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tailors.trynewmenu.domain.EntityTimeStamp;
import lombok.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.web.client.RestTemplate;

import javax.persistence.*;

@Entity
@Table(name = "customer")
@Getter
@Setter
@NoArgsConstructor
@Configurable
public class Customer extends EntityTimeStamp {
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
