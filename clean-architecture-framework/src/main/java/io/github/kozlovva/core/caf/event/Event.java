package io.github.kozlovva.core.caf.event;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Instant;
import java.util.UUID;

@Getter
@AllArgsConstructor
public abstract class Event {
    protected String id;
    protected Instant timestamp;

    protected String getType() {
        return this.getClass().getSimpleName();
    }

    public Event() {
        id = UUID.randomUUID().toString();
        timestamp = Instant.now();
    }
}
