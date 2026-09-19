# 🧒 14.4 Nested `try-catch`

### 1. Basic Idea

A **nested `try-catch`** means placing one `try-catch` inside another `try` block.

In simple words:

```text
Outer try
   ↓
   Inner try
      ↓
   Inner catch
   ↓
Outer catch
```

So, there is a **try inside another try**.

---

### 2. Why Do We Use Nested `try-catch`?

Sometimes a program has different sections of risky code.

One section may need its own exception handling, while another section can be handled by the outer `catch`.

For example:

```text
Main operation
   ↓
Outer try
   ↓
Small risky operation
   ↓
Inner try-catch
```

This allows us to handle exceptions at different levels.

---

### 3. Simple Real-World Analogy

Imagine a school has:

```text
School
 ↓
Classroom
 ↓
Student
```

If a small problem happens inside the classroom, the classroom teacher may handle it.

If the teacher cannot handle the problem, the school administration may handle it.

Similarly:

```text
Inner catch
   ↓
tries to handle the problem

Outer catch
   ↓
can handle an exception that is not handled inside
```

---

### 4. Basic Structure

```java
try {

    try {

        // inner risky code

    }
    catch (ExceptionType e) {

        // inner exception handling

    }

}
catch (ExceptionType e) {

    // outer exception handling

}
```

The important point is:

```text
try
 └── try
     └── catch
```

---

### 5. Outer `try`

The first `try` is called the **outer try**.

```java
try {

    // outer code

}
```

It contains the larger section of program logic.

It can also contain another `try-catch`.

---

### 6. Inner `try`

The `try` inside the outer `try` is called the **inner try**.

```java
try {

    try {

        // inner code

    }

}
```

The inner `try` handles a smaller section of risky code.

---

### 7. Inner `catch`

The `catch` immediately associated with the inner `try` is the **inner catch**.

```java
try {

    try {

        // risky code

    }
    catch (Exception e) {

        // inner handling

    }

}
```

When an exception occurs inside the inner `try`, Java first looks at the inner `catch`.

---

### 8. Outer `catch`

The outer `catch` belongs to the outer `try`.

```java
try {

    // outer code

}
catch (Exception e) {

    // outer handling

}
```

If an exception is not handled by the inner `catch`, Java can look for a suitable handler in the outer level.

---

### 9. Simple Java Example

```java
class Demo {

    public static void main(String[] args) {

        try {

            System.out.println("Outer try started");

            try {

                int result = 10 / 0;

            }
            catch (ArithmeticException e) {

                System.out.println("Inner catch handled exception");

            }

            System.out.println("Outer try ended");

        }
        catch (Exception e) {

            System.out.println("Outer catch handled exception");

        }

        System.out.println("Program Ends");

    }
}
```

Output:

```text
Outer try started
Inner catch handled exception
Outer try ended
Program Ends
```

---

### 10. Execution of the Example

The program starts:

```text
main()
 ↓
Outer try
 ↓
"Outer try started"
 ↓
Inner try
 ↓
10 / 0
```

The division by zero produces:

```text
ArithmeticException
```

Java looks for a handler inside the inner `try`.

It finds:

```java
catch (ArithmeticException e)
```

So the **inner catch handles the exception**.

---

### 11. What Happens to the Outer `catch`?

Because the inner `catch` successfully handled the exception:

```text
Outer catch
```

does not execute.

The program returns to the outer `try` and continues:

```text
Outer try ended
```

Then:

```text
Program Ends
```

is printed.

---

### 12. Flow of the Example

```text
main()
  ↓
Outer try
  ↓
Inner try
  ↓
10 / 0
  ↓
ArithmeticException
  ↓
Inner catch
  ↓
Exception handled
  ↓
Outer try continues
  ↓
Outer catch skipped
  ↓
Program Ends
```

---

### 13. What If Inner `catch` Cannot Handle It?

Suppose the inner `try` produces an exception that the inner `catch` does not handle.

Then Java can look at the outer level.

The basic idea is:

```text
Inner try
   ↓
Exception
   ↓
Inner catch?
   ↓
Not handled
   ↓
Outer catch?
   ↓
Handle if suitable
```

This is called **exception propagation**.

---

### 14. Example of Outer Catch Handling

```java
class Demo {

    public static void main(String[] args) {

        try {

            System.out.println("Outer try started");

            try {

                int[] arr = {10, 20, 30};

                System.out.println(arr[5]);

            }
            catch (ArithmeticException e) {

                System.out.println("Inner catch");

            }

        }
        catch (ArrayIndexOutOfBoundsException e) {

            System.out.println("Outer catch handled array exception");

        }

        System.out.println("Program Ends");

    }
}
```

