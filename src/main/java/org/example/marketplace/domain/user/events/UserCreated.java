package org.example.marketplace.domain.user.events;

import org.example.marketplace.domain.user.PersonalData;
import org.example.marketplace.generic.DomainEvent;

public class UserCreated extends DomainEvent {

    private PersonalData personalData; //id
    private String password;
    private String nickname;

    public UserCreated(PersonalData personalData, String password, String nickname) {
        super("org.example.marketplace.usercreated");
        this.personalData = personalData;
        this.password = password;
        this.nickname = nickname;
    }
    public UserCreated(String personalDataId, String personalDataId1) {
        super("org.example.marketplace.usercreated");
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
