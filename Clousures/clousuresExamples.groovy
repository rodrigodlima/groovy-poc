def printOnly = {println "Hello World"}
printOnly()

def sayHello = {String name -> println "Hello, ${name}"}
sayHello("Artur")

def squareResult = {int number -> number * number }
def result = squareResult(5)
println ("Square of 5 is $result")

def numberList = [1,2,3,4,5]
numberList.each { number -> println("Number: $number")}