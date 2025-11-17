class Person {
    String name
    Address address
}

class Address {
    String city
}

Person person = new Person(name: 'John')
// The person object is created without an address 
// Safe navigation operator ?. is used to avoid NullPointerException
String cityName = person.address?.city
println cityName