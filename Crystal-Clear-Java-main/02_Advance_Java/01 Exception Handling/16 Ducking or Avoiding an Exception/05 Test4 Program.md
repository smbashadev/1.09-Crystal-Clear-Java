# 🧒 16.5 Test4 Program

### 1. Basic Idea

`Test4` demonstrates a very important exception flow:

```text
alpha()
   ↓
beta()
   ↓
Exception occurs
   ↓
beta() ducks
   ↓
alpha() ducks
   ↓
main() handles
```

Here `beta()` and `alpha()` use `throws Exception`, while `main()` uses `try-catch` to finally handle the exception.

---

### 2. Method Hierarchy

The method relationship is:

```text
main()
  ↓
alpha()
  ↓
beta()
```

So:

* `main()` calls `alpha()`
* `alpha()` calls `beta()`
* `beta()` produces an exception
* `beta()` does not handle it
* `alpha()` also does not handle it
* `main()` finally handles it

---

### 3. `beta()` Uses `throws`

The method can be written as:

```java
static void beta() throws Exception {
    
    // exception-producing code

}
```

This means `beta()` is **ducking the exception**.

It is telling its caller:

> "`beta()` may produce an exception. I am not handling it here."

---

### 4. `alpha()` Also Uses `throws`

`alpha()` calls `beta()`:

```java
static void alpha() throws Exception {

    beta();

}
```

Because `alpha()` does not handle the exception, it also declares:

```java
throws Exception
```

Therefore, the responsibility continues to `main()`.

---

### 5. `main()` Uses `try-catch`

Unlike `alpha()` and `beta()`, `main()` handles the exception:

```java
public static void main(String[] args) {

    try {

        alpha();

    }
    catch (Exception e) {

        System.out.println("Exception Handled");

    }

}
```

So the final responsibility ends in `main()`.

---

### 6. Complete Program

```java
class Test4 {

    static void beta() throws Exception {

        int result = 10 / 0;

    }

    static void alpha() throws Exception {

        beta();

    }

    public static void main(String[] args) {

        try {

            alpha();

        }
        catch (Exception e) {

            System.out.println("Exception Handled");

            e.printStackTrace();

        }

        System.out.println("Program Ends");

    }
}
```

---

### 7. Understanding `beta()`

Inside `beta()`:

```java
int result = 10 / 0;
```

The program attempts:

```text
10 ÷ 0
```

Division of an integer by zero produces:

```text
ArithmeticException
```

---

### 8. Exception Occurs in `beta()`

The flow starts:

```text
beta()
 ↓
10 / 0
 ↓
ArithmeticException
```

Java creates an exception object representing the problem.

The Runtime System then begins looking for a suitable exception handler.

---

### 9. Does `beta()` Handle It?

No.

`beta()` contains:

```java
throws Exception
```

but no:

```java
catch (...)
```

Therefore:

```text
beta()
 ↓
No handler
 ↓
throws
 ↓
alpha()
```

---

### 10. What Does `throws` Do Here?

This:

```java
static void beta() throws Exception
```

does **not** handle the exception.

It tells the caller:

```text
beta()
 ↓
"I am not handling this exception."
 ↓
"Caller, take responsibility."
```

---

### 11. `alpha()` Receives the Responsibility

`alpha()` calls:

```java
beta();
```

But `alpha()` also has:

```java
throws Exception
```

Therefore, `alpha()` also ducks the exception.

```text
beta()
 ↓
throws
 ↓
alpha()
 ↓
throws
 ↓
main()
```

---

### 12. Why Does `alpha()` Need `throws`?

Because `alpha()` calls a method that has:

```java
throws Exception
```

If `alpha()` does not handle the exception itself, it can pass the responsibility onward by declaring:

```java
throws Exception
```

---

### 13. `main()` Calls `alpha()`

The call is:

```java
alpha();
```

This is placed inside:

```java
try {

    alpha();

}
```

Therefore, `main()` is prepared to handle the exception.

---

### 14. `try` Block

