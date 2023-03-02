package org.example.marketplace.domain.user.events;

import org.example.marketplace.domain.values.*;
import org.example.marketplace.generic.DomainEvent;

import java.util.Date;

public class PersonalDataAdded extends DomainEvent {

    private final PersonalDataId personalDataId;
    private final Name name;
    private final LastName lastname;
    private final Email email;
    private final Birthday birthDay;


    public PersonalDataAdded(PersonalDataId personalDataId, Name name, LastName lastname, Email email, Birthday birthDay) {
        super("org.example.marketplace.personaldataadded");
        this.personalDataId = personalDataId;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.birthDay = birthDay;
    }

    public PersonalDataId getPersonalDataId() {
        return personalDataId;
    }

    public Name getName() {
        return name;
    }

    public LastName getLastname() {
        return lastname;
    }

    public Email getEmail() {
        return email;
    }

    public Birthday getBirthDay() {
        return birthDay;
    }
}
