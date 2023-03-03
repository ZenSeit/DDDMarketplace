package org.example.marketplace.business.user;

import org.example.marketplace.business.commons.EventsRepository;
import org.example.marketplace.domain.user.commands.CreateUserCommand;
import org.example.marketplace.domain.user.events.UserCreated;
import org.example.marketplace.domain.values.Nickname;
import org.example.marketplace.domain.values.Password;
import org.example.marketplace.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class CreateUserUseCaseTest {

    @Mock
    private EventsRepository eventsRepository;
    private CreateUserUseCase createUserUseCase;

    @BeforeEach
    void setup(){
        createUserUseCase = new CreateUserUseCase(eventsRepository);
    }

    @Test
    void successfulScenario(){

        CreateUserCommand createUserCommand = new CreateUserCommand("testId", "123gerger", "Zensei");
        UserCreated userCreated = new UserCreated(new Password("123gerger"),new Nickname("Zensei"));
        userCreated.setAggregateRootId("testId");//primitive types
        Mockito.when(eventsRepository.saveEvent(ArgumentMatchers.any(UserCreated.class)))
                .thenAnswer(invocationOnMock -> {
                    return invocationOnMock.getArgument(0);
                });
        List<DomainEvent> domainEventList = createUserUseCase.apply(createUserCommand);

        Assertions.assertEquals(1,domainEventList.size());
        Assertions.assertEquals("testId",domainEventList.get(0).aggregateRootId());

    }

}