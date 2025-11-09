# Try-Catch in Groovy - Complete Guide

## 📌 What is Try-Catch?

Try-catch is a control structure for **exception handling** (errors) that may occur during code execution.

## 🎯 When to Use?

### ✅ **Situations where it's NECESSARY:**

1. **I/O Operations** (files, network)
   ```groovy
   try {
       new File("file.txt").text
   } catch (FileNotFoundException e) {
       println "File not found"
   }
   ```

2. **Type conversions**
   ```groovy
   try {
       def number = "abc" as Integer
   } catch (NumberFormatException e) {
       println "Not a valid number"
   }
   ```

3. **Mathematical divisions**
   ```groovy
   try {
       result = 10 / 0
   } catch (ArithmeticException e) {
       println "Division by zero!"
   }
   ```

4. **External API access**
   ```groovy
   try {
       def response = new URL("https://api.example.com").text
   } catch (IOException e) {
       println "Connection failed"
   }
   ```

5. **Data parsing** (JSON, XML)
   ```groovy
   try {
       def json = new JsonSlurper().parseText(text)
   } catch (JsonException e) {
       println "Invalid JSON"
   }
   ```

### ❌ **When NOT to use:**

1. **Normal flow control** - Use if/else instead
2. **Simple validations** - Validate before executing
3. **Logic errors** - Fix the code instead

## 📖 Basic Structure

```groovy
try {
    // Code that might throw an error
    dangerousCode()
} catch (ExceptionType1 e) {
    // Specific handling for ExceptionType1
} catch (ExceptionType2 e) {
    // Specific handling for ExceptionType2
} catch (Exception e) {
    // Generic handling (catches any exception)
} finally {
    // ALWAYS executes, with or without error
    // Useful for resource cleanup
}
```

## 🔍 Application to Your Example Code

### Original Code
```groovy
media = 7
alunos = [
    [Nome: "Rodrigo", Nota1: 10, Nota2: 10],
    [Nome: "Quelen", Nota1: 7, Nota2: 5]
]

for (i in alunos) {
    println("========== Resultado ==========")
    resultado = (i.Nota1 + i.Nota2) / 2
    if (resultado >= media) {
        println("${i.Nome} foi aprovado com nota ${resultado}")
    } else {
        println("${i.Nome} foi reprovado com nota ${resultado}")
    }
}
```

### ⚠️ Potential Problems:

1. **What if a student doesn't have grade1 or grade2?** → `NullPointerException`
2. **What if the grade is a string?** → `ClassCastException`
3. **What if the Map structure is wrong?** → `MissingPropertyException`

### ✅ Robust Version with Try-Catch

```groovy
passingGrade = 7
students = [
    [name: "Rodrigo", grade1: 10, grade2: 10],
    [name: "Quelen", grade1: 7, grade2: 5],
    [name: "John", grade1: 8] // Missing grade2
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
    } catch (NullPointerException e) {
        println("ERROR: Student ${student.name} has missing grades!")
    } catch (Exception e) {
        println("ERROR processing ${student.name}: ${e.message}")
    }
}
```

## 🏆 Best Practices

### 1️⃣ **Be Specific with Exceptions**
```groovy
// ❌ Bad
try {
    someCode()
} catch (Exception e) {
    println "Error"
}

// ✅ Good
try {
    someCode()
} catch (FileNotFoundException e) {
    println "File not found"
} catch (IOException e) {
    println "I/O error"
} catch (Exception e) {
    println "Unexpected error: ${e.message}"
}
```

### 2️⃣ **Validate First When Possible**
```groovy
// ✅ Better than try-catch
if (student.containsKey('grade1') && student.containsKey('grade2')) {
    average = (student.grade1 + student.grade2) / 2
} else {
    println "Incomplete grades"
}
```

### 3️⃣ **Use Finally for Cleanup**
```groovy
def file
try {
    file = new File("data.txt")
    // process file
} catch (IOException e) {
    println "Error reading file"
} finally {
    file?.close() // Always close the file
}
```

### 4️⃣ **Don't Silence Errors**
```groovy
// ❌ NEVER do this
try {
    someCode()
} catch (Exception e) {
    // Does nothing - silent error!
}

// ✅ Always log or handle
try {
    someCode()
} catch (Exception e) {
    println "ERROR: ${e.message}"
    e.printStackTrace() // During development
}
```

### 5️⃣ **Throw Custom Exceptions**
```groovy
def validateGrade(grade) {
    if (grade < 0 || grade > 10) {
        throw new IllegalArgumentException("Grade must be between 0 and 10")
    }
}

try {
    validateGrade(15)
} catch (IllegalArgumentException e) {
    println "Validation failed: ${e.message}"
}
```

## 📊 Common Exceptions in Groovy

| Exception | When it occurs |
|-----------|----------------|
| `NullPointerException` | Attempting to use null object |
| `NumberFormatException` | String to number conversion fails |
| `ArithmeticException` | Division by zero |
| `FileNotFoundException` | File doesn't exist |
| `IOException` | Read/write error |
| `IndexOutOfBoundsException` | Invalid index in list |
| `IllegalArgumentException` | Invalid method argument |
| `ClassCastException` | Invalid type conversion |

## 🎓 Summary

- **Try-catch** protects your code against unexpected errors
- Use when there's **real risk** of failure (I/O, conversions, APIs)
- **Validate first**, use try-catch as a second line of defense
- Be **specific** about which exceptions to catch
- **Never silence errors** - always log or handle appropriately
- Use **finally** to guarantee resource cleanup

## 🔗 For Your Example Code

The current code is **simple and controlled**, so try-catch is not mandatory. But it would be useful if:
- Data came from an external source (file, API)
- There was risk of incomplete data
- The system needed to be more robust in production

## 📝 Examples in the Repository

Check [try-catch-examples.groovy](try-catch-examples.groovy) for 7 complete examples showing:
1. Basic error handling
2. Specific exception types
3. Finally block usage
4. Preventive validation
5. Custom exceptions
6. Division by zero handling
7. Comprehensive error handling with logging
