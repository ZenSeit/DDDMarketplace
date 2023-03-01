package org.example.marketplace.domain.user;

import org.example.marketplace.domain.values.*;
import org.example.marketplace.generic.Entity;

public class PersonalData extends Entity<PersonalDataId> {

    private Name name;
    private LastName lastname;
    private Email email;
    private Birthday birthday;


    public PersonalData(PersonalDataId id, Name name, LastName lastname, Email email, Birthday birthday) {
        super(id);
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.birthday = birthday;
    }

    public Name Name() {
        return name;
    }

    public LastName Lastname() {
        return lastname;
    }

    public Email Email() {
        return email;
    }

    public Birthday Birthday() {
        return birthday;
    }

    public void updateName(Name newName){
        this.name=newName;
    }
}
