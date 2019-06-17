package com.tailors.trynewmenu.ui.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tailors.trynewmenu.domain.DomainDto;
import com.tailors.trynewmenu.domain.customer.Customer;
import com.tailors.trynewmenu.service.customer.exception.CustomerIdFormatException;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.UUID;

public interface CustomerDto extends DomainDto<Customer> {
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    class CreateEmailAccountRequest {
        @Email
        @JsonProperty("email")
        String email;

        @NotEmpty
        @JsonProperty("password")
        String password;

        @NotEmpty
        @Max(24)
        @JsonProperty("display_name")
        String displayName;

        @JsonProperty("profile_picture")
        String profilePicture;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    class Response {
        UUID accountId;

        @JsonProperty("email")
        String email;

        @JsonProperty("display_name")
        String displayName;

        @JsonProperty("profile_picture")
        String profilePicture;

        @JsonProperty("account_id")
        public String getAccountId() {
            return accountId.toString();
        }

        public static Response createResponse(Customer customer) {
            return Response.builder()
                    .accountId(customer.getAccountId())
                    .displayName(customer.getDisplayName())
                    .email(customer.getEmail())
                    .profilePicture(customer.getProfilePicture())
                    .build();
        }
    }
}
