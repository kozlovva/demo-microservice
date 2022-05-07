package io.github.kozlovva.os.application.api.order;

import com.fasterxml.jackson.core.type.TypeReference;
import io.github.kozlovva.os.api.order.v1.Routes;
import io.github.kozlovva.os.api.order.v1.request.CreateOrderRequest;
import io.github.kozlovva.os.api.order.v1.response.OrderResponse;
import io.github.kozlovva.os.domain.order.enity.Order;
import io.github.kozlovva.os.domain.order.usecase.CreateOrderUseCase;
import lombok.SneakyThrows;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.http.MediaType;

import java.util.Collections;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class CreateOrderControllerTests extends AbstractOrderResourceTest {

    @SneakyThrows
    @ParameterizedTest
    @MethodSource("createOrder_Successful_Test_Requests")
    void createOrder_Successful_Test(CreateOrderRequest request) {
        var result = this.mvc.perform(post(Routes.ROOT)
                .content(objectMapper.writeValueAsBytes(request))
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andReturn();

        OrderResponse response = objectMapper.readValue(result.getResponse().getContentAsByteArray(), new TypeReference<>() {});
        assertNotNull(response);
        assertEquals(1L, response.getNumber());
        assertEquals(Order.Status.NEW, response.getStatus());

        var dataFromDB = orderRepository.findById(response.getId());
        assertNotNull(dataFromDB);
    }

    private static Stream<Arguments> createOrder_Successful_Test_Requests() {
        return Stream.of(
                Arguments.of(CreateOrderRequest.builder()
                        .customerId(generateUuid())
                        .orderItems(Collections.singletonList(new CreateOrderUseCase.Command.OrderItem(generateUuid(), 1L)))
                        .build())
        );
    }

}
