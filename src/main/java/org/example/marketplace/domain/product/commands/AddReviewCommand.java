package org.example.marketplace.domain.product.commands;

import org.example.marketplace.generic.Command;

public class AddReviewCommand extends Command {

    private String productId;
    private String reviewId;
    private String title;
    private String description;
    private String userId;

    public AddReviewCommand(String productId, String reviewId, String title, String description, String userId) {
        this.productId = productId;
        this.reviewId = reviewId;
        this.title = title;
        this.description = description;
        this.userId = userId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getReviewId() {
        return reviewId;
    }

    public void setReviewId(String reviewId) {
        this.reviewId = reviewId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
