package org.example.marketplace.domain.values;

import org.example.marketplace.generic.Identity;

public class PersonalDataId extends Identity {

    private PersonalDataId(String uuid){
        super(uuid);
    }

    public PersonalDataId() {
    }

    public static PersonalDataId of(String uuid){
        return new PersonalDataId(uuid);
    }
}
