package org.example.marketplace.domain.order.events;

import org.example.marketplace.domain.order.Customer;
import org.example.marketplace.domain.order.Seller;
import org.example.marketplace.domain.product.Product;
import org.example.marketplace.domain.values.Status;
import org.example.marketplace.generic.DomainEvent;

import java.util.List;

public class OrderCreated extends DomainEvent {

    private final Status status;

    public OrderCreated(Status status) {
        super("org.example.marketplace.ordercreated");
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }
}
