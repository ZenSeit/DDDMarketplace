package org.example.marketplace.business.order;

import org.example.marketplace.business.commons.EventsRepository;
import org.example.marketplace.business.commons.UseCaseForCommand;
import org.example.marketplace.domain.order.Order;
import org.example.marketplace.domain.order.commands.AddProductCommand;
import org.example.marketplace.domain.values.OrderId;
import org.example.marketplace.generic.DomainEvent;

import java.util.List;

public class AddProductOrderUseCase implements UseCaseForCommand<AddProductCommand> {

    private final EventsRepository eventsRepository;

    public AddProductOrderUseCase(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }


    @Override
    public List<DomainEvent> apply(AddProductCommand command) {
        List<DomainEvent> orderEvents = eventsRepository.findByAggregatedRootId(command.getOrderId());
        Order order = Order.from(OrderId.of(command.getOrderId()),orderEvents);
        return order.getUncommittedChanges().stream().map(eventsRepository::saveEvent).toList();
    }
}
