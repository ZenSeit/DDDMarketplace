package org.example.marketplace.domain.values;

import org.example.marketplace.generic.Identity;

public class SellerId extends Identity {
    private SellerId(String uuid){
        super(uuid);
    }

    public SellerId() {
    }

    public static SellerId of (String uuid){
        return new SellerId(uuid);
    }
}
