package io.github.kozlovva.os.database.mongodb.order.port;

import io.github.kozlovva.core.caf.port.dto.SearchResult;
import io.github.kozlovva.os.database.mongodb.commons.ObjectIdMapper;
import io.github.kozlovva.os.database.mongodb.order.document.OrderDoc;
import io.github.kozlovva.os.database.mongodb.order.mapper.OrderDocMapper;
import io.github.kozlovva.os.database.mongodb.order.query.FindLastOrderQuery;
import io.github.kozlovva.os.database.mongodb.order.query.FindOrdersQuery;
import io.github.kozlovva.os.domain.order.enity.Order;
import io.github.kozlovva.os.domain.order.port.OrderRepository;
import io.github.kozlovva.os.domain.order.port.filters.OrderFilters;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Repository
public class MongoOrderRepositoryImpl implements OrderRepository {

    private final MongoTemplate mongoTemplate;
    private final OrderDocMapper mapper;
    private final ObjectIdMapper objectIdMapper;

    @Override
    public void save(Order entity) {
        mongoTemplate.save(mapper.inverseMap(entity));
    }

    @Override
    public Boolean delete(String s) {
        mongoTemplate.remove(Query.query(Criteria.where("_id").is(objectIdMapper.inverseMap(s))));
        return true;
    }

    @Override
    public Optional<Order> findById(String s) {
        return Optional.ofNullable(mongoTemplate.findById(objectIdMapper.inverseMap(s), OrderDoc.class))
                .map(mapper::map);
    }

    @Override
    public SearchResult<Order> find(OrderFilters filters) {
        var query = new FindOrdersQuery(filters).getQuery();
        return SearchResult.withItemsAndCount(
                mongoTemplate.find(query, OrderDoc.class).stream().map(mapper::map).collect(Collectors.toList()),
                mongoTemplate.count(query, OrderDoc.class)
        );
    }

    @Override
    public boolean exist(String s) {
        return mongoTemplate.exists(Query.query(Criteria.where("_id").is(objectIdMapper.inverseMap(s))), OrderDoc.class);
    }

    @Override
    public Long count() {
        return mongoTemplate.count(new Query(), OrderDoc.class);
    }

    @Override
    public Optional<Order> getLastOrder() {
        var query = new FindLastOrderQuery().getQuery();
        return Optional.ofNullable(mongoTemplate.findOne(query, OrderDoc.class))
                .map(mapper::map);
    }
}
