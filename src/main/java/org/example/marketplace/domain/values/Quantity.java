package org.example.marketplace.domain.values;

import org.example.marketplace.generic.ValueObject;

public class Quantity implements ValueObject<Integer> {

    private int quantity;

    public Quantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public Integer value() {
        return quantity;
    }
}
