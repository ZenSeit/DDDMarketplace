package org.example.marketplace.domain.product.events;

import org.example.marketplace.domain.values.ReviewId;
import org.example.marketplace.generic.DomainEvent;

public class ReviewDeleted extends DomainEvent {

    private final ReviewId reviewId;

    public ReviewDeleted(ReviewId reviewId) {
        super("org.example.marketplace.reviewdeleted");
        this.reviewId = reviewId;
    }

    public ReviewId getReviewId() {
        return reviewId;
    }

}
