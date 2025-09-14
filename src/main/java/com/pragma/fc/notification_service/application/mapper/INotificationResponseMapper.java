package com.pragma.fc.notification_service.application.mapper;

import com.pragma.fc.notification_service.application.dto.response.MessageResponseDto;
import com.pragma.fc.notification_service.domain.usecase.output.UseCaseSmsNotificationOutput;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface INotificationResponseMapper {
    MessageResponseDto toDto(UseCaseSmsNotificationOutput output);
}
