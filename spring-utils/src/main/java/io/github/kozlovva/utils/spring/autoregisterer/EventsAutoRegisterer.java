package io.github.kozlovva.utils.spring.autoregisterer;

import io.github.kozlovva.core.caf.event.Event;
import io.github.kozlovva.core.caf.event.EventDispatcher;
import io.github.kozlovva.core.caf.event.EventHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import net.jodah.typetools.TypeResolver;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

@Log
@RequiredArgsConstructor
class EventsAutoRegisterer implements BeanPostProcessor {
    private final EventDispatcher eventDispatcher;

    @SuppressWarnings("unchecked")
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof EventHandler) {
            EventHandler<Event> handler = (EventHandler<Event>) bean;
            Class<Event> eventClass = (Class<Event>) TypeResolver.resolveRawArgument(EventHandler.class, handler.getClass());
            eventDispatcher.registerHandler(eventClass, handler);
        }

        return bean;
    }
}

