# 🧒 14.1 `try` + `catch`

### 1. Basic Idea

`try` and `catch` are used together to **handle an exception**.

The basic structure is:

```java
try {
    // code
}
catch (exception e) {
    // code
}
```

The `try` block contains the code where an exception **may occur**.

The `catch` block contains the code that **handles the exception**.

---

### 2. Why Do We Use `try` + `catch`?

Without exception handling, an exception can cause the program to terminate abruptly.

With `try` + `catch`:

```text
Risky code
    ↓
Exception occurs
    ↓
catch handles it
    ↓
Program can continue
```

---

### 3. Simple Real-World Example

Imagine you are carrying a glass.

You know:

> "The glass might fall."

You keep a safety arrangement ready.

Similarly:

```text
try
 ↓
Perform risky operation

catch
 ↓
Handle the problem if it occurs
```

`try` means:

> "Try this code."

`catch` means:

> "If the expected exception occurs, handle it here."

---

### 4. `try` Block

The keyword:

```java
try
```

starts the `try` block.

Example:

```java
try {
    int result = 10 / 0;
}
```

The code inside the `try` block is the code where an exception may occur.

---

### 5. Curly Braces `{ }`

The curly braces define the body of the `try` block:

```java
try {
    // code
}
```

Everything between `{` and `}` belongs to the `try` block.

---

### 6. Exception-Producing Code

Usually, we place the code that may produce an exception inside `try`.

Example:

```java
try {
    int result = 10 / 0;
}
```

Here:

```text
10 / 0
```

causes:

```text
ArithmeticException
```

---

### 7. `catch` Block

The keyword:

```java
catch
```

is used to handle an exception thrown from the associated `try` block.

Structure:

```java
catch (exception e) {
    // handling code
}
```

---

### 8. `exception`

The word:

```java
exception
```

in your basic structure represents the **exception type**.

In actual Java code, we normally write a specific exception class, such as:

```java
ArithmeticException
```

Example:

```java
catch (ArithmeticException e) {
}
```

---

### 9. What Is `e`?

The variable:

```java
e
```

is a reference variable that refers to the exception object caught by the `catch` block.

For example:

```java
catch (ArithmeticException e)
```

means:

```text
ArithmeticException → type
e                  → reference to exception object
```

---

### 10. Exception Object

When an exception occurs, Java creates an exception object.

For example:

```java
int result = 10 / 0;
```

causes Java to create an:

```text
ArithmeticException object
```

The exception object is then made available to the `catch` block through `e`.

```text
Exception occurs
      ↓
Exception object
      ↓
catch (ArithmeticException e)
      ↓
e refers to that object
```

---

### 11. Simple Java Example

```java
class Demo {

    public static void main(String[] args) {

        try {

            int result = 10 / 0;

            System.out.println(result);

        }
        catch (ArithmeticException e) {

            System.out.println("Cannot divide by zero");

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

### 12. Explain the Code

The program starts from:

```java
public static void main(String[] args)
```

Then Java enters:

```java
try
```

and executes:

```java
int result = 10 / 0;
```

Division by zero causes:

```text
ArithmeticException
```

The remaining statements inside `try` are skipped.

Java searches for a suitable `catch`.

It finds:

```java
catch (ArithmeticException e)
```

So the exception is handled there.

Then:

```java
System.out.println("Program Ends");
```

executes.

---

### 13. Execution Flow

```text
main()
  ↓
try block starts
  ↓
10 / 0
  ↓
ArithmeticException occurs
  ↓
Exception object created
  ↓
try block stops
  ↓
catch block searched
  ↓
ArithmeticException matches
  ↓
catch executes
  ↓
"Cannot divide by zero"
  ↓
try-catch finishes
  ↓
"Program Ends"
```

---

### 14. What Happens to the Remaining `try` Code?

Consider:

```java
try {

    int result = 10 / 0;

    System.out.println("Hello");

}
catch (ArithmeticException e) {

    System.out.println("Exception handled");

}
```

`Hello` is **not printed**.

Why?

Because the exception occurs before:

```java
System.out.println("Hello");
```

Once the exception occurs, normal execution of that `try` block stops.

---

### 15. `catch` Executes Only When Needed

If no exception occurs:

```java
try {

    int result = 10 / 2;

    System.out.println(result);

}
catch (ArithmeticException e) {

    System.out.println("Exception handled");

}
```

Output:

```text
5
```

The `catch` block does not execute because no exception occurred.

---

### 16. Two Possible Paths

```text
                 try
                  ↓
             Code executes
                  ↓
          ┌───────┴────────┐
          ↓                ↓
   No exception       Exception occurs
          ↓                ↓
   Continue normally   catch executes
          ↓                ↓
          └───────┬────────┘
                  ↓
             Continue program
```

---

### 17. Important Rule

The `catch` block is associated with its `try` block.

Correct:

```java
try {
    // risky code
}
catch (ArithmeticException e) {
    // handling code
}
```

The `catch` cannot normally appear independently without an associated `try`.

---

### 18. The Exception Type Must Match

Suppose the exception is:

```text
ArithmeticException
```

Then this can handle it:

```java
catch (ArithmeticException e)
```

A broader handler can also handle it:

```java
catch (Exception e)
```

because:

```text
ArithmeticException
       ↓
RuntimeException
       ↓
