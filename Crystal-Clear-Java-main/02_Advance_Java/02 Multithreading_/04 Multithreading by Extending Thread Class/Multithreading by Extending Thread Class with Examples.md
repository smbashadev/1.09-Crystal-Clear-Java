# 🧒 22. Multithreading by Extending Thread Class

### 1. Basic Idea

Java allows us to create multithreading by **extending the predefined `Thread` class**.

The basic structure is:

```text
Your class
    ↓
extends Thread
    ↓
run()
    ↓
Thread activity
    ↓
start()
    ↓
Thread execution
```

In this topic, we will use two separate thread classes:

```text
TypeThread
   ↓
Typing activity

SyntaxThread
   ↓
Syntax-checking activity
```

This allows the application to have two different execution paths.

---

### 2. `TypeThread`

`TypeThread` is a user-defined class.

We make it a thread by extending the predefined `Thread` class:

```java
class TypeThread extends Thread {

}
```

The relationship is:

```text
Thread
   ↑
   |
TypeThread
```

Because `TypeThread` extends `Thread`, its object can be used to start thread execution.

---

### 3. Why `extends Thread` Is Used

The keyword `extends` establishes inheritance.

```java
class TypeThread extends Thread
```

means:

> `TypeThread` is a subclass of `Thread`.

The predefined `Thread` class provides thread-related functionality, while `TypeThread` defines the specific activity that this thread should perform.

---

### 4. `run()` in `TypeThread`

The typing activity is placed inside the `run()` method.

```java
class TypeThread extends Thread {

    public void run() {

        // Typing activity

    }
}
```

The `run()` method is the place where we define the work of this thread.

Think of it as:

```text
TypeThread
    ↓
"What work should I perform?"
    ↓
run()
    ↓
Typing activity
```

---

### 5. Typing Activity

Suppose the application needs to simulate typing.

We can write:

```java
System.out.println("Typing...");
```

inside `run()`.

For example:

```java
class TypeThread extends Thread {

    public void run() {

        System.out.println("Typing...");

    }
}
```

The thread's task is therefore to perform the typing-related activity.

---

### 6. Using a Loop

A loop allows the typing activity to be repeated.

For example:

```java
for (int i = 1; i <= 5; i++) {

    System.out.println("Typing...");

}
```

The loop means:

```text
i = 1 → Typing
i = 2 → Typing
i = 3 → Typing
i = 4 → Typing
i = 5 → Typing
```

So the typing activity happens five times.

---

### 7. Understanding the `for` Loop

The loop:

```java
for (int i = 1; i <= 5; i++)
```

has three important parts.

**Initialization:**

```java
int i = 1
```

The counter starts at `1`.

**Condition:**

```java
i <= 5
```

The loop continues while `i` is less than or equal to `5`.

**Increment:**

```java
i++
```

After each iteration, `i` increases by `1`.

Therefore:

```text
1 → 2 → 3 → 4 → 5 → stop
```

---

### 8. `Thread.sleep(1000)`

Inside the loop we can write:

```java
Thread.sleep(1000);
```

This pauses the **currently executing thread** for approximately 1000 milliseconds.

Since:

```text
1000 milliseconds ≈ 1 second
```

the thread pauses for approximately one second between iterations.

---

### 9. Why `sleep()` Is Used Here

Without `sleep()`:

```text
Typing
Typing
Typing
Typing
Typing
```

may be printed very quickly.

With:

```java
Thread.sleep(1000);
```

the output is spread over time:

```text
Typing...
   ↓ 1 second
Typing...
   ↓ 1 second
Typing...
   ↓ 1 second
Typing...
```

This makes the concurrent behavior easier to observe.

---

### 10. `InterruptedException`

`Thread.sleep()` can result in a checked `InterruptedException`.

Therefore, the code needs to handle or declare it.

A simple approach is:

```java
try {

    Thread.sleep(1000);

}
catch (InterruptedException e) {

    System.out.println("Thread interrupted");

}
```

This means:

```text
Try to sleep
     ↓
If interruption occurs
     ↓
catch handles it
```

---

