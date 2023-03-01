package org.example.marketplace.domain.values;

import org.example.marketplace.generic.Identity;

public class ReviewId extends Identity {

    private ReviewId(String uuid){
        super(uuid);
    }

    public ReviewId() {
    }

    public static ReviewId of(String uuid){
        return new ReviewId(uuid);
    }
}
