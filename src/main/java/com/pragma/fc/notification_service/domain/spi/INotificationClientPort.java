package com.pragma.fc.notification_service.domain.spi;

import com.pragma.fc.notification_service.domain.usecase.output.UseCaseSmsNotificationOutput;

public interface INotificationClientPort {
    UseCaseSmsNotificationOutput sendSms(String phoneNumber, String message);
}
