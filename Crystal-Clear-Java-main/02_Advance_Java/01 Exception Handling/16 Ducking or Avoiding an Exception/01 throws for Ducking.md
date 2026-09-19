# 🧒 16.1 `throws` for Ducking

### 1. Basic Idea

Sometimes a method encounters an exception but **does not want to handle it itself**.

Instead of using `try-catch`, the method can use the `throws` keyword to **pass the responsibility to the caller method**.

```text
Method
  ↓
Exception occurs
  ↓
Method does not handle it
  ↓
throws
  ↓
Caller must handle it
```

---

### 2. Meaning of Ducking

**Ducking an exception** means:

> A method avoids handling the exception itself and tells its caller that the exception may occur.

It is called **ducking** or **avoiding** because the current method is saying:

> "I am not handling this problem. The method that called me should take care of it."

---

### 3. Real-World Analogy

Imagine a student has a difficult problem.

Instead of solving it himself:

```text
Student
   ↓
Teacher
```

The student gives the problem to the teacher.

Similarly:

```text
fun()
   ↓
Exception
   ↓
fun() does not handle it
   ↓
Caller handles it
```

---

### 4. Technical Meaning

The `throws` keyword is written in the **method declaration**.

It tells the caller:

> "This method may produce this exception, so you must be prepared to handle it."

Example:

```java
void fun() throws InterruptedException {
    
    Thread.sleep(3000);

}
```

Here `fun()` does not use `try-catch`.

Instead, it declares:

```java
throws InterruptedException
```

---

### 5. Syntax

```java
returnType methodName() throws ExceptionType {

    // code that may produce exception

}
```

Example:

```java
void fun() throws InterruptedException {

    Thread.sleep(3000);

}
```

---

### 6. Simple Java Example

```java
class Demo {

    static void fun() throws InterruptedException {

        System.out.println("fun() started");

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

Output under normal execution:

```text
fun() started
```

After approximately 3 seconds:

```text
fun() completed
Program Ends
```

---

### 7. Understanding `fun()`

The method is:

```java
static void fun() throws InterruptedException
```

The important portion is:

```java
throws InterruptedException
```

It means:

```text
fun()
 ↓
may produce InterruptedException
 ↓
fun() is not handling it
 ↓
caller must be prepared
```

---

### 8. What Happens Inside `fun()`?

The method executes:

```java
Thread.sleep(3000);
```

`Thread.sleep()` can produce:

```text
InterruptedException
```

Instead of writing:

```java
try {
    Thread.sleep(3000);
}
catch (InterruptedException e) {
    // handle
}
```

the method declares:

```java
throws InterruptedException
```

---

### 9. Responsibility Moves to Caller

The caller is:

```java
main()
```

because `main()` calls:

```java
fun();
```

The responsibility therefore moves:

```text
fun()
 ↓
throws InterruptedException
 ↓
main()
 ↓
try-catch
 ↓
handles exception
```

---

### 10. Important Difference

With `try-catch`:

```text
fun()
 ↓
Exception
 ↓
fun() handles it
```

With `throws`:

```text
fun()
 ↓
Exception
 ↓
fun() does not handle it
 ↓
Caller handles it
```

---

### 11. `throws` Does Not Handle the Exception

This is very important.

```java
void fun() throws InterruptedException {
    
    Thread.sleep(3000);

}
```

The `throws` keyword does **not** handle the exception.

It only declares that the method may produce that exception.

```text
throws
  ↓
Declaration / warning
  ≠
Exception handling
```

---

### 12. `try-catch` Handles the Exception

```java
try {

    fun();

}
catch (InterruptedException e) {

    System.out.println("Exception handled");

}
```

The `catch` block actually handles the exception.

So remember:

```text
try-catch → handles
throws    → declares / passes responsibility
```

---

### 13. Why Use Ducking?

A method may not be the best place to decide what to do when an exception occurs.

For example:

```text
Database method
      ↓
Exception
      ↓
Caller knows what action to take
```

The lower-level method can declare the exception and let the higher-level method decide how to handle it.

---

### 14. Simple Flow

```text
main()
  ↓
calls fun()
  ↓
fun()
  ↓
Thread.sleep()
  ↓
InterruptedException
  ↓
fun() has throws
  ↓
exception responsibility moves to main()
  ↓
main() catch handles it
```

---

### 15. What If the Caller Does Not Handle It?

Suppose:

```java
static void fun() throws InterruptedException {

    Thread.sleep(3000);

}
```

and `main()` calls:

```java
fun();
```

without handling or declaring the exception.

For a checked exception, the compiler will complain because the responsibility has not been dealt with.

The responsibility must continue to another caller or eventually be handled.

---

### 16. Responsibility Chain

Exception responsibility can move through multiple methods.

```text
main()
  ↓
fun1()
  ↓
fun2()
  ↓
fun3()
```

Suppose `fun3()` uses:

```java
throws Exception
```

Then:

```text
fun3()
 ↓
does not handle
 ↓
fun2()
 ↓
does not handle
 ↓
fun1()
 ↓
does not handle
 ↓
main()
 ↓
handles
```

This is exception propagation through method calls.

---

### 17. Real-World Example

Imagine:

```text
ATM
 ↓
Bank
 ↓
Bank Server
```

The ATM may encounter a problem but may not decide how the bank should respond.

It can pass the responsibility upward:

```text
ATM
 ↓
throws Exception
 ↓
Bank
 ↓
