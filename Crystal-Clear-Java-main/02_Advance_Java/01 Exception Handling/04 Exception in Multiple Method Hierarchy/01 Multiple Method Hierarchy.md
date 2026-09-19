# 🧒 4.1 Multiple Method Hierarchy

## 1️⃣ Start From ZERO

Imagine a Java program where methods call other methods.

For example:

```java
main()
  ↓
fun1()
  ↓
fun2()
  ↓
fun3()
```

Here, the execution can move from one method to another.

---

## 2️⃣ What Is a Method Hierarchy?

A **method hierarchy** means the sequence or chain in which methods are called.

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

Each method can call another method.

---

## 3️⃣ Real-World Analogy 🧒

Imagine a manager gives work to an employee:

```text
Manager
  ↓
Team Leader
  ↓
Employee
  ↓
Assistant
```

Similarly:

```text
main()
  ↓
fun1()
  ↓
fun2()
  ↓
fun3()
```

One method can transfer execution to another method.

---

## 4️⃣ Simple Definition

> **Multiple Method Hierarchy is a chain of method calls where one method calls another method, which may call another method, forming multiple levels of execution.**

---

## 5️⃣ Basic Structure

```java
void main() {
    fun1();
}

void fun1() {
    fun2();
}

void fun2() {
    fun3();
}

void fun3() {
    // task
}
```

The flow is:

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

## 6️⃣ Simple Program

```java
class Demo {

    public static void main(String[] args) {

        System.out.println("Inside main");

        fun1();
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
    }
}
```

---

## 7️⃣ Output

```text
Inside main
Inside fun1
Inside fun2
Inside fun3
```

---

## 8️⃣ Execution Flow

```text
Program starts
     ↓
main()
     ↓
fun1()
     ↓
fun2()
     ↓
fun3()
     ↓
fun3() completes
     ↓
fun2() completes
     ↓
fun1() completes
     ↓
main() completes
```

---

## 9️⃣ Line-by-Line Explanation

### `main()`

```java
public static void main(String[] args)
```

Java starts execution from `main()`.

Then:

```java
fun1();
```

calls `fun1()`.

---

### `fun1()`

```java
static void fun1()
```

`fun1()` executes and calls:

```java
fun2();
```

---

### `fun2()`

`fun2()` executes and calls:

```java
fun3();
```

---

### `fun3()`

`fun3()` executes its statements and then finishes.

---

## 🔟 What Happens Internally?

Think of method calls as creating a path:

```text
main()
  ↓
fun1()
  ↓
fun2()
  ↓
fun3()
```

When `fun3()` finishes, control returns to `fun2()`.

Then:

```text
fun2()
  ↓
fun1()
  ↓
main()
```

---

## 1️⃣1️⃣ Why Does Java Return Back?

When one method calls another method, Java must remember **where it needs to return after the called method finishes**.

For example:

```java
fun1();
```

After `fun1()` finishes, execution returns to the point after that call.

---

## 1️⃣2️⃣ Real Execution Picture

```text
              main()
                |
                ↓
              fun1()
                |
                ↓
              fun2()
                |
                ↓
              fun3()
```

Then the return journey is:

```text
              fun3()
                |
                ↓
              fun2()
                |
                ↓
              fun1()
                |
                ↓
              main()
```

---

## 1️⃣3️⃣ Important Concept

The method hierarchy has **two directions**:

### Calling direction

```text
main → fun1 → fun2 → fun3
```

### Returning direction

```text
fun3 → fun2 → fun1 → main
```

---

## 1️⃣4️⃣ Visual Understanding

Imagine climbing stairs:

```text
main()
  ↓
  ├── fun1()
  │     ↓
  │   fun2()
  │     ↓
  │   fun3()
```

You go deeper:

```text
main
 ↓
fun1
 ↓
fun2
 ↓
fun3
```

Then come back upward:

```text
fun3
 ↑
fun2
 ↑
fun1
 ↑
main
```

---

## 1️⃣5️⃣ Valid Example

```java
class Demo {

    public static void main(String[] args) {
        fun1();
    }

    static void fun1() {
        fun2();
    }

    static void fun2() {
        fun3();
    }

    static void fun3() {
        System.out.println("Hello");
    }
}
```

