package io.github.kozlovva.os.api.order.v1;

import io.github.kozlovva.os.api.order.v1.request.CreateOrderRequest;
import io.github.kozlovva.os.api.order.v1.response.OrderResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Order API", description = "Orders documentation")
public interface OrderResource {

    @Operation(summary = "Create order")
    @PostMapping(value = Routes.ROOT, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<OrderResponse> createOrder(@RequestBody CreateOrderRequest request);

    @Operation(summary = "Cancel order")
    @PostMapping(value = Routes.CANCEL, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> cancelOrder(@PathVariable String id);

    @Operation(summary = "Pay order")
    @PostMapping(value = Routes.PAY, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> payOrder(@PathVariable String id);
}
