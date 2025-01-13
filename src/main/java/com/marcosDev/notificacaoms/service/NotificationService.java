package com.marcosDev.notificacaoms.service;

import com.marcosDev.notificacaoms.domain.dto.ScheduleNotificationDto;
import com.marcosDev.notificacaoms.domain.repository.NotificationRepository;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public void scheduleNotification(ScheduleNotificationDto dto) {
        notificationRepository.save(dto.toNotification());
    }
}
