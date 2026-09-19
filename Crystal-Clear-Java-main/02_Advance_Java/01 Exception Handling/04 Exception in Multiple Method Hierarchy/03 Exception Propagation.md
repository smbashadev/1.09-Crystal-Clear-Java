# 🧒 4.3 Exception Propagation

## 1️⃣ Start From ZERO

Sometimes an exception occurs inside a method, but that method **does not handle it**.

Then Java looks toward the method that called it.

Example:

```text
main()
  ↓
fun1()
  ↓
fun2()
  ↓
fun3()
  ↓
Exception
```

If `fun3()` does not handle the exception, Java moves upward through the method hierarchy.

```text
fun3()
  ↑
fun2()
  ↑
fun1()
  ↑
main()
```

This movement of an exception is called **exception propagation**.

---

## 2️⃣ What Is Exception Propagation?

> **Exception propagation is the process of passing an exception from the method where it occurred to its calling methods until a suitable exception handler is found.**

Simple:

```text
Exception
   ↓
Current method
   ↓
Caller
   ↓
Caller
   ↓
Handler
```

---

## 3️⃣ Real-World Analogy 🧒

Imagine an employee has a problem.

```text
Employee
   ↓
Team Leader
   ↓
Manager
   ↓
Director
```

The employee tries to solve it.

If the employee cannot solve it:

```text
Employee
   ↓
Team Leader
```

If the team leader cannot solve it:

```text
Team Leader
   ↓
Manager
```

The problem keeps moving upward until someone handles it.

Java exception propagation works similarly.

---

## 4️⃣ Simple Definition

> **Exception propagation means an exception moves upward through the method-call hierarchy when the current method does not handle it.**

---

## 5️⃣ Basic Structure

```text
main()
   ↓
fun1()
   ↓
fun2()
   ↓
fun3()
   ↓
Exception
```

If `fun3()` has no suitable handler:

```text
fun3()
   ↑
fun2()
   ↑
fun1()
   ↑
main()
```

---

## 6️⃣ Simple Program

```java
class Demo {

    public static void main(String[] args) {

        System.out.println("Inside main");

        fun1();

        System.out.println("Program Ends");
    }

    static void fun1() {

        System.out.println("Inside fun1");

        fun2();
    }

    static void fun2() {

        System.out.println("Inside fun2");

        fun3();
    }

    static void fun3() {

        System.out.println("Inside fun3");

        int result = 10 / 0;

        System.out.println(result);
    }
}
```

Here the exception occurs in:

```java
fun3()
```

---

## 7️⃣ Output

Conceptually:

```text
Inside main
Inside fun1
Inside fun2
Inside fun3
Exception in thread "main" java.lang.ArithmeticException: / by zero
```

`Program Ends` is not printed because no method in this example handles the exception.

---

## 8️⃣ Execution Flow

```text
main()
 ↓
fun1()
 ↓
fun2()
 ↓
fun3()
 ↓
10 / 0
 ↓
ArithmeticException
```

Then Java searches upward:

```text
fun3()
 ↑
fun2()
 ↑
fun1()
 ↑
main()
```

If no suitable handler exists:

```text
main()
 ↓
Default exception handling
 ↓
Affected thread terminates
```

---

## 9️⃣ Exception Object Creation

When the exception occurs:

```java
int result = 10 / 0;
```

Java creates an exception object.

```text
10 / 0
   ↓
ArithmeticException object
```

Conceptually:

```text
Exception occurs
      ↓
Exception object created
```

---

## 🔟 RTS Receives the Exception

The exception object is handed to the **Runtime System (RTS)**.

```text
Exception
   ↓
Exception object
   ↓
RTS
```

The RTS must determine what to do with the exception.

---

## 1️⃣1️⃣ RTS Checks the Method

The exception occurred inside:

```text
fun3()
```

So the RTS first checks `fun3()`.

```text
fun3()
 ↓
Exception handler?
```

If a suitable handler exists, the exception can be handled there.

If not, Java moves upward.

---

## 1️⃣2️⃣ Handler Check

Suppose `fun3()` contains:

```java
try {
    int result = 10 / 0;
}
catch (ArithmeticException e) {
    System.out.println("Handled");
}
```

Then:

```text
fun3()
 ↓
Exception
 ↓
Handler found
 ↓
catch executes
```

Propagation stops.

---

## 1️⃣3️⃣ If Handler Is Absent

Suppose `fun3()` has no handler.

```text
fun3()
 ↓
Exception
 ↓
No handler
```

The exception moves to its caller:

```text
fun2()
```

So:

```text
fun3()
 ↑
fun2()
```

---

## 1️⃣4️⃣ Propagation Through the Stack

The exception can continue moving upward:

