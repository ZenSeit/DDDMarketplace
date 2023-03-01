package org.example.marketplace.domain.user;

import org.example.marketplace.domain.user.events.PersonalDataAdded;
import org.example.marketplace.domain.user.events.PersonalDataEmailUpdated;
import org.example.marketplace.domain.user.events.UserCreated;
import org.example.marketplace.domain.values.*;
import org.example.marketplace.generic.EventChange;

public class UserChange extends EventChange {

    public UserChange(User user){

        apply((UserCreated event) ->{
            user.nickname=new Nickname(event.getNickname());
            user.password=new Password(event.getPassword());
        });

        apply((PersonalDataAdded event)-> {
            PersonalDataId personalDataId = PersonalDataId.of(event.getPersonalDataId());
            user.personalData = new PersonalData(personalDataId, new Name(event.getName()), new LastName(event.getLastname()), new Email(event.getEmail()), new Birthday(event.getBirthDay()));
        });

        apply((PersonalDataEmailUpdated event) ->{
            user.personalData.updateEmailData(event.getEmail().value());
        });

    }

}
