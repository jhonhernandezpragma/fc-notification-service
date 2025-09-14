package com.pragma.fc.notification_service.infraestructure.out.twilio.adapter;

import com.pragma.fc.notification_service.domain.spi.INotificationClientPort;
import com.pragma.fc.notification_service.domain.usecase.output.UseCaseSmsNotificationOutput;
import com.pragma.fc.notification_service.infraestructure.out.twilio.property.TwilioProperties;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class TwilioNotificationAdapter implements INotificationClientPort {
    private final TwilioProperties twilioProperties;

    public TwilioNotificationAdapter(TwilioProperties twilioProperties) {
        this.twilioProperties = twilioProperties;
    }

    @PostConstruct
    public void initTwilio() {
        Twilio.init(twilioProperties.getAccountSid(), twilioProperties.getAuthToken());
    }

    @Override
    public UseCaseSmsNotificationOutput sendSms(String phoneNumber, String message) {
        Message messageResponse = Message.creator(
                new PhoneNumber(phoneNumber),
                twilioProperties.getMessageServiceId(),
                message
        ).create();

        return new UseCaseSmsNotificationOutput(
                phoneNumber,
                messageResponse.getSid()
        );
    }
}

