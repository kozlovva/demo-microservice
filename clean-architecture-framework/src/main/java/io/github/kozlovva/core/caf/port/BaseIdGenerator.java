package io.github.kozlovva.core.caf.port;

public interface BaseIdGenerator<T> {
    String generate();
    T parse(String id);
}