Output:

```text
Outer try started
Outer catch handled array exception
Program Ends
```

---

### 15. Why Did the Outer Catch Execute?

The inner `try` produced:

```text
ArrayIndexOutOfBoundsException
```

But the inner `catch` handles only:

```text
ArithmeticException
```

Therefore:

```text
Inner catch
     ↓
Cannot handle ArrayIndexOutOfBoundsException
```

The exception moves outward.

The outer `catch` matches:

```java
catch (ArrayIndexOutOfBoundsException e)
```

Therefore, the outer catch handles it.

---

### 16. Exception Propagation in Nested `try-catch`

Think of it like levels:

```text
Level 1
Outer try
   ↓
Level 2
Inner try
   ↓
Exception
   ↓
Inner catch
   ↓
Can it handle?
 ↙        ↘
YES       NO
 ↓         ↓
Handle    Outer catch
          ↓
       Can it handle?
```

Java searches outward until it finds a suitable exception handler.

---

### 17. Inner Catch vs Outer Catch

| Inner `catch`                                   | Outer `catch`                                        |
| ----------------------------------------------- | ---------------------------------------------------- |
| Closest to inner `try`                          | Belongs to outer `try`                               |
| Checked first for an exception from inner `try` | Can be considered if exception is not handled inside |
| Handles the inner operation's exception         | Can handle exceptions that propagate outward         |

---

### 18. Real-World ATM Example

Imagine:

```text
BankApp
   ↓
Bank
   ↓
ATM transaction
```

Inside an ATM transaction, there may be another smaller risky operation:

```text
ATM transaction
   ↓
PIN verification
```

The PIN verification can have its own `try-catch`.

If the PIN problem is handled there:

```text
Inner catch
```

the outer ATM transaction does not need to handle that same exception.

If another exception is not handled there, it can move outward:

```text
Inner try
 ↓
Inner catch cannot handle
 ↓
Outer catch
```

---

### 19. Nested Structure to Remember

```java
try {                         // Outer try

    try {                     // Inner try

        // risky code

    }
    catch (Exception e) {     // Inner catch

        // handle inner exception
    }

}
catch (Exception e) {         // Outer catch

    // handle propagated exception
}
```

Remember the structure:

```text
Outer try
 ├── Inner try
 │    └── Inner catch
 │
 └── Outer catch
```

---

### 20. Common Confusion

Do not think that the outer `catch` always executes after the inner `catch`.

It does not.

If the inner `catch` handles the exception:

```text
Exception
 ↓
Inner catch handles
 ↓
Outer catch skipped
```

---

### 21. Common Confusion — Both Catches Do Not Handle the Same Exception

Suppose:

```text
Inner catch handles exception
```

The same exception is not automatically sent to the outer `catch`.

Once the exception has been handled, normal execution can continue according to the control flow.

---

### 22. Common Mistake

Do not assume that any `catch` can handle any exception.

For example:

```java
catch (ArithmeticException e)
```

handles an `ArithmeticException`, not every possible exception.

The exception type must be compatible with the exception being thrown.

---

### 23. Important Rule

For an exception occurring inside the inner `try`:

```text
First check inner catch
        ↓
If not handled
        ↓
Look outward
        ↓
Outer catch
        ↓
If still not handled
        ↓
Continue propagating
```

This follows the method/exception handling hierarchy.

---

### 24. Nested `try` Without Inner `catch`

An inner `try` can also participate in outer handling.

Example:

```java
class Demo {

    public static void main(String[] args) {

        try {

            try {

                int result = 10 / 0;

            }

        }
        catch (ArithmeticException e) {

            System.out.println("Outer catch handled exception");

        }

    }
}
```

Here, the inner `try` does not have its own `catch`.

The exception can be handled by the outer `catch`.

---

### 25. Flow of That Example

```text
Outer try
 ↓
Inner try
 ↓
10 / 0
 ↓
ArithmeticException
 ↓
No inner catch
 ↓
Outer catch
 ↓
Exception handled
```

---

### 26. Why Use Nested `try-catch`?

It is useful when different parts of a larger operation need different exception handling.

For example:

```text
Large operation
 ↓
 ├── File operation
 │      ↓
 │   own handling
 │
 └── Database operation
        ↓
     own handling
```

It gives the programmer more control over where different problems are handled.

---

### 27. Important Rules

