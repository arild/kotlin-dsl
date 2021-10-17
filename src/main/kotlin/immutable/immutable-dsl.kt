package immutable

data class Person(
    val name: String,
    val age: Int,
    val addresses: List<Address>
)

data class Address(
    val street: String,
    val number: Int,
    val city: String
)

fun person(block: PersonBuilder.() -> Unit): Person = PersonBuilder().apply(block).build()

@DslMarker
annotation class PersonDsl

@PersonDsl
class PersonBuilder {
    var name = ""
    private var age = 0
    private val addresses = mutableListOf<Address>()

    fun addresses(block: ADDRESSES.() -> Unit) {
        addresses.addAll(ADDRESSES().apply(block))
    }

    infix fun String.age(value: Int) {
        name = this
        age = value
    }

    fun build(): Person = Person(name, age, addresses)
}

@PersonDsl
class ADDRESSES : ArrayList<Address>() {
    fun address(block: AddressBuilder.() -> Unit) {
        add(AddressBuilder().apply(block).build())
    }
}

class AddressBuilder {
    var street: String = ""
    var number: Int = 0
    var city: String = ""

    fun build(): Address = Address(street, number, city)
}

fun main() {
    val person = person {
        "John" age 40
        addresses {
            address {
                street = "Main Street"
                number = 12
                city = "London"
            }
            address {
                street = "Dev Avenue"
                number = 42
                city = "Paris"
            }
        }
    }

    println(person)
}