handles exception
```

This is the basic idea of ducking.

---

### 18. `throws` Location

`throws` appears in the **method declaration**, after the method name and parameter list.

Correct:

```java
void fun() throws Exception {
    
}
```

Not:

```java
void throws fun() {
    
}
```

---

### 19. One Exception

A method can declare one exception:

```java
void fun() throws InterruptedException {

    Thread.sleep(3000);

}
```

---

### 20. Multiple Exceptions

A method can declare multiple exceptions using commas:

```java
void fun() throws IOException, InterruptedException {

    // code

}
```

The method is declaring that these exceptions may need to be dealt with by its caller.

---

### 21. Common Confusion

Do not think:

```text
throws = throw
```

They are different.

```text
throw
 ↓
actually throws a particular exception object
```

```text
throws
 ↓
declares that a method may produce an exception
```

---

### 22. `throw` vs `throws`

| `throw`                           | `throws`                        |
| --------------------------------- | ------------------------------- |
| Used inside method body           | Used in method declaration      |
| Explicitly throws an exception    | Declares possible exceptions    |
| Works with an exception object    | Works with exception types      |
| Causes the exception to be thrown | Passes responsibility to caller |
| Example: `throw e;`               | Example: `throws Exception`     |

---

### 23. Common Mistake

This is incorrect:

```java
void fun() {

    Thread.sleep(3000);

}
```

when dealing with the checked `InterruptedException`.

One option is to handle it:

```java
try {

    Thread.sleep(3000);

}
catch (InterruptedException e) {

}
```

Another option is to duck it:

```java
void fun() throws InterruptedException {

    Thread.sleep(3000);

}
```

---

### 24. Important Rule

For a checked exception, the responsibility cannot simply disappear.

It must be:

```text
Handled
   OR
Declared using throws
```

So:

```text
Checked Exception
      ↓
try-catch
      OR
throws
```

---

### 25. Ducking Does Not Mean Exception Disappears

When a method uses:

```java
throws InterruptedException
```

the exception is not removed.

The method is simply saying:

```text
"I am not handling it here."
```

The responsibility moves to the caller.

---

### 26. Caller Meaning

If:

```java
fun() throws InterruptedException
```

then the caller:

```java
main()
```

must be prepared to deal with the possibility of that exception.

The caller can:

```text
Handle it
```

or, for a checked exception, potentially declare it onward as well.

---

### 27. Beginner Example

```java
class Demo {

    static void fun() throws InterruptedException {

        Thread.sleep(3000);

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

Think:

```text
fun() → "I may have InterruptedException."
main() → "Okay, I will handle it."
```

---

### 28. Execution Without Exception

Normally:

```text
main()
 ↓
fun()
 ↓
Thread.sleep(3000)
 ↓
3-second pause
 ↓
fun() returns
 ↓
main() continues
 ↓
Program Ends
```

---

### 29. Execution If Exception Occurs

If the sleeping thread is interrupted:

```text
main()
 ↓
fun()
 ↓
Thread.sleep()
 ↓
InterruptedException
 ↓
fun() does not handle
 ↓
throws passes responsibility
 ↓
main()
 ↓
catch
 ↓
Exception handled
 ↓
Program Ends
```

---

### 30. Common Mistakes

Avoid these misunderstandings:

```text
❌ throws handles exception
```

Correct:

```text
✅ throws declares exception / passes responsibility
```

```text
❌ throws creates an exception
```

Correct:

```text
✅ throw is used to explicitly throw an exception
```

```text
❌ Ducking means ignoring the exception forever
```

Correct:

```text
✅ Ducking means allowing another method to handle the responsibility
```

---

### 31. Important Rules

* `throws` is written in the method declaration.
* `throws` declares possible exceptions.
* `throws` does not itself handle the exception.
* Ducking means avoiding handling in the current method.
* The caller becomes responsible for dealing with the exception.
* `InterruptedException` is a checked exception.
* A checked exception must be handled or declared.
* Multiple exception types can be declared after `throws`, separated by commas.
* `throw` and `throws` have different purposes.

---

### 32. Memory Flow

```text
Exception
   ↓
Current method
   ↓
Does it handle?
 ↙       ↘
YES       NO
 ↓         ↓
catch    throws
           ↓
        Caller
           ↓
        handles
```

---

### 33. Easy Comparison

```text
try-catch
    ↓
"I will handle the problem."

throws
    ↓
"I will not handle the problem here.
The caller should be prepared."
```

---

### 34. Interview Understanding

A clear interview explanation is:

> **Ducking an exception means a method avoids handling an exception itself and declares it using the `throws` keyword. The responsibility is then passed to the caller method, which must handle or further declare the exception as appropriate.**

---

### 35. Memory Trick

Remember:

```text
THROWS = "I am warning my caller."
```

And:

```text
try-catch = "I am handling it."
throws    = "You handle it."
```

---

### 36. Complete Lifetime Understanding

```text
                         main()
                           ↓
                       calls fun()
                           ↓
                          fun()
                           ↓
                  Thread.sleep(3000)
                           ↓
                 InterruptedException
                           ↓
               Does fun() handle it?
                    ↙            ↘
                  YES             NO
                   ↓               ↓
                catch           throws
                   ↓               ↓
               handled          caller
                                   ↓
                              main() receives
                                   ↓
                            main() handles it
                                   ↓
                             Program continues
```

**Core memory rule:**

> **Ducking means the current method avoids handling the exception and uses `throws` to pass the responsibility to its caller.**
