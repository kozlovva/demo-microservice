package io.github.kozlovva.os.database.mongodb.order.document;

import io.github.kozlovva.os.domain.customer.dto.Customer;
import io.github.kozlovva.os.domain.order.enity.Order;
import io.github.kozlovva.os.domain.order.enity.OrderItem;
import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.List;

@Document
@Data
@Builder
public class OrderDoc {
    private ObjectId id;
    private Instant createdAt;
    private Long number;
    private Customer customer;
    private List<OrderItem> orderItems;
    private Order.Status status;
    private Instant cancelAt;
    private Instant completeAt;
    private Order.PaymentStatus paymentStatus;
}
