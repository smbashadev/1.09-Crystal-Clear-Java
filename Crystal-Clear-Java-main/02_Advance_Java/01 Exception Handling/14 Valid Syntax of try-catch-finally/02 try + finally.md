# 🧒 14.2 `try` + `finally`

### 1. Basic Idea

`try` + `finally` is used when some code **must execute whether an exception occurs or not**.

Basic structure:

```java
try {

    // code that may cause exception

}
finally {

    // code that must execute
}
```

The important idea is:

```text
try
 ↓
Code executes
 ↓
Exception occurs or not
 ↓
finally executes
```

---

### 2. Why Do We Use `finally`?

Sometimes a program performs an operation that uses an important resource.

For example:

```text
File opened
Database connection created
ATM connection established
Network connection created
```

After using the resource, we may need to perform cleanup.

`finally` is useful for such code because it is intended to execute whether the `try` block completes normally or an exception occurs.

---

### 3. Simple Real-World Analogy

Imagine entering a classroom.

You study inside the classroom:

```text
try
 ↓
Study
```

Whether your study goes normally or something unexpected happens, you still have to:

```text
finally
 ↓
Close the classroom door
```

So:

```text
try    → main work
finally → compulsory cleanup/final work
```

---

### 4. `try` Block

The `try` block contains the code that may produce an exception.

Example:

```java
try {

    int result = 10 / 2;

}
```

Here the operation is:

```text
10 ÷ 2 = 5
```

No exception occurs.

---

### 5. `finally` Block

The `finally` block contains code that should execute after the `try` processing.

Example:

```java
finally {

    System.out.println("Finally executed");

}
```

The complete structure is:

```java
try {

    int result = 10 / 2;

}
finally {

    System.out.println("Finally executed");

}
```

Output:

```text
Finally executed
```

---

### 6. No `catch` Is Required

A very important point is that `try` can be followed directly by `finally`.

Valid:

```java
try {

    // code

}
finally {

    // final code

}
```

A `catch` block is **not mandatory** when `finally` is present.

---

### 7. Simple Java Example

```java
class Demo {

    public static void main(String[] args) {

        try {

            System.out.println("Inside try");

        }
        finally {

            System.out.println("Inside finally");

        }

        System.out.println("Program Ends");

    }
}
```

Output:

```text
Inside try
Inside finally
Program Ends
```

---

### 8. What Happened?

The program enters:

```text
try
```

and prints:

```text
Inside try
```

Then Java executes:

```text
finally
```

and prints:

```text
Inside finally
```

Finally:

```text
Program Ends
```

is printed.

---

### 9. When No Exception Occurs

The flow is:

```text
main()
 ↓
try
 ↓
No exception
 ↓
finally
 ↓
Program continues
```

Example:

```java
try {

    int result = 10 / 2;

}
finally {

    System.out.println("Finally");

}
```

Output:

```text
Finally
```

---

### 10. When an Exception Occurs

Now:

```java
try {

    int result = 10 / 0;

}
finally {

    System.out.println("Finally");

}
```

An `ArithmeticException` occurs.

But the `finally` block still executes.

Flow:

```text
try
 ↓
10 / 0
 ↓
ArithmeticException
 ↓
finally
 ↓
"Finally"
 ↓
Exception continues if not handled
```

---

### 11. Important Difference From `try` + `catch`

With:

```java
try + catch
```

the `catch` block is used to **handle** the exception.

With:

```java
try + finally
```

the `finally` block is used for code that should execute after the `try` processing.

So:

```text
catch   → exception handling
finally → final/cleanup action
```

---

### 12. Example With `try` + `catch` + `finally`

All three can be used together:

```java
try {

    int result = 10 / 0;

}
catch (ArithmeticException e) {

    System.out.println("Exception handled");

}
finally {

    System.out.println("Finally executed");

}
```

Output:

```text
Exception handled
Finally executed
```

Flow:

```text
try
 ↓
Exception
 ↓
catch
 ↓
Exception handled
 ↓
finally
 ↓
Finally executed
```

---

### 13. Why Is `finally` Important?

Suppose an ATM transaction starts.

```text
Transaction started
 ↓
PIN checked
 ↓
Transaction processing
```

