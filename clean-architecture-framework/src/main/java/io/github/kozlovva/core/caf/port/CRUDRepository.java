package io.github.kozlovva.core.caf.port;

import io.github.kozlovva.core.caf.entity.Entity;
import io.github.kozlovva.core.caf.port.dto.SearchFilters;

public interface CRUDRepository<Id, E extends Entity<Id>, Filters extends SearchFilters>
        extends DeleteRepository<Id>,
        CreateUpdateRepository<E>,
        ReadRepository<Id, E, Filters> {

}
