package org.example.marketplace.business.product;

import org.example.marketplace.business.commons.EventsRepository;
import org.example.marketplace.business.commons.UseCaseForCommand;
import org.example.marketplace.domain.product.Product;
import org.example.marketplace.domain.product.commands.CreateProductCommand;
import org.example.marketplace.domain.user.User;
import org.example.marketplace.domain.values.*;
import org.example.marketplace.generic.DomainEvent;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CreateProductUseCase implements UseCaseForCommand<CreateProductCommand> {

    private final EventsRepository eventsRepository;

    public CreateProductUseCase(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }

    @Override
    public List<DomainEvent> apply(CreateProductCommand command) {
        List<DomainEvent> userEvents =  eventsRepository.findByAggregatedRootId(command.getOwnerId());
        User user = User.from(UserId.of(command.getOwnerId()),userEvents);
        Product product = new Product(ProductId.of(command.getProductId()),new Name(command.getName()),new Description(command.getDescription()),new Quantity(command.getQuantity()),
                new Price(command.getPrice()),user.identity());
        return product.getUncommittedChanges().stream().map(eventsRepository::saveEvent).toList();
    }
}
