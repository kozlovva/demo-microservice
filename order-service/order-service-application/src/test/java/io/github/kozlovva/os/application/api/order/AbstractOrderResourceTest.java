package io.github.kozlovva.os.application.api.order;

import io.github.kozlovva.os.application.AbstractIntegrationTest;
import io.github.kozlovva.os.domain.customer.dto.Customer;
import io.github.kozlovva.os.domain.customer.port.CustomerGateway;
import io.github.kozlovva.os.domain.order.port.OrderRepository;
import io.github.kozlovva.os.domain.product.dto.Product;
import io.github.kozlovva.os.domain.product.port.ProductGateway;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Random;

import static org.mockito.ArgumentMatchers.anyString;

public abstract class AbstractOrderResourceTest extends AbstractIntegrationTest {

    @Autowired
    protected OrderRepository orderRepository;

    @MockBean
    protected CustomerGateway customerGateway;
    @MockBean
    protected ProductGateway productGateway;

    @BeforeEach
    void initMock() {
        Mockito.when(customerGateway.findById(anyString()))
                .thenAnswer(a -> {
                    var id = a.getArgument(0).toString();
                    return Optional.of(new Customer(id, "Vasia"));
                });

        Mockito.when(productGateway.findById(anyString()))
                .thenAnswer(a -> {
                    var id = a.getArgument(0).toString();
                    return Optional.of(new Product(id, generateRandomBigDecimalFromRange(BigDecimal.ONE, BigDecimal.valueOf(1000D))));
                });
    }

}
