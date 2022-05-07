package io.github.kozlovva.core.caf.mapper;

public interface DataMapper<I, O> {
    O map(I i);
    I inverseMap(O o);
}
