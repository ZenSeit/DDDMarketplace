package org.example.marketplace.domain.order.commands;

import org.example.marketplace.generic.Command;

public class AssignCustomerOrderCommand extends Command {

    private String orderId;
    private String customerId;
    private String userId;

    public AssignCustomerOrderCommand(String orderId, String customerId, String userId) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.userId = userId;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