Exception
```

---

### 19. Using `Exception e`

You can write:

```java
try {

    int result = 10 / 0;

}
catch (Exception e) {

    System.out.println("Exception handled");

}
```

This works because `Exception` is a parent class of `ArithmeticException`.

However, a specific exception type often gives clearer information.

---

### 20. Specific vs General Handler

Specific:

```java
catch (ArithmeticException e)
```

General:

```java
catch (Exception e)
```

Specific handling tells the reader exactly what problem is being handled.

General handling can handle many exception types.

---

### 21. Using `e.getMessage()`

The exception reference can be used to obtain information about the exception.

Example:

```java
catch (ArithmeticException e) {

    System.out.println(e.getMessage());

}
```

For division by zero, the message may describe the arithmetic problem.

The exact message can depend on the Java runtime.

---

### 22. Using `e.printStackTrace()`

You can also write:

```java
catch (ArithmeticException e) {

    e.printStackTrace();

}
```

This prints information useful for understanding where the exception occurred.

It is especially useful during debugging.

---

### 23. Important Difference: `try` Does Not Fix the Exception

A common misunderstanding is:

> "`try` prevents the exception."

It does not.

`try` only identifies the code whose exception can be handled.

For example:

```java
try {
    int result = 10 / 0;
}
```

The exception still occurs.

The `catch` block handles it.

```text
try
 ↓
Exception occurs
 ↓
catch
 ↓
Handle exception
```

---

### 24. Real-World Example: ATM

Suppose an ATM performs a transaction.

```text
try
 ↓
Process transaction
 ↓
Problem occurs
 ↓
catch
 ↓
Display transaction error
```

The ATM does not pretend that the problem never happened.

It handles the problem properly so the application does not terminate unexpectedly.

---

### 25. Real-World Example: File

Suppose Java tries to read a file.

```text
try
 ↓
Read file
 ↓
File problem
 ↓
catch
 ↓
Display appropriate message
```

The exception-handling structure allows the program to respond to the problem instead of simply stopping.

---

### 26. Common Mistake

Do not put unrelated code outside the `try` when that code itself may cause the exception you want to handle.

For example:

```java
int result = 10 / 0;

try {
    System.out.println(result);
}
catch (ArithmeticException e) {
    System.out.println("Handled");
}
```

The division occurs **before** the `try` block.

Therefore, this `try-catch` does not protect that division.

Correct:

```java
try {
    int result = 10 / 0;
}
catch (ArithmeticException e) {
    System.out.println("Handled");
}
```

---

### 27. Common Confusion

Do not think both blocks always execute.

If no exception occurs:

```text
try → executes
catch → skipped
```

If an exception occurs and matching `catch` exists:

```text
try → exception occurs
catch → executes
```

---

### 28. Common Confusion About `e`

This:

```java
catch (ArithmeticException e)
```

does not mean `e` is the exception class.

The class is:

```text
ArithmeticException
```

`e` is the reference variable.

It allows us to access information about the exception object.

---

### 29. Important Rules

* `try` contains code where an exception may occur.
* `catch` handles an exception from the associated `try`.
* `catch` contains an exception type.
* The variable such as `e` refers to the exception object.
* If no exception occurs, the `catch` block is skipped.
* If an exception occurs, normal execution of the `try` block stops from that point.
* Java searches for a matching `catch`.
* A specific exception handler can handle its matching exception.
* A broader `Exception` handler can handle subclasses of `Exception`.
* Code after the `try-catch` can continue executing when the exception is handled.

---

### 30. Syntax to Remember

```java
try {

    // exception-producing code

}
catch (ExceptionType e) {

    // exception-handling code

}
```

Example:

```java
try {

    int result = 10 / 0;

}
catch (ArithmeticException e) {

    System.out.println("Cannot divide by zero");

}
```

---

### 31. Without `try-catch`

```java
class Demo {

    public static void main(String[] args) {

        int result = 10 / 0;

        System.out.println("Program Ends");

    }
}
```

The exception is not handled.

The program terminates abnormally before reaching:

```java
System.out.println("Program Ends");
```

---

### 32. With `try-catch`

```java
class Demo {

    public static void main(String[] args) {

        try {

            int result = 10 / 0;

        }
        catch (ArithmeticException e) {

            System.out.println("Exception handled");

        }

        System.out.println("Program Ends");

    }
}
```

Output:

```text
Exception handled
Program Ends
```

The important difference is that the exception is handled.

---

### 33. Interview Understanding

`try-catch` is a mechanism for handling exceptions.

A strong understanding is:

```text
try
 ↓
Contains risky/exception-producing code

catch
 ↓
Receives and handles a matching exception

After catch
 ↓
Program can continue
```

The key point is that `try` and `catch` work together.

---

### 34. Memory Trick

Remember:

```text
TRY → Try the risky work
CATCH → Catch the problem
```

Or:

```text
TRY
  ↓
Problem?
  ↓
CATCH
  ↓
Handle
```

---

### 35. One Complete Example in Memory

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

        System.out.println("Program Ends");

    }
}
```

Flow:

```text
a = 10
 ↓
b = 0
 ↓
a / b
 ↓
ArithmeticException
 ↓
catch
 ↓
"Cannot divide by zero"
 ↓
"Program Ends"
```

---

### 36. Complete Lifetime Understanding

```text
                    try
                     ↓
          Put risky code inside
                     ↓
              Code executes
                     ↓
             Exception occurs?
                ↙          ↘
              NO            YES
               ↓              ↓
       Continue try       Exception object
       normally              created
               ↓              ↓
               ↓        try execution stops
               ↓              ↓
               ↓        Matching catch found
               ↓              ↓
               ↓        catch receives `e`
               ↓              ↓
               ↓        Exception handled
               ↓              ↓
               └──────┬───────┘
                      ↓
               Continue program
```

**Core memory rule:**

```text
try   → contains exception-producing/risky code
catch → handles the exception
e     → reference to the exception object
```

The complete idea is:

> **Put potentially problematic code inside `try`. If an exception occurs, Java transfers control to a matching `catch`, where the exception can be handled, after which the program can continue normally.**
