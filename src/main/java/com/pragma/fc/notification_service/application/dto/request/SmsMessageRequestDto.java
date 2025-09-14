package com.pragma.fc.notification_service.application.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class SmsMessageRequestDto {
    @NotNull
    @NotBlank
    private String phoneNumber;

    @Length(max = 1000, min = 5)
    @NotNull
    @NotBlank
    private String message;
}
