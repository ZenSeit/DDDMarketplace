package org.example.marketplace.domain.values;

import org.example.marketplace.generic.ValueObject;

public class Reputation implements ValueObject<Double> {

    private double reputation;

    public Reputation(double reputation){
        if(reputation<0){
            throw new IllegalArgumentException();
        }
        this.reputation=reputation;
    }

    @Override
    public Double value() {
        return reputation;
    }
}
