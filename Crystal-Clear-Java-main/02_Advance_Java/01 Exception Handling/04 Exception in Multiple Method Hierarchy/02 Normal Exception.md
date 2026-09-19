# 🧒 4.2 Normal Execution

## 1️⃣ Start From ZERO

In Java, methods can call other methods.

For example:

```text
main()
  ↓
fun1()
  ↓
fun2()
  ↓
fun3()
```

This is called a **method calling chain**.

In normal execution, every method completes successfully and control returns back through the methods.

---

## 2️⃣ What Is Normal Execution?

**Normal execution** means:

> The program executes its statements without any exception and completes each method normally.

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
return
```

No exception occurs.

---

## 3️⃣ Real-World Analogy 🧒

Imagine:

```text
Manager
 ↓
Employee 1
 ↓
Employee 2
 ↓
Employee 3
```

The manager gives a task to Employee 1.

Employee 1 gives part of it to Employee 2.

Employee 2 gives part of it to Employee 3.

Employee 3 finishes the task and reports back:

```text
Employee 3
 ↑
Employee 2
 ↑
Employee 1
 ↑
Manager
```

Java method execution works similarly.

---

## 4️⃣ Simple Definition

> **Normal execution in a method hierarchy means methods are called one after another, execute successfully, and control returns through the calling methods after each method completes.**

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
```

Returning:

```text
fun3()
  ↓
fun2()
  ↓
fun1()
  ↓
main()
```

---

## 6️⃣ Simple Program

```java
import java.util.Scanner;

class Demo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        fun1(n);

        System.out.println("Back to main");
    }

    static void fun1(int n) {

        System.out.println("Inside fun1");

        fun2(n);

        System.out.println("Back to fun1");
    }

    static void fun2(int n) {

        System.out.println("Inside fun2");

        fun3(n);

        System.out.println("Back to fun2");
    }

    static void fun3(int n) {

        System.out.println("Inside fun3");

        int square = n * n;

        System.out.println("Square = " + square);
    }
}
```

---

## 7️⃣ Output

If the input is:

```text
5
```

Output:

```text
Enter a number: 5
Inside fun1
Inside fun2
Inside fun3
Square = 25
Back to fun2
Back to fun1
Back to main
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
Square calculation
  ↓
fun3() completes
  ↓
fun2() continues
  ↓
fun2() completes
  ↓
fun1() continues
  ↓
fun1() completes
  ↓
main() continues
```

---

## 9️⃣ Method Calling

`main()` calls:

```java
fun1(n);
```

Then `fun1()` calls:

```java
fun2(n);
```

Then `fun2()` calls:

```java
fun3(n);
```

Therefore:

```text
main()
 ↓
fun1()
 ↓
fun2()
 ↓
fun3()
```

---

## 🔟 Stack Hierarchy

When methods are called, they form an execution stack.

Initially:

```text
main()
```

After `main()` calls `fun1()`:

```text
fun1()
main()
```

After `fun1()` calls `fun2()`:

```text
fun2()
fun1()
main()
```

After `fun2()` calls `fun3()`:

```text
fun3()
fun2()
fun1()
main()
```

The latest method call is at the top.

---

## 1️⃣1️⃣ Why Is It Called a Stack?

Think about a stack of plates:

```text
   Plate 4  ← added last
   Plate 3
   Plate 2
   Plate 1  ← added first
```

The last plate added is removed first.

Similarly:

```text
fun3() ← called last → returns first
fun2()
fun1()
main() ← called first
```

This follows **LIFO**:

> **Last In, First Out**

---

## 1️⃣2️⃣ Input

The program receives input:

```java
int n = sc.nextInt();
```

For example:

```text
Input = 5
```

Then `n` is passed through the method hierarchy:

```text
main(5)
   ↓
fun1(5)
   ↓
fun2(5)
   ↓
fun3(5)
```

---

## 1️⃣3️⃣ Passing the Input

`main()` calls:

```java
fun1(n);
```

So `fun1()` receives the value.

Then:

```java
fun2(n);
```

passes it to `fun2()`.

Then:

```java
fun3(n);
```

passes it to `fun3()`.

Therefore:

