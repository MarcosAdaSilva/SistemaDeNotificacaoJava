package com.marcosDev.notificacaoms.domain.repository;

import com.marcosDev.notificacaoms.domain.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, Long> {
}
