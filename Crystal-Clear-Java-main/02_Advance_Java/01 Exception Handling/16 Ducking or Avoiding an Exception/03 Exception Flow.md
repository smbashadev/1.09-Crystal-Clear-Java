# 🧒 16.3 Exception Flow

### 1. Basic Idea

When a method **ducks an exception**, it does not handle the exception itself.

Instead, the exception moves to the **caller method**.

```text
Current Method
      ↓
Exception occurs
      ↓
Current method ducks it
      ↓
Caller method
```

---

### 2. Simple Example

Suppose there are three methods:

```text
main()
  ↓
fun1()
  ↓
fun2()
```

If `fun2()` gets an exception and ducks it:

```text
fun2()
  ↓
throws
  ↓
fun1()
```

Now `fun1()` has the responsibility.

---

### 3. Real-World Analogy

Imagine:

```text
Child
 ↓
Parent
 ↓
Grandparent
```

The child has a problem but does not solve it.

```text
Child
 ↓
Parent
```

If the parent also does not solve it:

```text
Child
 ↓
Parent
 ↓
Grandparent
```

The problem keeps moving upward until someone handles it.

Exception propagation works similarly.

---

### 4. Technical Meaning

When a method ducks an exception using `throws`, the **Runtime System (RTS)** looks at the caller method to find an appropriate exception handler.

The flow is:

```text
Exception occurs
      ↓
Current method
      ↓
No handler
      ↓
Caller method
      ↓
Handler check
```

---

### 5. What Is RTS?

**RTS** means **Runtime System**.

It is the part of Java's execution environment that manages what happens when an exception occurs.

For this topic, remember:

```text
Exception occurs
      ↓
RTS receives/controls the exception flow
      ↓
Looks for a handler
```

---

### 6. Method Ducks the Exception

Example:

```java
static void fun2() throws Exception {

    int result = 10 / 0;

}
```

Here `fun2()` does not use `try-catch`.

It declares:

```java
throws Exception
```

So `fun2()` is ducking the exception.

---

### 7. Caller Method

Suppose `fun1()` calls `fun2()`:

```java
static void fun1() throws Exception {

    fun2();

}
```

`fun1()` also does not handle the exception.

It also ducks it using:

```java
throws Exception
```

Now the responsibility moves further upward.

```text
fun2()
 ↓
fun1()
```

---

### 8. `main()` Can Finally Handle It

The `main()` method can handle the exception:

```java
public static void main(String[] args) {

    try {

        fun1();

    }
    catch (Exception e) {

        System.out.println("Exception handled");

    }

}
```

The complete flow becomes:

```text
main()
 ↓
fun1()
 ↓
fun2()
 ↓
Exception
 ↓
fun2() ducks
 ↓
fun1() ducks
 ↓
main() handles
```

---

### 9. Complete Java Example

```java
class Demo {

    static void fun2() throws Exception {

        System.out.println("fun2() started");

        int result = 10 / 0;

        System.out.println("fun2() completed");
    }

    static void fun1() throws Exception {

        System.out.println("fun1() started");

        fun2();

        System.out.println("fun1() completed");
    }

    public static void main(String[] args) {

        try {

            System.out.println("main() started");

            fun1();

            System.out.println("main() completed");

        }
        catch (Exception e) {

            System.out.println("Exception handled");

        }

        System.out.println("Program Ends");
    }
}
```

---

### 10. Expected Output

```text
main() started
fun1() started
fun2() started
Exception handled
Program Ends
```

Notice that these statements do **not** execute:

```java
System.out.println("fun2() completed");
```

```java
System.out.println("fun1() completed");
```

```java
System.out.println("main() completed");
```

because the exception interrupts the normal flow.

---

### 11. Execution Begins

The program starts with:

```java
main()
```

It prints:

```text
main() started
```

Then `main()` calls:

```java
fun1();
```

---

### 12. `fun1()` Executes

`fun1()` prints:

```text
fun1() started
```

Then it calls:

```java
fun2();
```

---

### 13. `fun2()` Executes

`fun2()` prints:

```text
fun2() started
```

Then this statement executes:

