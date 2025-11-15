class Person {
    String name
    void sayHello() {
        println "Hello, my name is $name"
    }
}

def people = [ new Person(name: 'Rafael'), new Person(name: 'Amanda')]

people*.sayHello()