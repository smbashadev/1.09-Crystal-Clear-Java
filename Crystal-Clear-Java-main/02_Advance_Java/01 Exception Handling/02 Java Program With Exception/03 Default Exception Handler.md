# 🧒 2.3 Default Exception Handler

Your notes:

* Exception reaches default handler
* Program terminates abnormally

The main idea is:

> **When an exception is not handled by the programmer, it can propagate until it reaches the default uncaught-exception handling mechanism. The exception is reported, and the affected thread terminates. In a simple program where this is the `main` thread, the program terminates abnormally.**

---

# 1️⃣ Start From ZERO

Suppose we have:

```java
int result = 10 / 0;
```

Java encounters:

```text
10 / 0
   ↓
ArithmeticException
```

Now imagine we did **not** write:

```java
try {
    ...
}
catch (...) {
    ...
}
```

What happens?

```text
Exception occurs
      ↓
No programmer-written handler
      ↓
Exception propagates
      ↓
No suitable handler found
      ↓
Default uncaught-exception handling
      ↓
Affected thread terminates
```

---

# 2️⃣ What Is the Default Exception Handler?

In simple terms, the **default exception handler** is the runtime's behavior when an exception remains **uncaught**.

It provides information about the uncaught exception, typically including:

* Exception type
* Exception message
* Stack trace

Then the affected thread terminates.

---

# 3️⃣ Simple Program

```java
class Demo {

    public static void main(String[] args) {

        System.out.println("Program Starts");

        int a = 10;
        int b = 0;

        int result = a / b;

        System.out.println("Result = " + result);

        System.out.println("Program Ends");
    }
}
```

There is no:

```java
try
catch
```

to handle the `ArithmeticException`.

---

# 4️⃣ Execution Flow

The JVM executes:

```text
Program Starts
      ↓
a = 10
      ↓
b = 0
      ↓
a / b
      ↓
10 / 0
      ↓
ArithmeticException
```

Now Java looks for an appropriate exception handler.

```text
ArithmeticException
       ↓
Is there a handler?
       ↓
No
       ↓
Exception propagates
```

If it remains uncaught:

```text
Uncaught exception
       ↓
Default uncaught-exception handling
       ↓
Exception information displayed
       ↓
main thread terminates
```

---

# 5️⃣ Example Output

You may see output similar to:

```text
Program Starts
Exception in thread "main" java.lang.ArithmeticException: / by zero
    at Demo.main(Demo.java:...)
```

The exact line number depends on where the division appears in your source file.

Notice:

```text
Program Ends
```

is **not printed**.

Why?

Because execution was interrupted by the exception.

---

# 6️⃣ What Does "Reaches Default Handler" Mean?

Think of exception handling as searching for someone who can solve a problem.

```text
Exception
   ↓
Current method
   ↓
Can it handle?
   ↓
No
   ↓
Caller
   ↓
Can it handle?
   ↓
No
   ↓
Continue searching
```

If nobody handles it:

```text
No suitable handler
       ↓
Exception becomes uncaught
       ↓
Default uncaught-exception handling
```

---

# 7️⃣ Real-World Analogy 🧒

Imagine a student has a problem.

```text
Student
   ↓
Teacher
   ↓
Teacher cannot solve it
   ↓
Principal
   ↓
Principal cannot solve it
   ↓
Problem reaches final authority
```

Similarly:

```text
Exception
   ↓
Current method
   ↓
Caller
   ↓
Caller
   ↓
No handler
   ↓
Default handling
```

---

# 8️⃣ What Does "Program Terminates Abnormally" Mean?

**Abnormally** means the program did not reach its intended normal ending.

Normally:

```text
Program Starts
      ↓
Operations
      ↓
Program Ends
```

Abnormally:

```text
Program Starts
      ↓
Exception
      ↓
Uncaught
      ↓
Thread terminates
      ↓
Program does not reach normal ending
```

---

# 9️⃣ Normal Termination vs Abnormal Termination

| Normal Termination                   | Abnormal Termination                              |
| ------------------------------------ | ------------------------------------------------- |
| Program reaches its intended end     | Program is interrupted by an uncaught exception   |
| Expected flow completes              | Expected flow is disturbed                        |
| Final statements can execute         | Statements after the exception may not execute    |
| No uncaught exception stops the flow | Uncaught exception terminates the affected thread |

---

# 🔟 Very Important Point

When we say:

> **"Program terminates abnormally"**

in this context, don't interpret it as:

> "The operating system crashes."

That's incorrect.

Instead:

```text
Uncaught Java Exception
        ↓
Affected Java thread terminates
        ↓
Simple application may terminate
```

The operating system normally continues running.

---

# 1️⃣1️⃣ Example With `main()`

Consider:

```java
class Demo {

    public static void main(String[] args) {

        System.out.println("A");

        int x = 10 / 0;

        System.out.println("B");
    }
}
```

Flow:

