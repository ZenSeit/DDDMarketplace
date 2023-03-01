package org.example.marketplace.domain.values;

import org.example.marketplace.generic.ValueObject;

public class LastName implements ValueObject<String> {

    private String lastName;

    public LastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String value() {
        return lastName;
    }
}
