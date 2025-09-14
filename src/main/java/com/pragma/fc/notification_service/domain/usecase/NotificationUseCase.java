package com.pragma.fc.notification_service.domain.usecase;

import com.pragma.fc.notification_service.domain.api.INotificationServicePort;
import com.pragma.fc.notification_service.domain.spi.INotificationClientPort;
import com.pragma.fc.notification_service.domain.usecase.output.UseCaseSmsNotificationOutput;

public class NotificationUseCase implements INotificationServicePort {
    private final INotificationClientPort notificationClientPort;

    public NotificationUseCase(INotificationClientPort notificationClientPort) {
        this.notificationClientPort = notificationClientPort;
    }

    @Override
    public UseCaseSmsNotificationOutput sendSms(String phoneNumber, String message) {
        return notificationClientPort.sendSms(phoneNumber, message);
    }
}
