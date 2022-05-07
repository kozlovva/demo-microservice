package io.github.kozlovva.os.api.order.v1.mapper;

import io.github.kozlovva.os.api.order.v1.response.OrderResponse;
import io.github.kozlovva.os.api.order.v1.response.OrderResponse.OrderResponseBuilder;
import io.github.kozlovva.os.domain.order.enity.Order;
import io.github.kozlovva.os.domain.order.enity.OrderItem;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-07T12:32:46+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.6 (JetBrains s.r.o)"
)
@Component
public class OrderResponseMapperImpl implements OrderResponseMapper {

    @Override
    public OrderResponse map(Order arg0) {
        if ( arg0 == null ) {
            return null;
        }

        OrderResponseBuilder orderResponse = OrderResponse.builder();

        orderResponse.id( arg0.getId() );
        orderResponse.createdAt( arg0.getCreatedAt() );
        orderResponse.number( arg0.getNumber() );
        orderResponse.customer( arg0.getCustomer() );
        List<OrderItem> list = arg0.getOrderItems();
        if ( list != null ) {
            orderResponse.orderItems( new ArrayList<OrderItem>( list ) );
        }
        orderResponse.status( arg0.getStatus() );
        orderResponse.cancelAt( arg0.getCancelAt() );
        orderResponse.completeAt( arg0.getCompleteAt() );
        orderResponse.paymentStatus( arg0.getPaymentStatus() );

        return orderResponse.build();
    }

    @Override
    public Order inverseMap(OrderResponse arg0) {
        if ( arg0 == null ) {
            return null;
        }

        Long number = null;
        String id = null;

        number = arg0.getNumber();
        id = arg0.getId();

        Order order = new Order( id, number );

        order.setCustomer( arg0.getCustomer() );
        List<OrderItem> list = arg0.getOrderItems();
        if ( list != null ) {
            order.setOrderItems( new ArrayList<OrderItem>( list ) );
        }
        order.setStatus( arg0.getStatus() );
        order.setCancelAt( arg0.getCancelAt() );
        order.setCompleteAt( arg0.getCompleteAt() );
        order.setPaymentStatus( arg0.getPaymentStatus() );

        return order;
    }
}
