package io.github.kozlovva.core.caf.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@EqualsAndHashCode
@AllArgsConstructor
@Getter
public abstract class Entity<ID> {
    protected ID id;
    protected Instant createdAt;

    public Entity(ID id) {
        this.id = id;
    }
}
