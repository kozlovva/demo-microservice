package io.github.kozlovva.os.database.mongodb.order.query;

import io.github.kozlovva.os.database.mongodb.commons.PageableExampleQuery;
import io.github.kozlovva.os.domain.order.port.filters.OrderFilters;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.util.StringUtils;

import java.util.HashSet;

public class FindOrdersQuery extends PageableExampleQuery {

    private final OrderFilters orderFilters;

    public FindOrdersQuery(OrderFilters orderFilters) {
        super(orderFilters);
        this.orderFilters = orderFilters;
    }

    @Override
    public Criteria getCriteria() {
        var andCriteriaSet = new HashSet<>();

        if (StringUtils.hasText(orderFilters.getCustomerId()))
            andCriteriaSet.add(Criteria.where("customer.id").is(orderFilters.getCustomerId()));

        if (orderFilters.getNumber() != null)
            andCriteriaSet.add(Criteria.where("number").is(orderFilters.getNumber()));

        return andCriteriaSet.size() > 0 ? new Criteria().andOperator(andCriteriaSet.toArray(Criteria[]::new)) : new Criteria();
    }
}
