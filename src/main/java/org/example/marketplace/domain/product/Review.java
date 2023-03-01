package org.example.marketplace.domain.product;

import org.example.marketplace.domain.values.Description;
import org.example.marketplace.domain.values.ReviewId;
import org.example.marketplace.domain.values.Title;
import org.example.marketplace.domain.values.UserId;
import org.example.marketplace.generic.Entity;

public class Review extends Entity<ReviewId> {

    private Title title;
    private Description description;
    private UserId userId;

    public Review(ReviewId id, Title title, Description description, UserId userId) {
        super(id);
        this.title = title;
        this.description = description;
        this.userId = userId;
    }

    public Title Title() {
        return title;
    }

    public Description Description() {
        return description;
    }

    public UserId UserId() {
        return userId;
    }
}
