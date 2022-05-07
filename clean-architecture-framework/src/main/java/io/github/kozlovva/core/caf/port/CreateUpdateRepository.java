package io.github.kozlovva.core.caf.port;


import io.github.kozlovva.core.caf.entity.Entity;

public interface CreateUpdateRepository<E extends Entity<?>> {
    void save(E entity);
}
