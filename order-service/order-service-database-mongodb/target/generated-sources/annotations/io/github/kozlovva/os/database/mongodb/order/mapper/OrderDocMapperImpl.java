package io.github.kozlovva.os.database.mongodb.order.mapper;

import io.github.kozlovva.os.database.mongodb.commons.ObjectIdMapper;
import io.github.kozlovva.os.database.mongodb.order.document.OrderDoc;
import io.github.kozlovva.os.database.mongodb.order.document.OrderDoc.OrderDocBuilder;
import io.github.kozlovva.os.domain.order.enity.Order;
import io.github.kozlovva.os.domain.order.enity.OrderItem;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-07T12:32:45+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.6 (JetBrains s.r.o)"
)
@Component
public class OrderDocMapperImpl implements OrderDocMapper {

    @Autowired
    private ObjectIdMapper objectIdMapper;

    @Override
    public Order map(OrderDoc arg0) {
        if ( arg0 == null ) {
            return null;
        }

        Long number = null;
        String id = null;

        number = arg0.getNumber();
        id = objectIdMapper.map( arg0.getId() );

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

    @Override
    public OrderDoc inverseMap(Order arg0) {
        if ( arg0 == null ) {
            return null;
        }

        OrderDocBuilder orderDoc = OrderDoc.builder();

        orderDoc.id( objectIdMapper.inverseMap( arg0.getId() ) );
        orderDoc.createdAt( arg0.getCreatedAt() );
        orderDoc.number( arg0.getNumber() );
        orderDoc.customer( arg0.getCustomer() );
        List<OrderItem> list = arg0.getOrderItems();
        if ( list != null ) {
            orderDoc.orderItems( new ArrayList<OrderItem>( list ) );
        }
        orderDoc.status( arg0.getStatus() );
        orderDoc.cancelAt( arg0.getCancelAt() );
        orderDoc.completeAt( arg0.getCompleteAt() );
        orderDoc.paymentStatus( arg0.getPaymentStatus() );

        return orderDoc.build();
    }
}