```java
int result = 10 / 0;
```

Division by zero produces:

```text
ArithmeticException
```

---

### 14. Exception Object

When the exception occurs, Java creates an exception object representing the problem.

Conceptually:

```text
10 / 0
 ↓
ArithmeticException
 ↓
Exception object
```

The Runtime System takes control of the exception flow.

---

### 15. RTS Checks `fun2()`

The exception occurred inside:

```text
fun2()
```

The RTS checks whether `fun2()` has a suitable handler.

There is no `catch` block in `fun2()`.

Instead:

```java
throws Exception
```

was declared.

So the exception moves toward the caller:

```text
fun2()
 ↓
fun1()
```

---

### 16. RTS Checks `fun1()`

Now the RTS checks `fun1()`.

`fun1()` also has no `catch`.

It has:

```java
throws Exception
```

Therefore, `fun1()` also ducks the exception.

The exception continues upward:

```text
fun2()
 ↓
fun1()
 ↓
main()
```

---

### 17. RTS Checks `main()`

Now the RTS reaches `main()`.

`main()` contains:

```java
try {

    fun1();

}
catch (Exception e) {

    System.out.println("Exception handled");

}
```

There is a suitable handler:

```java
catch (Exception e)
```

Therefore, the exception is handled here.

---

### 18. Exception Handling

The catch block executes:

```java
System.out.println("Exception handled");
```

Output:

```text
Exception handled
```

The exception has now been handled.

---

### 19. Program Continues

After the `catch` block:

```java
System.out.println("Program Ends");
```

executes.

Output:

```text
Program Ends
```

So the program finishes normally after handling the exception.

---

### 20. Complete Exception Flow

```text
                         main()
                           ↓
                         fun1()
                           ↓
                         fun2()
                           ↓
                       10 / 0
                           ↓
                  ArithmeticException
                           ↓
                      RTS receives
                           ↓
                    Check fun2()
                           ↓
                     No handler
                           ↓
                     fun2() throws
                           ↓
                    Check fun1()
                           ↓
                     No handler
                           ↓
                     fun1() throws
                           ↓
                    Check main()
                           ↓
                     Handler found
                           ↓
                    catch executes
                           ↓
                 Exception handled
                           ↓
                    Program Ends
```

---

### 21. Caller Can Handle

A caller can choose to handle the exception.

```java
static void fun1() throws Exception {

    fun2();

}

public static void main(String[] args) {

    try {

        fun1();

    }
    catch (Exception e) {

        System.out.println("Handled");

    }

}
```

Here:

```text
fun2()
 ↓
fun1() ducks
 ↓
main() handles
```

---

### 22. Caller Can Also Duck

The caller does not have to handle it immediately.

For example:

```java
static void fun1() throws Exception {

    fun2();

}
```

Here `fun1()` also ducks the exception.

So:

```text
fun2()
 ↓
throws
 ↓
fun1()
 ↓
throws
 ↓
caller
```

---

### 23. Multiple Levels of Ducking

There can be many methods:

```text
main()
 ↓
fun1()
 ↓
fun2()
 ↓
fun3()
 ↓
fun4()
```

Suppose `fun4()` produces an exception.

If every method ducks it:

```text
fun4()
 ↓
fun3()
 ↓
fun2()
 ↓
fun1()
 ↓
main()
```

The exception continues upward through the method hierarchy.

---

### 24. If `fun2()` Handles It

Suppose:

```text
fun3()
 ↓
exception
```

and `fun3()` has:

```java
catch (Exception e)
```

Then propagation stops there.

```text
fun3()
 ↓
catch
 ↓
handled
```

It does not need to continue upward to `fun2()`.

---

### 25. If No Caller Handles It

Suppose every method ducks the exception:

```text
fun3()
 ↓
fun2()
 ↓
fun1()
 ↓
main()
```

and no suitable handler is found.

Then the exception eventually reaches the **default exception handler**, and the program terminates abnormally.

---

### 26. Handler vs Ducking

```text
Method
 ↓
Exception
 ↓
Has handler?
 ↙       ↘
YES       NO
 ↓         ↓
catch     throws
 ↓         ↓
Handled   Caller
```

