package org.example.marketplace.business.order;

import org.example.marketplace.business.commons.EventsRepository;
import org.example.marketplace.domain.order.commands.AssignCustomerOrderCommand;
import org.example.marketplace.domain.order.events.OrderCustomerAssigned;
import org.example.marketplace.domain.order.events.OrderSellerAssigned;
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
class AssignCustomerOrderUseCaseTest {

    @Mock
    private EventsRepository eventsRepository;

    private AssignCustomerOrderUseCase assignCustomerOrderUseCase;

    @BeforeEach
    void setup(){
        assignCustomerOrderUseCase = new AssignCustomerOrderUseCase(eventsRepository);
    }

    @Test
    void successfulScenario(){
        AssignCustomerOrderCommand assignCustomerOrderCommand = new AssignCustomerOrderCommand("orderId","CustomerId","userId");

        Mockito.when(eventsRepository.saveEvent(ArgumentMatchers.any(OrderCustomerAssigned.class)))
                .thenAnswer(invocationOnMock -> {
                    return invocationOnMock.getArgument(0);
                });
        List<DomainEvent> domainEventList = assignCustomerOrderUseCase.apply(assignCustomerOrderCommand);

        Assertions.assertEquals(1,domainEventList.size());
    }


    }