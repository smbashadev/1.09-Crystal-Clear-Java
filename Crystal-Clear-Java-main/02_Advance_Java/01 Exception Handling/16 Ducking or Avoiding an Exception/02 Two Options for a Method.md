# 🧒 16.2 Two Options for a Method

### 1. Basic Idea

When a method may produce an exception, the method has **two main choices** for dealing with it:

```text
Method
  ↓
Exception may occur
  ↓
┌──────────────────────────────┐
│                              │
↓                              ↓
Handle it                    Duck it
try-catch                    throws
│                              │
↓                              ↓
Current method handles       Caller handles
the exception                the responsibility
```

So the two options are:

1. **Handle the exception using `try-catch`**
2. **Duck the exception using `throws`**

---

### 2. First Option — Handle Using `try-catch`

The method itself takes responsibility for the exception.

Example:

```java
static void fun() {

    try {

        Thread.sleep(3000);

    }
    catch (InterruptedException e) {

        System.out.println("Exception handled");

    }

}
```

Here `fun()` says:

> "I will handle the exception myself."

---

### 3. Flow of `try-catch`

```text
fun()
 ↓
Thread.sleep(3000)
 ↓
InterruptedException
 ↓
catch
 ↓
Exception handled
 ↓
fun() continues
```

The exception responsibility **ends inside `fun()`**.

---

### 4. Complete `try-catch` Example

```java
class Demo {

    static void fun() {

        try {

            Thread.sleep(3000);

        }
        catch (InterruptedException e) {

            System.out.println("Exception handled");

        }

        System.out.println("fun() completed");
    }

    public static void main(String[] args) {

        fun();

        System.out.println("Program Ends");
    }
}
```

Normal execution:

```text
fun()
 ↓
sleep for approximately 3 seconds
 ↓
fun() completed
 ↓
Program Ends
```

---

### 5. Second Option — Duck Using `throws`

Instead of handling the exception, the method can declare it using `throws`.

```java
static void fun() throws InterruptedException {

    Thread.sleep(3000);

}
```

Here `fun()` says:

> "I am not handling `InterruptedException`. The caller should deal with it."

---

### 6. Flow of `throws`

```text
fun()
 ↓
Thread.sleep(3000)
 ↓
InterruptedException
 ↓
fun() does not handle
 ↓
throws
 ↓
Caller
 ↓
Caller handles it
```

The responsibility moves **from the current method to its caller**.

---

### 7. Complete `throws` Example

```java
class Demo {

    static void fun() throws InterruptedException {

        Thread.sleep(3000);

        System.out.println("fun() completed");
    }

    public static void main(String[] args) {

        try {

            fun();

        }
        catch (InterruptedException e) {

            System.out.println("Exception handled");

        }

        System.out.println("Program Ends");
    }
}
```

Here:

```text
fun()
 ↓
throws InterruptedException
 ↓
main()
 ↓
try-catch
 ↓
main() handles exception
```

---

### 8. Direct Comparison

| `try-catch`                               | `throws`                               |
| ----------------------------------------- | -------------------------------------- |
| Method handles exception                  | Method avoids handling exception       |
| Uses `try` and `catch`                    | Uses `throws`                          |
| Responsibility stays in current method    | Responsibility moves to caller         |
| Exception is handled here                 | Exception is declared here             |
| Example: `catch (InterruptedException e)` | Example: `throws InterruptedException` |

---

### 9. Simple Real-World Analogy

Imagine `fun()` is a student.

There are two choices when the student gets a difficult problem.

**Choice 1: Solve it himself**

```text
Student
 ↓
Gets problem
 ↓
Solves problem
```

This is like:

```text
try-catch
```

**Choice 2: Give it to the teacher**

```text
Student
 ↓
Gets problem
 ↓
Gives responsibility to teacher
 ↓
Teacher solves it
```

This is like:

```text
throws
```

---

### 10. Important Difference

Do not think that both options do exactly the same thing.

```text
try-catch
    ↓
"I handle the exception here."

throws
    ↓
"I don't handle it here.
The caller must handle it."
```

---

### 11. Why Does Java Give These Two Options?

Different methods have different responsibilities.

Sometimes a method knows exactly what to do when an exception occurs.

Then:

```text
try-catch
```

is useful.

Sometimes the caller knows better what action should be taken.

Then:

```text
throws
```

can be used.

---

### 12. Example With Method Hierarchy

Suppose:

```text
main()
  ↓
fun1()
  ↓
fun2()
```

If `fun2()` encounters an exception, it can handle it:

```text
fun2()
 ↓
try-catch
 ↓
handles exception
```

Or it can duck it:

```text
fun2()
 ↓
throws
 ↓
fun1()
 ↓
handles exception
```

---

### 13. Responsibility With `try-catch`

```text
main()
 ↓
fun()
 ↓
Exception
 ↓
fun() catch
 ↓
Handled
```

The responsibility does not move upward.

---

### 14. Responsibility With `throws`

```text
main()
 ↓
fun()
 ↓
Exception
 ↓
fun() uses throws
 ↓
main()
 ↓
catch
 ↓
Handled
```

The responsibility moves to the caller.

---

### 15. Checked Exception Example

`InterruptedException` is a checked exception.

Therefore, with:

```java
static void fun() {

    Thread.sleep(3000);

}
```

Java requires the checked exception to be dealt with.

The method can choose:

```java
try-catch
```

or:

```java
throws InterruptedException
```

---

### 16. Option 1 in Short

```java
static void fun() {

    try {

        Thread.sleep(3000);

    }
    catch (InterruptedException e) {

        System.out.println("Exception handled");

    }
}
```

