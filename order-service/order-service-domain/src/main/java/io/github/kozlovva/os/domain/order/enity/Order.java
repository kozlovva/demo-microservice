package io.github.kozlovva.os.domain.order.enity;

import io.github.kozlovva.core.caf.entity.Entity;
import io.github.kozlovva.os.domain.customer.dto.Customer;
import io.github.kozlovva.os.domain.order.exception.OrderAlreadyCancelledException;
import io.github.kozlovva.os.domain.order.exception.OrderAlreadyCompletedException;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;


@Setter
@Getter
@EqualsAndHashCode(callSuper = true)
public class Order extends Entity<String> {

    private Long number;
    private Customer customer;
    private List<OrderItem> orderItems;
    private Status status;
    private Instant cancelAt;
    private Instant completeAt;
    private PaymentStatus paymentStatus;

    public Order(String id, Long number) {
        super(id);
        this.number = number;
        this.orderItems = new ArrayList<>();
        this.status = Status.NEW;
        this.paymentStatus = PaymentStatus.WAIT;
    }

    public enum Status {
        NEW, CANCELLED, COMPLETED
    }

    public enum PaymentStatus {
        WAIT, PAYED, CANCELLED;
    }

    /** Methods **/

    public void addOrderItem(OrderItem orderItem) {
        this.orderItems.add(orderItem);
    }

    public void cancel() {
        if (this.status.equals(Status.CANCELLED))
            throw new OrderAlreadyCancelledException();

        this.status = Status.CANCELLED;
        this.cancelAt = Instant.now();
    }

    public void complete() {
        if (this.status.equals(Status.COMPLETED))
            throw new OrderAlreadyCompletedException();

        this.status = Status.COMPLETED;
        this.completeAt = Instant.now();
    }

    public boolean isPayed() {
        return paymentStatus.equals(PaymentStatus.PAYED);
    }

    public BigDecimal totalPrice() {
        return orderItems.stream()
                .map(OrderItem::totalPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
