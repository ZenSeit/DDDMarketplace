package org.example.marketplace.domain.values;

import org.example.marketplace.generic.ValueObject;

public class Address implements ValueObject<Address.Props> {

    private String street;
    private int houseNumber;
    private String neighborhood;
    private String city;


    @Override
    public Props value() {
        return new Props() {
            @Override
            public String street() {
                return street;
            }

            @Override
            public int houseNumber() {
                return houseNumber;
            }

            @Override
            public String neighborhood() {
                return neighborhood;
            }

            @Override
            public String city() {
                return city;
            }
        };

    }

    interface Props{
        String street();
        int houseNumber();
        String neighborhood();
        String city();
    }
}
