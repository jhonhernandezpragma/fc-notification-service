package com.pragma.fc.notification_service.domain.spi;

public interface ITokenServicePort {
    boolean isAccessTokenValid(String token);

    String extractSubject(String token);

    String extractRole(String token);
}