* A nested `try-catch` means a `try-catch` exists inside another `try`.
* The inner `try` handles a smaller section of risky code.
* The inner `catch` is checked first for an exception occurring in the inner `try`.
* If the inner `catch` can handle the exception, it handles it.
* If the inner `catch` cannot handle it, the exception can propagate outward.
* The outer `catch` can handle a suitable exception that reaches the outer level.
* The outer `catch` does not automatically execute when the inner `catch` handles the exception.
* Exception handling proceeds outward until a suitable handler is found.
* If no suitable handler exists, the exception can eventually reach the default exception handler.

---

### 28. Simple Memory Formula

```text
Inner problem
     ↓
Inner catch
     ↓
Can handle?
 ↙       ↘
YES      NO
 ↓        ↓
Handle   Outer catch
          ↓
        Handle
```

Remember:

> **"First look nearby; if nobody can handle it, go outward."**

---

### 29. Interview Understanding

A good explanation is:

> **Nested `try-catch` means placing one `try-catch` inside another `try` block. When an exception occurs in the inner `try`, Java first looks for a suitable inner `catch`. If the exception is not handled there, it can propagate outward and be handled by a suitable outer `catch`.**

---

### 30. Complete Example

```java
class Demo {

    public static void main(String[] args) {

        try {

            System.out.println("Outer try started");

            try {

                int[] arr = {10, 20, 30};

                System.out.println(arr[5]);

            }
            catch (ArithmeticException e) {

                System.out.println("Inner catch");

            }

            System.out.println("Outer try completed");

        }
        catch (ArrayIndexOutOfBoundsException e) {

            System.out.println("Outer catch handled array exception");

        }

        System.out.println("Program Ends");

    }
}
```

Flow:

```text
main()
 ↓
Outer try
 ↓
Inner try
 ↓
arr[5]
 ↓
ArrayIndexOutOfBoundsException
 ↓
Inner catch checked
 ↓
Inner catch cannot handle it
 ↓
Exception moves outward
 ↓
Outer catch matches
 ↓
Outer catch handles exception
 ↓
Program Ends
```

---

### 31. Important Difference From Normal `try-catch`

Normal:

```text
try
 ↓
catch
```

Nested:

```text
outer try
 ↓
inner try
 ↓
inner catch
 ↓
outer catch
```

The nested structure provides multiple levels at which an exception can be handled.

---

### 32. What Happens If No Catch Handles It?

Suppose:

```text
Inner try
 ↓
Inner catch cannot handle
 ↓
Outer catch cannot handle
 ↓
Exception continues propagating
 ↓
Default Exception Handler
```

If no suitable handler is found, the program can terminate abnormally.

---

### 33. Beginner Memory Example

Imagine two safety nets:

```text
Small safety net
       ↓
Inner catch

Large safety net
       ↓
Outer catch
```

The inner safety net gets the first chance.

If it cannot handle the problem, the outer safety net can catch it.

```text
Exception
   ↓
Inner catch
   ↓
Not handled
   ↓
Outer catch
```

---

### 34. Key Terms

| Term          | Meaning                               |
| ------------- | ------------------------------------- |
| Nested        | Something placed inside another thing |
| Inner `try`   | `try` inside another `try`            |
| Inner `catch` | Handler associated with inner `try`   |
| Outer `try`   | The surrounding `try`                 |
| Outer `catch` | Handler associated with outer `try`   |
| Propagation   | Moving an unhandled exception outward |
| Handler       | Code that handles an exception        |

---

### 35. Memory Trick

Remember these three words:

```text
NEAR → INNER → OUTER
```

When an exception occurs:

```text
Exception
 ↓
Nearest suitable catch
 ↓
If unavailable
 ↓
Outer suitable catch
 ↓
If unavailable
 ↓
Further propagation
```

---

### 36. Complete Lifetime Understanding

```text
                         main()
                           ↓
                       Outer try
                           ↓
                       Inner try
                           ↓
                    Risky operation
                           ↓
                    Exception occurs
                           ↓
                  Check Inner catch
                     ↙          ↘
                   YES           NO
                    ↓             ↓
              Handle it      Propagate outward
                    ↓             ↓
                    ↓        Check Outer catch
                    ↓          ↙       ↘
                    ↓        YES        NO
                    ↓         ↓          ↓
                    ↓      Handle    Propagate
                    ↓                    ↓
                    └──────────┬─────────┘
                               ↓
                         Program flow
```

**Core memory rule:**

> **In nested `try-catch`, an exception is first given to the nearest suitable `catch`. If that handler cannot handle it, the exception can move outward to the outer `catch`.**
