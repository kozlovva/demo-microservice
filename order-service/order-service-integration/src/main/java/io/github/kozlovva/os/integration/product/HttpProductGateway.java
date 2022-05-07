package io.github.kozlovva.os.integration.product;

import io.github.kozlovva.os.domain.product.dto.Product;
import io.github.kozlovva.os.domain.product.port.ProductGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class HttpProductGateway implements ProductGateway {

    @Override
    public Optional<Product> findById(String id) {
        return Optional.empty();
    }
}
