package io.github.kozlovva.os.api.order.v1.mapper;

import io.github.kozlovva.core.caf.mapper.DataMapper;
import io.github.kozlovva.os.api.order.v1.response.OrderResponse;
import io.github.kozlovva.os.domain.order.enity.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderResponseMapper extends DataMapper<Order, OrderResponse> {
}
