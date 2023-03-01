package org.example.marketplace.domain.values;

import org.example.marketplace.generic.Identity;

public class UserId extends Identity {

    private UserId(String uuid){
        super(uuid);
    }

    public UserId() {
    }

    public static UserId of(String uuid){
        return new UserId(uuid);
    }
}
