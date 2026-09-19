# 🧒 6. `throw` Keyword

The `throw` keyword is used when **the programmer wants to deliberately send an exception object from one place to another**.

Before learning `throw`, remember these three ideas:

```text
Exception
   ↓
A problem represented by an exception object

try-catch
   ↓
Used to handle an exception

throw
   ↓
Used to deliberately throw an exception object
```

A very important point:

```text
throw  → actually throws an exception object
throws → declares that a method may pass an exception
```

---

# 🧒 6.1 Rethrowing an Exception

## 1. What Does "Rethrow" Mean?

Suppose an exception occurs.

A method catches it:

```java
catch (Exception e)
```

Normally, the method could handle the problem and finish.

But sometimes the method wants to say:

> "I saw this problem and did some work with it, but the caller also needs to know about it."

So the method can throw the **same exception object again**.

This is called **rethrowing an exception**.

```text
Exception occurs
      ↓
catch receives exception
      ↓
Exception is handled/processed
      ↓
throw the same exception again
      ↓
Caller receives it
```

---

# 🧒 6.2 What Is an Exception Object?

When Java encounters an exception, an object representing that exception is created.

For example:

```java
int result = 10 / 0;
```

Java detects that integer division by zero is not allowed.

An `ArithmeticException` object is created.

Conceptually:

```text
10 / 0
  ↓
ArithmeticException object
```

That object contains information about the problem.

We can store its reference in a variable:

```java
catch (Exception e)
```

Here:

```text
Exception = type
e         = reference variable
```

So:

```java
catch (Exception e)
```

means:

> "If an exception matching `Exception` is received, keep its reference in `e`."

---

# 🧒 6.3 What Does `catch` Do?

Consider:

```java
try {
    int result = 10 / 0;
}
catch (Exception e) {
    System.out.println("Exception handled");
}
```

The flow is:

```text
try
 ↓
10 / 0
 ↓
Exception occurs
 ↓
Exception object created
 ↓
catch receives it
 ↓
e refers to exception object
```

The `catch` block now has access to the exception through `e`.

---

# 🧒 6.4 What Does "Already Handled" Mean?

When we say:

> "The exception is already handled"

it means the exception has reached a `catch` block and the programmer has performed some action for it.

For example:

```java
catch (Exception e) {
    System.out.println("Problem occurred");
}
```

The exception has been caught.

But **caught does not always mean the exception must completely disappear**.

The programmer can catch it, perform some processing, and then rethrow it.

---

# 🧒 6.5 Why Would We Rethrow an Exception?

Imagine a large application.

There may be multiple layers:

```text
Application
    ↓
Bank
    ↓
ATM
    ↓
Transaction
```

Suppose the transaction layer detects an exception.

The transaction layer may want to:

1. Record the problem.
2. Print/log some information.
3. Perform cleanup.
4. Inform the Bank layer that the problem occurred.

Therefore, it can rethrow the exception.

```text
Transaction
     ↓
Exception
     ↓
catch
     ↓
Do some work
     ↓
throw again
     ↓
Bank
```

---

# 🧒 6.6 What Is the `throw` Keyword?

`throw` is a Java keyword.

It is used to explicitly throw an exception object.

Basic syntax:

```java
throw exceptionObject;
```

For example:

```java
throw e;
```

Here `e` must refer to an exception object that can be thrown.

Think of:

```java
throw e;
```

as:

> "Take this exception object and send it out from here."

---

# 🧒 6.7 Understanding `throw e`

Suppose:

```java
catch (Exception e) {
    throw e;
}
```

There are two important parts.

### `throw`

This is the Java keyword that performs the throwing operation.

### `e`

This is the reference to the exception object.

Therefore:

```java
throw e;
```

means:

> "Throw the exception object currently referred to by `e`."

---

# 🧒 6.8 `throw` Is an Action

Think about the difference between these:

```java
Exception e;
```

and:

```java
throw e;
```

The first one only deals with a reference variable.

The second one actually performs an exception-throwing operation.

