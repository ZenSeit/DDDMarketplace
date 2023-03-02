package org.example.marketplace.domain.order.commands;

import org.example.marketplace.generic.Command;

public class CreateOrderCommand extends Command {

    private String orderId;
    private String status;

    public CreateOrderCommand(String orderId, String status) {
        this.orderId = orderId;
        this.status = status;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
