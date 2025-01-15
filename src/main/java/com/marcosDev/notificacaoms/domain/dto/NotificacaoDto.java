package com.marcosDev.notificacaoms.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;

public class NotificacaoDto {

    private Long notificationId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateTime;

    private String destination;
    private String message;
    private Long channelId;
    private Long statusId;

    // Getters
    public Long getNotificationId() {
        return notificationId;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getDestination() {
        return destination;
    }

    public String getMessage() {
        return message;
    }

    public Long getChannelId() {
        return channelId;
    }

    public Long getStatusId() {
        return statusId;
    }

    // Setters
    public void setNotificationId(Long notificationId) {
        this.notificationId = notificationId;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }
}