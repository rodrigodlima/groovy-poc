## Dynamic Typing in Groovy

Groovy is a **dynamically typed** language, which means you don't need to explicitly declare variable types. The language automatically determines the type at runtime.

### Practical Example
```groovy
age = 5
checkVar(age)
name = "jose"
checkVar(name)

def checkVar(variable) {
    switch(variable.getClass()) {
        case Integer:
            println("$variable was evaluated as Integer")
            break
        case String:
            println("$variable was evaluated as String")
            break
    }
}
```

**Output:**
```
5 was evaluated as Integer
jose was evaluated as String
```

### How It Works

In the example above:
- Variables `age` and `name` are declared without type specification
- The same function `checkVar()` can receive different types
- Type checking happens at **runtime** using `getClass()`
- Groovy's Meta-Object Protocol (MOP) dynamically resolves the correct method calls

### Technical Details

- **Compile Time**: Variables without explicit types are compiled as `Object` in JVM bytecode
- **Runtime**: Groovy uses reflection and the MOP to determine the actual type and available methods
- **Type Safety**: Despite being dynamically typed, Groovy is **strongly typed**, preventing arbitrary operations between incompatible types

### Dynamic vs Static Typing
```groovy
// Dynamic typing - type checking at runtime
def value = 100
value = "text"  // Valid - type can change at runtime

// Static typing - type checking at compile time (optional)
Integer count = 10
count = "text"  // Compilation error
```

### Optional Static Typing

For better performance and compile-time checks, you can use static typing:
```groovy
@CompileStatic
class Example {
    String process(Integer value) {
        return "Value: ${value}"
    }
}
```

This flexibility allows developers to choose between dynamic flexibility and static type safety based on their needs.