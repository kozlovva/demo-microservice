package io.github.kozlovva.os.domain.order.usecase;

import io.github.kozlovva.core.caf.usecase.UseCase;
import io.github.kozlovva.core.caf.usecase.VoidOutput;
import lombok.Value;

public interface PayOrderUseCase extends UseCase<PayOrderUseCase.Command, VoidOutput> {

    @Value
    class Command {
        String orderId;
    }
}
