package org.example.marketplace.business.user;

import org.example.marketplace.business.commons.EventsRepository;
import org.example.marketplace.business.commons.UseCaseForCommand;
import org.example.marketplace.domain.user.User;
import org.example.marketplace.domain.user.commands.UpdateEmailCommand;
import org.example.marketplace.domain.values.Email;
import org.example.marketplace.domain.values.UserId;
import org.example.marketplace.generic.DomainEvent;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UpdateEmailUseCase implements UseCaseForCommand<UpdateEmailCommand> {

    private final EventsRepository eventsRepository;

    public UpdateEmailUseCase(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }

    @Override
    public List<DomainEvent> apply(UpdateEmailCommand command) {
        List<DomainEvent> userEvents =  eventsRepository.findByAggregatedRootId(command.getUserId());
        User user = User.from(UserId.of(command.getUserId()),userEvents);
        user.updateEmail(new Email(command.getEmail()));
        return user.getUncommittedChanges().stream().map(eventsRepository::saveEvent).toList();
    }
}
