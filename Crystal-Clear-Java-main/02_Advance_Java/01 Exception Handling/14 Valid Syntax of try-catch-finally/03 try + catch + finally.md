# 🧒 14.3 `try` + `catch` + `finally`

### 1. Basic Idea

`try` + `catch` + `finally` combines three important parts of Java exception handling.

```java
try {

    // risky code

}
catch (ExceptionType e) {

    // exception-handling code

}
finally {

    // final / cleanup code

}
```

Their jobs are different:

```text
try     → performs risky work
catch   → handles the exception
finally → performs final or cleanup work
```

---

### 2. Why Do We Need All Three?

Consider an ATM transaction.

The ATM has to:

1. Start the transaction.
2. Perform the transaction.
3. Handle a problem if one occurs.
4. Complete cleanup or terminate the connection.

This can be represented as:

```text
try
 ↓
Perform transaction
 ↓
Exception?
 ↓
catch → handle problem
 ↓
finally → cleanup
```

---

### 3. Simple Real-World Analogy

Imagine going to school.

```text
try
 ↓
Go to school and attend class
```

If something goes wrong:

```text
catch
 ↓
Handle the problem
```

After everything:

```text
finally
 ↓
Return home / finish the day's activity
```

So:

```text
TRY     → Do the main work
CATCH   → Deal with the problem
FINALLY → Finish the necessary final work
```

---

### 4. `try` Block

The `try` block contains code that may produce an exception.

Example:

```java
try {

    int result = 10 / 0;

}
```

The division:

```text
10 / 0
```

produces:

```text
ArithmeticException
```

---

### 5. `catch` Block

The `catch` block handles the exception.

Example:

```java
catch (ArithmeticException e) {

    System.out.println("Cannot divide by zero");

}
```

Here:

```text
ArithmeticException → exception type
e                   → reference to exception object
```

---

### 6. `finally` Block

The `finally` block contains code that should execute after the `try`/`catch` processing.

Example:

```java
finally {

    System.out.println("Transaction completed");

}
```

It is commonly used for final or cleanup operations.

---

### 7. Complete Syntax

```java
try {

    // exception-producing code

}
catch (ExceptionType e) {

    // handle exception

}
finally {

    // final / cleanup code

}
```

This is the standard structure.

---

### 8. Simple Java Example

```java
class Demo {

    public static void main(String[] args) {

        try {

            int a = 10;
            int b = 0;

            int result = a / b;

            System.out.println(result);

        }
        catch (ArithmeticException e) {

            System.out.println("Cannot divide by zero");

        }
        finally {

            System.out.println("Transaction completed");

        }

        System.out.println("Program Ends");

    }
}
```

Output:

```text
Cannot divide by zero
Transaction completed
Program Ends
```

---

### 9. Understanding the Program

The program starts with:

```java
public static void main(String[] args)
```

Then it enters the `try` block.

It creates:

```java
int a = 10;
int b = 0;
```

Then:

```java
int result = a / b;
```

tries to divide `10` by `0`.

This produces:

```text
ArithmeticException
```

---

### 10. What Happens to `try`?

As soon as the exception occurs:

```java
int result = a / b;
```

the remaining statements inside that `try` block are not executed.

So this:

```java
System.out.println(result);
```

does not execute.

Java moves to the matching `catch`.

---

### 11. `catch` Handles the Exception

Java finds:

```java
catch (ArithmeticException e)
```

because the exception is:

```text
ArithmeticException
```

The catch block executes:

```java
System.out.println("Cannot divide by zero");
```

Output:

```text
Cannot divide by zero
```

---

### 12. What Happens After `catch`?

After the `catch` block finishes, Java moves to:

```java
finally
```

The `finally` block executes:

```java
System.out.println("Transaction completed");
```

Output:

```text
Transaction completed
```

---

### 13. Program Continues

After `finally`, execution reaches:

```java
System.out.println("Program Ends");
```

Output:

```text
Program Ends
```

So the complete flow is:

```text
try
 ↓
Exception
 ↓
catch
 ↓
Handle exception
 ↓
finally
 ↓
Final/cleanup operation
 ↓
Program continues
```

---

### 14. When an Exception Occurs

The normal flow is:

