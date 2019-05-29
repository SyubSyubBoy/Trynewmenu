package com.tailors.trynewmenu.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tailors.trynewmenu.domain.DomainDto;
import com.tailors.trynewmenu.domain.product.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public interface ProductDto extends DomainDto<Product> {

    interface Request {

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

        @Data
        @NoArgsConstructor
        class UpdateRequest implements DomainDto<Product> {
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
                        .productType(productType)
                        .productPrice(productPrice)
                        .productName(productName)
                        .build();
            }
        }

        @Data
        @NoArgsConstructor
        class DeleteRequest {
            @JsonProperty("product_code")
            String productCode;
        }
    }

    interface Response {

        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        @Builder
        class MainResponse {
            @JsonProperty("product_code")
            String productCode;

            @JsonProperty("product_name")
            String productName;

            @JsonProperty("product_type")
            String productType;

            @JsonProperty("product_price")
            Integer productPrice;

            @JsonProperty("product_views")
            Integer productViews;

            public MainResponse(Product product) {
                this.productCode = product.getProductCode();
                this.productName = product.getProductName();
                this.productType = product.getProductType();
                this.productPrice = product.getProductPrice();
                this.productViews = product.getProductViews();
            }
        }

        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        class DeleteResponse {
            @JsonProperty("result")
            boolean result;

            public boolean getResult() {
                return result;
            }
        }
    }
}
