package org.example.marketplace.business.order;

import org.example.marketplace.business.commons.EventsRepository;
import org.example.marketplace.business.commons.UseCaseForCommand;
import org.example.marketplace.domain.order.Order;
import org.example.marketplace.domain.order.commands.CreateOrderCommand;
import org.example.marketplace.domain.user.User;
import org.example.marketplace.domain.values.OrderId;
import org.example.marketplace.domain.values.Status;
import org.example.marketplace.domain.values.UserId;
import org.example.marketplace.generic.DomainEvent;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CreateOrderUseCase implements UseCaseForCommand<CreateOrderCommand> {

    private final EventsRepository eventsRepository;

    public CreateOrderUseCase(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }

    @Override
    public List<DomainEvent> apply(CreateOrderCommand command) {
        Order order = new Order(OrderId.of(command.getOrderId()), new Status(command.getStatus()));
        return order.getUncommittedChanges().stream().map(eventsRepository::saveEvent).toList();
    }
}
