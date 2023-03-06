package org.example.marketplace.business.order;

import org.example.marketplace.business.commons.EventsRepository;
import org.example.marketplace.domain.order.commands.CreateOrderCommand;
import org.example.marketplace.domain.order.events.OrderCreated;
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

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CreateOrderUseCaseTest {

    @Mock
    private EventsRepository eventsRepository;

    private CreateOrderUseCase createOrderUseCase;

    @BeforeEach
    void setup(){
        createOrderUseCase = new CreateOrderUseCase(eventsRepository);
    }

    @Test
    void successfulScenario(){

        CreateOrderCommand createOrderCommand = new CreateOrderCommand("OrderId","Active");

        Mockito.when(eventsRepository.saveEvent(ArgumentMatchers.any(OrderCreated.class)))
                .thenAnswer(invocationOnMock -> {
                    return invocationOnMock.getArgument(0);
                });
        List<DomainEvent> domainEventList = createOrderUseCase.apply(createOrderCommand);

        Assertions.assertEquals(1,domainEventList.size());

    }

    }