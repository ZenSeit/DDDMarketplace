package org.example.marketplace.domain.order.events;

import org.example.marketplace.generic.DomainEvent;

public class OrderCustomerAssigned extends DomainEvent {

    private final String customerId;
    private final String userId;

    public OrderCustomerAssigned(String customerId, String userId) {
        super("org.example.marketplace.assignedcustomertoorder");
        this.customerId = customerId;
        this.userId = userId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getUserId() {
        return userId;
    }
}