Think:

```text
e
↓
Points to exception object

throw e
↓
Throws that exception object
```

---

# 🧒 6.9 Simple Rethrowing Program

Here is a basic example:

```java
class Demo {

    static void fun() {

        try {

            int result = 10 / 0;

        }
        catch (Exception e) {

            System.out.println("Exception caught in fun()");

            throw e;
        }
    }

    public static void main(String[] args) {

        try {

            fun();

        }
        catch (Exception e) {

            System.out.println("Exception received in main()");
        }
    }
}
```

Let's understand this program slowly.

---

# 🧒 6.10 Program Execution — Step 1

Java starts execution from:

```java
public static void main(String[] args)
```

So:

```text
main()
```

is the starting point.

Inside `main()`:

```java
fun();
```

is called.

Therefore:

```text
main()
  ↓
fun()
```

---

# 🧒 6.11 Program Execution — Step 2

Inside `fun()`:

```java
try {

    int result = 10 / 0;

}
```

Java attempts:

```text
10 / 0
```

For integer arithmetic, division by zero causes:

```text
ArithmeticException
```

---

# 🧒 6.12 Program Execution — Step 3

An exception object is created.

Conceptually:

```text
10 / 0
   ↓
ArithmeticException object
```

The Runtime System looks for an appropriate handler.

The `fun()` method has:

```java
catch (Exception e)
```

So the exception is caught there.

---

# 🧒 6.13 Program Execution — Step 4

The following statement executes:

```java
System.out.println("Exception caught in fun()");
```

Output:

```text
Exception caught in fun()
```

At this point, `fun()` has received the exception in:

```java
e
```

So:

```text
e
↓
ArithmeticException object
```

---

# 🧒 6.14 Program Execution — Step 5

Now this statement executes:

```java
throw e;
```

This is the important part.

The exception is deliberately thrown again.

Therefore:

```text
fun()
 ↓
catch
 ↓
throw e
 ↓
exception leaves fun()
```

---

# 🧒 6.15 Program Execution — Step 6

Who called `fun()`?

Look at:

```java
fun();
```

It appears inside:

```java
main()
```

Therefore:

```text
Caller of fun() = main()
```

After:

```java
throw e;
```

the exception goes back toward the caller.

```text
fun()
  ↓
throw e
  ↓
main()
```

---

# 🧒 6.16 Program Execution — Step 7

`main()` has:

```java
try {

    fun();

}
catch (Exception e) {

    System.out.println("Exception received in main()");
}
```

Therefore, the exception thrown again by `fun()` reaches the `catch` block in `main()`.

Output:

```text
Exception received in main()
```

The complete output is:

```text
Exception caught in fun()
Exception received in main()
```

---

# 🧒 6.17 Complete Rethrow Flow

Remember this diagram:

```text
                    main()
                      │
                      │ calls
                      ▼
                     fun()
                      │
                      │
                    10 / 0
                      │
                      ▼
              Exception object
                      │
                      ▼
               catch(Exception e)
                      │
                      │ handles/processes
                      ▼
                  throw e
                      │
                      ▼
                    main()
                      │
                      ▼
               catch(Exception e)
                      │
                      ▼
                  Handled
```

This is **rethrowing**.

---

# 🧒 6.18 Rethrowing the Same Exception Object

In:

```java
catch (Exception e) {
    throw e;
}
```

we are throwing the exception referred to by `e`.

We are not creating a completely unrelated exception.

Conceptually:

```text
Exception Object #1
       ↑
       e
       ↓
    throw e
       ↓
same exception object continues
```

This is an important idea.

---

# 🧒 6.19 Explicit Exception Propagation

Your notes mention:

> Programmer explicitly propagates exception object.

The word **explicitly** is important.

It means the programmer intentionally writes:

```java
throw e;
```

The programmer is telling Java:

> "Do not stop the exception here. Send this exception toward the caller."

Therefore:

```text
Automatic propagation
        vs
Explicit propagation
```

are different ideas.

---

