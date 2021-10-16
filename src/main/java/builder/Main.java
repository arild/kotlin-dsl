package builder;

public class Main {

    public static void main(String[] args) {
        var person = Person.builder()
            .name("John")
            .age(25)
            .addresses(
                Address.builder()
                    .street("Main Street")
                    .number(12)
                    .city("London")
                    .build(),
                Address.builder()
                    .street("Dev Avenue")
                    .number(42)
                    .city("Paris")
                    .build()
            )
            .build();

        System.out.println(person);
    }
}
