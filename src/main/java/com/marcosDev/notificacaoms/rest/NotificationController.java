package com.marcosDev.notificacaoms.rest;

import com.marcosDev.notificacaoms.domain.dto.NotificacaoDto;
import com.marcosDev.notificacaoms.domain.dto.ScheduleNotificationDto;
import com.marcosDev.notificacaoms.domain.entity.Notification;
import com.marcosDev.notificacaoms.service.NotificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    private static final Logger logger = LoggerFactory.getLogger(NotificationController.class);

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping
    public ResponseEntity<Void> scheduleNotification(@RequestBody ScheduleNotificationDto dto) {
        logger.info("...Rest para criar uma nova Notificação...");
        notificationService.scheduleNotification(dto);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/{notificationId}")
    public ResponseEntity<Notification> getNotification(@PathVariable("notificationId") Long notificationId) {
        logger.info("...Rest para buscar uma notificação por Id...");
        var notification = notificationService.findById(notificationId);
        if (notification.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(notification.get());
    }

    @GetMapping
    public ResponseEntity<List<NotificacaoDto>> listarTodos() {
        logger.info("...Rest para buscar todas as notificações na tabela..");
        return ResponseEntity.ok(notificationService.listarTodos());
    }

    @DeleteMapping("/{notificationId}")
    public ResponseEntity<Void> cancelNotification(@PathVariable("notificationId") Long notificationId) {
        notificationService.cancelNotification(notificationId);
        return ResponseEntity.noContent().build();

    }
}