# 🧒 6.20 What Is Explicit Propagation?

Suppose:

```text
main()
 ↓
fun1()
 ↓
fun2()
```

An exception occurs in `fun2()`.

If `fun2()` doesn't handle it, Java's exception mechanism can propagate it upward according to the exception-handling rules.

But if `fun2()` catches it and deliberately writes:

```java
throw e;
```

then the programmer is explicitly telling Java to throw it again.

So:

```text
Exception
 ↓
catch
 ↓
throw e
 ↓
caller
```

is explicit propagation.

---

# 🧒 6.21 Simple Three-Level Example

Consider:

```text
main()
  ↓
fun1()
  ↓
fun2()
```

Suppose `fun2()` encounters an exception.

```text
fun2()
 ↓
Exception
```

It catches it:

```java
catch (Exception e)
```

Then:

```java
throw e;
```

Now:

```text
fun2()
 ↓
throw e
 ↓
fun1()
```

If `fun1()` catches it and throws it again:

```text
fun1()
 ↓
catch
 ↓
throw e
 ↓
main()
```

So the exception can travel through multiple levels.

---

# 🧒 6.22 Complete Three-Level Rethrowing Example

```java
class Demo {

    static void fun2() {

        try {

            int result = 10 / 0;

        }
        catch (Exception e) {

            System.out.println("Exception caught in fun2()");

            throw e;
        }
    }

    static void fun1() {

        try {

            fun2();

        }
        catch (Exception e) {

            System.out.println("Exception caught in fun1()");

            throw e;
        }
    }

    public static void main(String[] args) {

        try {

            fun1();

        }
        catch (Exception e) {

            System.out.println("Exception caught in main()");
        }
    }
}
```

---

# 🧒 6.23 Three-Level Execution

Execution begins:

```text
main()
```

Then:

```text
main()
 ↓
fun1()
```

Then:

```text
fun1()
 ↓
fun2()
```

Then:

```text
fun2()
 ↓
10 / 0
```

Exception occurs.

---

# 🧒 6.24 Exception in `fun2()`

The exception reaches:

```java
catch (Exception e)
```

inside `fun2()`.

It prints:

```text
Exception caught in fun2()
```

Then:

```java
throw e;
```

rethrows it.

Flow:

```text
fun2()
 ↓
catch
 ↓
throw e
 ↓
fun1()
```

---

# 🧒 6.25 Exception in `fun1()`

The exception reaches the `catch` block in `fun1()`.

It prints:

```text
Exception caught in fun1()
```

Then:

```java
throw e;
```

again.

Flow:

```text
fun1()
 ↓
catch
 ↓
throw e
 ↓
main()
```

---

# 🧒 6.26 Exception in `main()`

The exception reaches:

```java
catch (Exception e)
```

inside `main()`.

It prints:

```text
Exception caught in main()
```

So the output is:

```text
Exception caught in fun2()
Exception caught in fun1()
Exception caught in main()
```

---

# 🧒 6.27 The Important Difference: `throw` vs `throws`

This is one of the most important things to remember.

### `throw`

Used to actually throw an exception object.

Example:

```java
throw e;
```

### `throws`

Used in a method declaration to declare that a method may pass an exception to its caller.

Example:

```java
void fun() throws Exception {
}
```

Remember:

```text
throw
↓
Action

throws
↓
Declaration
```

A simple memory trick:

> **`throw` does the throwing. `throws` tells about the possibility of throwing.**

---

# 🧒 6.28 `throw` Syntax

The general syntax is:

```java
throw exceptionObject;
```

Example:

```java
throw e;
```

You can also create an exception object and throw it directly:

```java
throw new Exception("Something went wrong");
```

Here:

```text
new
 ↓
creates exception object

Exception(...)
 ↓
constructor call

throw
 ↓
throws that object
```

---

# 🧒 6.29 Creating and Throwing Your Own Exception

Example:

```java
class Demo {

    public static void main(String[] args) {

        throw new Exception("Something went wrong");
    }
}
```

