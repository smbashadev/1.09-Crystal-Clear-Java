# 🧒 26. Current Thread Name

### 1. Basic Idea

Every Java program runs with at least one thread.

When we run a normal Java program, Java automatically creates the **main thread** to execute the `main()` method.

So even if we do not create any extra thread ourselves:

```text
Java Program
     ↓
main()
     ↓
main thread executes
```

The default name of this thread is:

```text
main
```

That is why the output in this example is:

```text
main
```

---

### 2. What Is a Thread Name?

A thread name is simply a **name given to a thread so that we can identify it**.

For example:

```text
Thread 1 → fun
Thread 2 → Java
Thread 3 → Python
```

The name helps us understand which thread is executing a particular piece of code.

---

### 3. Real-World Analogy

Imagine a classroom with three students:

```text
Student → Ravi
Student → Rahul
Student → Priya
```

If the teacher asks:

> Who is currently answering?

we can identify the student by name.

Threads work similarly.

```text
Thread → fun
Thread → Java
Thread → Python
```

The thread name identifies the thread.

---

### 4. Creating a Thread Object

A `Thread` object can be created using:

```java
Thread t = new Thread();
```

Here:

```text
Thread
  ↓
Predefined Java class

t
  ↓
Reference variable

new Thread()
  ↓
Creates Thread object
```

The important point is that **creating a Thread object does not automatically mean that the thread has started executing**.

---

### 5. `setName()`

Java provides the `setName()` method to change the name of a thread.

Syntax:

```java
t.setName("fun");
```

Here:

```text
t
 ↓
Thread object

setName()
 ↓
Changes thread name

"fun"
 ↓
New thread name
```

So after:

```java
t.setName("fun");
```

the name of thread `t` becomes:

```text
fun
```

---

### 6. Understanding `"fun"`

In:

```java
t.setName("fun");
```

`"fun"` is a **String value**.

It is simply the name we want to give to the thread.

It does not mean that Java will execute a method called `fun()`.

These are completely different:

```java
t.setName("fun");
```

and:

```java
fun();
```

The first changes a thread's name.

The second calls a method named `fun`.

---

### 7. `Thread.currentThread()`

Java provides:

```java
Thread.currentThread()
```

This means:

> Give me the thread that is executing this code right now.

For example, when `main()` is executing:

```text
Currently executing thread
          ↓
       main
```

Therefore:

```java
Thread.currentThread()
```

returns the main thread.

---

### 8. `getName()`

Once we have the current thread, we can obtain its name using:

```java
getName()
```

Therefore:

```java
Thread.currentThread().getName()
```

means:

```text
Thread
  ↓
currentThread()
  ↓
Find the thread currently executing
  ↓
getName()
  ↓
Get that thread's name
```

---

### 9. The Complete Statement

```java
System.out.println(Thread.currentThread().getName());
```

This statement asks Java:

> "Which thread is currently executing this statement, and what is its name?"

If `main()` is executing it, the answer is:

```text
main
```

---

### 10. Important Point About `setName("fun")`

Consider:

```java
Thread t = new Thread();

t.setName("fun");

System.out.println(Thread.currentThread().getName());
```

A beginner may expect:

```text
fun
```

But the output is:

```text
main
```

Why?

Because:

```java
t.setName("fun");
```

changes the name of **`t`**.

But:

```java
Thread.currentThread().getName()
```

asks for the name of the **currently executing thread**.

The currently executing thread is still:

```text
main
```

---

### 11. Very Important Difference

Look carefully:

```text
Thread t
   ↓
Name = fun
```

But:

```text
main()
   ↓
executed by main thread
   ↓
Name = main
```

Therefore:

```java
t.setName("fun");
```

does not rename the main thread.

It renames only `t`.

---

### 12. `Test5` Program

A simple program based on your topic is:

```java
class Test5 {

    public static void main(String[] args) {

        Thread t = new Thread();

        t.setName("fun");

        System.out.println(
            Thread.currentThread().getName()
        );
    }
}
```

Output:

```text
main
```

---

### 13. Line-by-Line Explanation

First:

```java
class Test5 {
```

This creates a user-defined class named `Test5`.

The class contains our Java program.

---