### 11. Complete `TypeThread`

```java
class TypeThread extends Thread {

    public void run() {

        for (int i = 1; i <= 5; i++) {

            System.out.println("Typing...");

            try {

                Thread.sleep(1000);

            }
            catch (InterruptedException e) {

                System.out.println("Typing thread interrupted");

            }
        }
    }
}
```

This class creates a thread whose activity is typing.

---

### 12. Understanding `TypeThread` Flow

The execution inside `run()` is:

```text
run()
 ↓
Start loop
 ↓
Print "Typing..."
 ↓
Sleep approximately 1 second
 ↓
Next iteration
 ↓
Print "Typing..."
 ↓
Sleep approximately 1 second
 ↓
Continue
 ↓
After 5 iterations
 ↓
run() ends
```

The important point is that all of this is the activity of the `TypeThread`.

---

# SyntaxThread

### 13. `SyntaxThread`

Now we create another class:

```java
class SyntaxThread extends Thread {

}
```

This is another user-defined subclass of `Thread`.

Its purpose is to perform **syntax-checking activity**.

Conceptually:

```text
Thread
 ├── TypeThread
 └── SyntaxThread
```

Both are subclasses of `Thread`.

---

### 14. `run()` in `SyntaxThread`

The syntax-checking activity is placed inside its `run()` method.

```java
class SyntaxThread extends Thread {

    public void run() {

        // Syntax-checking activity

    }
}
```

So:

```text
SyntaxThread
      ↓
run()
      ↓
Syntax checking
```

---

### 15. Syntax-Checking Activity

We can represent syntax checking with a message:

```java
System.out.println("Checking syntax...");
```

For example:

```java
class SyntaxThread extends Thread {

    public void run() {

        System.out.println("Checking syntax...");

    }
}
```

The actual syntax analysis performed by an IDE is much more complicated, but this simple message is useful for understanding the thread concept.

---

### 16. Loop in `SyntaxThread`

We can also repeat the syntax-checking activity:

```java
for (int i = 1; i <= 5; i++) {

    System.out.println("Checking syntax...");

}
```

The loop executes five times.

```text
1 → Check syntax
2 → Check syntax
3 → Check syntax
4 → Check syntax
5 → Check syntax
```

---

### 17. `sleep(1000)` in `SyntaxThread`

We can pause the syntax thread after each check:

```java
Thread.sleep(1000);
```

Therefore:

```text
Syntax check
     ↓
Sleep ~1 second
     ↓
Syntax check
     ↓
Sleep ~1 second
```

This makes the execution of the two threads easier to observe.

---

### 18. Complete `SyntaxThread`

```java
class SyntaxThread extends Thread {

    public void run() {

        for (int i = 1; i <= 5; i++) {

            System.out.println("Checking syntax...");

            try {

                Thread.sleep(1000);

            }
            catch (InterruptedException e) {

                System.out.println("Syntax thread interrupted");

            }
        }
    }
}
```

Now we have two thread classes:

```text
TypeThread
   ↓
Typing

SyntaxThread
   ↓
Syntax checking
```

---

### 19. Two Different Execution Paths

The two classes provide two different activities:

```text
TypeThread
    ↓
run()
    ↓
Typing
    ↓
sleep
    ↓
Typing
```

and:

```text
SyntaxThread
    ↓
run()
    ↓
Syntax checking
    ↓
sleep
    ↓
Syntax checking
```

These are separate execution paths.

---

### 20. Creating the Thread Objects

Now we need objects.

```java
TypeThread t1 = new TypeThread();

SyntaxThread t2 = new SyntaxThread();
```

Here:

```text
t1 → TypeThread object
t2 → SyntaxThread object
```

Because both classes extend `Thread`, these objects can be used as thread objects.

---

### 21. What Does `new` Do?

Consider:

```java
new TypeThread();
```

The `new` keyword creates an object.

Similarly:

```java
new SyntaxThread();
```

creates another object.

So:

```java
TypeThread t1 = new TypeThread();
```

means:

```text
Create TypeThread object
        ↓
Store its reference in t1
```

---

### 22. Subclass Object as a Thread Object

