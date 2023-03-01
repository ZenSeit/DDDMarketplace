package org.example.marketplace.domain.order;

import org.example.marketplace.domain.order.events.OrderCreated;
import org.example.marketplace.domain.values.CustomerId;
import org.example.marketplace.domain.values.OrderId;
import org.example.marketplace.domain.values.SellerId;
import org.example.marketplace.domain.values.Status;
import org.example.marketplace.generic.AggregateRoot;
import org.example.marketplace.generic.DomainEvent;

import java.util.List;

public class Order extends AggregateRoot<OrderId> {

    protected CustomerId customerId;
    protected SellerId sellerId;

    protected Status status;

    public Order(OrderId id, CustomerId customerId, SellerId sellerId,Status status) {
        super(id);
        subscribe(new OrderChange(this));
        appendChange(new OrderCreated(customerId.value(),sellerId.value(),status.value()));
    }

    public Order(OrderId id) {
        super(id);
        subscribe(new OrderChange(this));
    }

    public static Order myOrder(OrderId id, List<DomainEvent> events){
        Order order = new Order(id);
        events.forEach(event -> order.applyEvent(event));
        return order;
    }

    public void addProducts(){}


}
