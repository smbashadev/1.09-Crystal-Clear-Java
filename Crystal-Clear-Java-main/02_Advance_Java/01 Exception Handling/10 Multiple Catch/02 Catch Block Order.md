# 🧒 10.2 Catch Block Order

### 1. The Basic Idea

When a Java program uses multiple `catch` blocks, **the order of those `catch` blocks matters**.

Java checks the `catch` blocks **from top to bottom**.

Therefore, we should place:

```text
Specific exception
        ↓
General exception
```

The specific handlers come first, and the general `Exception` handler comes at the end.

---

### 2. What Is a Specific Exception?

A specific exception is an exception class that represents a particular type of problem.

For example:

```java
ArithmeticException
```

represents an arithmetic-related problem.

Another example:

```java
ArrayIndexOutOfBoundsException
```

represents an invalid array index problem.

These are more specific than the general:

```java
Exception
```

---

### 3. What Is a General Exception?

`Exception` is a **general exception class**.

It can represent many different exception situations.

For example:

```java
catch (Exception e)
```

is a broad handler.

It is like saying:

> "If an exception reaches here and no earlier specific handler has handled it, I can handle it."

---

### 4. Simple Real-World Example

Imagine a hospital has these doctors:

```text
Heart specialist
Eye specialist
General doctor
```

Suppose a patient has a heart problem.

We should first send the patient to:

```text
Heart specialist
```

not directly to:

```text
General doctor
```

Similarly, Java should check the specific exception handler before the general handler.

```text
Specific handler
       ↓
General handler
```

---

### 5. Connecting This to Java

Suppose we have:

```java
try {
    int result = 10 / 0;
}
```

This produces:

```text
ArithmeticException
```

We can provide:

```java
catch (ArithmeticException e) {
    System.out.println("Cannot divide by zero");
}
```

And then:

```java
catch (Exception e) {
    System.out.println("Some other exception occurred");
}
```

The specific handler is placed first.

---

### 6. Why Must Specific Handlers Come First?

Java checks catch blocks from top to bottom.

If a general handler comes first:

```java
catch (Exception e)
```

it can already handle an `ArithmeticException`.

Therefore, Java would never get a chance to reach:

```java
catch (ArithmeticException e)
```

The specific handler would become unreachable.

So Java requires the more specific handler to appear first.

---

### 7. Understanding the Exception Hierarchy

Think of the relationship like this:

```text
             Throwable
                 |
             Exception
                 |
        ArithmeticException
```

`Exception` is more general.

`ArithmeticException` is more specific.

Therefore:

```text
ArithmeticException
        ↓
More specific

Exception
        ↓
More general
```

---

### 8. Correct Order

The correct order is:

```java
try {

    int result = 10 / 0;

}
catch (ArithmeticException e) {

    System.out.println("Cannot divide by zero");

}
catch (Exception e) {

    System.out.println("Some other exception occurred");

}
```

Here:

```text
ArithmeticException
        ↓
Specific handler
        ↓
First
```

and:

```text
Exception
        ↓
General handler
        ↓
Last
```

---

### 9. Simple Example

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
        catch (Exception e) {

            System.out.println("Some exception occurred");

        }

        System.out.println("Program Ends");
    }
}
```

Output:

```text
Cannot divide by zero
Program Ends
```

---

### 10. Understanding the Program

The program first enters:

```java
try
```

Then:

```java
int a = 10;
```

creates an integer variable containing `10`.

Next:

```java
int b = 0;
```

creates another integer variable containing `0`.

Then:

```java
int result = a / b;
```

tries to calculate:

```text
10 / 0
```

This produces:

```text
ArithmeticException
```

---

### 11. How Java Checks the Catch Blocks

Java now checks:

```java
catch (ArithmeticException e)
```

The exception is:

```text
ArithmeticException
```

So there is a match.

Java executes:

```java
System.out.println("Cannot divide by zero");
```

It does **not** execute the next:

```java
catch (Exception e)
```

because the exception has already been handled.

---

### 12. Execution Flow

The complete flow is:

```text
main()
  ↓
try
  ↓
10 / 0
  ↓
ArithmeticException
  ↓
Check ArithmeticException catch
  ↓
Match found
  ↓
Print "Cannot divide by zero"
  ↓
Skip remaining catch blocks
  ↓
Print "Program Ends"
```

---

### 13. What Happens If Another Exception Occurs?

Suppose the `try` block produces an exception that is not specifically handled.

Then Java continues checking the later catch blocks.

For example:

```java
try {

    // some risky operation

}
catch (ArithmeticException e) {

    // specific handler

}
catch (Exception e) {

    // general handler

}
```

If an exception compatible with `ArithmeticException` occurs, the first handler is used.

If another exception occurs that is compatible with the general `Exception` handler, the general handler can handle it.

---

### 14. Incorrect Order

Consider:

```java
try {

    int result = 10 / 0;

}
catch (Exception e) {

    System.out.println("General exception");

}
catch (ArithmeticException e) {

    System.out.println("Arithmetic problem");

}
```

This is incorrect.

Why?

Because:

```text
Exception
```

is general enough to catch:

```text
ArithmeticException
```

The later specific handler can therefore never be reached for an `ArithmeticException`.

Java reports a compile-time error because the later catch block is unreachable.

---

### 15. Correcting the Order

Move the specific handler before the general handler:

```java
try {

    int result = 10 / 0;

}
catch (ArithmeticException e) {

    System.out.println("Arithmetic problem");

}
catch (Exception e) {

    System.out.println("General exception");

}
```

Now the order is:

```text
ArithmeticException
        ↓
