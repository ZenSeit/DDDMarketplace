package org.example.marketplace.domain.user.events;

import org.example.marketplace.domain.values.Email;
import org.example.marketplace.domain.values.PersonalDataId;
import org.example.marketplace.generic.DomainEvent;

public class PersonalDataEmailUpdated extends DomainEvent {

    private Email email;

    public PersonalDataEmailUpdated(Email email) {
        super("org.example.marketplace.personaldatanameupdated");

        this.email = email;
    }


    public Email getEmail() {
        return email;
    }
}
