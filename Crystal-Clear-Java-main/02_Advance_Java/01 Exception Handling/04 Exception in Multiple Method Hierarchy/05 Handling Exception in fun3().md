# 🧒 4.5 Handling Exception in fun3()

## 1️⃣ Start From ZERO

Suppose our method hierarchy is:

```text
main()
 ↓
fun1()
 ↓
fun2()
 ↓
fun3()
```

This time, an exception occurs inside `fun3()`.

But `fun3()` has a `try-catch`, so it handles the exception itself.

---

## 2️⃣ What Is Happening?

The exception occurs in:

```text
fun3()
```

`fun3()` catches it:

```text
try
 ↓
Exception
 ↓
catch
```

Because the exception is handled, execution can continue normally.

---

## 3️⃣ Real-World Analogy 🧒

Imagine:

```text
Worker → Team Leader → Manager
```

The worker makes a mistake but fixes it immediately.

So the problem doesn't need to go to the team leader or manager.

Similarly:

```text
fun3()
 ↓
Exception
 ↓
catch handles it
```

The exception does not propagate upward.

---

## 4️⃣ Simple Definition

> **Handling an exception in `fun3()` means `fun3()` catches and handles the exception occurring inside it, allowing normal execution to continue.**

---

## 5️⃣ Basic Structure

```java
static void fun3() {

    try {
        // exception-producing code
    }
    catch (Exception e) {
        // handling code
    }

    System.out.println("fun3() ending");
}
```

---

## 6️⃣ Simple Program

```java
class Demo {

    public static void main(String[] args) {

        fun1();

        System.out.println("main() ending");
    }

    static void fun1() {

        fun2();

        System.out.println("fun1() ending");
    }

    static void fun2() {

        fun3();

        System.out.println("fun2() ending");
    }

    static void fun3() {

        try {

            int result = 10 / 0;

        }
        catch (Exception e) {

            System.out.println("Exception handled");
        }

        System.out.println("fun3() ending");
    }
}
```

---

## 7️⃣ Output

```text
Exception handled
fun3() ending
fun2() ending
fun1() ending
main() ending
```

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
try
 ↓
Exception
 ↓
catch
 ↓
Exception handled
 ↓
fun3() ending
 ↓
fun2() ending
 ↓
fun1() ending
 ↓
main() ending
```

---

## 9️⃣ Where Does the Exception Occur?

The exception occurs here:

```java
int result = 10 / 0;
```

Division by zero causes:

```text
ArithmeticException
```

---

## 🔟 What Does `try` Do?

The `try` block contains the code that may produce an exception.

```java
try {
    int result = 10 / 0;
}
```

Java watches this code for an exception.

---

## 1️⃣1️⃣ What Does `catch` Do?

The `catch` block handles the exception:

```java
catch (Exception e) {
    System.out.println("Exception handled");
}
```

So:

```text
Exception
 ↓
catch
 ↓
Handled
```

---

## 1️⃣2️⃣ What Happens After `catch`?

After the `catch` block finishes, execution continues with the next statement in `fun3()`:

```java
System.out.println("fun3() ending");
```

Therefore:

```text
Exception
 ↓
catch
 ↓
fun3() ending
```

---

## 1️⃣3️⃣ Does the Exception Propagate?

No.

Because `fun3()` already handled the exception.

```text
fun3()
 ↓
Exception
 ↓
catch
 ↓
Handled
```

Propagation stops here.

---

## 1️⃣4️⃣ Method Hierarchy

The hierarchy is:

```text
main()
 ↓
fun1()
 ↓
fun2()
 ↓
fun3()
```

Exception:

```text
fun3()
 ↓
Exception
 ↓
catch handles it
```

No upward propagation occurs.

---

## 1️⃣5️⃣ Returning From `fun3()`

After:

```text
fun3() ending
```

`fun3()` completes.

Control returns to `fun2()`:

```text
fun3()
 ↑
fun2()
```

Then `fun2()` executes:

```text
fun2() ending
```

---

## 1️⃣6️⃣ Returning From `fun2()`

After `fun2()` completes:

```text
fun2()
 ↑
fun1()
```

Then:

```text
fun1() ending
```

is executed.

---

## 1️⃣7️⃣ Returning From `fun1()`

After `fun1()` completes:

```text
fun1()
 ↑
main()
```

Then:

```text
main() ending
```

is executed.

---

## 1️⃣8️⃣ Complete Return Flow

```text
fun3() ending
     ↓
fun2() ending
     ↓
fun1() ending
     ↓
main() ending
```

So after handling the exception, execution returns normally through the method hierarchy.

---

## 1️⃣9️⃣ Stack Understanding

Before the exception:

```text
fun3()
fun2()
fun1()
main()
```

The exception occurs in `fun3()`.

But `fun3()` has a handler.

```text
fun3()
 ↓
catch
```

After handling it, `fun3()` finishes and its execution frame can be removed.

---

## 2️⃣0️⃣ Runtime Understanding

Conceptually:

```text
Exception occurs in fun3()
        ↓
Exception object created
        ↓
RTS receives exception
        ↓
Check fun3()
        ↓
Handler found
        ↓
catch executes
        ↓
Exception handled
        ↓
fun3() ending
```

---

## 2️⃣1️⃣ What Happens to the Exception?

The exception has been handled by:

```java
catch (Exception e)
```

Therefore, it does not continue propagating toward:

```text
fun2()
fun1()
main()
```

---

## 2️⃣2️⃣ Important Difference

### Without handler in `fun3()`

```text
fun3()
 ↓
