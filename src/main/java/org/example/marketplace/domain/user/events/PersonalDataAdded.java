package org.example.marketplace.domain.user.events;

import org.example.marketplace.generic.DomainEvent;

import java.util.Date;

public class PersonalDataAdded extends DomainEvent {

    private final String personalDataId;
    private final String name;
    private final String lastname;
    private final String email;
    private final Date birthDay;


    public PersonalDataAdded(String personalDataId, String name, String lastname, String email, Date birthDay) {
        super("org.example.marketplace.personaldataadded");
        this.personalDataId = personalDataId;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.birthDay = birthDay;
    }

    public String getPersonalDataId() {
        return personalDataId;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public Date getBirthDay() {
        return birthDay;
    }
}
