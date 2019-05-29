package com.tailors.trynewmenu.domain.product;

import com.tailors.trynewmenu.domain.EntityTimeStamp;
import com.tailors.trynewmenu.domain.product.exception.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.util.StringUtils;

import javax.persistence.*;

@Entity
@Access(value = AccessType.FIELD)
@Table(name = "product")
@Getter
@NoArgsConstructor
@Configurable
public class Product extends EntityTimeStamp {

    @Autowired
    private transient ProductRepository productRepository;

    @Id
    @Column(name = "product_code")
    private String productCode;

    @Column(name = "product_name", nullable = false, unique = true)
    private String productName;

    @Column(name = "product_price", nullable = false)
    private Integer productPrice;

    @Column(name = "product_type", nullable = false)
    private String productType;

    @Column(name = "product_views")
    private Integer productViews;

    public Product update(Product target) {
        this.productPrice = target.productPrice;
        this.productName = target.productName;
        this.productType = target.productType;
        this.productViews = target.productViews;
        return productRepository.save(this);
    }

    public Product changePrice(Integer newPrice) {
        if (newPrice < 0) {
            throw new PriceChangeException();
        }

        this.productPrice = newPrice;
        return productRepository.save(this);
    }

    public Product changeProductName(String newName) {
        if (StringUtils.isEmpty(newName)) {
            throw new EmptyNameException();
        }

        this.productName = newName;
        return productRepository.save(this);
    }

    public Product changeProductType(String productType) {
        if (StringUtils.isEmpty(productType)) {
            throw new EmptyProductTypeException();
        }

        this.productType = productType;
        return productRepository.save(this);
    }

    public Product changeProductCode(String productCode) {
        if (StringUtils.isEmpty(productCode)) {
            throw new EmptyProductCodeException();
        }

        this.productCode = productCode;

        try {
            return productRepository.save(this);
        } catch (Exception e) {
            e.printStackTrace();
            throw new SameProductCodeException(e);
        }
    }

    public Product addViewCount() {
        this.productViews += 1;
        return productRepository.save(this);
    }

    public Product setViewCount(Integer viewCount) {
        if (viewCount < 0) {
            throw new ProductViewsException();
        }

        this.productViews = viewCount;
        return productRepository.save(this);
    }

    @Builder
    public Product(String productCode, String productName, Integer productPrice, String productType) {
        this.productCode = productCode;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productType = productType;
        this.productViews = 0;
    }
}
