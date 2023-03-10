package org.example.marketplace.business.user;

import org.example.marketplace.business.commons.EventsRepository;
import org.example.marketplace.business.commons.UseCaseForCommand;
import org.example.marketplace.domain.user.User;
import org.example.marketplace.domain.user.commands.CreatePersonalDataCommand;
import org.example.marketplace.domain.values.*;
import org.example.marketplace.generic.DomainEvent;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AddPersonalDataUseCase implements UseCaseForCommand<CreatePersonalDataCommand> {

    private final EventsRepository eventsRepository;

    public AddPersonalDataUseCase(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }

    @Override
    public List<DomainEvent> apply(CreatePersonalDataCommand command) {
        List<DomainEvent> userEvents =  eventsRepository.findByAggregatedRootId(command.getUserId());
        User user = User.from(UserId.of(command.getUserId()),userEvents);
        user.addPersonalData(PersonalDataId.of(command.getPersonalDataId()), new Name(command.getName()), new LastName(command.getLastname()), new Email(command.getEmail()),
                new Birthday(command.getBirthDay()));
        return user.getUncommittedChanges().stream().map(event->eventsRepository.saveEvent(event)).toList();
    }
}
