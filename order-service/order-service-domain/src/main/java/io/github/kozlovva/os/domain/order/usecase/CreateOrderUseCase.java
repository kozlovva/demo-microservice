package io.github.kozlovva.os.domain.order.usecase;

import io.github.kozlovva.core.caf.usecase.UseCase;
import io.github.kozlovva.os.domain.order.enity.Order;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

public interface CreateOrderUseCase extends UseCase<CreateOrderUseCase.Command, Order> {

    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Getter
    class Command {

        @NotEmpty
        private List<@Valid OrderItem> orderItems;
        @NotEmpty
        private String customerId;

        @AllArgsConstructor
        @NoArgsConstructor
        @Builder
        @Getter
        public static class OrderItem {
            @NotEmpty
            private String productId;

            @Min(1)
            @NotNull
            private Long amount;
        }
    }

}
