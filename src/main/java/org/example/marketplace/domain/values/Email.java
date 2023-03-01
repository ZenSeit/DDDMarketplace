package org.example.marketplace.domain.values;

import org.example.marketplace.generic.ValueObject;

public class Email implements ValueObject<String> {

    private String email;

    public Email(String email) {
        this.email = email;
    }

    @Override
    public String value() {
        return email;
    }
}
