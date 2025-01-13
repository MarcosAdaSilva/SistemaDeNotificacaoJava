package com.marcosDev.notificacaoms.domain.repository;

import com.marcosDev.notificacaoms.domain.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
