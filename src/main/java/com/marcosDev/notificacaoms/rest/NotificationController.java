package com.marcosDev.notificacaoms.rest;

import com.marcosDev.notificacaoms.domain.dto.ScheduleNotificationDto;
import com.marcosDev.notificacaoms.service.NotificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
