package org.example.marketplace.business.order;

import org.example.marketplace.business.commons.EventsRepository;
import org.example.marketplace.domain.order.commands.AssignSellerOrderCommand;
import org.example.marketplace.domain.order.events.OrderSellerAssigned;
import org.example.marketplace.domain.product.events.ProductCreated;
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
class AssignSellerOrderUseCaseTest {

    @Mock
    private EventsRepository eventsRepository;

    private AssignSellerOrderUseCase assignSellerOrderUseCase;

    @BeforeEach
    void setup(){
        assignSellerOrderUseCase = new AssignSellerOrderUseCase(eventsRepository);
    }

    @Test
    void successfulScenario(){

        AssignSellerOrderCommand assignSellerOrderCommand = new AssignSellerOrderCommand("orderId","sellerId","userId");

        Mockito.when(eventsRepository.saveEvent(ArgumentMatchers.any(OrderSellerAssigned.class)))
                .thenAnswer(invocationOnMock -> {
                    return invocationOnMock.getArgument(0);
                });
        List<DomainEvent> domainEventList = assignSellerOrderUseCase.apply(assignSellerOrderCommand);

        Assertions.assertEquals(1,domainEventList.size());

    }


    }