package com.marcosDev.notificacaoms.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class NotificacaoDto {

    private Long notificationId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateTime;

    private String destination;
    private String message;
    private Long channelId;
    private Long statusId;
}

