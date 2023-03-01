package org.example.marketplace.domain.values;

import org.example.marketplace.generic.Identity;

public class ProductId extends Identity {

    private ProductId(String uuid){
        super(uuid);
    }
    public ProductId() {
    }

    public static ProductId of(String uuid){
        return new ProductId(uuid);
    }

}
