package org.example.marketplace.business.product;

import org.example.marketplace.business.commons.EventsRepository;
import org.example.marketplace.business.commons.UseCaseForCommand;
import org.example.marketplace.domain.product.Product;
import org.example.marketplace.domain.product.commands.RemoveReviewCommand;
import org.example.marketplace.domain.values.ProductId;
import org.example.marketplace.domain.values.ReviewId;
import org.example.marketplace.generic.DomainEvent;

import java.util.List;

public class RemoveReviewUseCase implements UseCaseForCommand<RemoveReviewCommand> {

    private final EventsRepository eventsRepository;

    public RemoveReviewUseCase(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }

    @Override
    public List<DomainEvent> apply(RemoveReviewCommand command) {
        List<DomainEvent> productEvents =  eventsRepository.findByAggregatedRootId(command.getProductId());
        Product product = Product.from(ProductId.of(command.getProductId()),productEvents);
        product.deleteReview(ReviewId.of(command.getReviewId()));
        return product.getUncommittedChanges().stream().map(eventsRepository::saveEvent).toList();
    }
}
