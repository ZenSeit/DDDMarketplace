package org.example.marketplace.domain.order.commands;

import org.example.marketplace.generic.Command;

public class CreateOrderCommand extends Command {

    private String orderId;
    private String customerId;
    private String sellerId;

    private String status;

    public CreateOrderCommand(String orderId, String customerId, String sellerId, String status) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.sellerId = sellerId;
        this.status = status;
    }

    public CreateOrderCommand() {
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
