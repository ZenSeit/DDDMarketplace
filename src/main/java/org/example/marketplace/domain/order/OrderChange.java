package org.example.marketplace.domain.order;

import org.example.marketplace.domain.order.events.OrderCreated;
import org.example.marketplace.domain.order.events.OrderCustomerAssigned;
import org.example.marketplace.domain.order.events.OrderSellerAssigned;
import org.example.marketplace.domain.values.CustomerId;
import org.example.marketplace.domain.values.SellerId;
import org.example.marketplace.domain.values.UserId;
import org.example.marketplace.generic.EventChange;

import java.util.ArrayList;

public class OrderChange extends EventChange {

    public OrderChange(Order order){
        apply((OrderCreated event) ->{
            order.products = new ArrayList<>();
        });

        apply((OrderCustomerAssigned event) ->{
            order.customer = new Customer(CustomerId.of(event.getCustomerId()),UserId.of(event.getUserId()));
        });

        apply((OrderSellerAssigned event) ->{
            order.seller = new Seller(SellerId.of(event.getSellerId()),UserId.of(event.getUserId()));
        });

    }
}
