package org.example.marketplace.domain.values;

import org.example.marketplace.generic.ValueObject;

public class Password implements ValueObject<String> {

    private String password;

    public Password(String password) {
        this.password = password;
    }

    @Override
    public String value() {
        return password;
    }
}
