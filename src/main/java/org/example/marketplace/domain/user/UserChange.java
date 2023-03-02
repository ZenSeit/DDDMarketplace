package org.example.marketplace.domain.user;

import org.example.marketplace.domain.user.events.PersonalDataAdded;
import org.example.marketplace.domain.user.events.PersonalDataEmailUpdated;
import org.example.marketplace.domain.user.events.UserCreated;
import org.example.marketplace.domain.values.*;
import org.example.marketplace.generic.EventChange;

public class UserChange extends EventChange {

    public UserChange(User user){

        apply((UserCreated event) ->{
            user.nickname=event.getNickname();
            user.password=event.getPassword();
        });

        apply((PersonalDataAdded event)-> {
            user.personalData = new PersonalData(event.getPersonalDataId(), event.getName(), event.getLastname(), event.getEmail(), event.getBirthDay());
        });

        apply((PersonalDataEmailUpdated event) ->{
            user.personalData.updateEmailData(event.getEmail().value());
        });

    }

}
