package org.example.marketplace.domain.values;

import org.example.marketplace.generic.ValueObject;

public class Points implements ValueObject<Integer> {

    private int point;

    public Points(int point) {
        if(point<0){
            throw new IllegalArgumentException();
        }
        this.point = point;
    }

    @Override
    public Integer value() {
        return point;
    }
}
