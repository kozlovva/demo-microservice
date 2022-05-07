package io.github.kozlovva.os.domain.order.service;

import io.github.kozlovva.os.domain.order.enity.Order;
import io.github.kozlovva.os.domain.order.usecase.CancelOrderUseCase;
import io.github.kozlovva.os.domain.order.usecase.CreateOrderUseCase;
import io.github.kozlovva.os.domain.order.usecase.PayOrderUseCase;

public interface OrderService {
    Order createOrder(CreateOrderUseCase.Command command);
    void cancelOrder(CancelOrderUseCase.Command command);
    void payOrder(PayOrderUseCase.Command command);
}
