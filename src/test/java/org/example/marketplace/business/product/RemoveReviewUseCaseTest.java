package org.example.marketplace.business.product;

import org.example.marketplace.business.commons.EventsRepository;
import org.example.marketplace.domain.product.commands.RemoveReviewCommand;
import org.example.marketplace.domain.product.events.ProductCreated;
import org.example.marketplace.domain.product.events.ReviewAdded;
import org.example.marketplace.domain.product.events.ReviewDeleted;
import org.example.marketplace.domain.user.events.PersonalDataEmailUpdated;
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
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class RemoveReviewUseCaseTest {

    @Mock
    private EventsRepository eventsRepository;

    private RemoveReviewUseCase removeReviewUseCase;

    @BeforeEach
    void setup(){
        removeReviewUseCase = new RemoveReviewUseCase(eventsRepository);
    }

    @Test
    void successfulScenario(){

        List<DomainEvent> historyEvents = new ArrayList<DomainEvent>();

        historyEvents.add(new ProductCreated(new Name("Box"),new Description("nothing to say"),new Quantity(5),new Price(2.5),
                UserId.of("userId")));
        historyEvents.add(new ReviewAdded(ReviewId.of("reviewId"),new Title("Good product"),new Description("high quality"),
                UserId.of("userId")));

        RemoveReviewCommand removeReviewCommand = new RemoveReviewCommand("productId","reviewId");

        Mockito.when(eventsRepository.findByAggregatedRootId("productId")).thenAnswer(invocationOnMock -> {
            return historyEvents;});

        Mockito.when(eventsRepository.saveEvent(ArgumentMatchers.any(ReviewDeleted.class)))
                .thenAnswer(invocationOnMock -> {
                    return invocationOnMock.getArgument(0);
                });

        List<DomainEvent> domainEventList = removeReviewUseCase.apply(removeReviewCommand);

        Assertions.assertEquals(1,domainEventList.size());
    }

    }