package org.example.marketplace.business.order;

import org.example.marketplace.business.commons.EventsRepository;
import org.example.marketplace.business.commons.UseCaseForCommand;
import org.example.marketplace.domain.order.Order;
import org.example.marketplace.domain.order.commands.AssignSellerOrderCommand;
import org.example.marketplace.domain.values.OrderId;
import org.example.marketplace.domain.values.SellerId;
import org.example.marketplace.domain.values.UserId;
import org.example.marketplace.generic.DomainEvent;

import java.util.List;

public class AssignSellerOrderUseCase implements UseCaseForCommand<AssignSellerOrderCommand> {

    private final EventsRepository eventsRepository;

    public AssignSellerOrderUseCase(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }

    @Override
    public List<DomainEvent> apply(AssignSellerOrderCommand command) {
        List<DomainEvent> orderEvents = eventsRepository.findByAggregatedRootId(command.getOrderId());
        Order order = Order.from(OrderId.of(command.getOrderId()),orderEvents);
        order.assignSellerToOrder(SellerId.of(command.getSellerId()), UserId.of(command.getUserId()));
        return order.getUncommittedChanges().stream().map(eventsRepository::saveEvent).toList();
    }
}
