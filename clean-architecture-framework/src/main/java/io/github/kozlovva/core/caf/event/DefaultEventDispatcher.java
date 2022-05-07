package io.github.kozlovva.core.caf.event;

import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Slf4j
public class DefaultEventDispatcher extends EventDispatcher {

    @Override
    public <E extends Event> void registerHandler(Class<E> eventType, EventHandler<? super E> handler) {
        List<EventHandler<? extends Event>> registeredHandlersForEvent = handlers.get(eventType);
        if (registeredHandlersForEvent != null) {
            boolean handlerBeenRegistered = registeredHandlersForEvent
                    .stream()
                    .anyMatch(h -> !h.getClass().equals(handler.getClass()));
            if (handlerBeenRegistered)
                registeredHandlersForEvent.add(handler);
        } else
            handlers.put(eventType, new ArrayList<>(Collections.singletonList(handler)));
    }

    @Override
    public <E extends Event> void dispatch(E event) {
        if (getEventStorage() != null)
            getEventStorage().put(event);

        Class<E> eventClass = (Class<E>) event.getClass();

        Set<EventHandler<? extends Event>> targetEventHandlers = getSuperEventClasses(eventClass)
                .stream()
                .map(handlers::get)
                .filter(Objects::nonNull)
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());


        sendEventToHandlers(targetEventHandlers, event);
    }

    @Override
    protected <E extends Event> void sendEventToHandlers(Collection<EventHandler<? extends Event>> targetEventHandlers, E event) {
        targetEventHandlers
                .parallelStream()
                .forEach(handler -> {
                    ((EventHandler<E>) handler).onEvent(event);
                    log.debug("Event {} dispatched to handler {} ", event.getType(), handler.getClass().getSimpleName());
                });
    }

    private <E extends Event> Set<Class<? super E>> getSuperEventClasses(Class<E> eventClass) {
        Set<Class<? super E>> classSet = new HashSet<>();

        Class<? super E> latestClazz = eventClass;

        while (!latestClazz.equals(Event.class)) {
            classSet.add(latestClazz);

            latestClazz = latestClazz.getSuperclass();
        }

        return classSet;
    }
}
