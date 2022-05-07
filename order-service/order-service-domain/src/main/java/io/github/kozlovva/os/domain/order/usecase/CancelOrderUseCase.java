package io.github.kozlovva.os.domain.order.usecase;

import io.github.kozlovva.core.caf.usecase.UseCase;
import io.github.kozlovva.core.caf.usecase.VoidOutput;
import lombok.Value;

import javax.validation.constraints.NotEmpty;

public interface CancelOrderUseCase extends UseCase<CancelOrderUseCase.Command, VoidOutput> {

    @Value
    class Command {
        @NotEmpty
        String orderId;
    }
}
