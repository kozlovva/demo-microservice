package io.github.kozlovva.os.database.mongodb.order.query;

import io.github.kozlovva.os.database.mongodb.commons.ExampleQuery;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

public class FindLastOrderQuery extends ExampleQuery {

    @Override
    public Criteria getCriteria() {
        return new Criteria();
    }

    @Override
    public Query getQuery() {
        return Query.query(getCriteria()).with(Sort.by(Sort.Direction.DESC, "number"));
    }
}