Something may go wrong during processing.

Regardless of whether the transaction succeeds or an exception occurs, the ATM may need to perform a final operation such as:

```text
Transaction cleanup
Connection termination
Resource release
```

This is where `finally` is useful.

---

### 14. ATM Example

```java
class ATM {

    public static void main(String[] args) {

        try {

            System.out.println("Transaction Started");

            int amount = 100 / 0;

            System.out.println("Transaction Processing");

        }
        finally {

            System.out.println("Transaction Completed");

        }

    }
}
```

The `finally` block executes even though division by zero causes an exception.

---

### 15. Important Execution Rule

If an exception occurs inside `try`, Java does not simply ignore `finally`.

The general flow is:

```text
Exception occurs
      ↓
finally gets a chance to execute
      ↓
then exception continues if it has not been handled
```

This is why `finally` is useful for cleanup.

---

### 16. `finally` Does Not Handle the Exception

This is a very important distinction.

Consider:

```java
try {

    int result = 10 / 0;

}
finally {

    System.out.println("Cleanup");

}
```

`finally` prints:

```text
Cleanup
```

But it does **not** catch the `ArithmeticException`.

There is no:

```java
catch (ArithmeticException e)
```

So the exception remains unhandled.

---

### 17. `finally` vs `catch`

| `catch`                                   | `finally`                                           |
| ----------------------------------------- | --------------------------------------------------- |
| Handles an exception                      | Performs final/cleanup work                         |
| Receives exception object                 | Normally does not receive the exception object      |
| Executes when a matching exception occurs | Intended to execute whether exception occurs or not |
| Used for exception handling               | Used for cleanup/final actions                      |

---

### 18. Resource Example

Consider a file:

```text
File opened
 ↓
File operation
 ↓
File should be closed
```

The closing operation can conceptually be placed in `finally`:

```java
try {

    // use file

}
finally {

    // close file

}
```

The idea is:

```text
Use resource
     ↓
Finish/cleanup resource
```

---

### 19. Database Example

Suppose a program establishes a database connection:

```text
Database connection established
 ↓
Database operation
 ↓
Connection should be closed
```

A `finally` block can be used for cleanup logic:

```java
try {

    // database operation

}
finally {

    // close connection

}
```

---

### 20. Important Flow

Think of `finally` as a final checkpoint:

```text
                 try
                  ↓
             Code executes
                  ↓
          ┌───────┴───────┐
          ↓               ↓
     No exception      Exception
          ↓               ↓
          └───────┬───────┘
                  ↓
              finally
                  ↓
          Final/cleanup code
```

---

### 21. Example Without Exception

```java
class Demo {

    public static void main(String[] args) {

        try {

            System.out.println("Transaction processing");

        }
        finally {

            System.out.println("Connection terminated");

        }

    }
}
```

Output:

```text
Transaction processing
Connection terminated
```

---

### 22. Example With Exception

```java
class Demo {

    public static void main(String[] args) {

        try {

            int result = 10 / 0;

        }
        finally {

            System.out.println("Connection terminated");

        }

    }
}
```

The output includes:

```text
Connection terminated
```

The exception is still not handled because there is no `catch`.

---

### 23. `finally` After `catch`

A common pattern is:

```java
try {

    // risky operation

}
catch (Exception e) {

    // handle exception

}
finally {

    // cleanup

}
```

For example:

```java
try {

    int result = 10 / 0;

}
catch (ArithmeticException e) {

    System.out.println("Division problem");

}
finally {

    System.out.println("Transaction cleanup");

}
```

Output:

```text
Division problem
Transaction cleanup
```

---

### 24. Why `finally` Is Called "Final"

It is called `finally` because it is designed for the **final stage of the try-catch processing**.

The normal pattern is:

```text
try
 ↓
catch, if needed
 ↓
finally
```

So you can remember:

```text
try     → attempt the work
catch   → handle the problem
finally → perform final work
```

---

### 25. Common Confusion

Do not think:

> "`finally` means the program can never terminate."

That is not correct.

`finally` is normally executed, but Java has exceptional situations where normal execution cannot reach it, such as forced JVM termination.

For beginner understanding, remember:

> **Normally, `finally` executes whether an exception occurs or not.**

