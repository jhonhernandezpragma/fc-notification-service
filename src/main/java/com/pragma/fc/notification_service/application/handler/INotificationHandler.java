package com.pragma.fc.notification_service.application.handler;

import com.pragma.fc.notification_service.application.dto.request.SmsMessageRequestDto;
import com.pragma.fc.notification_service.application.dto.response.MessageResponseDto;

public interface INotificationHandler {
    MessageResponseDto sendSms(SmsMessageRequestDto dto);
}
