package org.example.marketplace.domain.product.commands;

import org.example.marketplace.generic.Command;

public class RemoveReviewCommand extends Command {

    private String productId;
    private String reviewId;

    public RemoveReviewCommand(String productId, String reviewId) {
        this.productId = productId;
        this.reviewId = reviewId;
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
}
