package org.example.marketplace.domain.values;

import org.example.marketplace.generic.Identity;

public class CustomerId extends Identity {

    private CustomerId(String uuid){
        super(uuid);
    }

    public CustomerId() {
    }

    public static CustomerId of(String uuid){
        return new CustomerId(uuid);
    }
}
