package io.github.kozlovva.os.integration.payment;

import io.github.kozlovva.os.domain.payment.dto.PaymentCommand;
import io.github.kozlovva.os.domain.payment.dto.PaymentResult;
import io.github.kozlovva.os.domain.payment.port.PaymentGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class HttpPaymentGateway implements PaymentGateway {

    @Override
    public PaymentResult pay(PaymentCommand paymentCommand) {
        return null;
    }
}
