# 🧒 23. Multithreading by Implementing Runnable

### 1. Basic Idea

The second common way to create a thread in Java is by **implementing the `Runnable` interface**.

Instead of making our class itself a `Thread`, we make our class represent the **task** that should be performed.

```text
Runnable
   ↓
Task
   ↓
run()
   ↓
Thread executes the task
```

For this example, we have two tasks:

```text
TypeThread
   ↓
Typing

SyntaxThread
   ↓
Syntax checking
```

---

### 2. Why `Runnable` Is Used

Suppose we want to create a program that performs two activities:

```text
Typing
Syntax checking
```

We can define each activity as a separate `Runnable` task.

```text
Application
    ↓
 ┌──┴──────────┐
 ↓             ↓
Typing Task    Syntax Task
```

Then we give those tasks to `Thread` objects.

This creates a clean separation between:

```text
WHAT WORK?
    ↓
Runnable

WHO EXECUTES THE WORK?
    ↓
Thread
```

---

### 3. `Runnable` Interface

`Runnable` is a predefined Java interface.

Its important method is:

```java
void run();
```

The interface essentially provides a contract:

> A class that implements `Runnable` must provide the `run()` method.

Conceptually:

```text
Runnable
   ↓
requires run()
   ↓
Your class provides run()
```

---

### 4. `implements Runnable`

To make a class a runnable task, we write:

```java
class TypeThread implements Runnable {
    
}
```

The keyword:

```java
implements
```

means that the class agrees to follow the contract provided by the interface.

So:

```text
TypeThread
     ↓
implements
     ↓
Runnable
```

---

### 5. TypeThread

Now we create the first task:

```java
class TypeThread implements Runnable {

    public void run() {

        System.out.println("Typing");

    }
}
```

Here, `TypeThread` does **not** extend `Thread`.

It implements `Runnable`.

Therefore, the object of `TypeThread` represents the **typing task**.

---

### 6. `run()` in TypeThread

The work that the typing task should perform is written inside:

```java
public void run()
```

Example:

```java
public void run() {

    System.out.println("Typing");

}
```

The flow is:

```text
TypeThread object
      ↓
run()
      ↓
Typing activity
```

The `run()` method is therefore the place where we define the task's activity.

---

### 7. Simple Typing Example

Suppose an editor needs to simulate typing five times.

We can write:

```java
class TypeThread implements Runnable {

    public void run() {

        for (int i = 1; i <= 5; i++) {

            System.out.println("Typing");

        }
    }
}
```

The loop repeats the activity:

```text
Typing
Typing
Typing
Typing
Typing
```

---

### 8. Understanding the Loop

The statement:

```java
for (int i = 1; i <= 5; i++)
```

has three parts.

```text
int i = 1
    ↓
Starting value

i <= 5
    ↓
Continue condition

i++
    ↓
Increase by 1
```

Execution:

```text
i = 1 → Typing
i = 2 → Typing
i = 3 → Typing
i = 4 → Typing
i = 5 → Typing
i = 6 → condition false → stop
```

---

### 9. SyntaxThread

Now we create another task:

```java
class SyntaxThread implements Runnable {

    public void run() {

        System.out.println("Syntax checking");

    }
}
```

This class also implements `Runnable`.

Its purpose is different:

```text
TypeThread
    ↓
Typing

SyntaxThread
    ↓
Syntax checking
```

---

### 10. `run()` in SyntaxThread

The syntax-checking activity is placed inside its `run()` method:

```java
public void run() {

    System.out.println("Syntax checking");

}
```

The flow is:

```text
SyntaxThread object
       ↓
run()
       ↓
Syntax-checking activity
```

---

### 11. Simple Syntax-Checking Example

We can repeat syntax checking using a loop:

```java
class SyntaxThread implements Runnable {

    public void run() {

        for (int i = 1; i <= 5; i++) {

            System.out.println("Syntax checking");

        }
    }
}
```

The task performs:

```text
Syntax checking
Syntax checking
Syntax checking
Syntax checking
Syntax checking
```

---

### 12. Two Runnable Tasks

Now our application has two independent task classes:

