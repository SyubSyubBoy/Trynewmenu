package com.tailors.trynewmenu.service.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tailors.trynewmenu.domain.DomainDto;
import com.tailors.trynewmenu.domain.product.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public interface ProductDto extends DomainDto<Product> {

    @Data
    @NoArgsConstructor
    class CreateRequest implements ProductDto {
        @JsonProperty("product_code")
        String productCode;

        @JsonProperty("product_name")
        String productName;

        @JsonProperty("product_type")
        String productType;

        @JsonProperty("product_price")
        Integer productPrice;

        @Override
        public Product toEntity() {
            return Product.builder()
                    .productCode(productCode)
                    .productName(productName)
                    .productPrice(productPrice)
                    .productType(productType)
                    .build();
        }
    }
}
