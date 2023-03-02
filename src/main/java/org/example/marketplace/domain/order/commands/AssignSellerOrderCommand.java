package org.example.marketplace.domain.order.commands;

import org.example.marketplace.generic.Command;

public class AssignSellerOrderCommand extends Command {

    private String orderId;
    private String sellerId;
    private String userId;

    public AssignSellerOrderCommand(String orderId, String sellerId, String userId) {
        this.orderId = orderId;
        this.sellerId = sellerId;
        this.userId = userId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
