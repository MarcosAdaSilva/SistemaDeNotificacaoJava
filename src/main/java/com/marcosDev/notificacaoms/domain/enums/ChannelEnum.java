package com.marcosDev.notificacaoms.domain.enums;

import com.marcosDev.notificacaoms.domain.entity.Channel;
import lombok.Getter;

@Getter
public enum ChannelEnum {
    EMAIL(1L, "email"),
    SMS(2L,"sms"),
    PUSH(3L,"push"),
    WHATSAPP(4L,"whatsapp");

    private final Long id;
    private final String description;

    ChannelEnum(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public Channel toChannel() {
        return new Channel(id, description);
    }
}