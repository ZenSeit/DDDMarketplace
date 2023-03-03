package org.example.marketplace.business.user;

import org.example.marketplace.business.commons.EventsRepository;
import org.example.marketplace.business.commons.UseCaseForCommand;
import org.example.marketplace.domain.user.User;
import org.example.marketplace.domain.user.commands.CreateUserCommand;
import org.example.marketplace.domain.values.Nickname;
import org.example.marketplace.domain.values.Password;
import org.example.marketplace.domain.values.UserId;
import org.example.marketplace.generic.DomainEvent;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CreateUserUseCase implements UseCaseForCommand<CreateUserCommand> {

    private final EventsRepository eventsRepository;

    public CreateUserUseCase(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }

    @Override
    public List<DomainEvent> apply(CreateUserCommand command) {
        User user=new User(UserId.of(command.getUserId()),new Password(command.getPassword()),new Nickname(command.getNickname()));
        return user.getUncommittedChanges().stream()
                .map(eventsRepository::saveEvent).toList();
    }
}
