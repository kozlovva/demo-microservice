package io.github.kozlovva.os.domain.payment.port;

import io.github.kozlovva.os.domain.payment.dto.PaymentCommand;
import io.github.kozlovva.os.domain.payment.dto.PaymentResult;

public interface PaymentGateway {
    PaymentResult pay(PaymentCommand paymentCommand);
}
