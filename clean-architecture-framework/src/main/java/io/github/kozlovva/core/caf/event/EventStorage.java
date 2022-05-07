package io.github.kozlovva.core.caf.event;

public interface EventStorage {
    <E extends Event> void put(E event);
}