```text
             Runnable
              /     \
             /       \
            ↓         ↓
    TypeThread      SyntaxThread
         ↓                ↓
       run()             run()
         ↓                ↓
      Typing        Syntax checking
```

Neither class itself extends `Thread`.

They are **Runnable task definitions**.

---

### 13. Creating the Task Objects

In the `main()` method, we create objects:

```java
TypeThread typeTask = new TypeThread();

SyntaxThread syntaxTask = new SyntaxThread();
```

These are **Runnable objects**.

Conceptually:

```text
typeTask
   ↓
TypeThread object
   ↓
Typing task

syntaxTask
   ↓
SyntaxThread object
   ↓
Syntax-checking task
```

---

### 14. Why Are They Called Task Objects?

Because these objects describe **what work needs to be performed**.

The `TypeThread` object contains:

```text
Typing activity
```

The `SyntaxThread` object contains:

```text
Syntax-checking activity
```

But these objects are not themselves `Thread` objects.

That distinction is very important.

---

### 15. Creating the Thread Objects

Now we create actual `Thread` objects:

```java
Thread t1 = new Thread(typeTask);

Thread t2 = new Thread(syntaxTask);
```

Here:

```text
typeTask
   ↓
Runnable object
   ↓
given to
   ↓
Thread t1
```

and:

```text
syntaxTask
   ↓
Runnable object
   ↓
given to
   ↓
Thread t2
```

---

### 16. Passing Runnable to Thread

This statement:

```java
Thread t1 = new Thread(typeTask);
```

means:

> Create a `Thread` object and associate the `typeTask` Runnable object with it.

Similarly:

```java
Thread t2 = new Thread(syntaxTask);
```

associates the syntax-checking task with another thread.

The relationship becomes:

```text
Thread t1 → typeTask → Typing

Thread t2 → syntaxTask → Syntax checking
```

---

### 17. Constructor Concept

The statement:

```java
new Thread(typeTask)
```

uses a `Thread` constructor that accepts a `Runnable`.

Conceptually:

```text
Thread constructor
       ↓
receives Runnable object
       ↓
Thread knows which task to execute
```

This is how the task and thread are connected.

---

### 18. Starting the First Thread

Now we write:

```java
t1.start();
```

This starts the first thread.

The execution relationship is:

```text
t1.start()
    ↓
Thread starts
    ↓
Runnable task
    ↓
typeTask.run()
    ↓
Typing
```

The `run()` method contains the actual task.

---

### 19. Starting the Second Thread

Then:

```java
t2.start();
```

starts the second thread.

The conceptual flow is:

```text
t2.start()
    ↓
Thread starts
    ↓
Runnable task
    ↓
syntaxTask.run()
    ↓
Syntax checking
```

Now two threads have been started.

---

### 20. Complete `EclipseApps` Program

```java
class TypeThread implements Runnable {

    public void run() {

        for (int i = 1; i <= 5; i++) {

            System.out.println("Typing");

            try {

                Thread.sleep(1000);

            }
            catch (InterruptedException e) {

                System.out.println("Typing thread interrupted");

            }
        }
    }
}


class SyntaxThread implements Runnable {

    public void run() {

        for (int i = 1; i <= 5; i++) {

            System.out.println("Syntax checking");

            try {

                Thread.sleep(1000);

            }
            catch (InterruptedException e) {

                System.out.println("Syntax thread interrupted");

            }
        }
    }
}


public class EclipseApps {

    public static void main(String[] args) {

        TypeThread typeTask = new TypeThread();

        SyntaxThread syntaxTask = new SyntaxThread();

        Thread t1 = new Thread(typeTask);

        Thread t2 = new Thread(syntaxTask);

        t1.start();

        t2.start();

    }
}
```

---

### 21. Complete Program Structure

The entire program can be understood as:

```text
EclipseApps
     ↓
main()
     ↓
Create TypeThread task
     ↓
Create SyntaxThread task
     ↓
Create Thread t1 with TypeThread
     ↓
Create Thread t2 with SyntaxThread
     ↓
t1.start()
     ↓
Typing thread starts

t2.start()
     ↓
Syntax thread starts
     ↓
Syntax-checking activity
```

