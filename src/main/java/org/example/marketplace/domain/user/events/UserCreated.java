package org.example.marketplace.domain.user.events;

import org.example.marketplace.domain.values.Nickname;
import org.example.marketplace.domain.values.Password;
import org.example.marketplace.generic.DomainEvent;

public class UserCreated extends DomainEvent {

    private final Password password;
    private final Nickname nickname;

    public UserCreated(Password password, Nickname nickname) {
        super("org.example.marketplace.usercreated");
        this.password = password;
        this.nickname = nickname;
    }

    public Password getPassword() {
        return password;
    }

    public Nickname getNickname() {
        return nickname;
    }
}
