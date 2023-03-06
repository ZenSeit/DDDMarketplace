package org.example.marketplace.business.product;

import org.example.marketplace.business.commons.EventsRepository;
import org.example.marketplace.domain.product.commands.AddReviewCommand;
import org.example.marketplace.domain.product.events.ProductCreated;
import org.example.marketplace.domain.product.events.ReviewAdded;
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
class AddReviewUseCaseTest {

    @Mock
    private EventsRepository eventsRepository;

    private AddReviewUseCase addReviewUseCase;

    @BeforeEach
    void setup(){
        addReviewUseCase = new AddReviewUseCase(eventsRepository);
    }

    @Test
    void successfulScenario(){
        AddReviewCommand addReviewCommand = new AddReviewCommand("productID","reviewId","Good product","nothing","userID");

        Mockito.when(eventsRepository.saveEvent(ArgumentMatchers.any(ReviewAdded.class)))
                .thenAnswer(invocationOnMock -> {
                    return invocationOnMock.getArgument(0);
                });
        List<DomainEvent> domainEventList = addReviewUseCase.apply(addReviewCommand);

        Assertions.assertEquals(1,domainEventList.size());
    }

}