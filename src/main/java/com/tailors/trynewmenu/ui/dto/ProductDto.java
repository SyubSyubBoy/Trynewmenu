package com.tailors.trynewmenu.ui.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tailors.trynewmenu.domain.DomainDto;
import com.tailors.trynewmenu.domain.product.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public interface ProductDto extends DomainDto<Product> {
    @Data
    @NoArgsConstructor
    class CreateRequest implements ProductDto {
        @NotEmpty
        @JsonProperty("product_code")
        String productCode;

        @NotEmpty
        @JsonProperty("product_name")
        String productName;

        @NotEmpty
        @JsonProperty("product_type")
        String productType;

        @Min(0)
        @NotNull
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
    class UpdateRequest implements ProductDto {
        @NotEmpty
        @JsonProperty("product_code")
        String productCode;

        @JsonProperty("product_name")
        String productName;

        @JsonProperty("product_type")
        String productType;

        @Min(0)
        @JsonProperty("product_price")
        Integer productPrice;

        @JsonProperty("product_picture")
        String productPicture;

        @Override
        public Product toEntity() {
            Product product = Product.builder()
                    .productCode(productCode)
                    .productType(productType)
                    .productPrice(productPrice)
                    .productName(productName)
                    .build();
            return product.changeProductPicture(productPicture);
        }
    }

    @Data
    @NoArgsConstructor
    class DeleteRequest {
        @NotEmpty
        @JsonProperty("product_code")
        String productCode;
    }

    @Data
    @AllArgsConstructor
    @Builder
    class Response {
        @JsonProperty("product_code")
        String productCode;

        @JsonProperty("product_name")
        String productName;

        @JsonProperty("product_type")
        String productType;

        @JsonProperty("product_price")
        Integer productPrice;

        @JsonProperty("product_picture")
        String productPicture;

        public static Response createResponse(Product product) {
            return Response.builder()
                    .productName(product.getProductName())
                    .productCode(product.getProductCode())
                    .productType(product.getProductType())
                    .productPrice(product.getProductPrice())
                    .productPicture(product.getProductPicture())
                    .build();
        }
    }
}