```text
fun3()
   ↑
fun2()
   ↑
fun1()
   ↑
main()
```

At every level, Java checks whether a suitable handler exists.

---

## 1️⃣5️⃣ Visual Understanding

```text
                    Exception
                        ↑
                      fun3()
                        ↑
                      fun2()
                        ↑
                      fun1()
                        ↑
                      main()
                        ↑
             Default Exception Handler
```

The exception travels **upward** through the calling hierarchy.

---

## 1️⃣6️⃣ Important Concept

Normal execution moves:

```text
main()
 ↓
fun1()
 ↓
fun2()
 ↓
fun3()
```

Exception propagation moves:

```text
fun3()
 ↑
fun2()
 ↑
fun1()
 ↑
main()
```

So remember:

> **Normal method call → Down the hierarchy**
> **Exception propagation → Up the hierarchy**

---

## 1️⃣7️⃣ Why Does Java Propagate the Exception?

Because the method where the exception occurred may not know how to handle it.

For example:

```text
fun3()
 ↓
Exception
 ↓
"I don't know how to handle this."
```

So Java gives the caller a chance:

```text
fun2()
 ↓
Can you handle it?
```

If not:

```text
fun1()
 ↓
Can you handle it?
```

And so on.

---

## 1️⃣8️⃣ Connection With Method Hierarchy

Our hierarchy is:

```text
main()
 ↓
fun1()
 ↓
fun2()
 ↓
fun3()
```

An exception in `fun3()` can propagate:

```text
fun3()
 ↑
fun2()
 ↑
fun1()
 ↑
main()
```

Therefore, understanding the **method hierarchy** is essential for understanding exception propagation.

---

## 1️⃣9️⃣ Runtime Understanding

Everything happens during program execution.

Example:

```java
int result = 10 / 0;
```

At runtime:

```text
Division
 ↓
Exception
 ↓
Exception object
 ↓
RTS
 ↓
Check fun3()
 ↓
No handler
 ↓
Check fun2()
 ↓
No handler
 ↓
Check fun1()
 ↓
No handler
 ↓
Check main()
```

---

## 2️⃣0️⃣ Behind-the-Scenes Explanation

Conceptually:

```text
fun3() executes
      ↓
Exception occurs
      ↓
Exception object created
      ↓
RTS receives object
      ↓
Check fun3() for handler
      ↓
No handler
      ↓
Move to fun2()
      ↓
Check fun2()
      ↓
No handler
      ↓
Move to fun1()
      ↓
Check fun1()
      ↓
No handler
      ↓
Move to main()
      ↓
Check main()
```

---

## 2️⃣1️⃣ Important Technical Point

Exception propagation follows the **method-call stack**.

If:

```text
main()
 ↓
fun1()
 ↓
fun2()
 ↓
fun3()
```

then an uncaught exception in `fun3()` can move toward:

```text
fun2()
 ↓
fun1()
 ↓
main()
```

It does not randomly jump to unrelated methods.

---

## 2️⃣2️⃣ Common Confusion

### ❌ Does exception propagation move downward?

No.

Method calling:

```text
main → fun1 → fun2 → fun3
```

Exception propagation:

```text
fun3 → fun2 → fun1 → main
```

So exception propagation generally moves **upward toward callers**.

---

## 2️⃣3️⃣ Another Common Confusion

### ❌ Does the exception disappear when it moves to another method?

No.

The same exception object continues to be propagated until it is handled or remains uncaught.

```text
Exception object
      ↓
fun3
      ↓
fun2
      ↓
fun1
      ↓
main
```

---

## 2️⃣4️⃣ Handler Found

Suppose `fun2()` has a handler:

```java
static void fun2() {

    try {
        fun3();
    }
    catch (ArithmeticException e) {
        System.out.println("Exception handled in fun2");
    }
}
```

Then:

```text
fun3()
 ↓
Exception
 ↓
fun2()
 ↓
Handler found
 ↓
catch executes
```

Propagation stops at `fun2()`.

---

## 2️⃣5️⃣ Handler Not Found

If none of these methods handles it:

```text
fun3()
 ↓
fun2()
 ↓
fun1()
 ↓
main()
```

then:

```text
No suitable handler
      ↓
Default exception handler
      ↓
Thread terminates
```

---

## 2️⃣6️⃣ Hierarchy / Relationship

The complete relationship is:

```text
main()
   │
   └── fun1()
         │
         └── fun2()
               │
               └── fun3()
```

Exception:

```text
fun3()
   ↑
fun2()
   ↑
fun1()
   ↑
main()
```

This is the **propagation path**.

---

## 2️⃣7️⃣ Why Is This Important?

Exception propagation allows a method to avoid handling every exception itself.

For example:

```text
fun3()
 ↓
Cannot handle
 ↓
fun2()
 ↓
Can handle
```

