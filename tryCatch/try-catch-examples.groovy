println("===== EXAMPLE 1: Basic Error Handling =====\n")

passingGrade = 7
students = [
    [name: "Rodrigo", grade1: 10, grade2: 10],
    [name: "Quelen", grade1: 7, grade2: 5],
    [name: "John", grade1: 8] 
]

for (student in students) {
    try {
        println("========== Result ==========")
        average = (student.grade1 + student.grade2) / 2

        if (average >= passingGrade) {
            println("${student.name} passed with grade ${average}")
        } else {
            println("${student.name} failed with grade ${average}")
        }
    } catch (Exception e) {
        println("ERROR processing student ${student.name}: ${e.message}")
        println("Please check if all grades were provided.\n")
    }
}

println("\n\n===== EXAMPLE 2: Specific Exception Handling =====\n")

students2 = [
    [name: "Maria", grade1: 10, grade2: 8],
    [name: "Peter", grade1: "invalid", grade2: 7], 
    [name: "Ana"]
]

for (student in students2) {
    try {
        println("========== Result ==========")
        average = (student.grade1 + student.grade2) / 2

        if (average >= passingGrade) {
            println("${student.name} passed with grade ${average}")
        } else {
            println("${student.name} failed with grade ${average}")
        }
    } catch (NullPointerException e) {
        println("ERROR: Student ${student.name} has missing grades!")
    } catch (NumberFormatException e) {
        println("ERROR: Student ${student.name} has invalid grade format!")
    } catch (Exception e) {
        println("UNEXPECTED ERROR processing ${student.name}: ${e.message}")
    }
    println()
}


println("\n\n===== EXAMPLE 3: With Finally Block (Always Executes) =====\n")

int processedStudents = 0
int studentsWithError = 0

students3 = [
    [name: "Carlos", grade1: 9, grade2: 7],
    [name: "Beatriz", grade1: 6] // Missing grade
]

for (student in students3) {
    try {
        println("========== Processing ${student.name} ==========")
        average = (student.grade1 + student.grade2) / 2

        if (average >= passingGrade) {
            println("${student.name} passed with grade ${average}")
        } else {
            println("${student.name} failed with grade ${average}")
        }
        processedStudents++

    } catch (Exception e) {
        println("ERROR: ${e.message}")
        studentsWithError++

    } finally {
        println("Finishing processing of ${student.name}")
        println()
    }
}

println("===== SUMMARY =====")
println("Students processed successfully: ${processedStudents}")
println("Students with errors: ${studentsWithError}")

println("\n\n===== EXAMPLE 4: Preventive Validation (Best Practice) =====\n")

students4 = [
    [name: "Fernando", grade1: 8, grade2: 9],
    [name: "Julia", grade1: 7],
    [name: "Lucas", grade1: null, grade2: 8]
]

for (student in students4) {
    println("========== Result ==========")

    if (!student.containsKey('grade1') || !student.containsKey('grade2')) {
        println("WARNING: Student ${student.name} has incomplete grades. Skipping...")
        println()
        continue
    }

    if (student.grade1 == null || student.grade2 == null) {
        println("WARNING: Student ${student.name} has null grade. Skipping...")
        println()
        continue
    }

    try {
        average = (student.grade1 + student.grade2) / 2

        if (average >= passingGrade) {
            println("${student.name} passed with grade ${average}")
        } else {
            println("${student.name} failed with grade ${average}")
        }
    } catch (Exception e) {
        println("UNEXPECTED ERROR: ${e.message}")
    }
    println()
}

println("\n\n===== EXAMPLE 5: Throwing Custom Exceptions =====\n")

def calculateAverage(student) {
    if (!student.containsKey('grade1') || !student.containsKey('grade2')) {
        throw new IllegalArgumentException("Student ${student.name} doesn't have all required grades")
    }

    if (student.grade1 < 0 || student.grade1 > 10 || student.grade2 < 0 || student.grade2 > 10) {
        throw new IllegalArgumentException("Grades must be between 0 and 10")
    }

    return (student.grade1 + student.grade2) / 2
}

students5 = [
    [name: "Sandra", grade1: 8, grade2: 9],
    [name: "Roberto", grade1: 15, grade2: 7] 
]

for (student in students5) {
    try {
        println("========== Result ==========")
        average = calculateAverage(student)

        if (average >= passingGrade) {
            println("${student.name} passed with grade ${average}")
        } else {
            println("${student.name} failed with grade ${average}")
        }
    } catch (IllegalArgumentException e) {
        println("VALIDATION ERROR: ${e.message}")
    } catch (Exception e) {
        println("GENERAL ERROR: ${e.message}")
    }
    println()
}

println("\n\n===== EXAMPLE 6: Division by Zero =====\n")

testCases = [
    [name: "Test 1", numerator: 10, denominator: 2],
    [name: "Test 2", numerator: 15, denominator: 0], // Division by zero
    [name: "Test 3", numerator: 8, denominator: 4]
]

for (testCase in testCases) {
    try {
        result = testCase.numerator / testCase.denominator
        println("${testCase.name}: ${testCase.numerator} / ${testCase.denominator} = ${result}")
    } catch (ArithmeticException e) {
        println("${testCase.name}: ERROR - Cannot divide by zero!")
    }
}

println("\n\n===== EXAMPLE 7: Comprehensive Error Handling =====\n")

students6 = [
    [name: "Alice", grade1: 9, grade2: 8],
    [name: "Bob", grade1: "seven", grade2: 8],
    [name: "Charlie"]
]

for (student in students6) {
    try {
        println("========== Processing ${student.name} ==========")

        if (!student.containsKey('grade1') || !student.containsKey('grade2')) {
            throw new IllegalStateException("Missing required fields")
        }

        average = (student.grade1 + student.grade2) / 2

        status = average >= passingGrade ? "PASSED" : "FAILED"
        println("Student: ${student.name}")
        println("Average: ${average}")
        println("Status: ${status}")

    } catch (IllegalStateException e) {
        println("DATA ERROR: ${e.message}")
        println("Student record is incomplete")
    } catch (ClassCastException e) {
        println("TYPE ERROR: Invalid data type for grades")
        println("Expected numeric values")
    } catch (NullPointerException e) {
        println("NULL ERROR: One or more grades are null")
    } catch (Exception e) {
        println("UNKNOWN ERROR: ${e.class.simpleName}")
        println("Message: ${e.message}")
    } finally {
        println("---")
    }
}