Specific
        ↓
Exception
        ↓
General
```

This is correct.

---

### 16. Multiple Specific Exceptions

We can have several specific exception handlers before the general handler.

Example:

```java
try {

    // risky code

}
catch (ArithmeticException e) {

    System.out.println("Arithmetic problem");

}
catch (ArrayIndexOutOfBoundsException e) {

    System.out.println("Invalid array index");

}
catch (Exception e) {

    System.out.println("Some other exception occurred");

}
```

The order is:

```text
ArithmeticException
        ↓
Specific

ArrayIndexOutOfBoundsException
        ↓
Specific

Exception
        ↓
General
```

---

### 17. Why `Exception` Comes at the End

Think of `Exception` as a **large umbrella**.

Specific exception classes are smaller categories underneath it.

```text
              Exception
             /         \
            /           \
 ArithmeticException   Other exceptions
```

If we put the umbrella first, it can cover the problem before the specific handler gets a chance.

Therefore:

```text
Specific
   ↓
General
```

---

### 18. Understanding "General Exception Reference"

When we write:

```java
catch (Exception e)
```

`e` is a reference variable.

`Exception` is the type of that reference.

It allows the catch block to handle exceptions that are compatible with the `Exception` type.

Example:

```java
catch (Exception e) {
    System.out.println("An exception occurred");
}
```

This is a general-purpose handler.

---

### 19. Real-World ATM Example

Imagine an ATM application.

There can be specific problems:

```text
Wrong PIN
     ↓
PIN-related handling
```

```text
Insufficient balance
     ↓
Balance-related handling
```

```text
Invalid amount
     ↓
Amount-related handling
```

Then there can be a general problem handler:

```text
Unexpected problem
     ↓
General handling
```

The application should first try to identify and handle the specific problem.

The general handler should be the final safety net.

---

### 20. Java ATM-Style Example

```java
try {

    int balance = 5000;
    int withdrawal = 6000;

    int remaining = balance - withdrawal;

    if (remaining < 0) {
        throw new Exception("Insufficient balance");
    }

}
catch (ArithmeticException e) {

    System.out.println("Arithmetic problem");

}
catch (Exception e) {

    System.out.println(e.getMessage());

}
```

The specific `ArithmeticException` handler comes first.

The general `Exception` handler comes afterward.

---

### 21. Important Rule

The most important rule is:

> **Specific exception handlers must come before general exception handlers.**

Remember:

```text
Specific
   ↓
General
```

Never reverse this order when the specific type is covered by the general type.

---

### 22. Another Exception Hierarchy Example

Consider:

```text
Exception
   |
   +--- RuntimeException
           |
           +--- ArithmeticException
           |
           +--- NullPointerException
           |
           +--- ArrayIndexOutOfBoundsException
```

The more deeply specialized exception should be handled before its parent/general type.

For example:

```java
catch (ArithmeticException e) {

}

catch (RuntimeException e) {

}

catch (Exception e) {

}
```

This follows:

```text
ArithmeticException
        ↓
RuntimeException
        ↓
Exception
```

---

### 23. Common Mistake — General First

Wrong:

```java
catch (Exception e) {

}
catch (ArithmeticException e) {

}
```

Correct:

```java
catch (ArithmeticException e) {

}
catch (Exception e) {

}
```

The difference is simply the order, but that order is extremely important.

---

### 24. Common Mistake — Thinking Catch Order Does Not Matter

A beginner may think:

> "Java can simply look at all the catch blocks and choose the correct one."

Java does not work that way.

It checks them in order.

Therefore, the order must be designed correctly.

```text
Top
 ↓
First catch
 ↓
Second catch
 ↓
Third catch
 ↓
...
```

---

### 25. Common Mistake — Putting `Exception` Everywhere

It is technically possible to use:

```java
catch (Exception e)
```

as a general handler.

But if we always use only a general handler, we lose the opportunity to give specific handling to different problems.

Better:

```java
catch (ArithmeticException e) {
    System.out.println("Cannot divide by zero");
}
catch (Exception e) {
    System.out.println("Some other problem occurred");
}
```

---

### 26. Specific vs General

| Specific Handler                    | General Handler                      |
| ----------------------------------- | ------------------------------------ |
| Handles a particular exception type | Handles a broad group of exceptions  |
| More precise                        | More general                         |
| Should come first                   | Should come later                    |
| Can provide specific handling       | Can provide common/fallback handling |

Example:

```java
catch (ArithmeticException e)
```

is specific.

```java
catch (Exception e)
```

is general.

---

### 27. Catch Order With Three Levels

Consider:

```java
catch (ArithmeticException e) {

}
catch (RuntimeException e) {

}
catch (Exception e) {

}
```

The order is:

```text
ArithmeticException
       ↓
