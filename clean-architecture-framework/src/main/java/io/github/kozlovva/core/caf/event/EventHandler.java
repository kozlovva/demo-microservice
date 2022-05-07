package io.github.kozlovva.core.caf.event;

/**
 *  Handle event
 * @param <E>
 */
public interface EventHandler<E extends Event> {

    void onEvent(E event);

}
