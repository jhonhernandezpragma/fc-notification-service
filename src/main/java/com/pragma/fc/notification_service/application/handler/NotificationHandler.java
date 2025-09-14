package com.pragma.fc.notification_service.application.handler;

import com.pragma.fc.notification_service.application.dto.request.SmsMessageRequestDto;
import com.pragma.fc.notification_service.application.dto.response.MessageResponseDto;
import com.pragma.fc.notification_service.application.mapper.INotificationResponseMapper;
import com.pragma.fc.notification_service.domain.api.INotificationServicePort;
import com.pragma.fc.notification_service.domain.usecase.output.UseCaseSmsNotificationOutput;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
public class NotificationHandler implements INotificationHandler {
    private final INotificationServicePort notificationServicePort;
    private final INotificationResponseMapper notificationResponseMapper;

    @Override
    public MessageResponseDto sendSms(SmsMessageRequestDto dto) {
        UseCaseSmsNotificationOutput smsNotificationOutput = notificationServicePort.sendSms(dto.getPhoneNumber(), dto.getMessage());
        return notificationResponseMapper.toDto(smsNotificationOutput);
    }
}