```text
5
 ↓
fun1()
 ↓
fun2()
 ↓
fun3()
```

---

## 1️⃣4️⃣ Square Calculation

The calculation occurs inside `fun3()`:

```java
int square = n * n;
```

If:

```text
n = 5
```

then:

```text
5 × 5 = 25
```

So:

```text
Square = 25
```

---

## 1️⃣5️⃣ Visual Understanding

```text
                 main()
                   |
                input 5
                   |
                   ↓
                 fun1()
                   |
                   ↓
                 fun2()
                   |
                   ↓
                 fun3()
                   |
                   ↓
             5 × 5 = 25
```

---

## 1️⃣6️⃣ Returning Back

After `fun3()` completes:

```text
fun3()
  ↑
fun2()
```

Then `fun2()` completes:

```text
fun2()
  ↑
fun1()
```

Then `fun1()` completes:

```text
fun1()
  ↑
main()
```

So:

```text
Call:
main → fun1 → fun2 → fun3

Return:
fun3 → fun2 → fun1 → main
```

---

## 1️⃣7️⃣ Important Concept

A method doesn't permanently transfer control to another method.

When:

```java
fun1();
```

is called, execution temporarily moves to `fun1()`.

After `fun1()` finishes, control returns to the caller.

```text
main
 ↓
fun1
 ↑
main
```

---

## 1️⃣8️⃣ Normal Execution vs Exception

### Normal execution

```text
main
 ↓
fun1
 ↓
fun2
 ↓
fun3
 ↓
return
 ↑
 ↑
 ↑
main
```

### Exception execution

```text
main
 ↓
fun1
 ↓
fun2
 ↓
fun3
 ↓
Exception
```

The second situation is important for the next exception-hierarchy concepts.

---

## 1️⃣9️⃣ Connection With Exception Handling

Suppose the hierarchy is:

```text
main()
 ↓
fun1()
 ↓
fun2()
 ↓
fun3()
```

If everything is successful:

```text
fun3 → fun2 → fun1 → main
```

If `fun3()` produces an exception and doesn't handle it, the exception can move upward:

```text
fun3()
 ↓
fun2()
 ↓
fun1()
 ↓
main()
```

This is why understanding normal method execution is important before learning exception propagation.

---

## 2️⃣0️⃣ Runtime Understanding

At runtime, Java keeps track of active method calls.

Example:

```text
main()
 ↓
fun1()
 ↓
fun2()
 ↓
fun3()
```

At the deepest point:

```text
fun3()
fun2()
fun1()
main()
```

After `fun3()` completes, it is removed from the active call stack.

Then `fun2()` continues.

---

## 2️⃣1️⃣ Behind-the-Scenes

Conceptually:

```text
main() called
     ↓
fun1() added
     ↓
fun2() added
     ↓
fun3() added
     ↓
fun3() completes
     ↓
fun3() removed
     ↓
fun2() continues
     ↓
fun2() completes
     ↓
fun1() continues
     ↓
fun1() completes
     ↓
main() continues
```

---

## 2️⃣2️⃣ Important Technical Point

The **call stack** keeps track of active method invocations.

At the deepest point:

```text
fun3()
fun2()
fun1()
main()
```

When `fun3()` finishes, the top stack frame is removed.

This allows execution to return to `fun2()`.

---

## 2️⃣3️⃣ Common Confusion

### ❌ Does `fun1()` finish before `fun2()` is called?

No.

`fun1()` calls `fun2()` while `fun1()` is still active.

```text
fun1()
 ↓
fun2()
```

`fun1()` resumes after `fun2()` returns.

---

## 2️⃣4️⃣ Another Common Confusion

### ❌ Does `fun3()` return directly to `main()`?

No.

It returns to its immediate caller:

```text
fun3()
 ↓
fun2()
```

Then:

```text
fun2()
 ↓
fun1()
```

Then:

```text
fun1()
 ↓
main()
```

---

## 2️⃣5️⃣ Return Journey

The complete journey is:

```text
CALLING

main()
 ↓
fun1()
 ↓
fun2()
 ↓
fun3()


RETURNING

fun3()
 ↓
fun2()
 ↓
fun1()
 ↓
main()
```

Remember:

