package org.example.marketplace.domain.product;

import org.example.marketplace.domain.product.events.ProductCreated;
import org.example.marketplace.domain.product.events.ReviewAdded;
import org.example.marketplace.domain.product.events.ReviewDeleted;
import org.example.marketplace.domain.values.*;
import org.example.marketplace.generic.EventChange;

import java.util.ArrayList;

public class ProductChange extends EventChange {

    public ProductChange(Product product){
        apply((ProductCreated event) ->{
            product.name=event.getName();
            product.description=event.getDescription();
            product.quantity=event.getQuantity();
            product.price=event.getPrice();
            product.owner=event.getOwnerId();
            product.reviews=new ArrayList<>();
        });

        apply((ReviewAdded event)->{
            Review review = new Review(event.getReviewId(),event.getTitle(),event.getDescription(),event.getUserId());
            product.reviews.add(review);
        });

        apply((ReviewDeleted event) ->{
            product.reviews = product.reviews.stream().filter(review -> !review.identity().value().equalsIgnoreCase(event.getReviewId().value())).toList();
        });
    }


}
