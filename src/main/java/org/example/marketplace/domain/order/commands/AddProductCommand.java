package org.example.marketplace.domain.order.commands;

import org.example.marketplace.generic.Command;

public class AddProductCommand extends Command {

    private String orderId;
    private String productId;

    public AddProductCommand(String orderId, String productId) {
        this.orderId = orderId;
        this.productId = productId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
}