Exception
 ↑
fun2()
 ↑
fun1()
 ↑
main()
```

### With handler in `fun3()`

```text
fun3()
 ↓
Exception
 ↓
catch
 ↓
fun3() ending
 ↓
fun2()
```

---

## 2️⃣3️⃣ Common Confusion

### ❌ Does `fun2()` handle the exception?

No.

`fun3()` handles it.

```text
fun3()
 ↓
catch
```

`fun2()` simply continues normally after `fun3()` returns.

---

## 2️⃣4️⃣ Another Common Confusion

### ❌ Does handling the exception stop the whole program?

No.

In this example, handling the exception allows the program to continue:

```text
fun3() ending
 ↓
fun2() ending
 ↓
fun1() ending
 ↓
main() ending
```

---

## 2️⃣5️⃣ Why Does `fun3()` Continue?

Because the exception was caught.

After:

```java
catch (Exception e) {
    System.out.println("Exception handled");
}
```

execution moves to the statement following the `catch` block.

```java
System.out.println("fun3() ending");
```

---

## 2️⃣6️⃣ Connection With Exception Propagation

This example shows where propagation **stops**.

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
catch
```

The exception doesn't reach:

```text
fun2()
fun1()
main()
```

because it was handled in `fun3()`.

---

## 2️⃣7️⃣ Handler Location Matters

The handler is located in:

```text
fun3()
```

Therefore:

```text
Exception occurs → fun3() handler
```

If the handler were in `fun2()` instead:

```text
Exception occurs in fun3()
 ↓
No handler in fun3()
 ↓
fun2() handler
```

The location of the handler determines where propagation stops.

---

## 2️⃣8️⃣ Important Rules

1. `try` contains code that may produce an exception.
2. `catch` handles the exception.
3. In this example, the exception occurs in `fun3()`.
4. `fun3()` contains the exception handler.
5. The exception is handled inside `fun3()`.
6. The exception does not propagate to `fun2()`.
7. `fun3()` continues after the `catch` block.
8. `fun3()` reaches its ending statement.
9. Control returns to `fun2()`.
10. `fun2()` reaches its ending statement.
11. Control returns to `fun1()`.
12. `fun1()` reaches its ending statement.
13. Control returns to `main()`.
14. `main()` reaches its ending statement.
15. The program completes normally.

---

## 2️⃣9️⃣ Memory Trick 🧠

Remember:

> **Handle where it happens → Stop propagation → Continue normally.**

```text
fun3()
 ↓
Exception
 ↓
catch
 ↓
Handled
 ↓
fun3() ending
 ↓
fun2() ending
 ↓
fun1() ending
 ↓
main() ending
```

---

## 3️⃣0️⃣ Interview Question

### ❓ What happens when an exception is handled in `fun3()`?

> The exception is handled inside `fun3()`, so it does not propagate to the calling methods. After handling, `fun3()` continues and returns normally to its caller.

---

## 3️⃣1️⃣ Interview Question

### ❓ Does the exception propagate to `fun2()`?

> No. Since `fun3()` has a suitable `catch` block and handles the exception, propagation stops in `fun3()`.

---

## 3️⃣2️⃣ Interview Question

### ❓ What happens after the `catch` block executes?

> Execution continues with the statement following the `catch` block, provided there is no other control-flow interruption.

---

## 3️⃣3️⃣ Complete Program

```java
class Demo {

    public static void main(String[] args) {

        fun1();

        System.out.println("main() ending");
    }

    static void fun1() {

        fun2();

        System.out.println("fun1() ending");
    }

    static void fun2() {

        fun3();

        System.out.println("fun2() ending");
    }

    static void fun3() {

        try {

            int result = 10 / 0;

        }
        catch (Exception e) {

            System.out.println("Exception handled");
        }

        System.out.println("fun3() ending");
    }
}
```

---

## 3️⃣4️⃣ Program Flow

```text
main()
 ↓
fun1()
 ↓
fun2()
 ↓
fun3()
 ↓
try
 ↓
10 / 0
 ↓
ArithmeticException
 ↓
catch(Exception e)
 ↓
Exception handled
 ↓
fun3() ending
 ↓
fun2() ending
 ↓
fun1() ending
 ↓
main() ending
```

---

## 3️⃣5️⃣ Super-Simple Mental Model 🧒

Imagine:

```text
Worker
 ↓
Problem
 ↓
Worker fixes it
```

The problem doesn't need to go to:

```text
Team Leader
Manager
Director
```

Similarly:

```text
fun3()
 ↓
Exception
 ↓
catch
 ↓
Handled
```

The exception doesn't need to travel to:

```text
fun2()
fun1()
main()
```

---

## 3️⃣6️⃣ Final Understanding 🎯

The complete process is:

```text
main()
 ↓
fun1()
 ↓
fun2()
 ↓
fun3()
 ↓
try
 ↓
Exception occurs
 ↓
catch handles exception
 ↓
fun3() ending
 ↓
fun2() ending
 ↓
fun1() ending
 ↓
main() ending
```

### ⭐ Remember:

> **When `fun3()` handles its own exception using `try-catch`, exception propagation stops in `fun3()`, and execution continues normally through `fun3()`, `fun2()`, `fun1()`, and finally `main()`.**
