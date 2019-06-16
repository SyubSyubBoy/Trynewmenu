package com.tailors.trynewmenu.domain.order;

import com.tailors.trynewmenu.domain.DomainEntity;
import com.tailors.trynewmenu.domain.customer.Customer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TRM_Order")
@Getter
@Setter
@NoArgsConstructor
public class Order extends DomainEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_no")
    private Long orderNo;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "account_id")
    private Customer customer;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<OrderLine> orderLines = new ArrayList<>();
}