---

### 22. What Happens After `t1.start()`?

When:

```java
t1.start();
```

is executed, the first thread is started.

Its task is associated with:

```text
typeTask
```

The thread eventually executes the task's:

```java
run()
```

method.

Therefore:

```text
t1
 ↓
typeTask
 ↓
run()
 ↓
Typing
```

---

### 23. What Happens After `t2.start()`?

When:

```java
t2.start();
```

is executed, the second thread is started.

Its associated task is:

```text
syntaxTask
```

Therefore:

```text
t2
 ↓
syntaxTask
 ↓
run()
 ↓
Syntax checking
```

---

### 24. Concurrent Execution

Because both threads have been started:

```java
t1.start();
t2.start();
```

their activities can execute concurrently.

Conceptually:

```text
Thread 1                  Thread 2
   ↓                         ↓
Typing                 Syntax checking
   ↓                         ↓
Typing                 Syntax checking
   ↓                         ↓
Typing                 Syntax checking
```

The scheduler controls when each thread gets processor execution time.

---

### 25. Interleaved Execution

The output can be **interleaved**.

For example:

```text
Typing
Syntax checking
Typing
Syntax checking
Typing
Syntax checking
Typing
Syntax checking
```

But another execution could produce:

```text
Typing
Typing
Syntax checking
Typing
Syntax checking
Syntax checking
...
```

The exact order is not guaranteed.

---

### 26. Why Is the Output Interleaved?

Both threads are independently eligible to execute.

Conceptually:

```text
T1 → Typing
T2 → Syntax checking
T1 → Typing
T2 → Syntax checking
```

The scheduler determines which runnable thread gets processor execution time.

Therefore, we should not assume that:

```text
t1
```

will completely finish before:

```text
t2
```

starts executing.

---

### 27. Role of `sleep(1000)`

In the example:

```java
Thread.sleep(1000);
```

pauses the currently executing thread for approximately one second.

If the typing thread sleeps:

```text
TypeThread → sleeping
```

the syntax thread may get an opportunity to execute.

Similarly:

```text
SyntaxThread → sleeping
```

allows another runnable thread to potentially make progress.

This makes interleaving easier to observe.

---

### 28. `Runnable` vs `Thread`

This is the most important comparison.

With `Thread` inheritance:

```java
class TypeThread extends Thread
```

the class itself is a `Thread`.

With `Runnable`:

```java
class TypeThread implements Runnable
```

the class represents a **task**.

Then:

```java
Thread t1 = new Thread(typeTask);
```

provides a separate `Thread` to execute that task.

Think:

```text
EXTENDS THREAD
    ↓
Class itself is a Thread

IMPLEMENTS RUNNABLE
    ↓
Class is a Task
    ↓
Thread executes the Task
```

---

### 29. Why Runnable Is Often More Flexible

Java classes can extend only one class.

Suppose:

```java
class TypeThread extends Thread
```

Then `TypeThread` has already used its class inheritance relationship.

But:

```java
class TypeThread extends SomeOtherClass
        implements Runnable
```

is allowed.

Therefore, `Runnable` lets the class inherit from another class while still defining a runnable task.

Conceptually:

```text
SomeOtherClass
       ↑
       |
 TypeThread
       |
 implements
       ↓
   Runnable
```

---

### 30. Important Object Relationship

Do not confuse these objects:

```java
TypeThread typeTask = new TypeThread();
```

and:

```java
Thread t1 = new Thread(typeTask);
```

The first object is:

```text
TypeThread
   ↓
Runnable task
```

The second object is:

```text
Thread
   ↓
Execution mechanism
```

Together:

```text
Runnable Task
      +
    Thread
      ↓
Thread executes task
```

---

### 31. Common Mistakes

**Mistake 1 — Calling `run()` directly**

```java
t1.run();
```

This is a normal method call.

It does not provide the new-thread behavior of:

```java
t1.start();
```

**Mistake 2 — Thinking Runnable itself creates a thread**

```java
TypeThread typeTask = new TypeThread();
```

