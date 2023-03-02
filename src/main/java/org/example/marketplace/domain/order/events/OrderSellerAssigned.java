package org.example.marketplace.domain.order.events;

import org.example.marketplace.domain.values.SellerId;
import org.example.marketplace.domain.values.UserId;
import org.example.marketplace.generic.DomainEvent;

public class OrderSellerAssigned extends DomainEvent {

    private final SellerId sellerId;
    private final UserId userId;

    public OrderSellerAssigned(SellerId sellerId, UserId userId) {
        super("org.example.marketplace.assignedsellertoorder");
        this.sellerId = sellerId;
        this.userId = userId;
    }

    public SellerId getSellerId() {
        return sellerId;
    }

    public UserId getUserId() {
        return userId;
    }
}
