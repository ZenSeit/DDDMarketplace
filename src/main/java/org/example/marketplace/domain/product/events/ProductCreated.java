package org.example.marketplace.domain.product.events;

import org.example.marketplace.domain.user.User;
import org.example.marketplace.domain.values.*;
import org.example.marketplace.generic.DomainEvent;

public class ProductCreated extends DomainEvent {

    private final Name name;
    private final Description description;
    private final Quantity quantity;
    private final Price price;
    private final UserId ownerId;

    public ProductCreated(Name name, Description description, Quantity quantity, Price price, UserId ownerId) {
        super("org.example.marketplace.productcreated");
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.ownerId = ownerId;
    }

    public Name getName() {
        return name;
    }

    public Description getDescription() {
        return description;
    }

    public Quantity getQuantity() {
        return quantity;
    }

    public Price getPrice() {
        return price;
    }

    public UserId getOwnerId() {
        return ownerId;
    }
}