### 14. `main()` Method

```java
public static void main(String[] args) {
```

The `main()` method is the starting point of this program.

Java starts executing the program from `main()`.

The thread that executes `main()` is called the **main thread**.

---

### 15. Creating the Thread Object

```java
Thread t = new Thread();
```

This creates a new `Thread` object and stores its reference in `t`.

At this point:

```text
t
 ↓
Thread object
```

The thread object has its own thread-related information, including a name.

---

### 16. Changing Its Name

```java
t.setName("fun");
```

This changes the name of `t` to:

```text
fun
```

So we can visualize:

```text
t
 ↓
Thread object
 ↓
Name = fun
```

But remember: we have not started `t`.

---

### 17. Finding the Current Thread

Next:

```java
Thread.currentThread()
```

Java asks:

> Which thread is executing this statement?

The answer is:

```text
main
```

because the `main()` method is currently being executed by the main thread.

---

### 18. Getting the Current Thread's Name

Then:

```java
Thread.currentThread().getName()
```

works like this:

```text
currentThread()
      ↓
main thread
      ↓
getName()
      ↓
"main"
```

Therefore the result is:

```text
main
```

---

### 19. Printing the Result

Finally:

```java
System.out.println(
    Thread.currentThread().getName()
);
```

`System.out.println()` prints the value returned by:

```java
Thread.currentThread().getName()
```

The value is:

```text
main
```

Therefore:

```text
Output:
main
```

---

### 20. Complete Execution Flow

```text
Test5
  ↓
main()
  ↓
Main thread starts executing
  ↓
Create Thread object t
  ↓
t.setName("fun")
  ↓
t's name becomes "fun"
  ↓
main thread continues
  ↓
Thread.currentThread()
  ↓
Find current executing thread
  ↓
main thread
  ↓
getName()
  ↓
"main"
  ↓
Print
  ↓
main
```

---

### 21. Why Isn't the Output `fun`?

This is the most important confusion in this topic.

We have:

```java
t.setName("fun");
```

So:

```text
t → fun
```

But we ask:

```java
Thread.currentThread().getName()
```

The question being asked is:

> What is the name of the thread executing this statement?

That thread is:

```text
main
```

Therefore:

```text
Output → main
```

---

### 22. What Would Print `fun`?

If we write:

```java
System.out.println(t.getName());
```

then we are directly asking for the name of `t`.

Since we previously wrote:

```java
t.setName("fun");
```

the output would be:

```text
fun
```

So:

```java
t.getName()
```

gives:

```text
fun
```

while:

```java
Thread.currentThread().getName()
```

gives:

```text
main
```

in this program.

---

### 23. Direct Comparison

| Code                               | Meaning                         | Output           |
| ---------------------------------- | ------------------------------- | ---------------- |
| `t.setName("fun")`                 | Changes `t`'s name              | No direct output |
| `t.getName()`                      | Gets `t`'s name                 | `fun`            |
| `Thread.currentThread()`           | Gets currently executing thread | Main thread here |
| `Thread.currentThread().getName()` | Gets current thread's name      | `main`           |

---

### 24. Thread Picture

The program actually has two important thread objects/concepts to distinguish:

```text
                 Java Program
                      ↓
                   main()
                      ↓
               Main Thread
               Name = main

                      +

                  Thread t
                  Name = fun
```

The important thing is:

```text
main thread → executing main()
t           → created but not started
```

Therefore, the current thread is `main`.

---

### 25. Creating a Thread Is Not Starting It

This is another important rule.

When we write:

```java
Thread t = new Thread();
```

we create a Thread object.

But to start that thread, we normally use:

```java
t.start();
```

So:

```text
new Thread()
    ↓
Thread object created

start()
    ↓
Thread begins execution
```

In the `Test5` example, we do not call:

```java
t.start();
```

Therefore, `t` does not become the thread executing the following statement.

---

### 26. If `t.start()` Were Used

Suppose we had:

```java
Thread t = new Thread();

t.setName("fun");

t.start();
```

Now `t` starts execution.

But simply calling:

```java
t.start();
```

does not automatically mean that the next statement in `main()` is executed by `t`.

The `main` thread continues its own execution, while `t` gets its own execution path.

