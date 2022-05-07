package io.github.kozlovva.os.domain.order.port;

import io.github.kozlovva.core.caf.port.CRUDRepository;
import io.github.kozlovva.os.domain.order.enity.Order;
import io.github.kozlovva.os.domain.order.port.filters.OrderFilters;

import java.util.Optional;

public interface OrderRepository extends CRUDRepository<String, Order, OrderFilters> {
    Optional<Order> getLastOrder();
}
