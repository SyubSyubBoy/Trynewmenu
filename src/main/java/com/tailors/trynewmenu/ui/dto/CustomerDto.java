package com.tailors.trynewmenu.ui.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tailors.trynewmenu.domain.DomainDto;
import com.tailors.trynewmenu.domain.customer.Customer;
import com.tailors.trynewmenu.service.customer.exception.CustomerIdFormatException;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.UUID;

public interface CustomerDto extends DomainDto<Customer> {
    @Data
    @NoArgsConstructor
    class CreateRequest implements CustomerDto {
        @NotEmpty
        @JsonProperty("email")
        String email;

        @NotEmpty
        @JsonProperty("display_name")
        String displayName;

        @JsonProperty("profile_picture")
        String profilePicture;

        @Override
        public Customer toEntity() {
            return Customer.builder()
                    .email(email)
                    .displayName(displayName)
                    .profilePicture(profilePicture)
                    .build();
        }
    }

    @Data
    @NoArgsConstructor
    class UpdateRequest implements CustomerDto {
        @Getter(AccessLevel.NONE)
        @NotEmpty
        @JsonProperty("customer_id")
        String customerId;

        @NotEmpty
        @JsonProperty("email")
        String email;

        @NotEmpty
        @JsonProperty("display_name")
        String displayName;

        @JsonProperty("profile_picture")
        String profilePicture;

        public UUID getCustomerId() {
            try {
                return UUID.fromString(customerId);
            } catch (Exception e) {
                throw new CustomerIdFormatException(e);
            }
        }

        @Override
        public Customer toEntity() {
            return Customer.builder()
                    .customerId(getCustomerId())
                    .email(email)
                    .displayName(displayName)
                    .profilePicture(profilePicture)
                    .build();
        }
    }
}
