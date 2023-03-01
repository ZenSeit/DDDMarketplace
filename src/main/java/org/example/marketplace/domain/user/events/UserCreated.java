package org.example.marketplace.domain.user.events;

import org.example.marketplace.domain.user.PersonalData;
import org.example.marketplace.generic.DomainEvent;

public class UserCreated extends DomainEvent {

    private PersonalData personalData;
    private String password;
    private String nickname;

    public UserCreated(String password, String nickname) {
        super("org.example.marketplace.usercreated");
        this.password = password;
        this.nickname = nickname;
    }


    public PersonalData getPersonalData() {
        return personalData;
    }

    public String getPassword() {
        return password;
    }

    public String getNickname() {
        return nickname;
    }
}
