package io.github.kozlovva.os.domain.product.port;

import io.github.kozlovva.os.domain.product.dto.Product;

import java.util.Optional;

public interface ProductGateway {
    Optional<Product> findById(String id);
}
