package io.github.kozlovva.os.domain.order.usecase.impl;

import io.github.kozlovva.core.caf.event.EventDispatcher;
import io.github.kozlovva.os.domain.customer.exception.CustomerNotFoundException;
import io.github.kozlovva.os.domain.customer.port.CustomerGateway;
import io.github.kozlovva.os.domain.order.enity.Order;
import io.github.kozlovva.os.domain.order.enity.OrderItem;
import io.github.kozlovva.os.domain.order.event.OrderCreatedEvent;
import io.github.kozlovva.os.domain.order.port.OrderIdGenerator;
import io.github.kozlovva.os.domain.order.port.OrderItemIdGenerator;
import io.github.kozlovva.os.domain.order.port.OrderNumberGenerator;
import io.github.kozlovva.os.domain.order.port.OrderRepository;
import io.github.kozlovva.os.domain.order.usecase.CreateOrderUseCase;
import io.github.kozlovva.os.domain.product.exception.ProductNotFoundException;
import io.github.kozlovva.os.domain.product.port.ProductGateway;
import lombok.RequiredArgsConstructor;

/**
 * Creating order in the system.
 * After execution dispatching new OrderCreatedEvent.
 */
@RequiredArgsConstructor
public class CreateOrderUseCaseImpl implements CreateOrderUseCase {

    private final OrderRepository repository;
    private final OrderIdGenerator<?> idGenerator;
    private final OrderNumberGenerator numberGenerator;
    private final CustomerGateway customerGateway;
    private final ProductGateway productGateway;
    private final EventDispatcher eventDispatcher;
    private final OrderItemIdGenerator<?> orderItemIdGenerator;

    @Override
    public Order execute(Command command) {
        var order = new Order(idGenerator.generate(), numberGenerator.getNextNumber());
        var customer = customerGateway.findById(command.getCustomerId())
                .orElseThrow(() -> new CustomerNotFoundException(command.getCustomerId()));
        order.setCustomer(customer);
        command.getOrderItems()
                .forEach(o -> {
                    var product = productGateway.findById(o.getProductId())
                            .orElseThrow(() -> new ProductNotFoundException(o.getProductId()));
                    order.addOrderItem(OrderItem.builder()
                            .amount(o.getAmount())
                            .id(orderItemIdGenerator.generate())
                            .price(product.getPrice())
                            .productId(o.getProductId())
                            .build());
                });

        eventDispatcher.dispatch(new OrderCreatedEvent(order));
        repository.save(order);
        return order;
    }
}
