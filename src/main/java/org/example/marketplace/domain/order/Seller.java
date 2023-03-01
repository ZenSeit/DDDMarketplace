package org.example.marketplace.domain.order;

import org.example.marketplace.domain.values.Reputation;
import org.example.marketplace.domain.values.SellerId;
import org.example.marketplace.domain.values.UserId;
import org.example.marketplace.generic.Entity;

public class Seller extends Entity<SellerId> {

    private UserId userId;
    private Reputation reputation;

    public Seller(SellerId id, UserId userId, Reputation reputation) {
        super(id);
        this.userId = userId;
        this.reputation = reputation;
    }

    public UserId UserId() {
        return userId;
    }

    public Reputation Reputation() {
        return reputation;
    }
}
