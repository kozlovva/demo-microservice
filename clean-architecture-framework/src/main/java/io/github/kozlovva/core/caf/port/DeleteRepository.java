package io.github.kozlovva.core.caf.port;

public interface DeleteRepository<Id> {
    Boolean delete(Id id);
}
