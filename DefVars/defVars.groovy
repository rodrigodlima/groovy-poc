age = 5
checkVar(age)
name = "jose"

def checkVar(variable) {
    switch(variable.getClass()) {
        case Integer:
            println("$variable was evaluated as Integer")
        case String:
            println("$variable was evaluated as String")
        break
    }
}