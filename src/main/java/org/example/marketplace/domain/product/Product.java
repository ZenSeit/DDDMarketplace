package org.example.marketplace.domain.product;

import org.example.marketplace.domain.product.events.ProductCreated;
import org.example.marketplace.domain.product.events.ReviewAdded;
import org.example.marketplace.domain.values.*;
import org.example.marketplace.generic.AggregateRoot;
import org.example.marketplace.generic.DomainEvent;

import java.util.List;

public class Product extends AggregateRoot<ProductId> {

    protected Name name;
    protected Description description;
    protected Quantity quantity;
    protected Price price;
    protected  UserId ownerId;

    protected List<Review> reviews;

    public Product(ProductId id, Name name, Description description, Quantity quantity, Price price, UserId ownerId) {
        super(id);
        subscribe(new ProductChange(this));
        appendChange(new ProductCreated(name.value(), description.value(), quantity.value(),price.value(), ownerId.value()));
    }

    public Product(ProductId id) {
        super(id);
        subscribe(new ProductChange(this));
    }

    public static Product myProduct(ProductId id, List<DomainEvent> events){
        Product product = new Product(id);
        events.forEach(event -> product.applyEvent(event));
        return product;
    }

    public void addReview(ReviewId id, Title title,Description description, UserId userId){
        appendChange(new ReviewAdded(id, title.value(), description.value(), userId));
    }
}
