package io.github.kozlovva.os.database.mongodb.commons;

import io.github.kozlovva.core.caf.port.dto.SearchFilters;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

@RequiredArgsConstructor
public abstract class PageableExampleQuery extends ExampleQuery {

    private final SearchFilters searchFilters;

    @Override
    public Query getQuery() {
        return Query.query(getCriteria())
                .with(Sort.by(Sort.Direction.valueOf(searchFilters.getSortDirection().name()), searchFilters.getSortName()))
                .skip(searchFilters.getOffset())
                .limit(searchFilters.getLimit().intValue());
    }
}