```text
main()
 ↓
try
 ↓
Exception occurs
 ↓
try stops from exception point
 ↓
matching catch
 ↓
catch executes
 ↓
finally executes
 ↓
program continues
```

Example:

```text
10 / 0
 ↓
ArithmeticException
 ↓
catch
 ↓
"Cannot divide by zero"
 ↓
finally
 ↓
"Transaction completed"
```

---

### 15. When No Exception Occurs

Now change:

```java
int b = 0;
```

to:

```java
int b = 2;
```

Then:

```java
int result = a / b;
```

becomes:

```text
10 / 2 = 5
```

No exception occurs.

The flow becomes:

```text
try
 ↓
No exception
 ↓
Remaining try code executes
 ↓
catch is skipped
 ↓
finally executes
 ↓
Program continues
```

---

### 16. Example Without Exception

```java
class Demo {

    public static void main(String[] args) {

        try {

            int a = 10;
            int b = 2;

            int result = a / b;

            System.out.println("Result = " + result);

        }
        catch (ArithmeticException e) {

            System.out.println("Cannot divide by zero");

        }
        finally {

            System.out.println("Transaction completed");

        }

        System.out.println("Program Ends");

    }
}
```

Output:

```text
Result = 5
Transaction completed
Program Ends
```

Notice:

```text
catch → not executed
finally → executed
```

---

### 17. Two Important Execution Paths

```text
                 try
                  ↓
           Exception occurs?
             ↙          ↘
           NO            YES
            ↓              ↓
     try completes     catch executes
            ↓              ↓
            └──────┬───────┘
                   ↓
                finally
                   ↓
             Program continues
```

This is the easiest way to remember the flow.

---

### 18. Why Does `catch` Not Always Execute?

`catch` exists specifically for handling an exception.

If there is no exception:

```text
No problem
 ↓
No need for catch
```

Therefore:

```text
Exception occurs → catch executes
No exception → catch is skipped
```

But `finally` is intended for the final/cleanup stage in both cases.

---

### 19. Why Does `finally` Execute?

The purpose of `finally` is to perform important final work.

For example:

```text
Database connection
File resource
Network connection
ATM connection
Transaction cleanup
```

A program may need to clean up these resources whether the main operation succeeds or encounters an exception.

---

### 20. ATM Example

Consider:

```java
class ATM {

    public static void main(String[] args) {

        try {

            System.out.println("Transaction Started");

            int amount = 100 / 0;

        }
        catch (ArithmeticException e) {

            System.out.println("Transaction failed");

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
Transaction failed
Transaction Completed
```

---

### 21. ATM Execution Flow

```text
ATM transaction starts
        ↓
try
        ↓
Transaction processing
        ↓
Exception occurs
        ↓
catch
        ↓
Transaction failure handled
        ↓
finally
        ↓
Final transaction operation
        ↓
Transaction completed
```

This gives a simple real-world meaning to all three blocks.

---

### 22. `catch` Is the Handler

Remember:

```java
catch (ArithmeticException e)
```

is responsible for handling the exception.

For example:

```java
catch (ArithmeticException e) {

    System.out.println("Please enter a valid value");

}
```

The catch block can provide a meaningful response instead of allowing the exception to remain unhandled.

---

### 23. `finally` Is Not a Handler

This is very important.

`finally` does **not** replace `catch`.

For example:

```java
try {

    int result = 10 / 0;

}
finally {

    System.out.println("Cleanup");

}
```

The `finally` block executes, but it does not handle the `ArithmeticException`.

There is no `catch` in this example.

---

### 24. `try` + `catch` + `finally` Together

The three blocks have three different responsibilities:

| Block     | Main responsibility        |
| --------- | -------------------------- |
| `try`     | Execute risky code         |
| `catch`   | Handle exception           |
| `finally` | Perform final/cleanup work |

Remember:

```text
try     → Work
catch   → Problem
finally → Cleanup
```

---

### 25. Exception Object and `e`

When an exception occurs, Java creates an exception object.

For example:

```text
ArithmeticException object
```

The `catch` block receives it through:

```java
catch (ArithmeticException e)
```

So:

```text
Exception occurs
 ↓
Exception object
 ↓
e refers to the object
```

