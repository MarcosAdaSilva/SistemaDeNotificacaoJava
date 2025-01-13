package com.marcosDev.notificacaoms.domain.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ChannelDto{

    private LocalDateTime dateTime;
    private Long channelId;
    private String description;
}