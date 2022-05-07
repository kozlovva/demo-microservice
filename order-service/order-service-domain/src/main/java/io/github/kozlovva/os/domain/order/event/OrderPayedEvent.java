package io.github.kozlovva.os.domain.order.event;

import io.github.kozlovva.core.caf.event.Event;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class OrderPayedEvent extends Event {
    private String orderId;
}