The `try` block contains:

```java
try {

    alpha();

}
```

It means:

> Execute `alpha()`, but watch for an exception that may occur during this operation.

---

### 15. `catch` Block

The handler is:

```java
catch (Exception e) {

    System.out.println("Exception Handled");

    e.printStackTrace();

}
```

The important parts are:

```text
Exception → type of exception reference
e         → reference variable
```

The `catch` block receives the exception object.

---

### 16. `Exception Handled`

This statement:

```java
System.out.println("Exception Handled");
```

prints:

```text
Exception Handled
```

It tells us that the `catch` block has received control and is handling the exception.

---

### 17. `printStackTrace()`

The statement:

```java
e.printStackTrace();
```

prints information about the exception and its **stack trace**.

The stack trace helps us understand:

```text
What exception occurred?
Where did it occur?
Which methods were involved?
```

---

### 18. What Is a Stack Trace?

A stack trace is like a **map showing the path of method calls** that was active when the exception occurred.

In this program:

```text
main()
 ↓
alpha()
 ↓
beta()
```

The exception occurs in:

```text
beta()
```

So the stack trace provides information about that path.

---

### 19. Real-World Analogy for `printStackTrace()`

Imagine a delivery problem.

Instead of simply saying:

```text
"Delivery failed."
```

you provide the complete route:

```text
Warehouse
   ↓
Truck
   ↓
City
   ↓
Customer
   ↓
Problem occurred
```

That route helps find where the problem happened.

Similarly, `printStackTrace()` provides the method-call path associated with the exception.

---

### 20. Exception Flow

The complete flow is:

```text
main()
 ↓
alpha()
 ↓
beta()
 ↓
10 / 0
 ↓
ArithmeticException
 ↓
beta() has no catch
 ↓
throws
 ↓
alpha() has no catch
 ↓
throws
 ↓
main()
 ↓
catch(Exception e)
 ↓
Exception Handled
 ↓
printStackTrace()
 ↓
Program Ends
```

---

### 21. Why Does Propagation Stop at `main()`?

Because `main()` has:

```java
catch (Exception e)
```

This is a suitable general exception handler.

Therefore:

```text
alpha()
 ↓
beta()
 ↓
Exception
 ↓
main()
 ↓
catch found
 ↓
STOP PROPAGATION
```

The exception does not need to continue to the default handler.

---

### 22. `printStackTrace()` Does Not Handle the Exception

This is important.

The actual handling occurs because of:

```java
catch (Exception e)
```

`printStackTrace()` only **prints diagnostic information** about the exception.

```text
catch
 ↓
handles exception

printStackTrace()
 ↓
prints exception details
```

---

### 23. Output

The first custom message is:

```text
Exception Handled
```

Then:

```java
e.printStackTrace();
```

prints the exception details and stack-trace information.

Finally:

```text
Program Ends
```

is printed.

The exact stack-trace formatting can vary, but it will identify the `ArithmeticException` and the methods involved.

---

### 24. Why Does `Program Ends` Execute?

After the `catch` block finishes, execution continues with the statement after the `try-catch` structure:

```java
System.out.println("Program Ends");
```

Therefore:

```text
Exception occurs
 ↓
catch handles it
 ↓
catch finishes
 ↓
Program Ends
```

---

### 25. Normal Flow vs Exception Flow

**Normal method call:**

```text
main()
 ↓
alpha()
 ↓
beta()
 ↓
beta() completes
 ↓
alpha() completes
 ↓
main() continues
```

**Exception flow:**

```text
main()
 ↓
alpha()
 ↓
beta()
 ↓
Exception
 ↓
alpha() / beta() do not handle
 ↓
main() catch handles
```

---

### 26. Why Is This a Good Example of Ducking?

Because:

```text
beta()  → throws Exception
alpha() → throws Exception
main()  → try-catch
```

So the exception responsibility is passed through two methods and finally handled by the caller.

