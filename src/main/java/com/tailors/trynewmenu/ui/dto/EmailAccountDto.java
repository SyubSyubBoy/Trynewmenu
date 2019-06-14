package com.tailors.trynewmenu.ui.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tailors.trynewmenu.domain.DomainDto;
import com.tailors.trynewmenu.domain.account.Account;
import lombok.Data;
import lombok.NoArgsConstructor;

public interface EmailAccountDto {
    @Data
    @NoArgsConstructor
    class CreateAccountRequest {
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
