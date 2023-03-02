package org.example.marketplace.business.product;

import org.example.marketplace.business.commons.EventsRepository;
import org.example.marketplace.business.commons.UseCaseForCommand;
import org.example.marketplace.domain.product.Product;
import org.example.marketplace.domain.product.commands.AddReviewCommand;
import org.example.marketplace.domain.values.*;
import org.example.marketplace.generic.DomainEvent;

import java.util.List;

public class AddReviewUseCase implements UseCaseForCommand<AddReviewCommand> {

    private final EventsRepository eventsRepository;

    public AddReviewUseCase(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }

    @Override
    public List<DomainEvent> apply(AddReviewCommand command) {
        List<DomainEvent> productEvents =  eventsRepository.findByAggregatedRootId(command.getProductId());
        Product product = Product.from(ProductId.of(command.getProductId()),productEvents);
        product.addReview(ReviewId.of(command.getReviewId()),new Title(command.getTitle()),new Description(command.getDescription()),UserId.of(command.getUserId()));
        return product.getUncommittedChanges().stream().map(eventsRepository::saveEvent).toList();
    }
}
