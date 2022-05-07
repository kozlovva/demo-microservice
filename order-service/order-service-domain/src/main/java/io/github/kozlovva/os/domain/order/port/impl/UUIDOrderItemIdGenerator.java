package io.github.kozlovva.os.domain.order.port.impl;

import io.github.kozlovva.os.domain.order.port.OrderItemIdGenerator;

import java.util.UUID;

public class UUIDOrderItemIdGenerator implements OrderItemIdGenerator<UUID> {

    @Override
    public String generate() {
        return UUID.randomUUID().toString();
    }

    @Override
    public UUID parse(String id) {
        return UUID.fromString(id);
    }
}
