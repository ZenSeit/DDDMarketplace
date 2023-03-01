package org.example.marketplace.domain.product;

import org.example.marketplace.domain.product.events.ProductCreated;
import org.example.marketplace.domain.product.events.ReviewAdded;
import org.example.marketplace.domain.values.*;
import org.example.marketplace.generic.EventChange;

import java.util.ArrayList;

public class ProductChange extends EventChange {

    public ProductChange(Product product){
        apply((ProductCreated event) ->{
            product.name=new Name(event.getName());
            product.description=new Description(event.getDescription());
            product.quantity=new Quantity(event.getQuantity());
            product.price=new Price(event.getPrice());
            product.ownerId=UserId.of(event.getOwnerId());
            product.reviews=new ArrayList<>();
        });

        apply((ReviewAdded event)->{
            Review review = new Review(event.getReviewId(),new Title(event.getTitle()),new Description(event.getDescription()),event.getUserId());
        });
    }


}
