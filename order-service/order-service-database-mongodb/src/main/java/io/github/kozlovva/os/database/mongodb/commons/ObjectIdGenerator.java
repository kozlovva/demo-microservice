package io.github.kozlovva.os.database.mongodb.commons;

import io.github.kozlovva.core.caf.port.BaseIdGenerator;
import org.bson.types.ObjectId;

public class ObjectIdGenerator implements BaseIdGenerator<ObjectId> {

    @Override
    public String generate() {
        return ObjectId.get().toString();
    }

    @Override
    public ObjectId parse(String id) {
        return new ObjectId(id);
    }
}
