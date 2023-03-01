package org.example.marketplace.domain.order;

import org.example.marketplace.domain.order.events.OrderCreated;
import org.example.marketplace.domain.values.CustomerId;
import org.example.marketplace.domain.values.SellerId;
import org.example.marketplace.domain.values.Status;
import org.example.marketplace.generic.EventChange;

public class OrderChange extends EventChange {

    public OrderChange(Order order){
        apply((OrderCreated event) ->{
            order.customerId= CustomerId.of(event.getCustomerId());
            order.sellerId= SellerId.of(event.getSellerId());
            order.status= new Status(event.getStatus());
        });
    }
}