However, `Exception` is a checked exception, so this simple program requires appropriate declaration/handling.

For example:

```java
class Demo {

    public static void main(String[] args) throws Exception {

        throw new Exception("Something went wrong");
    }
}
```

Here:

```java
throw new Exception("Something went wrong");
```

means:

1. Create an `Exception` object.
2. Give it the message `"Something went wrong"`.
3. Throw that object.

---

# 🧒 6.30 `throw` Is Not Only for Rethrowing

`throw` has two important uses.

### Use 1 — Rethrowing an existing exception

```java
catch (Exception e) {

    throw e;
}
```

Here we already have an exception object.

We throw it again.

### Use 2 — Explicitly creating and throwing an exception

```java
throw new Exception("Invalid operation");
```

Here the programmer creates the exception and immediately throws it.

So:

```text
throw
 ├── Rethrow existing exception
 └── Throw newly created exception
```

---

# 🧒 6.31 Why Is `throw` Useful?

Suppose we have:

```text
ATM
 ↓
Bank
 ↓
BankApp
```

The ATM may discover a problem.

The ATM may first record:

```text
"Transaction failed"
```

But the Bank may also need to know.

So:

```text
ATM
 ↓
catch
 ↓
process/log
 ↓
throw e
 ↓
Bank
```

This allows lower-level code to perform some work while still informing higher-level code.

---

# 🧒 6.32 Real-Life Example

Imagine a student submits an assignment to a teacher.

The teacher notices a problem.

The teacher writes down the problem but also sends the assignment to the principal.

```text
Student
   ↓
Teacher
   ↓
Problem found
   ↓
Teacher records problem
   ↓
Teacher sends problem upward
   ↓
Principal
```

The teacher did not simply ignore the problem.

The teacher processed it and then passed it upward.

That is similar to:

```java
catch (Exception e) {

    // process exception

    throw e;
}
```

---

# 🧒 6.33 `throw` and Method Completion

This is important.

When Java executes:

```java
throw e;
```

the normal execution of that method does not continue from the next statement as though nothing happened.

For example:

```java
catch (Exception e) {

    System.out.println("Caught");

    throw e;

    // System.out.println("After throw");
}
```

The statement after `throw e` is unreachable in this flow.

The exception is sent toward a suitable caller/handler.

Think:

```text
throw
 ↓
Stop normal flow at this point
 ↓
Search for handler
```

---

# 🧒 6.34 `throw` and Exception Object Flow

Let's memorize the complete sequence.

```text
1. Problem occurs
       ↓
2. Exception object exists
       ↓
3. catch receives reference
       ↓
4. Programmer processes it
       ↓
5. throw e
       ↓
6. Exception travels toward caller
       ↓
7. Caller handles it
```

This is the core of **rethrowing**.

---

# 🧒 6.35 Final Lifetime-Memory Picture

Keep this picture in your mind:

```text
              EXCEPTION
                  │
                  ▼
          Exception object
                  │
                  ▼
              catch
                  │
                  │
          Programmer decides
                  │
            ┌─────┴─────┐
            │           │
         Handle       Rethrow
            │           │
            ▼           ▼
       Finish here    throw e
                        │
                        ▼
                     Caller
                        │
                        ▼
                     catch
```

And remember these three words:

```text
catch → receives
throw → sends
throws → declares
```

### The most important rules

| Concept              | Meaning                                                        |
| -------------------- | -------------------------------------------------------------- |
| `try`                | Contains code where an exception may occur                     |
| `catch`              | Receives and handles an exception                              |
| `Exception e`        | `e` refers to the exception object                             |
| `throw e`            | Explicitly throws/rethrows the exception object                |
| `throws Exception`   | Declares that a method may pass an exception to its caller     |
| Rethrowing           | Catching an exception and throwing it again                    |
| Explicit propagation | Programmer deliberately uses `throw` to propagate an exception |

### One-line memory trick

> **`catch` catches the problem, `throw` sends the problem again, and `throws` warns the caller that the problem may come out.**