This is why identifying the current thread is important in multithreading.

---

### 27. Real-World Example

Imagine a company has:

```text
Manager → main
Worker → fun
```

The manager creates the worker:

```text
main
 ↓
creates worker
 ↓
worker name = fun
```

If the manager asks:

> "Who is speaking right now?"

the answer is:

```text
main
```

Even though the worker has the name `fun`.

Similarly:

```java
Thread.currentThread().getName()
```

identifies the thread currently executing the code.

---

### 28. Common Mistake

A common beginner mistake is thinking:

```java
t.setName("fun");
```

means:

```text
Current thread = fun
```

That is incorrect.

It means:

```text
Thread t
   ↓
Name changed to fun
```

Only `t` has been renamed.

---

### 29. Another Common Mistake

Do not confuse:

```java
t.getName()
```

with:

```java
Thread.currentThread().getName()
```

They answer different questions.

```text
t.getName()
     ↓
"What is t's name?"

Thread.currentThread().getName()
     ↓
"What is the name of the thread executing right now?"
```

---

### 30. Important Rules

* Every Java program starts with a `main` thread.
* The `main` thread executes the `main()` method.
* `Thread` is a predefined Java class.
* `new Thread()` creates a Thread object.
* `setName()` changes a thread's name.
* `getName()` obtains a thread's name.
* `Thread.currentThread()` returns the currently executing thread.
* `Thread.currentThread().getName()` returns the name of the currently executing thread.
* Renaming one Thread object does not rename another thread.
* Creating a Thread object does not automatically start it.
* `start()` is used to begin a new thread's execution.
* In the given `Test5` program, `t` is named `fun`, but `main()` is still executing on the `main` thread.
* Therefore the output is `main`.

---

### 31. The Most Important Difference

Keep this picture permanently:

```text
t.setName("fun")
       ↓
       t
       ↓
    Name = fun
```

But:

```text
Thread.currentThread()
       ↓
Who is executing NOW?
       ↓
main
       ↓
getName()
       ↓
main
```

These are two different operations.

---

### 32. Easy Memory Trick

Remember:

```text
setName() → GIVE a name
getName() → TAKE a name
currentThread() → FIND who is working NOW
```

So:

```text
t.setName("fun")
      ↓
Give t the name "fun"

Thread.currentThread()
      ↓
Find who is working now

.getName()
      ↓
Get that worker's name
```

---

### 33. One-Line Memory Formula

```text
currentThread() + getName()
              ↓
       WHO IS WORKING?
              ↓
        WHAT IS ITS NAME?
```

In `Test5`:

```text
Who is working?
     ↓
main thread

What is its name?
     ↓
main
```

---

### 34. Expected Output

The program produces:

```text
main
```

The reason is simple:

```text
main() is executing
      ↓
main thread is executing
      ↓
currentThread() = main thread
      ↓
getName() = main
      ↓
Output = main
```

---

### 35. Interview Understanding

`Thread.currentThread().getName()` is used to obtain the name of the thread that is currently executing the code. In the `Test5` example, a Thread object `t` is created and its name is changed to `"fun"` using `setName("fun")`. However, the program does not start `t`; the `main()` method is still being executed by the main thread. Therefore, `Thread.currentThread()` returns the main thread, and `getName()` returns `"main"`. The output is consequently:

```text
main
```

The important distinction is between **the name of a particular Thread object** (`t.getName() → fun`) and **the name of the currently executing thread** (`Thread.currentThread().getName() → main`).

---

### 36. Lifetime Memory

```text
              Test5
                ↓
              main()
                ↓
          Main thread executes
                ↓
        Create Thread object t
                ↓
        t.setName("fun")
                ↓
           t → Name = fun
                ↓
        BUT t is not started
                ↓
       main() continues executing
                ↓
   Thread.currentThread()
                ↓
      Currently executing = main
                ↓
            getName()
                ↓
              main
                ↓
             OUTPUT
                ↓
              main
```

### 🔑 Remember Forever

> **`setName("fun")` changes the name of `t`; `Thread.currentThread().getName()` tells you the name of whoever is executing the code right now. In `Test5`, that thread is `main`, so the output is `main`.**
