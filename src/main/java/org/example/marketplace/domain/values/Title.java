package org.example.marketplace.domain.values;

import org.example.marketplace.generic.ValueObject;

import java.util.Objects;

public class Title implements ValueObject<String> {
        private String title;

        public Title( String title) {
            if(title.length() <= 3){
                throw new IllegalArgumentException();
            }
            this.title = Objects.requireNonNull(title);
        }

        @Override
        public String value() {
            return title;
        }
}
