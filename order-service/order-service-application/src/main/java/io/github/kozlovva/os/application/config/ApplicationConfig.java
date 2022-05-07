package io.github.kozlovva.os.application.config;

import io.github.kozlovva.core.caf.event.DefaultEventDispatcher;
import io.github.kozlovva.core.caf.event.EventDispatcher;
import io.github.kozlovva.core.caf.usecase.UseCaseExecutor;
import io.github.kozlovva.core.caf.usecase.impl.UseCaseExecutorImpl;
import io.github.kozlovva.os.domain.order.port.OrderItemIdGenerator;
import io.github.kozlovva.os.domain.order.port.OrderNumberGenerator;
import io.github.kozlovva.os.domain.order.port.OrderRepository;
import io.github.kozlovva.os.domain.order.port.impl.OrderNumberGeneratorImpl;
import io.github.kozlovva.os.domain.order.port.impl.UUIDOrderItemIdGenerator;
import io.github.kozlovva.os.domain.order.service.OrderService;
import io.github.kozlovva.os.domain.order.service.impl.OrderServiceImpl;
import io.github.kozlovva.os.domain.order.usecase.CancelOrderUseCase;
import io.github.kozlovva.os.domain.order.usecase.CreateOrderUseCase;
import io.github.kozlovva.os.domain.order.usecase.PayOrderUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.validation.Validator;

@Configuration
public class ApplicationConfig {

    @Bean
    public EventDispatcher eventDispatcher() {
        return new DefaultEventDispatcher();
    }

    @Bean
    public OrderNumberGenerator orderNumberGenerator(OrderRepository orderRepository) {
        return new OrderNumberGeneratorImpl(orderRepository);
    }

    @Bean
    public OrderItemIdGenerator<?> orderItemIdGenerator() {
        return new UUIDOrderItemIdGenerator();
    }

    @Bean
    public UseCaseExecutor useCaseExecutor(Validator validator) {
        return new UseCaseExecutorImpl(validator);
    }

    @Bean
    public OrderService orderService(
            UseCaseExecutor useCaseExecutor,
            CreateOrderUseCase createOrderUseCase,
            CancelOrderUseCase cancelOrderUseCase,
            PayOrderUseCase payOrderUseCase
    ) {
        return new OrderServiceImpl(useCaseExecutor, createOrderUseCase, cancelOrderUseCase, payOrderUseCase);
    }
}
