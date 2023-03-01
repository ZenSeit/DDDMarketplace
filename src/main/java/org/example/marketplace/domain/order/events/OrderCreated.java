package org.example.marketplace.domain.order.events;

import org.example.marketplace.generic.DomainEvent;

public class OrderCreated extends DomainEvent {

    private String customerId;
    private String sellerId;

    private String status;

    public OrderCreated(String customerId, String sellerId, String status) {
        super("org.example.marketplace.ordercreated");
        this.customerId = customerId;
        this.sellerId = sellerId;
        this.status = status;
    }

    public OrderCreated(String type) {
        super("org.example.marketplace.ordercreated");
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getSellerId() {
        return sellerId;
    }

    public String getStatus() {
        return status;
    }
}