This is the central idea of exception flow.

---

### 27. Common Confusion

Do not think `throws` means:

> The exception is completely ignored.

It is not ignored.

The exception is being passed through the method hierarchy so that another method can handle it.

```text
throws
 ↓
responsibility moves
```

---

### 28. Common Confusion

Do not think the exception physically travels like a normal variable.

Instead, Java's Runtime System manages the exception propagation through the **call stack**.

```text
fun3()
 ↓
fun2()
 ↓
fun1()
 ↓
main()
```

The RTS searches these active method calls for a suitable handler.

---

### 29. Important Rules

* A method can duck an exception using `throws`.
* The current method does not handle the exception.
* The caller becomes responsible.
* The caller can handle the exception using `try-catch`.
* The caller can also duck it using `throws`.
* The exception can continue upward through several caller methods.
* The RTS searches for an appropriate exception handler.
* Once a suitable handler is found, propagation stops.
* If no suitable handler is found, the default exception handler takes over.
* An unhandled exception causes abnormal program termination.

---

### 30. Real-World Example

Consider:

```text
ATM
 ↓
Bank
 ↓
Bank Server
```

If the Bank Server has a problem:

```text
Bank Server
 ↓
does not handle
 ↓
Bank
```

If Bank also ducks it:

```text
Bank
 ↓
does not handle
 ↓
ATM
```

If ATM handles it:

```text
ATM
 ↓
catch
 ↓
Exception handled
```

This is similar to exception propagation through method callers.

---

### 31. Method Hierarchy Example

```text
main()
  |
  └── fun1()
        |
        └── fun2()
              |
              └── fun3()
```

If `fun3()` gets an exception:

```text
fun3()
 ↓
fun2()
 ↓
fun1()
 ↓
main()
```

The RTS checks each level until it finds a handler.

---

### 32. The Important Difference

**Ducking:**

```text
Current method
      ↓
throws
      ↓
Caller
```

**Handling:**

```text
Current method
      ↓
catch
      ↓
Exception handled
```

---

### 33. Memory Flow

Remember this sequence:

```text
Exception occurs
       ↓
Current method checked
       ↓
Handler?
   ↙        ↘
 YES         NO
  ↓           ↓
catch       throws
  ↓           ↓
Done       Caller checked
              ↓
          Handler?
          ↙      ↘
        YES       NO
         ↓         ↓
       catch     throws
                   ↓
                Next caller
```

---

### 34. Interview Understanding

**Exception propagation** is the process in which an exception moves from the method where it occurs toward its caller methods until a suitable exception handler is found.

When a method ducks an exception using `throws`, the caller can either **handle the exception** or **duck it further**, allowing the exception to continue upward through the method hierarchy.

---

### 35. Memory Trick

Remember:

```text
Ducks → Caller
Caller → Check
Handles → Stop
Ducks again → Continue upward
No handler → Default handler
```

Or:

```text
Exception
   ↓
Ducks
   ↓
Caller
   ↓
Ducks?
 ↙     ↘
YES     NO
 ↓       ↓
Up      Handle
```

---

### 36. Complete Lifetime Understanding

```text
                         EXCEPTION
                             ↓
                     Method where it occurs
                             ↓
                    Does method handle it?
                       ↙            ↘
                     YES             NO
                      ↓               ↓
                   catch           throws
                      ↓               ↓
                   HANDLED          Caller
                                      ↓
                             RTS checks caller
                                      ↓
                          Does caller handle it?
                              ↙            ↘
                            YES             NO
                             ↓               ↓
                          catch           throws
                             ↓               ↓
                          HANDLED       Next caller
                                             ↓
                                      RTS checks again
                                             ↓
                                     Handler found?
                                      ↙         ↘
                                    YES          NO
                                     ↓            ↓
                                  HANDLED    Default Exception
                                               Handler
                                                   ↓
                                      Abnormal termination
```

**Core memory rule:**

> **If a method ducks an exception, the RTS looks for a handler in its caller. The caller may handle it or duck it again. If every method ducks the exception and no handler is found, the exception eventually reaches the default exception handler.**
