package org.example.marketplace.domain.order.events;

import org.example.marketplace.domain.order.Customer;
import org.example.marketplace.domain.order.Seller;
import org.example.marketplace.domain.product.Product;
import org.example.marketplace.generic.DomainEvent;

import java.util.List;

public class OrderCreated extends DomainEvent {

    private String status;

    public OrderCreated(String status) {
        super("org.example.marketplace.ordercreated");
        this.status = status;
    }

    public OrderCreated() {
        super("org.example.marketplace.ordercreated");
    }

    public String getStatus() {
        return status;
    }
}
