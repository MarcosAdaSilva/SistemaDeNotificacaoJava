package com.marcosDev.notificacaoms.rest;

import com.marcosDev.notificacaoms.domain.dto.ScheduleNotificationDto;
import com.marcosDev.notificacaoms.domain.entity.Notification;
import com.marcosDev.notificacaoms.service.NotificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping
    public ResponseEntity<Void> ScheduleNotification(@RequestBody ScheduleNotificationDto dto) {
         notificationService.scheduleNotification(dto);
         return ResponseEntity.accepted().build();

    }

    @GetMapping("/{notificationId}")
    public ResponseEntity<Notification> getNotification(@PathVariable("notificationId") Long notificationsId) {
         var notification = notificationService.findById(notificationsId);
         if (notification.isEmpty()) {
             return ResponseEntity.notFound().build();
         }

         return ResponseEntity.ok(notification.get());
    }

    @GetMapping
    public ResponseEntity<List<Notification>> getAllNotifications() {
        List<Notification> notifications = notificationService.findAll();
        return ResponseEntity.ok(notifications);
    }
}
