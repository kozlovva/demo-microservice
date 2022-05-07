package io.github.kozlovva.os.domain.order.usecase.impl;

import io.github.kozlovva.core.caf.event.EventDispatcher;
import io.github.kozlovva.core.caf.usecase.VoidOutput;
import io.github.kozlovva.os.domain.order.event.OrderCancelledEvent;
import io.github.kozlovva.os.domain.order.exception.OrderNotFoundException;
import io.github.kozlovva.os.domain.order.port.OrderRepository;
import io.github.kozlovva.os.domain.order.usecase.CancelOrderUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CancelOrderUseCaseImpl implements CancelOrderUseCase {

    private final OrderRepository orderRepository;
    private final EventDispatcher eventDispatcher;

    @Override
    public VoidOutput execute(Command command) {
        var order = orderRepository.findById(command.getOrderId())
                .orElseThrow(() -> new OrderNotFoundException(command.getOrderId()));
        order.cancel();
        orderRepository.save(order);

        eventDispatcher.dispatch(new OrderCancelledEvent(order.getId()));

        return new VoidOutput();
    }
}
