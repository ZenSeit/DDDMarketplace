package org.example.marketplace.business.order;

import org.example.marketplace.business.commons.EventsRepository;
import org.example.marketplace.domain.order.commands.AddProductCommand;
import org.example.marketplace.domain.order.events.OrderCreated;
import org.example.marketplace.domain.order.events.OrderProductAdded;
import org.example.marketplace.domain.product.events.ReviewDeleted;
import org.example.marketplace.domain.values.Status;
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
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AddProductOrderUseCaseTest {

    @Mock
    private EventsRepository eventsRepository;

    private AddProductOrderUseCase addProductOrderUseCase;

    @BeforeEach
    void setup(){
        addProductOrderUseCase = new AddProductOrderUseCase(eventsRepository);
    }

    @Test
    void successfulScenario(){

        List<DomainEvent> historyEvents = new ArrayList<DomainEvent>();

        historyEvents.add(new OrderCreated(new Status("Active")));

        Mockito.when(eventsRepository.findByAggregatedRootId("orderId")).thenAnswer(invocationOnMock -> {
            return historyEvents;});

        AddProductCommand addProductCommand = new AddProductCommand("orderId","productId");

        Mockito.when(eventsRepository.saveEvent(ArgumentMatchers.any(OrderProductAdded.class)))
                .thenAnswer(invocationOnMock -> {
                    return invocationOnMock.getArgument(0);
                });

        List<DomainEvent> domainEventList = addProductOrderUseCase.apply(addProductCommand);

        Assertions.assertEquals(1,domainEventList.size());
    }

    }