package org.example.marketplace.domain.order.events;

import org.example.marketplace.generic.DomainEvent;

public class OrderSellerAssigned extends DomainEvent {

    private final String sellerId;
    private final String userId;

    public OrderSellerAssigned(String sellerId, String userId) {
        super("org.example.marketplace.assignedsellertoorder");
        this.sellerId = sellerId;
        this.userId = userId;
    }

    public String getSellerId() {
        return sellerId;
    }

    public String getUserId() {
        return userId;
    }
}
