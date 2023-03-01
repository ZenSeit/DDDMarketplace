package org.example.marketplace.domain.order;

import org.example.marketplace.domain.values.CustomerId;
import org.example.marketplace.domain.values.Points;
import org.example.marketplace.domain.values.UserId;
import org.example.marketplace.generic.Entity;

public class Customer extends Entity<CustomerId> {

    private UserId userId;
    private Points points;

    public Customer(CustomerId id, UserId userId, Points points) {
        super(id);
        this.userId = userId;
        this.points = points;
    }

    public UserId UserId() {
        return userId;
    }

    public Points Points() {
        return points;
    }
}
