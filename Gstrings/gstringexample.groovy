def name = 'Rodrigo'
def age = 43
// String with single quotes. This examples prints all as string. 
def normalString = 'I am ${age} years old and and my name is ${name}'
println(normalString)
// Using double quotes for GString interpolation
def gString = "I am ${age} year old and my name is ${name}"
println(gString)
// GString with expression inside
def gStringWithExpression = "I am ${age} year old and I will be ${age + 1} next year"
println(gStringWithExpression)