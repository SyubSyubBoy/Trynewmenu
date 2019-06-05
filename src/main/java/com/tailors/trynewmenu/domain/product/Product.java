package com.tailors.trynewmenu.domain.product;

import com.tailors.trynewmenu.domain.DomainEntity;
import com.tailors.trynewmenu.domain.EntitySaveException;
import com.tailors.trynewmenu.domain.product.exception.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.util.StringUtils;

import javax.persistence.*;

@Entity
@Table(name = "TRM_Product")
@Access(value = AccessType.FIELD)
@Getter
@NoArgsConstructor
public class Product extends DomainEntity {

    @Id
    @Column(name = "product_code")
    private String productCode;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "product_price", nullable = false)
    private Integer productPrice;

    @Column(name = "product_type", nullable = false)
    private String productType;

    @Column(name = "product_views")
    private Integer productViews;

    @Column(name = "product_picture")
    private String productPicture;

    public Product update(Product target) {
        this.productPrice = target.productPrice;
        this.productName = target.productName;
        this.productType = target.productType;
        this.productViews = target.productViews;
        return this;
    }

    public Product changePrice(Integer newPrice) {
        if (newPrice < 0) {
            throw new PriceChangeException();
        }

        this.productPrice = newPrice;
        return this;
    }

    public Product changeProductName(String newName) {
        if (StringUtils.isEmpty(newName)) {
            throw new EmptyNameException();
        }

        this.productName = newName;
        return this;
    }

    public Product changeProductType(String productType) {
        if (StringUtils.isEmpty(productType)) {
            throw new EmptyProductTypeException();
        }

        this.productType = productType;
        return this;
    }

    public Product changeProductCode(String productCode) {
        if (StringUtils.isEmpty(productCode)) {
            throw new EmptyProductCodeException();
        }

        this.productCode = productCode;

        return this;
    }

    public Product changeProductPicture(String productPicture) {
        this.productPicture = productPicture;

        return this;
    }

    public Product addViewCount() {
        this.productViews += 1;
        return this;
    }

    public Product setViewCount(Integer viewCount) {
        if (viewCount < 0) {
            throw new ProductViewsException();
        }

        this.productViews = viewCount;
        return this;
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