Output:

```text
Hello
```

---

## 1️⃣6️⃣ What If `fun3()` Has More Work?

For example:

```java
static void fun3() {
    System.out.println("Inside fun3");
}
```

After `fun3()` finishes:

```text
fun3()
 ↓
fun2()
 ↓
fun1()
 ↓
main()
```

The previous methods continue from where their calls ended.

---

## 1️⃣7️⃣ Comparison

| Method   | Calls                             |
| -------- | --------------------------------- |
| `main()` | `fun1()`                          |
| `fun1()` | `fun2()`                          |
| `fun2()` | `fun3()`                          |
| `fun3()` | No further method in this example |

So:

```text
main → fun1 → fun2 → fun3
```

---

## 1️⃣8️⃣ Connection With Previous Concepts

This concept becomes important when studying **exceptions**.

Suppose:

```text
main()
  ↓
fun1()
  ↓
fun2()
  ↓
fun3()
```

and an exception occurs inside `fun3()`.

Java needs to determine:

> **Where can this exception be handled?**

This is why multiple method hierarchy is important in exception handling.

---

## 1️⃣9️⃣ Runtime Understanding

Suppose:

```java
main() → fun1() → fun2() → fun3()
```

At runtime:

```text
main()
 ↓
fun1()
 ↓
fun2()
 ↓
fun3()
```

Each method becomes part of the current execution chain.

If `fun3()` produces an exception, Java can search through the calling hierarchy for a suitable handler.

---

## 2️⃣0️⃣ Behind-the-Scenes Explanation

Conceptually, method calls create a **call stack**:

```text
fun3()
fun2()
fun1()
main()
```

The most recently called method is at the top.

When `fun3()` finishes:

```text
fun3() removed
   ↓
fun2() becomes active
```

Then:

```text
fun2() removed
   ↓
fun1() becomes active
```

And so on.

---

## 2️⃣1️⃣ Important Technical Point

The method-call sequence:

```text
main()
 ↓
fun1()
 ↓
fun2()
 ↓
fun3()
```

is commonly understood as a **method call chain** or **call hierarchy**.

The runtime maintains information about these active method calls so that control can return correctly.

---

## 2️⃣2️⃣ Common Confusion

### ❌ Does `main()` execute `fun3()` directly?

Not in this example.

The chain is:

```text
main()
 ↓
fun1()
 ↓
fun2()
 ↓
fun3()
```

So `main()` directly calls `fun1()`, while `fun2()` and `fun3()` are reached indirectly.

---

## 2️⃣3️⃣ Another Common Confusion

### ❌ After calling `fun1()`, does `main()` continue immediately?

No.

Suppose:

```java
fun1();

System.out.println("Main");
```

Java first executes `fun1()`.

Only after `fun1()` completes does execution return to `main()` and continue.

```text
main
 ↓
fun1
 ↓
return
 ↓
main continues
```

---

## 2️⃣4️⃣ Exception Flow Connection

Suppose:

```text
main()
 ↓
fun1()
 ↓
fun2()
 ↓
fun3()
```

An exception occurs in `fun3()`:

```text
fun3()
 ↓
Exception
```

If `fun3()` doesn't handle it, exception handling can move upward through the calling methods:

```text
fun3()
 ↓
fun2()
 ↓
fun1()
 ↓
main()
```

This is called **exception propagation**.

---

## 2️⃣5️⃣ Hierarchy / Relationship

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

The relationship is:

```text
Caller
  ↓
Called method
```

For example:

```text
main() → fun1()
```

means `main()` is the caller and `fun1()` is the called method.

---

## 2️⃣6️⃣ Why Is This Important for Exceptions?

Because an exception may occur deep inside the hierarchy.

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

If `fun3()` doesn't handle it, Java can look toward its callers.

```text
fun3()
 ↓
fun2()
 ↓
fun1()
 ↓
main()
```

This allows exception handling to work across multiple method levels.

---

## 2️⃣7️⃣ Important Rules