```text
beta()
 ↓
DUCK
 ↓
alpha()
 ↓
DUCK
 ↓
main()
 ↓
HANDLE
```

---

### 27. Common Confusion

Do not think:

```text
beta() throws
 ↓
Exception disappears
```

Correct:

```text
beta() throws
 ↓
Exception responsibility moves to alpha()
```

---

### 28. Common Confusion

Do not think:

```text
printStackTrace()
 ↓
handles exception
```

Correct:

```text
catch()
 ↓
handles exception

printStackTrace()
 ↓
prints diagnostic information
```

---

### 29. Common Confusion

Do not think that `throws Exception` means the method will definitely produce an exception.

It means:

> The method declares that an exception of that type may be passed to its caller.

In this particular program, an exception does occur because of:

```java
10 / 0
```

---

### 30. Important Rules

* `beta()` uses `throws Exception`.
* `alpha()` uses `throws Exception`.
* `beta()` does not handle the exception.
* `alpha()` does not handle the exception.
* The exception propagates toward `main()`.
* `main()` uses `try-catch`.
* `catch(Exception e)` handles the exception.
* `e` refers to the exception object.
* `printStackTrace()` prints exception and stack-trace information.
* After the `catch` block completes, `main()` continues.
* `Program Ends` therefore executes.

---

### 31. Method Responsibility

Think of responsibility moving upward:

```text
beta()
 ↓
"I won't handle it."
 ↓
alpha()
 ↓
"I won't handle it."
 ↓
main()
 ↓
"I will handle it."
```

---

### 32. Method Call vs Exception Direction

This is especially important:

```text
METHOD CALL:

main()
  ↓
alpha()
  ↓
beta()
```

But when the exception occurs:

```text
EXCEPTION PROPAGATION:

beta()
  ↓
alpha()
  ↓
main()
```

So the exception moves **back through the caller hierarchy**.

---

### 33. Interview Understanding

`Test4` demonstrates exception propagation using `throws`. `beta()` throws the exception to `alpha()`, and `alpha()` also ducks it using `throws Exception`. Finally, `main()` calls `alpha()` inside a `try` block and handles the propagated exception using `catch(Exception e)`. `printStackTrace()` then displays diagnostic information about the exception and the method-call path.

---

### 34. Easy Mental Picture

```text
              main()
                │
                │ try
                ↓
              alpha()
                │
                │ throws
                ↓
              beta()
                │
                │ throws
                ↓
          Exception occurs
                │
                ↑
              beta()
                ↑
              alpha()
                ↑
              main()
                │
                ↓
              catch
                │
                ↓
       printStackTrace()
                │
                ↓
          Program Ends
```

---

### 35. Memory Trick

Remember:

```text
beta()  → throws
alpha() → throws
main()  → catches
```

And:

```text
CALL:
main → alpha → beta

EXCEPTION:
beta → alpha → main → catch
```

---

### 36. Complete Lifetime Understanding

```text
                         main()
                           ↓
                    try block starts
                           ↓
                     calls alpha()
                           ↓
                         alpha()
                           ↓
                    calls beta()
                           ↓
                         beta()
                           ↓
                       10 / 0
                           ↓
                  ArithmeticException
                           ↓
                    Exception object
                           ↓
                         RTS
                           ↓
                  Check beta() handler
                           ↓
                      No catch
                           ↓
                    beta() throws
                           ↓
                  Check alpha() handler
                           ↓
                      No catch
                           ↓
                   alpha() throws
                           ↓
                   Return to main()
                           ↓
                 main() has catch block
                           ↓
                catch(Exception e)
                           ↓
                  Exception Handled
                           ↓
                 e.printStackTrace()
                           ↓
                 Stack-trace information
                           ↓
                    catch completes
                           ↓
                    Program Ends
                           ↓
                 Program terminates
                    normally
```

**Core memory rule:**

> **`beta()` and `alpha()` duck the exception using `throws`, allowing it to propagate upward. `main()` finally handles it with `try-catch`, and `printStackTrace()` displays the exception's diagnostic information.**
