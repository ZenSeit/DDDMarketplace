package org.example.marketplace.domain.values;

import org.example.marketplace.generic.ValueObject;

public class Description implements ValueObject<String> {

    private String description;

    public Description(String description) {
        this.description = description;
    }

    @Override
    public String value() {
        return description;
    }
}
