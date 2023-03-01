package org.example.marketplace.domain.values;

import org.example.marketplace.generic.ValueObject;

import java.util.Date;

public class Birthday implements ValueObject<Date> {

    private Date birthday;

    public Birthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public Date value() {
        return null;
    }
}
