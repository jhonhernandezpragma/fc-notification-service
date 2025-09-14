package com.pragma.fc.notification_service.infraestructure.configuration;

import com.pragma.fc.notification_service.domain.api.INotificationServicePort;
import com.pragma.fc.notification_service.domain.spi.INotificationClientPort;
import com.pragma.fc.notification_service.domain.usecase.NotificationUseCase;
import com.pragma.fc.notification_service.infraestructure.out.twilio.adapter.TwilioNotificationAdapter;
import com.pragma.fc.notification_service.infraestructure.out.twilio.property.TwilioProperties;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class NotificationBeanConfiguration {
    private final TwilioProperties twilioProperties;

    @Bean
    public INotificationClientPort notificationClientPort() {
        return new TwilioNotificationAdapter(twilioProperties);
    }

    @Bean
    public INotificationServicePort notificationServicePort() {
        return new NotificationUseCase(notificationClientPort());
    }
}
