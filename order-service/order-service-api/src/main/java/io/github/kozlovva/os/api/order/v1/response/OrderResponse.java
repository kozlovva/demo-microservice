package io.github.kozlovva.os.api.order.v1.response;

import io.github.kozlovva.os.domain.customer.dto.Customer;
import io.github.kozlovva.os.domain.order.enity.Order;
import io.github.kozlovva.os.domain.order.enity.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class OrderResponse {
    private String id;
    private Instant createdAt;
    private Long number;
    private Customer customer;
    private List<OrderItem> orderItems;
    private Order.Status status;
    private Instant cancelAt;
    private Instant completeAt;
    private Order.PaymentStatus paymentStatus;
}
