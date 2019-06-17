package com.tailors.trynewmenu.ui.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public interface AccountDto {

    @Data
    @NoArgsConstructor
    class EmailSignInRequest {
        @Email
        @JsonProperty("email")
        String email;

        @NotEmpty
        @JsonProperty("password")
        String password;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    class SignInResult {
        @JsonProperty("token")
        String token;
    }
}