This allows the catch block to obtain information about the exception.

---

### 26. Using the Exception Message

Example:

```java
catch (ArithmeticException e) {

    System.out.println(e.getMessage());

}
```

`e.getMessage()` obtains the message associated with the exception object.

The exact message can depend on the Java runtime.

---

### 27. Complete Flow With Messages

```java
class Demo {

    public static void main(String[] args) {

        System.out.println("Program Started");

        try {

            System.out.println("Inside try");

            int result = 10 / 0;

        }
        catch (ArithmeticException e) {

            System.out.println("Exception handled");

        }
        finally {

            System.out.println("Finally executed");

        }

        System.out.println("Program Ends");

    }
}
```

Output:

```text
Program Started
Inside try
Exception handled
Finally executed
Program Ends
```

---

### 28. What If `catch` Cannot Handle the Exception?

Suppose the `try` produces:

```text
ArithmeticException
```

but the catch is designed for a different incompatible exception type.

Then that catch does not handle the exception.

Java may continue searching for another applicable handler, and if none exists, the exception can propagate outward.

The `finally` block still participates in the final processing.

---

### 29. Important Rule About `finally`

The beginner-level rule is:

> **Normally, `finally` executes whether an exception occurs or not.**

For example:

```text
Exception occurs
     ↓
catch
     ↓
finally
```

and:

```text
No exception
     ↓
finally
```

So `finally` is useful for code that should normally happen in either situation.

---

### 30. Common Confusion

Do not think:

```text
try → catch → finally
```

means all three blocks always execute.

Instead:

```text
No exception:
try → finally
```

and:

```text
Exception handled:
try → catch → finally
```

This is an important difference.

---

### 31. Common Mistake

Do not put important exception-handling code inside `finally` expecting it to receive the exception.

Incorrect idea:

```java
finally {

    // handle ArithmeticException
}
```

Correct:

```java
catch (ArithmeticException e) {

    // handle ArithmeticException
}

finally {

    // cleanup/final operation
}
```

---

### 32. Common Mistake — Forgetting the Order

The usual order is:

```text
try
 ↓
catch
 ↓
finally
```

You cannot randomly arrange them.

For example, this is incorrect:

```java
catch (Exception e) {
}

try {
}
```

The normal structure must associate the `catch` and `finally` with the `try`.

---

### 33. Important Rules

* `try` contains code that may produce an exception.
* `catch` handles a matching exception.
* `finally` contains final or cleanup code.
* `catch` executes when a matching exception occurs.
* `catch` is skipped when no exception occurs.
* `finally` normally executes whether an exception occurs or not.
* `finally` does not itself handle an exception.
* `try` can be followed by both `catch` and `finally`.
* The `catch` block can use the exception reference such as `e`.
* After exception handling and `finally`, the program can continue when normal control flow is possible.

---

### 34. Interview Understanding

A strong interview explanation is:

> **`try` contains risky code, `catch` handles a matching exception, and `finally` contains code that is normally executed regardless of whether an exception occurs. `finally` is commonly used for cleanup or final operations.**

Example:

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

---

### 35. Memory Trick

Remember this sentence:

> **"Try the work, catch the problem, finally finish the cleanup."**

```text
TRY
 ↓
Do the work

CATCH
 ↓
Handle the problem

FINALLY
 ↓
Finish / clean up
```

---

### 36. Complete Lifetime Understanding

```text
                         main()
                           ↓
                          try
                           ↓
                  Risky code executes
                           ↓
                  ┌────────┴────────┐
                  ↓                 ↓
             No exception      Exception occurs
                  ↓                 ↓
        Remaining try code       try stops
             executes                ↓
                  ↓              catch found
                  │                  ↓
                  │           Exception handled
                  │                  ↓
                  └────────┬─────────┘
                           ↓
                        finally
                           ↓
                Final / cleanup work
                           ↓
                  Program continues
                           ↓
                    Program Ends
```

**Core memory rule:**

```text
try     → risky/main work
catch   → exception handling
finally → final/cleanup work
```

The complete concept is:

> **`try` attempts the main operation, `catch` handles the exception if one occurs, and `finally` performs the necessary final or cleanup operation whether the `try` succeeds or an exception occurs.**
