package io.github.kozlovva.os.domain.order.usecase.impl;

import io.github.kozlovva.core.caf.event.EventDispatcher;
import io.github.kozlovva.core.caf.usecase.VoidOutput;
import io.github.kozlovva.os.domain.order.enity.Order;
import io.github.kozlovva.os.domain.order.event.OrderPayedEvent;
import io.github.kozlovva.os.domain.order.exception.OrderAlreadyPayedException;
import io.github.kozlovva.os.domain.order.exception.OrderNotFoundException;
import io.github.kozlovva.os.domain.order.port.OrderRepository;
import io.github.kozlovva.os.domain.order.usecase.PayOrderUseCase;
import io.github.kozlovva.os.domain.payment.dto.PaymentCommand;
import io.github.kozlovva.os.domain.payment.dto.PaymentResult;
import io.github.kozlovva.os.domain.payment.port.PaymentGateway;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PayOrderUseCaseImpl implements PayOrderUseCase {

    private final OrderRepository orderRepository;
    private final PaymentGateway paymentGateway;
    private final EventDispatcher eventDispatcher;

    @Override
    public VoidOutput execute(Command command) {
        var order = orderRepository.findById(command.getOrderId())
                .orElseThrow(() -> new OrderNotFoundException(command.getOrderId()));

        if (order.isPayed())
            throw new OrderAlreadyPayedException();

        PaymentResult paymentResult = paymentGateway.pay(new PaymentCommand(order.getId(), order.totalPrice(), order.getCustomer().getId()));
        if (paymentResult.isSuccess())
            order.setPaymentStatus(Order.PaymentStatus.PAYED);
        else
            order.setPaymentStatus(Order.PaymentStatus.CANCELLED);

        orderRepository.save(order);

        if (order.isPayed())
            eventDispatcher.dispatch(new OrderPayedEvent(order.getId()));

        return new VoidOutput();
    }
}
