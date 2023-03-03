package org.example.marketplace.domain.user;

import org.example.marketplace.domain.user.events.PersonalDataAdded;
import org.example.marketplace.domain.user.events.PersonalDataEmailUpdated;
import org.example.marketplace.domain.user.events.UserCreated;
import org.example.marketplace.domain.values.*;
import org.example.marketplace.generic.AggregateRoot;
import org.example.marketplace.generic.DomainEvent;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class User extends AggregateRoot<UserId> {

    protected PersonalData personalData;
    protected Password password;
    protected Nickname nickname;

    public User(UserId id, Password password, Nickname nickname) {
        super(id);
        subscribe(new UserChange(this));
        appendChange(new UserCreated(password, nickname)).apply();
    }

    private User(UserId id){
        super(id);
        subscribe(new UserChange(this));
    }

    public static User from(UserId id, List<DomainEvent> events){
        User user = new User(id);
        events.forEach(event -> user.applyEvent(event));
        return user;
    }

    public void addPersonalData(PersonalDataId id,Name name, LastName lastname, Email email, Birthday birthDay){
        Objects.requireNonNull(id);
        appendChange(new PersonalDataAdded(id,name,lastname,email,birthDay));
    }

    public void updateEmail(Email email){
        appendChange(new PersonalDataEmailUpdated(email)).apply();
    }
}
