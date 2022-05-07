package io.github.kozlovva.os.domain.payment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@AllArgsConstructor
@Getter
public class PaymentCommand {

    @NotNull
    private String orderId;
    @NotNull
    private BigDecimal total;
    @NotEmpty
    private String customerId;
}
