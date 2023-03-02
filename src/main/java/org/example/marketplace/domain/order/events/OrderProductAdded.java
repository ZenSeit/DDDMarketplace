package org.example.marketplace.domain.order.events;

import org.example.marketplace.domain.values.ProductId;
import org.example.marketplace.generic.DomainEvent;

public class OrderProductAdded extends DomainEvent {

    private final ProductId productId;

    public OrderProductAdded(ProductId productId) {
        super("org.example.marketplace.addproductoorder");
        this.productId = productId;
    }

    public ProductId getProductId() {
        return productId;
    }
}