Most specific

RuntimeException
       ↓
More general

Exception
       ↓
Most general
```

This follows the hierarchy from specific to general.

---

### 28. What Happens After a Catch Handles the Exception?

Once the appropriate catch block executes, Java does not continue checking the remaining catch blocks.

For example:

```java
catch (ArithmeticException e) {
    System.out.println("Arithmetic problem");
}

catch (Exception e) {
    System.out.println("General problem");
}
```

If `ArithmeticException` occurs:

```text
Arithmetic catch executes
        ↓
General catch is skipped
        ↓
Continue after catch structure
```

---

### 29. Complete Example With Multiple Exceptions

```java
class Demo {

    public static void main(String[] args) {

        try {

            int[] numbers = {10, 20, 30};

            System.out.println(numbers[5]);

        }
        catch (ArrayIndexOutOfBoundsException e) {

            System.out.println("Invalid array index");

        }
        catch (ArithmeticException e) {

            System.out.println("Arithmetic problem");

        }
        catch (Exception e) {

            System.out.println("Some other exception occurred");

        }

        System.out.println("Program Ends");
    }
}
```

The array exception is specific.

The arithmetic exception is also specific.

The `Exception` catch is the general handler.

So:

```text
Specific handlers
       ↓
General handler
```

---

### 30. Complete Execution Flow

For the array example:

```text
Program starts
      ↓
try block starts
      ↓
Array created
      ↓
numbers[5] accessed
      ↓
ArrayIndexOutOfBoundsException
      ↓
Check ArrayIndexOutOfBoundsException catch
      ↓
Match found
      ↓
Print "Invalid array index"
      ↓
Skip remaining catch blocks
      ↓
Print "Program Ends"
      ↓
Program finishes normally
```

---

### 31. Important Rules

Keep these rules firmly in mind:

1. Multiple catch blocks are checked from top to bottom.
2. Specific handlers should appear before general handlers.
3. `Exception` is a general exception type.
4. `catch (Exception e)` should normally be placed after specific handlers.
5. Once a compatible catch is found, that handler executes.
6. Remaining catch blocks are skipped.
7. An unreachable catch block causes a compile-time error.
8. The exception hierarchy determines which types are more general or specific.

---

### 32. Easy Way to Remember the Hierarchy

Imagine folders on your computer.

A large folder can contain many smaller folders.

```text
Exception
   ↓
RuntimeException
   ↓
ArithmeticException
```

`Exception` is the larger category.

`ArithmeticException` is a smaller, more specific category.

Therefore:

```text
Small category
      ↓
Large category
```

In catch blocks:

```text
Specific
   ↓
General
```

---

### 33. Common Confusion

Do not confuse:

```text
Exception occurrence
```

with:

```text
Exception handler order
```

The exception itself has its own type.

For example:

```text
10 / 0
 ↓
ArithmeticException
```

Then Java uses the catch order to find a compatible handler.

So there are two separate ideas:

```text
What problem happened?
        ↓
Exception type

Which handler should handle it?
        ↓
Catch block order
```

---

### 34. Professional Coding Pattern

A commonly useful structure is:

```java
try {

    // risky code

}
catch (SpecificException1 e) {

    // specific handling

}
catch (SpecificException2 e) {

    // specific handling

}
catch (Exception e) {

    // general/fallback handling

}
```

This gives the program a clear handling structure.

The specific problems receive special treatment.

The general handler catches remaining compatible exceptions.

---

### 35. Memory Trick

Remember this sentence:

> **"Small first, big last."**

Here:

```text
Small = Specific exception
Big   = General exception
```

Therefore:

```text
Specific
   ↓
More general
   ↓
Most general
```

Or simply:

> **Specific first, `Exception` last.**

---

### 36. Complete Lifetime Understanding

The entire concept can be remembered through this flow:

```text
                 try
                  ↓
              Risky code
                  ↓
            Exception occurs
                  ↓
          Identify exception type
                  ↓
        Catch blocks checked in order
                  ↓
        ┌─────────┴─────────┐
        ↓                   ↓
   Specific catch       General catch
        ↓                   ↓
   Try this first       Use as fallback
        ↓                   ↓
      Match?              If needed
        ↓                   ↓
     Handle             Handle
        └─────────┬─────────┘
                  ↓
           Continue program
```

The most important picture is:

```text
        CATCH BLOCK ORDER

   Most Specific Exception
              ↓
      Less Specific Exception
              ↓
        General Exception
              ↓
          Exception
```

### Lifetime Rule

> **Always arrange related catch blocks from specific to general. Put the general `Exception` handler at the end.**

Example:

```java
try {

    // risky code

}
catch (ArithmeticException e) {

    System.out.println("Arithmetic problem");

}
catch (RuntimeException e) {

    System.out.println("Runtime problem");

}
catch (Exception e) {

    System.out.println("General exception");

}
```

The idea is very simple:

**Java looks from top to bottom, so give the most specific handler the first chance to handle the problem, and keep the general `Exception` handler as the final safety net.**
