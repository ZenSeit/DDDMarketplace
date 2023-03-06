package org.example.marketplace.business.user;

import org.example.marketplace.business.commons.EventsRepository;
import org.example.marketplace.domain.user.User;
import org.example.marketplace.domain.user.commands.CreatePersonalDataCommand;
import org.example.marketplace.domain.user.commands.CreateUserCommand;
import org.example.marketplace.domain.user.events.PersonalDataAdded;
import org.example.marketplace.domain.user.events.UserCreated;
import org.example.marketplace.domain.values.*;
import org.example.marketplace.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;

@ExtendWith(MockitoExtension.class)
class AddPersonalDataUseCaseTest {

    @Mock
    private EventsRepository eventsRepository;

    private AddPersonalDataUseCase addPersonalDataUseCase;

    @BeforeEach
    void setup(){
        addPersonalDataUseCase = new AddPersonalDataUseCase(eventsRepository);
    }

    @Test
    void successfulScenario(){

        CreatePersonalDataCommand createPersonalDataCommand = new CreatePersonalDataCommand("testData","Diego","Becerra","diego@correo.com","11/10/1993","testUser");
        PersonalDataAdded personalDataAdded = new PersonalDataAdded(PersonalDataId.of("testData"),new Name("Diego"),new LastName("Becerra"),new Email("diego@correo.com"),new Birthday("11/11/1993"));

        Mockito.when(eventsRepository.saveEvent(ArgumentMatchers.any(PersonalDataAdded.class)))
                .thenAnswer(invocationOnMock -> {
                    return invocationOnMock.getArgument(0);
                });

        List<DomainEvent> domainEventList = addPersonalDataUseCase.apply(createPersonalDataCommand);

        Assertions.assertEquals(1,domainEventList.size());

    }

}