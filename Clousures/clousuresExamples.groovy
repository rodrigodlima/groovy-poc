def printOnly = {println "Hello World"}
printOnly()

def sayHello = {String name -> println "Hello, ${name}"}
sayHello("Artur")

def squareResult = {int number -> number * number }
def result = squareResult(5)
println ("Square of 5 is $result")