package io.github.kozlovva.os.domain.order.event;

import io.github.kozlovva.core.caf.event.Event;
import io.github.kozlovva.os.domain.order.enity.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class OrderCreatedEvent extends Event {
    private Order order;
}
