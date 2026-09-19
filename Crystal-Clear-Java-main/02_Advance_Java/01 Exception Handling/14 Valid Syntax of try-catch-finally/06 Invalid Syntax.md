# 🧒 14.6 Invalid Syntax

### 1. Basic Idea

Java has specific rules for writing `try`, `catch`, and `finally`.

They cannot be written in any order.

The correct structures are:

```java
try {
    // risky code
}
catch (Exception e) {
    // handling code
}
finally {
    // final code
}
```

or:

```java
try {
    // risky code
}
finally {
    // final code
}
```

But `finally` cannot be written incorrectly or separated from its `try`.

---

### 2. Why Is the Syntax Important?

Java compiler expects a specific structure.

If the structure is incorrect, the program will not compile.

Think of it like building blocks:

```text
try
 ↓
catch
 ↓
finally
```

The blocks have a fixed relationship.

---

### 3. Correct Order

The correct order is:

```text
try
 ↓
catch
 ↓
finally
```

For example:

```java
try {

    // code

}
catch (Exception e) {

    // handling

}
finally {

    // final work

}
```

---

### 4. Incorrect `finaly`

The keyword must be spelled exactly:

```java
finally
```

Not:

```java
finaly
```

Not:

```java
final
```

Not:

```java
finallly
```

Java keywords must be written correctly.

---

### 5. Invalid Example

```java
class Demo {

    public static void main(String[] args) {

        try {

            int result = 10 / 0;

        }
        catch (ArithmeticException e) {

            System.out.println("Exception handled");

        }
        finaly {

            System.out.println("Completed");

        }

    }
}
```

Here:

```java
finaly
```

is incorrect.

The correct keyword is:

```java
finally
```

---

### 6. Correct Example

```java
class Demo {

    public static void main(String[] args) {

        try {

            int result = 10 / 0;

        }
        catch (ArithmeticException e) {

            System.out.println("Exception handled");

        }
        finally {

            System.out.println("Completed");

        }

    }
}
```

Output:

```text
Exception handled
Completed
```

---

### 7. What Does the Compiler See?

When Java sees:

```java
finaly
```

it does not recognize it as the `finally` keyword.

Therefore, the compiler reports a syntax error.

The program must be corrected before it can run.

```text
Wrong spelling
     ↓
Compiler error
     ↓
Program does not compile
```

---

### 8. Another Invalid Structure

This is also incorrect:

```java
catch (Exception e) {

    System.out.println("Exception");

}

try {

    // code

}
```

A `catch` must be associated with a preceding `try`.

You cannot place an unrelated `try` after its `catch`.

---

### 9. Correct Structure

```java
try {

    // risky code

}
catch (Exception e) {

    // handle exception

}
finally {

    // final work

}
```

The relationship is:

```text
try
 ├── catch
 └── finally
```

---

### 10. Important Rule

A `try` must be followed by either:

```text
catch
```

or:

```text
finally
```

Therefore:

```java
try {
    // code
}
```

by itself is incomplete.

---

### 11. Valid Combinations

These are valid:

```text
try + catch
```

```text
try + finally
```

```text
try + catch + finally
```

These are the important valid combinations.

---

### 12. Invalid Combination

This is invalid:

```text
try only
```

because Java needs exception handling or final processing associated with the `try`.

---

### 13. Correct `try + catch`

```java
try {

    int result = 10 / 0;

}
catch (ArithmeticException e) {

    System.out.println("Exception handled");

}
```

This is valid.

---

### 14. Correct `try + finally`

```java
try {

    int result = 10 / 2;

}
finally {

    System.out.println("Completed");

}
```

This is also valid.

---

### 15. Correct `try + catch + finally`

```java
try {

    int result = 10 / 0;

}
catch (ArithmeticException e) {

    System.out.println("Exception handled");

}
finally {

    System.out.println("Completed");

}
```

This is valid.

---

### 16. Invalid `finally`

This is invalid:

```java
finally {

    System.out.println("Completed");

}
```

A `finally` cannot exist independently.

It must be associated with a `try`.

---

### 17. Why Can't `finally` Stand Alone?

`finally` belongs to a `try` statement.

Its purpose is to perform final work related to that `try`.

So Java expects:

```text
try
 ↓
finally
```

not:

```text
finally
```

alone.

---

### 18. Simple Analogy

Think of `finally` as the **closing step of a task**.

You cannot say:

```text
Finish the task
```

when no task was started.

Similarly:

```text
try
 ↓
finally
```

makes sense because `finally` belongs to the `try`.

---

### 19. Invalid Spelling vs Invalid Structure

There are two different mistakes.

**Wrong spelling:**

```java
finaly
```

Correct:

```java
finally
```

**Wrong structure:**

```java
finally {
}
```

Correct:

```java
try {
}
finally {
}
```

Both must be avoided.

---

### 20. Example With `try-catch-finally`

