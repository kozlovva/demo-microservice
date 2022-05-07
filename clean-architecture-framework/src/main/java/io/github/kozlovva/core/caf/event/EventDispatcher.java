package io.github.kozlovva.core.caf.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public abstract class EventDispatcher {

    protected final Map<Class<? extends Event>, List<EventHandler<? extends Event>>> handlers = new HashMap<>();

    @Setter
    private EventStorage eventStorage;

    public abstract <E extends Event> void registerHandler(Class<E> eventType, EventHandler<? super E> handler);

    public abstract <E extends Event> void dispatch(E event);

    protected abstract  <E extends Event> void sendEventToHandlers(Collection<EventHandler<? extends Event>> targetEventHandlers, E event);

}
