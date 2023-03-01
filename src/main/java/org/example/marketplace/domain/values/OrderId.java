package org.example.marketplace.domain.values;

import org.example.marketplace.generic.Identity;

public class OrderId extends Identity {

    public OrderId(String uuid) {
        super(uuid);
    }

    public OrderId() {
    }

    public static OrderId of(String uuid){
        return new OrderId(uuid);
    }
}
