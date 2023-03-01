package org.example.marketplace.domain.user.events;

import org.example.marketplace.domain.user.PersonalData;
import org.example.marketplace.domain.values.Name;
import org.example.marketplace.domain.values.PersonalDataId;
import org.example.marketplace.generic.DomainEvent;

public class PersonalDataNameUpdated extends DomainEvent {

    private PersonalData personalData;
    private Name name;

    public PersonalDataNameUpdated(PersonalData personalData, Name name) {
        super("org.example.marketplace.personaldatanameupdated");
        this.personalData = personalData;
        this.name = name;
    }

    public PersonalData getPersonalData() {
        return personalData;
    }

    public Name getName() {
        return name;
    }
}
