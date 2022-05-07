package io.github.kozlovva.os.api.order.v1.request;

import io.github.kozlovva.os.domain.order.usecase.CreateOrderUseCase;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CreateOrderRequest {
    private List<CreateOrderUseCase.Command.OrderItem> orderItems;
    private String customerId;
}
