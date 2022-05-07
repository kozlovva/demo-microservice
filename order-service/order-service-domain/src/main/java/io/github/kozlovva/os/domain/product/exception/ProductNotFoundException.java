package io.github.kozlovva.os.domain.product.exception;

import io.github.kozlovva.core.caf.exception.ResourceNotFoundException;

public class ProductNotFoundException extends ResourceNotFoundException {

    public ProductNotFoundException(String id) {
        super("Product", id);
    }
}
