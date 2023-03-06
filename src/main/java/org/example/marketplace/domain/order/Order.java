package org.example.marketplace.domain.order;

import org.example.marketplace.domain.order.events.OrderCreated;
import org.example.marketplace.domain.order.events.OrderCustomerAssigned;
import org.example.marketplace.domain.order.events.OrderProductAdded;
import org.example.marketplace.domain.order.events.OrderSellerAssigned;
import org.example.marketplace.domain.product.Product;
import org.example.marketplace.domain.values.*;
import org.example.marketplace.generic.AggregateRoot;
import org.example.marketplace.generic.DomainEvent;

import java.util.List;

public class Order extends AggregateRoot<OrderId> {

    protected Customer customer;
    protected Seller seller;

    protected List<ProductId> products;

    protected Status status;

    public Order(OrderId id,Status status) {
        super(id);
        subscribe(new OrderChange(this));
        appendChange(new OrderCreated(status));
    }

    private Order(OrderId id) {
        super(id);
        subscribe(new OrderChange(this));
    }

    public static Order from(OrderId id, List<DomainEvent> events){
        Order order = new Order(id);
        events.forEach(event -> order.applyEvent(event));
        return order;
    }

    public void assignSellerToOrder(SellerId sellerId,UserId userId){
        appendChange(new OrderSellerAssigned(sellerId,userId)).apply();
    }

    public void assignCustomerToOrder(CustomerId customerId,UserId userId){
        appendChange(new OrderCustomerAssigned(customerId,userId)).apply();
    }

    public void addProducts(ProductId productId){
        appendChange(new OrderProductAdded(productId)).apply();
    }


}
