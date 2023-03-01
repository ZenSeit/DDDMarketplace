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
        appendChange(new UserCreated(password.value(), nickname.value()));
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

    public void addPersonalData(PersonalDataId id,String name, String lastname, String email, Date birthDay){
        Objects.requireNonNull(id);
        appendChange(new PersonalDataAdded(id.value(),name,lastname,email,birthDay));
    }

    public void updateEmail(Email email){
        appendChange(new PersonalDataEmailUpdated(email)).apply();
    }
}