This is a very important idea.

`TypeThread` is a subclass of `Thread`:

```text
Thread
   ↑
TypeThread
```

Therefore, a `TypeThread` object has the inherited thread functionality.

Likewise:

```text
Thread
   ↑
SyntaxThread
```

A `SyntaxThread` object also has the inherited thread functionality.

So:

```java
TypeThread t1 = new TypeThread();
SyntaxThread t2 = new SyntaxThread();
```

creates two thread-capable objects.

---

### 23. Starting the Threads

We start them using:

```java
t1.start();
t2.start();
```

The first statement starts the `TypeThread`.

The second starts the `SyntaxThread`.

Conceptually:

```text
t1.start()
   ↓
TypeThread starts
   ↓
TypeThread.run()
```

and:

```text
t2.start()
   ↓
SyntaxThread starts
   ↓
SyntaxThread.run()
```

---

### 24. Complete Program

```java
class TypeThread extends Thread {

    public void run() {

        for (int i = 1; i <= 5; i++) {

            System.out.println("Typing...");

            try {

                Thread.sleep(1000);

            }
            catch (InterruptedException e) {

                System.out.println("Typing thread interrupted");

            }
        }
    }
}


class SyntaxThread extends Thread {

    public void run() {

        for (int i = 1; i <= 5; i++) {

            System.out.println("Checking syntax...");

            try {

                Thread.sleep(1000);

            }
            catch (InterruptedException e) {

                System.out.println("Syntax thread interrupted");

            }
        }
    }
}


public class Test {

    public static void main(String[] args) {

        TypeThread t1 = new TypeThread();

        SyntaxThread t2 = new SyntaxThread();

        t1.start();

        t2.start();

    }
}
```

---

### 25. Complete Program Structure

The program can be understood as:

```text
Test
 ↓
main()
 ↓
Create TypeThread object
 ↓
Create SyntaxThread object
 ↓
t1.start()
 ↓
Typing thread begins

t2.start()
 ↓
Syntax thread begins
```

There are now two thread objects.

---

### 26. Possible Execution

The output might look like:

```text
Typing...
Checking syntax...
Typing...
Checking syntax...
Typing...
Checking syntax...
Typing...
Checking syntax...
Typing...
Checking syntax...
```

But the exact order is **not guaranteed**.

You might instead see:

```text
Checking syntax...
Typing...
Checking syntax...
Typing...
Typing...
Checking syntax...
...
```

This happens because thread scheduling determines when each thread executes.

---

### 27. Why Does `sleep(1000)` Not Guarantee Exact Ordering?

Both threads sleep for approximately one second.

But when they wake, that does not mean they will execute in a fixed order.

The scheduler determines which runnable thread gets processor execution time.

Therefore:

```text
T1 wakes
T2 wakes
```

does not guarantee:

```text
T1 prints first
T2 prints second
```

The opposite order can happen.

---

### 28. Important Note About Thread Creation

Your notes state:

> A thread is created when an object of `Thread` class or subclass is created.

For beginner understanding, this describes the connection between creating a `Thread`/subclass object and having a thread object.

However, there is an important distinction:

```text
Creating Thread object
        ≠
Starting thread execution
```

For example:

```java
TypeThread t1 = new TypeThread();
```

creates the thread object.

Actual concurrent thread execution begins when:

```java
t1.start();
```

is called.

This distinction is extremely important in Java.

---

### 29. Object Creation vs Thread Execution

Remember these two events separately:

```text
new TypeThread()
       ↓
Thread object created
```

Then:

```text
t1.start()
       ↓
Thread execution begins
       ↓
run() executes
```

So the complete relationship is:

```text
Object creation
      ↓
Thread object exists
      ↓
start()
      ↓
Thread begins execution
      ↓
run()
      ↓
Activity
```

---

### 30. What Happens Internally Conceptually?

When:

```java
t1.start();
```

is called, the JVM/runtime arranges for a new thread of execution to begin.

That thread executes the `run()` method.

Conceptually:

```text
main thread
     |
     | t1.start()
     ↓
TypeThread
     ↓
run()
     ↓
Typing activity
```

