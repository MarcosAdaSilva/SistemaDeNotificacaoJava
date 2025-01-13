package com.marcosDev.notificacaoms.domain.repository;

import com.marcosDev.notificacaoms.domain.entity.Channel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChannelRepository extends JpaRepository<Channel, Long> {
}
