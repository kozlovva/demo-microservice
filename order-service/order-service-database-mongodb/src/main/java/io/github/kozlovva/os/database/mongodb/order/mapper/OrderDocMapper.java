package io.github.kozlovva.os.database.mongodb.order.mapper;

import io.github.kozlovva.core.caf.mapper.DataMapper;
import io.github.kozlovva.os.database.mongodb.commons.ObjectIdMapper;
import io.github.kozlovva.os.database.mongodb.order.document.OrderDoc;
import io.github.kozlovva.os.domain.order.enity.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {ObjectIdMapper.class})
public interface OrderDocMapper extends DataMapper<OrderDoc, Order> {
}
