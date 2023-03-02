package org.example.marketplace.domain.product.events;

import org.example.marketplace.domain.user.User;
import org.example.marketplace.domain.values.UserId;
import org.example.marketplace.generic.DomainEvent;

public class ProductCreated extends DomainEvent {

    private String name;
    private String description;
    private int quantity;
    private double price;
    private UserId ownerId;

    public ProductCreated(String name, String description, int quantity, double price, UserId ownerId) {
        super("org.example.marketplace.productcreated");
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.ownerId = ownerId;
    }

    public ProductCreated() {
        super("org.example.marketplace.productcreated");
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public UserId getOwnerId() {
        return ownerId;
    }
}
