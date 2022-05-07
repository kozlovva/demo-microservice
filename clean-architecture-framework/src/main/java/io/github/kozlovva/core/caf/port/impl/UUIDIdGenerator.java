package io.github.kozlovva.core.caf.port.impl;



import io.github.kozlovva.core.caf.port.BaseIdGenerator;

import java.util.UUID;

public class UUIDIdGenerator implements BaseIdGenerator<String> {

    @Override
    public String generate() {
        return UUID.randomUUID().toString();
    }

    @Override
    public String parse(String id) {
        return id;
    }
}