The higher-level method can decide how to handle the problem.

This makes exception handling more flexible.

---

## 2️⃣8️⃣ Important Rules

1. An exception occurs during execution.
2. Java creates an exception object.
3. The Runtime System receives the exception.
4. RTS first checks the method where the exception occurred.
5. Java checks for a suitable exception handler.
6. If a suitable handler exists, the exception is handled there.
7. If no handler exists, the exception propagates to the caller.
8. The caller is then checked for a suitable handler.
9. Propagation can continue through multiple calling methods.
10. The propagation follows the method-call hierarchy.
11. Exception propagation generally moves upward through the call stack.
12. If no suitable handler is found, the default exception handling mechanism is reached.
13. An uncaught exception causes the affected thread to terminate.
14. If a handler is found, propagation stops at that handler.

---

## 2️⃣9️⃣ Memory Trick 🧠

Remember:

### **EXCEPTION GOES UP**

```text
fun3()
  ↑
fun2()
  ↑
fun1()
  ↑
main()
```

And:

### **CALL DOWN, PROPAGATE UP**

```text
CALL:
main → fun1 → fun2 → fun3

EXCEPTION:
fun3 → fun2 → fun1 → main
```

---

## 3️⃣0️⃣ Interview Question

### ❓ What is exception propagation?

> Exception propagation is the process in which an exception moves from the method where it occurs to its calling methods when the current method does not handle it.

---

## 3️⃣1️⃣ Interview Question

### ❓ In which direction does exception propagation occur?

> Exception propagation generally occurs upward through the method-call hierarchy, from the method where the exception occurs toward its callers.

---

## 3️⃣2️⃣ Interview Question

### ❓ What happens if no method handles the exception?

> The exception eventually reaches the default exception-handling mechanism, and the affected thread terminates.

---

## 3️⃣3️⃣ Complete Program

```java
class Demo {

    public static void main(String[] args) {

        System.out.println("Inside main");

        fun1();

        System.out.println("Program Ends");
    }

    static void fun1() {

        System.out.println("Inside fun1");

        fun2();
    }

    static void fun2() {

        System.out.println("Inside fun2");

        fun3();
    }

    static void fun3() {

        System.out.println("Inside fun3");

        int result = 10 / 0;

        System.out.println(result);
    }
}
```

Flow:

```text
main()
 ↓
fun1()
 ↓
fun2()
 ↓
fun3()
 ↓
10 / 0
 ↓
ArithmeticException
 ↓
Check fun3()
 ↓
No handler
 ↓
Check fun2()
 ↓
No handler
 ↓
Check fun1()
 ↓
No handler
 ↓
Check main()
 ↓
No handler
 ↓
Default exception handler
```

---

## 3️⃣4️⃣ Program With Handler

```java
class Demo {

    public static void main(String[] args) {

        System.out.println("Inside main");

        try {
            fun1();
        }
        catch (ArithmeticException e) {
            System.out.println("Exception handled in main");
        }

        System.out.println("Program Ends");
    }

    static void fun1() {
        fun2();
    }

    static void fun2() {
        fun3();
    }

    static void fun3() {

        int result = 10 / 0;

        System.out.println(result);
    }
}
```

Flow:

```text
main()
 ↓
fun1()
 ↓
fun2()
 ↓
fun3()
 ↓
Exception
 ↓
fun3() → no handler
 ↓
fun2() → no handler
 ↓
fun1() → no handler
 ↓
main() → handler found
 ↓
catch executes
 ↓
Program Ends
```

---

## 3️⃣5️⃣ Super-Simple Mental Model 🧒

Imagine:

```text
Worker
  ↑
Team Leader
  ↑
Manager
  ↑
Director
```

Worker gets a problem.

If Worker can't solve it:

```text
Worker → Team Leader
```

If Team Leader can't solve it:

```text
Team Leader → Manager
```

If Manager can't solve it:

```text
Manager → Director
```

Java:

```text
fun3()
  ↑
fun2()
  ↑
fun1()
  ↑
main()
```

The exception keeps moving upward until someone handles it.

---

## 3️⃣6️⃣ Final `/eli5` Understanding 🎯

Exception propagation follows this chain:

```text
Exception occurs in fun3()
          ↓
Exception object created
          ↓
RTS receives exception
          ↓
Check fun3()
          ↓
No handler
          ↓
Propagate to fun2()
          ↓
No handler
          ↓
Propagate to fun1()
          ↓
No handler
          ↓
Propagate to main()
          ↓
No handler
          ↓
Default exception handler
          ↓
Affected thread terminates
```

### ⭐ Remember:

> **An exception starts where the problem occurs and travels upward through the method-call hierarchy until a suitable handler is found.**