---

### 26. Common Mistake

Do not use `finally` as if it were a `catch`.

Incorrect understanding:

```java
finally {

    // exception handling
}
```

The purpose is different.

Correct understanding:

```text
catch
 ↓
Handle exception

finally
 ↓
Final/cleanup work
```

---

### 27. Common Mistake — Thinking Exception Is Removed

Suppose:

```java
try {

    int result = 10 / 0;

}
finally {

    System.out.println("Done");

}
```

Printing:

```text
Done
```

does not mean the exception disappeared.

The `ArithmeticException` is still unhandled.

`finally` does not automatically remove or handle the exception.

---

### 28. Important Rules

* `try` contains potentially exception-producing code.
* `finally` contains final or cleanup code.
* `try` can be used with `finally` without a `catch`.
* `finally` is intended to execute whether an exception occurs or not.
* `finally` does not itself handle an exception.
* `catch` is for handling exceptions.
* `finally` is commonly used for cleanup.
* `try + catch + finally` can all be used together.
* If an exception is not handled, it can continue propagating after `finally`.
* Resources such as connections, files, or other cleanup operations are common reasons for using `finally`.

---

### 29. Quick Comparison

```text
try
 ↓
Do risky work
```

```text
catch
 ↓
Handle exception
```

```text
finally
 ↓
Do final/cleanup work
```

Remember:

```text
TRY     → Work
CATCH   → Handle problem
FINALLY → Cleanup/final action
```

---

### 30. Real-World ATM Flow

```text
ATM transaction starts
        ↓
try
        ↓
Process transaction
        ↓
Exception occurs?
    ↙          ↘
  NO            YES
   ↓             ↓
Continue       catch
normally       handles problem
    ↘           ↙
       finally
          ↓
Transaction cleanup
          ↓
Connection terminated
```

This is why `finally` is useful in an ATM-style application.

---

### 31. Simple Example to Memorize

```java
class Demo {

    public static void main(String[] args) {

        try {

            System.out.println("Transaction Started");

            int result = 10 / 2;

        }
        finally {

            System.out.println("Transaction Completed");

        }

    }
}
```

Output:

```text
Transaction Started
Transaction Completed
```

The important point is that the `finally` block executes after the `try` block.

---

### 32. Exception Example to Memorize

```java
class Demo {

    public static void main(String[] args) {

        try {

            System.out.println("Transaction Started");

            int result = 10 / 0;

        }
        finally {

            System.out.println("Cleanup Completed");

        }

    }
}
```

Flow:

```text
Transaction Started
        ↓
Division by zero
        ↓
ArithmeticException
        ↓
finally
        ↓
Cleanup Completed
```

---

### 33. Interview Understanding

A strong interview explanation is:

> **The `finally` block is used to execute important final or cleanup code after a `try` block, regardless of whether an exception occurs. It can be used with `try` directly or together with `catch`.**

Example:

```java
try {

    // risky code

}
finally {

    // cleanup code

}
```

---

### 34. Memory Trick

Remember:

> **"Try the work, catch the problem, finally clean up."**

```text
TRY
 ↓
Work

CATCH
 ↓
Problem

FINALLY
 ↓
Cleanup
```

---

### 35. One-Line Memory Formula

```text
try + finally
        ↓
Risky work + compulsory final/cleanup action
```

And:

```text
try + catch + finally
        ↓
Work + handle problem + cleanup
```

---

### 36. Complete Lifetime Understanding

```text
                         try
                          ↓
                Risky code executes
                          ↓
                 Exception occurs?
                    ↙           ↘
                  NO             YES
                   ↓              ↓
            try completes    Exception occurs
                   ↓              ↓
                   └──────┬───────┘
                          ↓
                       finally
                          ↓
                 Final/cleanup code
                          ↓
              ┌───────────┴───────────┐
              ↓                       ↓
        No exception            Exception not handled
              ↓                       ↓
      Program continues        Exception propagates
              ↓                       ↓
              └───────────┬───────────┘
                          ↓
                     Program flow
```

**Core memory rule:**

> **`try` performs the risky work, while `finally` performs the final or cleanup work whether the `try` completes normally or an exception occurs. `finally` does not itself handle the exception.**
