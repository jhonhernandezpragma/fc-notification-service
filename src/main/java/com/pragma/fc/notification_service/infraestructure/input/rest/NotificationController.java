package com.pragma.fc.notification_service.infraestructure.input.rest;

import com.pragma.fc.notification_service.application.dto.request.SmsMessageRequestDto;
import com.pragma.fc.notification_service.application.dto.response.MessageResponseDto;
import com.pragma.fc.notification_service.application.handler.INotificationHandler;
import com.pragma.fc.notification_service.infraestructure.input.rest.dto.ApiError;
import com.pragma.fc.notification_service.infraestructure.input.rest.dto.ApiSuccess;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${app.api.prefix}/notifications")
@RequiredArgsConstructor
public class NotificationController {
    private final INotificationHandler notificationHandler;

    @Operation(
            summary = "Send sms message",
            description = "Requires api key",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Message sent",
                            content = @Content(schema = @Schema(implementation = MessageResponseDto.class))),
                    @ApiResponse(responseCode = "400", description = "Invalid request body format",
                            content = @Content(schema = @Schema(implementation = ApiError.class))),
                    @ApiResponse(responseCode = "401", description = "Unauthorized: missing Api Key",
                            content = @Content(schema = @Schema(implementation = ApiError.class)))
            }
    )
    @PostMapping("/sms")
    @PreAuthorize("hasAnyRole('OWNER', 'WORKER')")
    public ResponseEntity<ApiSuccess<MessageResponseDto>> sendSms(@RequestBody @Valid SmsMessageRequestDto dto) {
        MessageResponseDto response = notificationHandler.sendSms(dto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ApiSuccess<>(
                        "Sms message send successfully",
                        response
                ));
    }
}
