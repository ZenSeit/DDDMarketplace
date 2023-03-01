package org.example.marketplace.domain.user;

import org.example.marketplace.domain.user.events.PersonalDataAdded;
import org.example.marketplace.domain.user.events.PersonalDataNameUpdated;
import org.example.marketplace.domain.user.events.UserCreated;
import org.example.marketplace.domain.values.*;
import org.example.marketplace.generic.EventChange;

public class UserChange extends EventChange {

    public UserChange(User user){

        apply((UserCreated event) ->{
            user.personalData=event.getPersonalData();
            user.nickname=new Nickname(event.getNickname());
            user.password=new Password(event.getPassword());
        });

        apply((PersonalDataAdded event)-> {
            PersonalDataId personalDataId = PersonalDataId.of(event.getPersonalDataId());
            user.addPersonalData(personalDataId, event.getName(), event.getLastname(), event.getEmail(), event.getBirthDay());
        });

        apply((PersonalDataNameUpdated event) ->{
            PersonalData personalData = user.personalData;
            personalData.updateName(event.getName());
        });

    }

}
