package org.example.marketplace.domain.values;

import org.example.marketplace.generic.ValueObject;

public class Status implements ValueObject<String> {

    private String status;

    public Status(String status) {
        this.status = status;
    }

    @Override
    public String value() {
        return status;
    }
}
