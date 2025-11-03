println("range01")
range01 = 1..15

for (int i =0; i < range01.size(); i++) {
    println ("${range01[i]}")
}

range02 = "a".."z"
range02.each{letter -> println("${letter}")}