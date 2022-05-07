package io.github.kozlovva.os.domain.customer.port;

import io.github.kozlovva.os.domain.customer.dto.Customer;

import java.util.Optional;

public interface CustomerGateway {
    Optional<Customer> findById(String id);
}
