package io.github.kozlovva.os.domain.order.port.impl;

import io.github.kozlovva.os.domain.order.port.OrderNumberGenerator;
import io.github.kozlovva.os.domain.order.port.OrderRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrderNumberGeneratorImpl implements OrderNumberGenerator {

    private final OrderRepository orderRepository;

    @Override
    public Long getNextNumber() {
        return orderRepository.getLastOrder()
                .map(o -> o.getNumber() + 1)
                .orElse(1L);
    }
}
