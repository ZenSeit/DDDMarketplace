package org.example.marketplace.business.order;

import org.example.marketplace.business.commons.EventsRepository;
import org.example.marketplace.business.commons.UseCaseForCommand;
import org.example.marketplace.domain.order.Order;
import org.example.marketplace.domain.order.commands.AssignCustomerOrderCommand;
import org.example.marketplace.domain.values.OrderId;
import org.example.marketplace.generic.DomainEvent;

import java.util.List;

public class AssignCustomerOrderUseCase implements UseCaseForCommand<AssignCustomerOrderCommand> {

    private final EventsRepository eventsRepository;

    public AssignCustomerOrderUseCase(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }

    @Override
    public List<DomainEvent> apply(AssignCustomerOrderCommand command) {
        List<DomainEvent> orderEvents = eventsRepository.findByAggregatedRootId(command.getOrderId());
        Order order = Order.from(OrderId.of(command.getOrderId()),orderEvents);
        order.assignSellerToOrder(command.getCustomerId(), command.getUserId());
        return order.getUncommittedChanges().stream().map(eventsRepository::saveEvent).toList();
    }
}
