package com.tailors.trynewmenu.domain.order;

import com.tailors.trynewmenu.domain.product.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "order_lines")
@Getter
@Setter
@NoArgsConstructor
public class OrderLine {
    @Id
    @GeneratedValue
    @Column(name = "order_line_id")
    private Long orderLineId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "order_no")
    private Order order;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "product_code")
    private Product product;
}
