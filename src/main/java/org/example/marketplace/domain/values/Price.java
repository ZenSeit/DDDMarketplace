package org.example.marketplace.domain.values;

import org.example.marketplace.generic.ValueObject;

public class Price implements ValueObject<Double> {

    private double price;

    public Price(double price) {
        if(price<0){
            throw new IllegalArgumentException();
        }
        this.price = price;
    }

    @Override
    public Double value() {
        return price;
    }
}
