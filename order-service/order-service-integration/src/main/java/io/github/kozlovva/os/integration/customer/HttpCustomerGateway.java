package io.github.kozlovva.os.integration.customer;

import io.github.kozlovva.os.domain.customer.dto.Customer;
import io.github.kozlovva.os.domain.customer.port.CustomerGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class HttpCustomerGateway implements CustomerGateway {

    @Override
    public Optional<Customer> findById(String id) {
        return Optional.empty();
    }
}
