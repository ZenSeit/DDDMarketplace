package org.example.marketplace.domain.product.commands;

import org.example.marketplace.generic.Command;

public class CreateProductCommand extends Command {

    private String productId;
    private String name;
    private String description;
    private int quantity;
    private double price;
    private String ownerId;

    //private String reviewId;


    public CreateProductCommand(String productId, String name, String description, int quantity, double price, String ownerId) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.ownerId = ownerId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }
}
