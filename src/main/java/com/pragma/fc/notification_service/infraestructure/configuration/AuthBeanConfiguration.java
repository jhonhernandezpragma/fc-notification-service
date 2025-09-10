package com.pragma.fc.notification_service.infraestructure.configuration;

import com.pragma.fc.notification_service.domain.spi.ITokenServicePort;
import com.pragma.fc.notification_service.infraestructure.out.security.adapter.JwtTokenServiceAdapter;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class AuthBeanConfiguration {
    @Bean
    public ITokenServicePort tokenServicePort() {
        return new JwtTokenServiceAdapter();
    }
}
