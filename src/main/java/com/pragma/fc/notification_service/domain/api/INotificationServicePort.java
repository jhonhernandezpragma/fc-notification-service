package com.pragma.fc.notification_service.domain.api;

import com.pragma.fc.notification_service.domain.usecase.output.UseCaseSmsNotificationOutput;

public interface INotificationServicePort {
    UseCaseSmsNotificationOutput sendSms(String phoneNumber, String message);
}