> **The method returns to the method that directly called it.**

---

## 2️⃣6️⃣ Hierarchy / Relationship

```text
main()
 │
 └── fun1()
       │
       └── fun2()
             │
             └── fun3()
```

This represents:

```text
Caller → Called method
```

For example:

```text
fun2() → fun3()
```

means `fun2()` is the caller of `fun3()`.

---

## 2️⃣7️⃣ Why Is Normal Execution Important?

Because it gives the foundation for understanding:

* Method call stack
* Method hierarchy
* Exception propagation
* Exception handling
* Runtime System behavior

The basic pattern is:

```text
Call ↓
Execute ↓
Return ↑
```

---

## 2️⃣8️⃣ Important Rules

1. Java starts execution from `main()`.
2. A method can call another method.
3. A called method becomes active before the caller continues.
4. Method calls create a hierarchy.
5. The call stack tracks active method calls.
6. The latest called method is at the top of the stack.
7. The latest called method normally returns first.
8. `fun1()` can call `fun2()`.
9. `fun2()` can call `fun3()`.
10. `fun3()` performs the square calculation in this example.
11. After `fun3()` completes, control returns to `fun2()`.
12. After `fun2()` completes, control returns to `fun1()`.
13. After `fun1()` completes, control returns to `main()`.
14. This is normal execution because no exception interrupts the flow.

---

## 2️⃣9️⃣ Memory Trick 🧠

Remember:

### **CALL DOWN — RETURN UP**

```text
CALL
main
 ↓
fun1
 ↓
fun2
 ↓
fun3

RETURN
fun3
 ↑
fun2
 ↑
fun1
 ↑
main
```

---

## 3️⃣0️⃣ Interview Question

### ❓ What happens when `fun1()` calls `fun2()`?

> Execution moves from `fun1()` to `fun2()`. After `fun2()` completes, control returns to `fun1()`.

---

## 3️⃣1️⃣ Interview Question

### ❓ What is the order of execution?

For:

```text
main() → fun1() → fun2() → fun3()
```

The execution order is:

```text
main → fun1 → fun2 → fun3
```

---

## 3️⃣2️⃣ Interview Question

### ❓ What is the return order?

For:

```text
main() → fun1() → fun2() → fun3()
```

The return order is:

```text
fun3 → fun2 → fun1 → main
```

---

## 3️⃣3️⃣ Complete Program

```java
import java.util.Scanner;

class Demo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        System.out.println("Inside main");

        fun1(n);

        System.out.println("Back to main");
    }

    static void fun1(int n) {

        System.out.println("Inside fun1");

        fun2(n);

        System.out.println("Back to fun1");
    }

    static void fun2(int n) {

        System.out.println("Inside fun2");

        fun3(n);

        System.out.println("Back to fun2");
    }

    static void fun3(int n) {

        System.out.println("Inside fun3");

        int square = n * n;

        System.out.println("Square = " + square);
    }
}
```

---

## 3️⃣4️⃣ Program Flow

For input:

```text
5
```

```text
main()
 ↓
Read 5
 ↓
fun1(5)
 ↓
fun2(5)
 ↓
fun3(5)
 ↓
5 × 5
 ↓
25
 ↓
return to fun2()
 ↓
return to fun1()
 ↓
return to main()
```

---

## 3️⃣5️⃣ Super-Simple Mental Model 🧒

Think of passing a message through three people:

```text
main
 ↓
Person 1
 ↓
Person 2
 ↓
Person 3
```

Person 3 completes the task first.

Then the result travels back:

```text
Person 3
 ↑
Person 2
 ↑
Person 1
 ↑
main
```

Java:

```text
main → fun1 → fun2 → fun3
fun3 → fun2 → fun1 → main
```

---

## 3️⃣6️⃣ Final `/eli5` Understanding 🎯

Normal method execution follows:

```text
Input
 ↓
main()
 ↓
fun1()
 ↓
fun2()
 ↓
fun3()
 ↓
Square calculation
 ↓
fun3() returns
 ↓
fun2() returns
 ↓
fun1() returns
 ↓
main() continues
```

### ⭐ Remember:

> **Methods are called from top to bottom, and after completing, control returns from bottom to top.**
