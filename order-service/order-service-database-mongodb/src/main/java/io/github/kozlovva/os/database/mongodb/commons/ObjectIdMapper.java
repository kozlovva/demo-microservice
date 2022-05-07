package io.github.kozlovva.os.database.mongodb.commons;

import io.github.kozlovva.core.caf.mapper.DataMapper;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

@Component
public class ObjectIdMapper implements DataMapper<ObjectId, String> {

    @Override
    public String map(ObjectId id) {
        return id.toString();
    }

    @Override
    public ObjectId inverseMap(String o) {
        return new ObjectId(o);
    }
}
