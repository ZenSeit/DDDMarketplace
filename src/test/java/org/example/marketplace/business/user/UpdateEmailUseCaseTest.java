package org.example.marketplace.business.user;

import org.example.marketplace.business.commons.EventsRepository;
import org.example.marketplace.domain.user.User;
import org.example.marketplace.domain.user.commands.CreateUserCommand;
import org.example.marketplace.domain.user.commands.UpdateEmailCommand;
import org.example.marketplace.domain.user.events.PersonalDataAdded;
import org.example.marketplace.domain.user.events.PersonalDataEmailUpdated;
import org.example.marketplace.domain.user.events.UserCreated;
import org.example.marketplace.domain.values.*;
import org.example.marketplace.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mockStatic;


@ExtendWith(MockitoExtension.class)
class UpdateEmailUseCaseTest {

    @Mock
    private EventsRepository eventsRepository;

    private UpdateEmailUseCase updateEmailUseCase;


    @BeforeEach
    void setup(){
        updateEmailUseCase = new UpdateEmailUseCase(eventsRepository);
    }

    @Test
    void successfulScenario(){

        List<DomainEvent> historyEvents = new ArrayList<DomainEvent>();

        historyEvents.add(new UserCreated(new Password("123efef"),new Nickname("Zensei")));
        historyEvents.add(new PersonalDataAdded(PersonalDataId.of("pruebaDataID"),new Name("Diego"),new LastName("Becerra"),new Email("diego@correo.com"),new Birthday("11/10/1993")));

        UpdateEmailCommand updateEmailCommand =new UpdateEmailCommand("testUser","newEmail@email.com");
        Mockito.when(eventsRepository.findByAggregatedRootId("testUser")).thenAnswer(invocationOnMock -> {
            return historyEvents;});

        Mockito.when(eventsRepository.saveEvent(ArgumentMatchers.any(PersonalDataEmailUpdated.class)))
                .thenAnswer(invocationOnMock -> {
                    return invocationOnMock.getArgument(0);
                });

        List<DomainEvent> domainEventList = updateEmailUseCase.apply(updateEmailCommand);

        Assertions.assertEquals(1,domainEventList.size());
    }

}