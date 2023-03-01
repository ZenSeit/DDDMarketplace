package org.example.marketplace.domain.product.events;


import org.example.marketplace.domain.values.ReviewId;
import org.example.marketplace.domain.values.UserId;
import org.example.marketplace.generic.DomainEvent;

public class ReviewAdded extends DomainEvent {

    private ReviewId reviewId;
    private String title;
    private String description;
    private UserId userId;

    public ReviewAdded(ReviewId reviewId, String title, String description, UserId userId) {
        super("org.example.marketplace.reviewadded");
        this.reviewId = reviewId;
        this.title = title;
        this.description = description;
        this.userId = userId;
    }

    public ReviewAdded() {
        super("org.example.marketplace.reviewadded");
    }

    public ReviewId getReviewId() {
        return reviewId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public UserId getUserId() {
        return userId;
    }
}
