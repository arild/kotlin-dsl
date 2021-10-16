package builder;

import java.util.Arrays;
import java.util.List;

record Person(String name, Integer age) {

    private Person(Builder builder) {
        this(builder.name, builder.age);
    }

    static Builder builder() {
        return new Builder();
    }

    static final class Builder {
        private String name;
        private Integer age;
        private List<Address> addresses;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder age(Integer age) {
            this.age = age;
            return this;
        }

        public Builder addresses(Address... addresses) {
            this.addresses = Arrays.stream(addresses).toList();
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }
}
