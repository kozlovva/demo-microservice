package io.github.kozlovva.os.domain.payment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PaymentResult {
    private String id;
    private Status status;

    public enum Status {
        SUCCESS, REJECTED, CANCELED
    }

    public boolean isSuccess() {
        return status.equals(Status.SUCCESS);
    }
}