```java
class Demo {

    public static void main(String[] args) {

        try {

            System.out.println("Try block");

            int a = 10;
            int b = 0;

            System.out.println(a / b);

        }
        catch (ArithmeticException e) {

            System.out.println("Exception handled");

        }
        finally {

            System.out.println("Finally block executed");

        }

        System.out.println("Program Ends");

    }
}
```

Output:

```text
Try block
Exception handled
Finally block executed
Program Ends
```

---

### 21. Execution Flow

```text
main()
 ↓
try
 ↓
10 / 0
 ↓
ArithmeticException
 ↓
catch
 ↓
Exception handled
 ↓
finally
 ↓
Finally block executed
 ↓
Program Ends
```

---

### 22. Common Confusion

Do not confuse:

```java
finally
```

with:

```java
final
```

They have completely different purposes.

```text
final   → Java keyword used with variables, methods, and classes
finally → exception-handling block
```

---

### 23. Common Spelling Mistakes

Incorrect:

```text
finaly
finallly
finaly()
```

Correct:

```text
finally
```

Remember that `finally` ends with:

```text
...lly
```

---

### 24. Common Structure Mistake

Incorrect:

```java
try {

    // code

}
finally {

}
catch (Exception e) {

}
```

The order is wrong.

Correct:

```java
try {

}
catch (Exception e) {

}
finally {

}
```

---

### 25. `catch` and `finally` Relationship

After `try`, you can have:

```text
catch
```

then optionally:

```text
finally
```

So:

```text
try → catch → finally
```

is valid.

---

### 26. Important Rules

* `finally` must be spelled exactly as `finally`.
* `finaly` is not a Java keyword.
* `finally` cannot exist by itself.
* `finally` must be associated with a `try`.
* `try + catch` is valid.
* `try + finally` is valid.
* `try + catch + finally` is valid.
* `try` alone is incomplete.
* `catch` must be associated with a `try`.
* The normal order is `try`, `catch`, then `finally`.

---

### 27. Compiler-Level Understanding

When you write:

```java
finaly {
}
```

the Java compiler does not interpret it as:

```java
finally {
}
```

Therefore, compilation fails.

```text
finaly
 ↓
Not recognized
 ↓
Compilation error
 ↓
No execution
```

---

### 28. Beginner Example

Imagine three labeled boxes:

```text
TRY
 ↓
CATCH
 ↓
FINALLY
```

The labels must be correct.

If you write:

```text
FINALY
```

Java does not understand the label.

Similarly, if you put the boxes in the wrong relationship, Java rejects the structure.

---

### 29. Remember the Three Valid Forms

```text
1. try + catch

2. try + finally

3. try + catch + finally
```

These three forms are enough to remember the basic syntax.

---

### 30. Quick Comparison

| Structure               | Valid? |
| ----------------------- | ------ |
| `try + catch`           | ✅      |
| `try + finally`         | ✅      |
| `try + catch + finally` | ✅      |
| `try` alone             | ❌      |
| `finally` alone         | ❌      |
| `finaly`                | ❌      |

---

### 31. Correct Syntax to Memorize

```java
try {

    // risky code

}
catch (Exception e) {

    // handle exception

}
finally {

    // final / cleanup work

}
```

Do not change the keyword:

```text
finally
```

---

### 32. Common Mistake in Exams

If you see:

```java
try {

    // code

}
catch (Exception e) {

}
finaly {

}
```

identify:

```text
finaly ❌
```

The correction is:

```text
finally ✅
```

---

### 33. Real-World Meaning

In an ATM:

```text
try
 ↓
Perform transaction
 ↓
catch
 ↓
Handle transaction problem
 ↓
finally
 ↓
Perform final/cleanup operation
```

The spelling and structure must be correct for Java to compile the program.

---

### 34. Interview Understanding

A clear interview explanation is:

> **Java provides specific syntax for exception handling. A `try` block must be followed by either a `catch` or a `finally`. The keyword `finally` must be spelled correctly and cannot be used independently. The valid common structures are `try-catch`, `try-finally`, and `try-catch-finally`.**

---

### 35. Memory Trick

Remember:

```text
TRY  → Try the work
CATCH → Catch the problem
FINALLY → Finish the final work
```

And remember the spelling:

```text
FINALLY
```

**not**

```text
FINALY
```

---

### 36. Complete Lifetime Understanding

```text
                         Java Program
                              ↓
                             try
                              ↓
                    Is the syntax correct?
                       ↙              ↘
                     YES               NO
                      ↓                 ↓
              Program compiles    Compilation error
                      ↓
             Exception handling
                      ↓
             try + catch/finally
                      ↓
        ┌─────────────┴─────────────┐
        ↓                           ↓
   try + catch              try + finally
        ↓                           ↓
   catch handles             finally executes
        │                           │
        └─────────────┬─────────────┘
                      ↓
             try + catch + finally
                      ↓
             catch if required
                      ↓
                  finally
                      ↓
             Program continues
```

**Core memory rule:**

> **`try` must be properly associated with `catch` and/or `finally`, and the keyword must be written exactly as `finally`.**
