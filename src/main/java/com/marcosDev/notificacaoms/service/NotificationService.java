package com.marcosDev.notificacaoms.service;

import com.marcosDev.notificacaoms.domain.dto.NotificacaoDto;
import com.marcosDev.notificacaoms.domain.dto.ScheduleNotificationDto;
import com.marcosDev.notificacaoms.domain.entity.Notification;
import com.marcosDev.notificacaoms.domain.entity.Status;
import com.marcosDev.notificacaoms.domain.enums.StatusEnum;
import com.marcosDev.notificacaoms.domain.repository.NotificationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public void scheduleNotification(ScheduleNotificationDto dto) {
        Notification notification = dto.toNotification();
        System.out.println("Salvando notificação: " + notification);
        notificationRepository.save(notification);
    }

    public Optional<Notification> findById(Long notificationId) {
        return notificationRepository.findById(notificationId);
    }

    public List<NotificacaoDto> listarTodos() {
        return notificationRepository.findAll()
                .stream()
                .map(this::toNotificacaoDto)
                .collect(Collectors.toList());
    }

    private NotificacaoDto toNotificacaoDto(Notification notification) {
        NotificacaoDto dto = new NotificacaoDto();
        dto.setNotificationId(notification.getNotificationId());
        dto.setDateTime(notification.getDateTime());
        dto.setDestination(notification.getDestination());
        dto.setMessage(notification.getMessage());
        dto.setChannelId(notification.getChannel().getChannelId());
        dto.setStatusId(notification.getStatus().getStatusId());
        dto.setDescription(notification.getStatus().getDescription());

        return dto;
    }

    public void cancelNotification(Long notificationId) {
        var notification = findById(notificationId);

        if(notification.isPresent()) {
            notification.get().setStatus(StatusEnum.CANCELED.toStatus());
            notificationRepository.save(notification.get());
        }
    }
}