Meaning:

```text
fun() → "I will handle it."
```

---

### 17. Option 2 in Short

```java
static void fun() throws InterruptedException {

    Thread.sleep(3000);

}
```

Meaning:

```text
fun() → "I will not handle it.
         Caller, you handle it."
```

---

### 18. What Happens to the Exception?

With `try-catch`:

```text
Exception
 ↓
Current method
 ↓
catch
 ↓
Handled
```

With `throws`:

```text
Exception
 ↓
Current method
 ↓
throws
 ↓
Caller
```

---

### 19. Common Confusion

`throws` does **not** mean:

> "The exception has been handled."

It means:

> "This method is declaring that this exception may occur and is leaving the responsibility to the caller."

---

### 20. Common Confusion

`try-catch` does **not** pass the responsibility to the caller.

It handles the exception in the current method.

```text
try-catch → current method
throws → caller
```

---

### 21. Common Mistake

Do not write both as if they are the same:

```java
static void fun() throws InterruptedException {

    try {

        Thread.sleep(3000);

    }
    catch (InterruptedException e) {

        System.out.println("Handled");

    }
}
```

This is technically possible, but if the exception is already handled by the `catch`, there is normally no need to declare that same exception with `throws` for this simple example.

The key concept here is to understand the **two different choices**.

---

### 22. Important Rule

For a checked exception, the programmer must make sure the exception is dealt with.

The method can:

```text
Handle
   ↓
try-catch
```

or:

```text
Duck
   ↓
throws
```

---

### 23. Method Responsibility

Think of responsibility as a ball.

With `try-catch`:

```text
Method
  ↓
keeps the ball
  ↓
handles exception
```

With `throws`:

```text
Method
  ↓
passes the ball
  ↓
Caller
  ↓
handles exception
```

---

### 24. Caller Responsibility

When a method uses:

```java
throws InterruptedException
```

the caller must be prepared to deal with the possibility of that exception.

For example:

```java
try {

    fun();

}
catch (InterruptedException e) {

    System.out.println("Handled");

}
```

---

### 25. Real-World ATM Example

Suppose:

```text
BankApp
 ↓
Bank
 ↓
ATM
```

The ATM encounters an exception.

The ATM can handle it itself:

```text
ATM
 ↓
try-catch
 ↓
Exception handled
```

Or ATM can duck it:

```text
ATM
 ↓
throws
 ↓
Bank
 ↓
handles exception
```

This is the same basic idea.

---

### 26. Quick Decision

```text
Does the current method want to handle it?
          ↓
       YES → try-catch

       NO
          ↓
   Pass responsibility
          ↓
       throws
```

---

### 27. Important Rules

* A method can handle an exception using `try-catch`.
* A method can duck an exception using `throws`.
* `try-catch` handles the exception in the current method.
* `throws` does not handle the exception.
* `throws` declares the exception and passes responsibility to the caller.
* `InterruptedException` is a checked exception.
* Checked exceptions must be handled or declared.
* The caller can use `try-catch` to handle a declared checked exception.

---

### 28. Memory Trick

Remember:

```text
TRY-CATCH
"I will handle it."

THROWS
"You handle it."
```

Or simply:

```text
try-catch → HANDLE
throws    → DUCK
```

---

### 29. One-Line Difference

```text
try-catch → Handle exception here.
throws    → Let the caller handle it.
```

---

### 30. Complete Comparison Example

**Handle:**

```java
static void fun() {

    try {

        Thread.sleep(3000);

    }
    catch (InterruptedException e) {

        System.out.println("Handled");

    }
}
```

**Duck:**

```java
static void fun() throws InterruptedException {

    Thread.sleep(3000);

}
```

The difference is simply **where the responsibility is handled**.

---

### 31. Execution Comparison

```text
              Exception occurs
                     ↓
              ┌──────┴──────┐
              ↓             ↓
         try-catch        throws
              ↓             ↓
      Current method      Caller
         handles          handles
              ↓             ↓
            Done           Done
```

---

### 32. Common Mistake to Avoid

Never remember:

```text
throws = handling
```

Instead remember:

```text
throws = declaration + responsibility to caller
```

And:

```text
catch = actual handling
```

---

### 33. Interview Understanding

A method that encounters a checked exception has two common choices:

```text
1. Handle it using try-catch.
2. Declare it using throws and allow the caller
   to handle the responsibility.
```

---

### 34. Beginner Understanding

Imagine a problem reaches a method.

The method asks:

```text
"Should I solve this problem?"
```

If yes:

```text
try-catch
```

If no:

```text
throws
```

Then the caller gets the responsibility.

---

### 35. Lifetime Memory

```text
Exception may occur
       ↓
Current method
       ↓
       ├───────────────┐
       ↓               ↓
   try-catch         throws
       ↓               ↓
  Handle here       Caller handles
       ↓               ↓
     Done            Caller
                       ↓
                    catch
                       ↓
                     Done
```

---

### 36. Final Understanding

The most important idea is:

> **When a method faces a checked exception, it cannot simply ignore the responsibility. It can either handle the exception itself using `try-catch`, or duck the exception by using `throws`, which tells the caller to take responsibility for handling it.**

```text
             METHOD
                ↓
       Exception may occur
                ↓
       ┌────────┴────────┐
       ↓                 ↓
   TRY-CATCH           THROWS
       ↓                 ↓
 Handle here       Duck / declare
                         ↓
                     CALLER
                         ↓
                    Handle there
```

**Memory formula:**

```text
try-catch = HANDLE HERE
throws    = CALLER, YOU HANDLE
```
