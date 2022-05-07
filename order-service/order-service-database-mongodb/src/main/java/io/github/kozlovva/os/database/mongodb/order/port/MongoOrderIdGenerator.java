package io.github.kozlovva.os.database.mongodb.order.port;

import io.github.kozlovva.os.database.mongodb.commons.ObjectIdGenerator;
import io.github.kozlovva.os.domain.order.port.OrderIdGenerator;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

@Component
public class MongoOrderIdGenerator extends ObjectIdGenerator implements OrderIdGenerator<ObjectId> {
}
