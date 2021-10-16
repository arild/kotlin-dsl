package builder;

record Address(String street, Integer number, String city) {

    private Address(Builder builder) {
        this(builder.street, builder.number, builder.city);
    }

    static Builder builder() {
        return new Builder();
    }

    static final class Builder {
        private String street;
        private Integer number;
        private String city;

        public Builder street(String street) {
            this.street = street;
            return this;
        }

        public Builder number(Integer number) {
            this.number = number;
            return this;
        }

        public Builder city(String city) {
            this.city = city;
            return this;
        }

        public Address build() {
            return new Address(this);
        }
    }
}
