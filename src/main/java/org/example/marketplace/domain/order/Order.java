package org.example.marketplace.domain.order;

import org.example.marketplace.domain.order.events.OrderCreated;
import org.example.marketplace.domain.product.Product;
import org.example.marketplace.domain.values.CustomerId;
import org.example.marketplace.domain.values.OrderId;
import org.example.marketplace.domain.values.SellerId;
import org.example.marketplace.domain.values.Status;
import org.example.marketplace.generic.AggregateRoot;
import org.example.marketplace.generic.DomainEvent;

import java.util.List;

public class Order extends AggregateRoot<OrderId> {

    protected Customer customer;
    protected Seller seller;

    protected List<Product> products;

    protected Status status;

    public Order(OrderId id,Status status) {
        super(id);
        subscribe(new OrderChange(this));
        appendChange(new OrderCreated(status.value()));
    }

    private Order(OrderId id) {
        super(id);
        subscribe(new OrderChange(this));
    }

    public static Order from(OrderId id, List<DomainEvent> events){
        Order order = new Order(id);
        events.forEach(event -> order.applyEvent(event));
        return order;
    }

    public void addProducts(){}


}
