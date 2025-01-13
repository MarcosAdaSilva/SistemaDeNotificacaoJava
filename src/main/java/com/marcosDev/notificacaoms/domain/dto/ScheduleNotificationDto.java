package com.marcosDev.notificacaoms.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.marcosDev.notificacaoms.domain.entity.Notification;
import com.marcosDev.notificacaoms.domain.enums.ChannelEnum;
import com.marcosDev.notificacaoms.domain.enums.StatusEnum;

import java.time.LocalDateTime;

public record ScheduleNotificationDto(
        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "America/Sao_Paulo")
        LocalDateTime dateTime,
        String destination,
        String message,
        ChannelEnum channel
) {
    public Notification toNotification() {
        return new Notification(
            dateTime,
            destination,
            message,
            channel.toChannel(),
            StatusEnum.PENDING.toStatus()
        );
    }
}
