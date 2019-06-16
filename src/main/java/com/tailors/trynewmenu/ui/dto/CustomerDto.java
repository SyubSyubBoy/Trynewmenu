package com.tailors.trynewmenu.ui.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tailors.trynewmenu.domain.DomainDto;
import com.tailors.trynewmenu.domain.customer.Customer;
import com.tailors.trynewmenu.service.customer.exception.CustomerIdFormatException;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import java.util.UUID;

public interface CustomerDto extends DomainDto<Customer> {
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    class CreateEmailAccountRequest {
        @JsonProperty("email")
        String email;

        @JsonProperty("password")
        String password;

        @JsonProperty("display_name")
        String displayName;

        @JsonProperty("profile_picture")
        String profilePicture;
    }
}
