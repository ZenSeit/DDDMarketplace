package org.example.marketplace.domain.product.events;


import org.example.marketplace.domain.values.Description;
import org.example.marketplace.domain.values.ReviewId;
import org.example.marketplace.domain.values.Title;
import org.example.marketplace.domain.values.UserId;
import org.example.marketplace.generic.DomainEvent;

public class ReviewAdded extends DomainEvent {

    private final ReviewId reviewId;
    private final Title title;
    private final Description description;
    private final UserId userId;

    public ReviewAdded(ReviewId reviewId, Title title, Description description, UserId userId) {
        super("org.example.marketplace.reviewadded");
        this.reviewId = reviewId;
        this.title = title;
        this.description = description;
        this.userId = userId;
    }

    public ReviewId getReviewId() {
        return reviewId;
    }

    public Title getTitle() {
        return title;
    }

    public Description getDescription() {
        return description;
    }

    public UserId getUserId() {
        return userId;
    }
}