```text
A
↓
10 / 0
↓
ArithmeticException
↓
Uncaught
↓
Default handling
↓
main thread terminates
```

Therefore:

```text
A
```

is printed.

But:

```text
B
```

is not printed.

---

# 1️⃣2️⃣ Why Doesn't `B` Execute?

Because:

```java
int x = 10 / 0;
```

does not successfully complete.

The exception interrupts normal execution.

So Java cannot simply move to:

```java
System.out.println("B");
```

The flow has changed.

---

# 1️⃣3️⃣ Exception Flow

A simplified model:

```text
             Exception
                 ↓
       Current method checks
                 ↓
       Handler available?
            /          \
          YES           NO
           ↓             ↓
        Handle       Propagate
                         ↓
                      Caller
                         ↓
                  Handler available?
                    /          \
                  YES           NO
                   ↓             ↓
                Handle       Continue
                                  ↓
                           No handler found
                                  ↓
                          Uncaught exception
                                  ↓
                        Default handling
                                  ↓
                         Thread terminates
```

---

# 1️⃣4️⃣ What Does the Default Handler Display?

Typically, uncaught-exception handling reports:

### Exception type

```text
java.lang.ArithmeticException
```

### Message

```text
/ by zero
```

### Stack trace

Something like:

```text
at Demo.main(Demo.java:...)
```

Together, these help the developer understand where the failure occurred.

---

# 1️⃣5️⃣ Default Handler vs Programmer Handler

### Programmer handler

You explicitly write:

```java
try {
    int x = 10 / 0;
}
catch (ArithmeticException e) {
    System.out.println("Cannot divide by zero");
}
```

Flow:

```text
Exception
   ↓
catch
   ↓
Handled
```

### Default handling

You don't write a matching handler:

```java
int x = 10 / 0;
```

Flow:

```text
Exception
   ↓
No matching handler
   ↓
Uncaught
   ↓
Default handling
   ↓
Thread terminates
```

---

# 1️⃣6️⃣ Why Is the Default Handler Important?

Suppose the programmer forgets to handle an exception.

Java should still provide useful information instead of silently doing nothing.

Therefore, the runtime reports the exception and stack trace.

For example:

```text
Exception in thread "main"
java.lang.ArithmeticException: / by zero
```

This tells the developer:

```text
What happened? → ArithmeticException

Why? → / by zero

Where? → Demo.main(...)
```

---

# 1️⃣7️⃣ Is the Default Handler a `catch` Block?

No.

You should distinguish:

```text
Programmer-written catch
        vs
Default uncaught-exception handling
```

A `catch` block is explicitly written by the programmer.

The default uncaught-exception mechanism operates when an exception remains uncaught.

---

# 1️⃣8️⃣ Is the Exception Really "Handled"?

Not in the sense of recovery.

This is important.

When the default uncaught-exception mechanism reports:

```text
ArithmeticException
```

it is **not recovering the program**.

The affected thread still terminates.

So:

```text
Default handling
      ≠
Recovery
```

---

# 1️⃣9️⃣ What Happens to the Exception?

Conceptually:

```text
Exception occurs
      ↓
Thrown
      ↓
Search for handler
      ↓
No suitable handler
      ↓
Uncaught
      ↓
Default uncaught-exception behavior
```

---

# 2️⃣0️⃣ Connection With Exception Propagation

Suppose:

```text
main()
  ↓
methodA()
  ↓
methodB()
  ↓
methodC()
  ↓
Exception
```

If `methodC()` doesn't handle it:

```text
methodC
   ↓
methodB
   ↓
methodA
   ↓
main
```

The exception propagates upward.

If nobody handles it:

```text
main
 ↓
No handler
 ↓
Uncaught
 ↓
Default handling
 ↓
main thread terminates
```

---

# 2️⃣1️⃣ Important: Thread Terminates

The most technically accurate statement is:

> **An uncaught exception causes the thread in which it occurs to terminate.**

In a simple Java program, the exception commonly occurs in:

```text
main thread
```

Therefore:

```text
main thread terminates
       ↓
standalone program terminates
```

---

# 2️⃣2️⃣ What About Other Threads?

Suppose a Java application has:

```text
Main Thread
Worker Thread 1
Worker Thread 2
```

If an uncaught exception occurs in `Worker Thread 1`:

```text
Worker Thread 1
       ↓
Uncaught exception
       ↓
Worker Thread 1 terminates
```

It does **not automatically mean every thread or the entire JVM immediately terminates**.

This is an important advanced point.

---

# 2️⃣3️⃣ Beginner Mental Model

For now, remember:

```text
Exception
   ↓
No catch
   ↓
Default uncaught handling
   ↓
Thread terminates
```

For a simple program:

```text
main thread
   ↓
terminates
   ↓
program ends
```

---

# 2️⃣4️⃣ Common Confusion

### ❌ "Default handler prevents the program from terminating."

No.

