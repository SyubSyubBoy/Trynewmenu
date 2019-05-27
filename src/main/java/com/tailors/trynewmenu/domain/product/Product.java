package com.tailors.trynewmenu.domain.product;

import com.tailors.trynewmenu.domain.EntityTimeStamp;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "product")
@Getter
@Setter
@NoArgsConstructor
public class Product extends EntityTimeStamp {
    @Id
    @Column(name = "product_code")
    private String productCode;

    @Column(name = "product_name", nullable = false, unique = true)
    private String productName;

    @Column(name = "product_price", nullable = false)
    private Integer productPrice;

    @Column(name = "product_type", nullable = false)
    private String productType;
}
