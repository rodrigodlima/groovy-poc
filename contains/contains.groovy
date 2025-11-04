interval = 'a'..'f'

if (interval.contains('d')){
    println "The interval contains the letter 'd'"
}
println "The interval contains ${interval.size()} elements"
println "The firts element is ${interval.from}"
println "The last element is ${interval.to}"