1. Java begins execution from `main()`.
2. A method can call another method.
3. A called method executes before control returns to its caller.
4. Methods can form multiple levels of calls.
5. `main()` can call `fun1()`.
6. `fun1()` can call `fun2()`.
7. `fun2()` can call `fun3()`.
8. After `fun3()` completes, control returns to `fun2()`.
9. After `fun2()` completes, control returns to `fun1()`.
10. After `fun1()` completes, control returns to `main()`.
11. This creates a method-call chain.
12. Such a hierarchy is important when understanding exception propagation.

---

## 2️⃣8️⃣ Memory Trick 🧠

Remember:

> **Call DOWN, Return UP.**

```text
CALL:
main
 ↓
fun1
 ↓
fun2
 ↓
fun3

RETURN:
fun3
 ↑
fun2
 ↑
fun1
 ↑
main
```

---

## 2️⃣9️⃣ Interview Question

### ❓ What is a method call hierarchy?

**Answer:**

> A method call hierarchy is a sequence of method calls where one method calls another, forming multiple levels such as `main() → fun1() → fun2() → fun3()`.

---

## 3️⃣0️⃣ Interview Question

### ❓ What happens when `fun1()` calls `fun2()`?

**Answer:**

> Execution temporarily moves from `fun1()` to `fun2()`. After `fun2()` completes, control returns to `fun1()` and continues from the point after the method call.

---

## 3️⃣1️⃣ Interview Question

### ❓ What happens if an exception occurs in `fun3()`?

**Answer:**

> If `fun3()` does not handle the exception, the exception can propagate through its calling methods such as `fun2()`, `fun1()`, and eventually `main()`, until a suitable handler is found or the exception remains uncaught.

---

## 3️⃣2️⃣ Interview Question

### ❓ Why is method hierarchy important in exception handling?

**Answer:**

> Because an exception may occur in a deeply called method. If that method does not handle it, Java can propagate the exception toward its callers to search for a suitable exception handler.

---

## 3️⃣3️⃣ Complete Program

```java
class Demo {

    public static void main(String[] args) {

        System.out.println("Inside main");

        fun1();

        System.out.println("Back to main");
    }

    static void fun1() {

        System.out.println("Inside fun1");

        fun2();

        System.out.println("Back to fun1");
    }

    static void fun2() {

        System.out.println("Inside fun2");

        fun3();

        System.out.println("Back to fun2");
    }

    static void fun3() {

        System.out.println("Inside fun3");
    }
}
```

Output:

```text
Inside main
Inside fun1
Inside fun2
Inside fun3
Back to fun2
Back to fun1
Back to main
```

This clearly demonstrates:

```text
main()
 ↓
fun1()
 ↓
fun2()
 ↓
fun3()
```

and then:

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

## 3️⃣4️⃣ Your Topic Mapped to the Program

### `main()`

```java
public static void main(String[] args)
```

The starting point.

### `fun1()`

```java
fun1();
```

Called by `main()`.

### `fun2()`

```java
fun2();
```

Called by `fun1()`.

### `fun3()`

```java
fun3();
```

Called by `fun2()`.

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

## 3️⃣5️⃣ Super-Simple Mental Model 🧒

Think of four people:

```text
Person 1 → Person 2 → Person 3 → Person 4
```

Person 1 asks Person 2 to do something.

Person 2 asks Person 3.

Person 3 asks Person 4.

After Person 4 finishes:

```text
Person 4 → Person 3 → Person 2 → Person 1
```

Java:

```text
main()
 ↓
fun1()
 ↓
fun2()
 ↓
fun3()

fun3()
 ↑
fun2()
 ↑
fun1()
 ↑
main()
```

---

## 3️⃣6️⃣ Final `/eli5` Understanding 🎯

A multiple method hierarchy is simply a **chain of method calls**:

```text
main()
   ↓
fun1()
   ↓
fun2()
   ↓
fun3()
```

Java goes **down the call chain**:

```text
main → fun1 → fun2 → fun3
```

and returns **back up the chain**:

```text
fun3 → fun2 → fun1 → main
```

This becomes especially important for exception handling because an exception occurring in a deeply called method can **propagate upward through the method hierarchy** looking for a suitable exception handler.
