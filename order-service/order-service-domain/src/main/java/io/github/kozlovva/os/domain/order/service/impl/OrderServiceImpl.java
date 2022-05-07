package io.github.kozlovva.os.domain.order.service.impl;

import io.github.kozlovva.core.caf.usecase.UseCaseExecutor;
import io.github.kozlovva.os.domain.order.enity.Order;
import io.github.kozlovva.os.domain.order.service.OrderService;
import io.github.kozlovva.os.domain.order.usecase.CancelOrderUseCase;
import io.github.kozlovva.os.domain.order.usecase.CreateOrderUseCase;
import io.github.kozlovva.os.domain.order.usecase.PayOrderUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final UseCaseExecutor useCaseExecutor;
    private final CreateOrderUseCase createOrderUseCase;
    private final CancelOrderUseCase cancelOrderUseCase;
    private final PayOrderUseCase payOrderUseCase;

    @Override
    public Order createOrder(CreateOrderUseCase.Command command) {
        return useCaseExecutor.execute(createOrderUseCase, command);
    }

    @Override
    public void cancelOrder(CancelOrderUseCase.Command command) {
        useCaseExecutor.execute(cancelOrderUseCase, command);
    }

    @Override
    public void payOrder(PayOrderUseCase.Command command) {
        useCaseExecutor.execute(payOrderUseCase, command);
    }
}
