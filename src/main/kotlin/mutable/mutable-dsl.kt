package mutable

data class Person(
    var name: String? = null,
    var age: Int? = null,
    var address: Address? = null
)

data class Address(
    var street: String? = null,
    var number: Int? = null,
    var city: String? = null
)

fun person(block: Person.() -> Unit): Person = Person().apply(block)

fun Person.address(block: Address.() -> Unit) {
    address = Address().apply(block)
}

fun main() {
    val person = person {
        name = "John"
        age = 25
        address {
            street = "Main Street"
            number = 42
            city = "London"
        }
    }
    println(person)
}
