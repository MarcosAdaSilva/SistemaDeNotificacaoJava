package com.marcosDev.notificacaoms.scheduler;

import com.marcosDev.notificacaoms.service.NotificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@Component
public class NotificationMsScheduler {

    private static final Logger logger = LoggerFactory.getLogger(NotificationMsScheduler.class);

    private final NotificationService notificationService;

    public NotificationMsScheduler(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @Scheduled(fixedDelay = 1, timeUnit = TimeUnit.MINUTES)
    public void runTasks() {
        var dateTime = LocalDateTime.now();
        logger.info("Running at {}", dateTime);
        notificationService.checkAndSend(dateTime);

    }
}
