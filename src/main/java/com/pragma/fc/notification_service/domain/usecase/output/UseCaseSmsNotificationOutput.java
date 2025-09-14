package com.pragma.fc.notification_service.domain.usecase.output;

public class UseCaseSmsNotificationOutput {
    private String to;
    private String messageId;

    public UseCaseSmsNotificationOutput() {
    }

    public UseCaseSmsNotificationOutput(String to, String messageId) {
        this.to = to;
        this.messageId = messageId;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }
}
