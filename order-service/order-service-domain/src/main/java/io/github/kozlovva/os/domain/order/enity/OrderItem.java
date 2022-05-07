package io.github.kozlovva.os.domain.order.enity;

import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class OrderItem {
    private String id;
    private String productId;
    private Long amount;
    private BigDecimal price;

    public BigDecimal totalPrice() {
        return price.multiply(BigDecimal.valueOf(amount));
    }
}
