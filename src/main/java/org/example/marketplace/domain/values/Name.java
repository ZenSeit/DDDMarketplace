package org.example.marketplace.domain.values;

import org.example.marketplace.generic.ValueObject;

public class Name implements ValueObject<String> {

    private String name;

    public Name(String name) {
        this.name = name;
    }

    @Override
    public String value() {
        return name;
    }
}
