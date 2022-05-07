package io.github.kozlovva.os.api.order.v1;

import io.github.kozlovva.os.api.order.v1.mapper.OrderResponseMapper;
import io.github.kozlovva.os.api.order.v1.request.CreateOrderRequest;
import io.github.kozlovva.os.api.order.v1.response.OrderResponse;
import io.github.kozlovva.os.domain.order.service.OrderService;
import io.github.kozlovva.os.domain.order.usecase.CancelOrderUseCase;
import io.github.kozlovva.os.domain.order.usecase.CreateOrderUseCase;
import io.github.kozlovva.os.domain.order.usecase.PayOrderUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderController implements OrderResource {

    private final OrderService orderService;
    private final OrderResponseMapper mapper;

    @Override
    public ResponseEntity<OrderResponse> createOrder(CreateOrderRequest request) {
        var result = orderService.createOrder(CreateOrderUseCase.Command.builder()
                .customerId(request.getCustomerId())
                .orderItems(request.getOrderItems())
                .build());
        return ResponseEntity.ok(mapper.map(result));
    }

    @Override
    public ResponseEntity<?> cancelOrder(String id) {
        orderService.cancelOrder(new CancelOrderUseCase.Command(id));
        return ResponseEntity.ok("OK");
    }

    @Override
    public ResponseEntity<?> payOrder(String id) {
        orderService.payOrder(new PayOrderUseCase.Command(id));
        return ResponseEntity.ok("OK");
    }
}
