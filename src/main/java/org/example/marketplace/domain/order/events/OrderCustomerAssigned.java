package org.example.marketplace.domain.order.events;

import org.example.marketplace.domain.values.CustomerId;
import org.example.marketplace.domain.values.UserId;
import org.example.marketplace.generic.DomainEvent;

public class OrderCustomerAssigned extends DomainEvent {

    private final CustomerId customerId;
    private final UserId userId;

    public OrderCustomerAssigned(CustomerId customerId, UserId userId) {
        super("org.example.marketplace.assignedcustomertoorder");
        this.customerId = customerId;
        this.userId = userId;
    }

    public CustomerId getCustomerId() {
        return customerId;
    }

    public UserId getUserId() {
        return userId;
    }
}
