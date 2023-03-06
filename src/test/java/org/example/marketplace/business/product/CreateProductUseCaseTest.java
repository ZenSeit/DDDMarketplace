package org.example.marketplace.business.product;

import org.example.marketplace.business.commons.EventsRepository;
import org.example.marketplace.domain.product.commands.CreateProductCommand;
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


@ExtendWith(MockitoExtension.class)
class CreateProductUseCaseTest {

    @Mock
    private EventsRepository eventsRepository;

    private CreateProductUseCase createProductUseCase;

    @BeforeEach
    void setup(){
        createProductUseCase = new CreateProductUseCase(eventsRepository);
    }

    @Test
    void successfulScenario(){

        CreateProductCommand createProductCommand = new CreateProductCommand("productId","Box","nothing to say",5,2.5,"pacoID");

        Mockito.when(eventsRepository.saveEvent(ArgumentMatchers.any(ProductCreated.class)))
                .thenAnswer(invocationOnMock -> {
                    return invocationOnMock.getArgument(0);
                });
        List<DomainEvent> domainEventList = createProductUseCase.apply(createProductCommand);

        Assertions.assertEquals(1,domainEventList.size());
        //Assertions.assertEquals("testId",domainEventList.get(0).aggregateRootId());

    }

}