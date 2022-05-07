package io.github.kozlovva.os.database.mongodb.commons;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

public abstract class ExampleQuery {
    abstract public Criteria getCriteria();
    public Query getQuery() {
        return Query.query(getCriteria());
    }
}
