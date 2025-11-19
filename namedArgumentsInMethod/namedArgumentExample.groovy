def displayPersonInfo(Map args) {
    println "${args.name} is ${args.age} years old and lives in ${args.city}."
}

// Calling the method using named arguments
displayPersonInfo(name: 'Joao', age: 30, city: 'Porto Alegre')

// Named arguments can be provided in any order
displayPersonInfo(city: 'Londres', name: 'Maria', age: 25)