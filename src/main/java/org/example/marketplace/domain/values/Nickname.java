package org.example.marketplace.domain.values;

import org.example.marketplace.generic.ValueObject;

public class Nickname implements ValueObject<String> {

    private String nickname;

    public Nickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String value() {
        return nickname;
    }
}
