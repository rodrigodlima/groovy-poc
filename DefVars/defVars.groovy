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
        break
    }
}