The default uncaught-exception behavior **does not prevent termination**.

It reports the exception, then the affected thread terminates.

---

# 2️⃣5️⃣ Common Confusion

### ❌ "Default handler fixes the exception."

No.

It does not fix the underlying problem.

For:

```java
int x = 10 / 0;
```

the problem remains:

```text
Division by zero
```

The default mechanism only reports the uncaught exception.

---

# 2️⃣6️⃣ Common Confusion

### ❌ "Abnormal termination means OS crash."

No.

In this context:

```text
Java program terminates
```

doesn't mean:

```text
Operating system crashes
```

Remember:

```text
Application termination ≠ OS crash
```

---

# 2️⃣7️⃣ Common Confusion

### ❌ "The exception disappears after default handling."

No.

The exception is reported as uncaught and the affected thread terminates.

It isn't successfully recovered from.

---

# 2️⃣8️⃣ Important Rules

Remember these rules:

1. An exception can be thrown during program execution.
2. Java searches for an appropriate exception handler.
3. If the current method cannot handle it, the exception can propagate to the caller.
4. Propagation can continue up the call stack.
5. If no suitable handler is found, the exception becomes uncaught.
6. Java's runtime performs default uncaught-exception handling.
7. The default behavior typically prints the exception and stack trace.
8. The affected thread terminates.
9. If the uncaught exception occurs in the `main` thread of a simple standalone program, the program terminates.
10. Default handling is not the same as recovery.
11. An application termination is not the same as an operating-system crash.

---

# 2️⃣9️⃣ Memory Trick 🧠

Remember:

### **NO CATCH → PROPAGATE → UNCaught → TERMINATE**

```text
No catch
   ↓
Propagation
   ↓
No handler found
   ↓
Uncaught
   ↓
Default handling
   ↓
Thread terminates
```

---

# 3️⃣0️⃣ Interview Question

### ❓ What happens when an exception reaches the default handler?

Answer:

> **If an exception remains uncaught after propagating through the call stack, Java's default uncaught-exception handling reports the exception and its stack trace, and the thread in which the exception occurred terminates.**

---

# 3️⃣1️⃣ Interview Question

### ❓ What is abnormal termination?

Answer:

> **Abnormal termination means the program or affected execution thread does not complete its intended normal flow because an uncaught exception interrupts execution.**

---

# 3️⃣2️⃣ Interview Question

### ❓ Does the default exception handler handle the exception and allow the program to continue?

Answer:

> **No.** The default uncaught-exception behavior reports the uncaught exception; it does not provide recovery. The affected thread terminates.

---

# 3️⃣3️⃣ Core Example

```java
class Demo {

    public static void main(String[] args) {

        System.out.println("Program Starts");

        int a = 10;
        int b = 0;

        int result = a / b;

        System.out.println("Program Ends");
    }
}
```

Flow:

```text
Program Starts
      ↓
10 / 0
      ↓
ArithmeticException
      ↓
No catch
      ↓
Exception propagates
      ↓
No handler found
      ↓
Default uncaught-exception handling
      ↓
Stack trace displayed
      ↓
main thread terminates
      ↓
Program terminates abnormally
```

---

# 3️⃣4️⃣ Your Notes Mapped Directly

### **Exception reaches default handler**

This means:

```text
Exception
   ↓
No suitable programmer-written handler
   ↓
Exception remains uncaught
   ↓
Default uncaught-exception handling
```

### **Program terminates abnormally**

The uncaught exception terminates the affected thread.

If that is the `main` thread in a simple standalone program:

```text
main thread terminates
       ↓
program terminates
```

---

# 3️⃣5️⃣ Super-Simple Mental Model 🧒

Imagine you are playing a game:

```text
Game starts
   ↓
Playing
   ↓
Unexpected problem
   ↓
You look for someone to solve it
   ↓
Nobody can solve it
   ↓
Game reports the problem
   ↓
Game stops
```

Java:

```text
Program starts
     ↓
Exception occurs
     ↓
Look for handler
     ↓
No handler
     ↓
Default uncaught-exception handling
     ↓
Exception information displayed
     ↓
Affected thread stops
```

---

# 3️⃣6️⃣ Final `/eli5` Understanding 🎯

Suppose Java is executing:

```java
int result = 10 / 0;
```

Java encounters:

```text
ArithmeticException
```

If you haven't written a suitable `catch`:

```text
Exception
   ↓
No handler here
   ↓
Propagate upward
   ↓
No handler anywhere
   ↓
Exception becomes uncaught
   ↓
Default uncaught-exception handling
   ↓
Exception + stack trace displayed
   ↓
Affected thread terminates
```

In a simple program where this happens in `main`:

```text
main thread terminates
        ↓
program terminates abnormally
```

### ⭐ Remember this exact chain:

> **Exception → No handler → Propagation → Uncaught → Default handling → Thread termination → Abnormal program termination (for a simple `main`-thread program).**
