package org.example.marketplace.domain.product.events;

import org.example.marketplace.generic.DomainEvent;

public class ProductCreated extends DomainEvent {

    private String name;
    private String description;
    private int quantity;
    private double price;
    private String ownerId;

    public ProductCreated(String name, String description, int quantity, double price, String ownerId) {
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

    public String getOwnerId() {
        return ownerId;
    }
}
