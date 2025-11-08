average = 7

listStudents = [
    [name: "Marco", grade1: 7, grade2: 8],
    [name: "Julio", grade1: 5, grade2: 7]
]

println("=========Students results==========")

for (student in listStudents) {
    finalGrade = (student.grade1 + student.grade2) / 2
    if (finalGrade >= average) {
        println("${student.name}: ${finalGrade} - Approved")
    } else {
        println("${student.name}: ${finalGrade} - Failed")
    }
}    

