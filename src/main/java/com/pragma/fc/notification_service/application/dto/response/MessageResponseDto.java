package com.pragma.fc.notification_service.application.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageResponseDto {
    private String messageId;
    private String to;
}
