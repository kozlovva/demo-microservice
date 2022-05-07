package io.github.kozlovva.core.caf.port;

import io.github.kozlovva.core.caf.entity.Entity;
import io.github.kozlovva.core.caf.port.dto.SearchFilters;
import io.github.kozlovva.core.caf.port.dto.SearchResult;

import java.util.Optional;

public interface ReadRepository<Id, E extends Entity<Id>, Filters extends SearchFilters> {
    Optional<E> findById(Id id);

    SearchResult<E> find(Filters filters);

    boolean exist(Id id);

    Long count();
}
