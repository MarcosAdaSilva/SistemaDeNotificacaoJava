package com.marcosDev.notificacaoms.domain.enums;

import com.marcosDev.notificacaoms.domain.entity.Status;
import lombok.Getter;

@Getter
public enum StatusEnum {
    PENDING(1L, "pending"),
    SUCCESS(2L, "success"),
    ERROR(3L, "error"),
    CANCELED(4L, "canceled");

    private final Long id;
    private final String description;

    StatusEnum(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public Status toStatus() {
        return new Status(id, description);
    }
}