creates a Runnable task object.

You still need:

```java
Thread t1 = new Thread(typeTask);
```

and then:

```java
t1.start();
```

**Mistake 3 — Assuming fixed output order**

Do not assume:

```text
Typing
Syntax checking
Typing
Syntax checking
```

will always occur in exactly that order.

Thread scheduling can change the order.

---

### 32. Important Rules

* `Runnable` is a predefined Java interface.
* `Runnable` provides the `run()` method contract.
* A class implements `Runnable` using the `implements` keyword.
* The task's activity is written inside `run()`.
* A `Runnable` object represents the task.
* A `Thread` object provides the thread that executes the task.
* A Runnable object can be passed to a `Thread` constructor.
* `t1.start()` starts the first thread.
* `t2.start()` starts the second thread.
* `start()` causes the associated task's `run()` method to execute as part of thread execution.
* Calling `run()` directly is a normal method call.
* Multiple threads can execute concurrently.
* The order of concurrent thread output is generally unpredictable.
* `Thread.sleep(1000)` pauses the currently executing thread for approximately one second.
* `Runnable` separates the task from the thread that executes it.

---

### 33. Complete Execution Flow

Remember the complete flow:

```text
TypeThread
     ↓
implements Runnable
     ↓
run()
     ↓
Typing task

SyntaxThread
     ↓
implements Runnable
     ↓
run()
     ↓
Syntax-checking task
```

Then:

```text
typeTask
     ↓
new Thread(typeTask)
     ↓
t1
     ↓
t1.start()
     ↓
typeTask.run()
```

And:

```text
syntaxTask
     ↓
new Thread(syntaxTask)
     ↓
t2
     ↓
t2.start()
     ↓
syntaxTask.run()
```

---

### 34. Real-World Understanding

Imagine an office with two workers.

The **tasks** are:

```text
Task 1 → Type a document
Task 2 → Check the document
```

`Runnable` represents the job description:

```text
Runnable
 ↓
"This is the work to perform"
```

`Thread` represents the worker who performs the job:

```text
Thread
 ↓
"Execute this work"
```

So:

```text
Typing Task
     ↓
Worker 1
     ↓
Executes typing

Syntax Task
     ↓
Worker 2
     ↓
Executes syntax checking
```

This is the simplest way to remember why `Runnable` and `Thread` are separate.

---

### 35. Memory Trick

Remember:

```text
RUNNABLE
   ↓
WHAT TO DO?
   ↓
run()
```

```text
THREAD
   ↓
WHO EXECUTES IT?
   ↓
start()
```

Complete chain:

```text
Runnable Task
      ↓
run()
      ↓
Pass task to Thread
      ↓
Thread object
      ↓
start()
      ↓
Thread executes run()
      ↓
Task performed
```

For this example:

```text
TypeThread
    ↓
Typing

SyntaxThread
    ↓
Syntax checking

      ↓

Thread t1 + TypeThread
Thread t2 + SyntaxThread

      ↓

t1.start()
t2.start()

      ↓

Concurrent / interleaved execution
```

---

### 36. Interview Understanding

Java can achieve multithreading by implementing the **`Runnable` interface**. In this approach, the class represents the **task**, rather than directly becoming a subclass of `Thread`. For example, `TypeThread` implements `Runnable` and places typing activity inside `run()`, while `SyntaxThread` implements `Runnable` and places syntax-checking activity inside `run()`. Objects of these classes are created as task objects. Separate `Thread` objects are then created by passing those Runnable objects to the `Thread` constructor:

```java
Thread t1 = new Thread(typeTask);
Thread t2 = new Thread(syntaxTask);
```

Calling:

```java
t1.start();
t2.start();
```

starts the two threads, and each thread executes its associated Runnable object's `run()` method. Because both threads can make progress concurrently, the output such as `Typing` and `Syntax checking` can appear in an interleaved order. The exact order is not guaranteed because thread scheduling controls when each thread receives processor execution time. The key idea to remember is:

```text
Runnable → defines WHAT WORK must be done
Thread   → provides the execution mechanism
run()    → contains the work
start()  → starts the thread
```