Then:

```text
main thread
     |
     | t2.start()
     ↓
SyntaxThread
     ↓
run()
     ↓
Syntax-checking activity
```

The actual scheduling details are handled by the JVM and operating system.

---

### 31. Main Thread Also Exists

When the Java program starts, the `main()` method executes on the main thread.

So our application conceptually has:

```text
Application
     ↓
Main Thread
     ├── creates t1
     ├── creates t2
     ├── starts t1
     └── starts t2

TypeThread
     ↓
Typing activity

SyntaxThread
     ↓
Syntax-checking activity
```

Thus, after `start()` calls, the application can have multiple threads executing.

---

### 32. Important Rules

* `Thread` is a predefined Java class.
* `TypeThread` is a user-defined subclass of `Thread`.
* `SyntaxThread` is another user-defined subclass of `Thread`.
* `extends` establishes inheritance between the subclass and `Thread`.
* The thread's activity is placed inside `run()`.
* A loop can be used to repeat the thread's activity.
* `Thread.sleep(1000)` pauses the currently executing thread for approximately one second.
* `sleep()` does not create another thread.
* `new TypeThread()` creates a `TypeThread` object.
* `new SyntaxThread()` creates a `SyntaxThread` object.
* Creating a thread object and starting thread execution are different events.
* `start()` is used to begin thread execution.
* `start()` causes the thread's `run()` method to execute as part of the new thread.
* Directly calling `run()` does not start a new thread.
* Multiple threads do not necessarily execute in a predictable order.
* Thread scheduling is handled by the runtime/operating system.
* `Thread.sleep()` requires handling or declaring `InterruptedException`.

---

### 33. Common Confusion: `start()` vs `run()`

This is one of the most frequently asked multithreading questions.

**Correct:**

```java
t1.start();
```

Meaning:

```text
Start new thread execution
       ↓
run()
```

**Not equivalent:**

```java
t1.run();
```

Meaning:

```text
Normal method call
       ↓
run()
```

It does not provide the new-thread behavior of `start()`.

Memory trick:

```text
start() → START a thread
run()   → RUN the task
```

---

### 34. Common Confusion: Thread Object vs Running Thread

Do not mix these two ideas.

```java
TypeThread t1 = new TypeThread();
```

means:

```text
Thread object created
```

while:

```java
t1.start();
```

means:

```text
Thread execution is started
```

Therefore:

```text
new
 ↓
Object creation

start()
 ↓
Thread execution
```

This distinction should be remembered clearly.

---

### 35. Memory Trick

Use this simple chain:

```text
EXTEND
  ↓
Thread
  ↓
CREATE OBJECT
  ↓
start()
  ↓
run()
  ↓
ACTIVITY
```

For this particular example:

```text
TypeThread
    ↓
start()
    ↓
run()
    ↓
Typing
    ↓
sleep(1000)
```

and:

```text
SyntaxThread
    ↓
start()
    ↓
run()
    ↓
Syntax checking
    ↓
sleep(1000)
```

The most important sentence to remember is:

> **`run()` contains the work, `start()` begins the thread, and the `Thread` object provides the thread mechanism.**

---

### 36. Interview Understanding

Multithreading can be achieved in Java by creating a class that **extends the predefined `Thread` class**. For example, `TypeThread` can extend `Thread` and place typing-related activity inside its `run()` method, while `SyntaxThread` can extend `Thread` and place syntax-checking activity inside its `run()` method. Objects are created using `new`, such as `new TypeThread()` and `new SyntaxThread()`. These objects represent thread objects because their classes are subclasses of `Thread`. Calling `start()` begins the corresponding thread's execution, and the thread then executes its `run()` method. A loop can repeatedly perform the activity, and `Thread.sleep(1000)` pauses that particular thread for approximately one second. The exact order in which the typing and syntax-checking messages appear cannot generally be guaranteed because thread scheduling determines when each runnable thread receives processor execution time. The most important distinction is **object creation is not the same as starting execution**: `new TypeThread()` creates the object, whereas `t1.start()` starts the thread.
