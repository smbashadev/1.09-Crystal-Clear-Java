# 🧒 24. Thread Names

### 1. Basic Idea

In a multithreaded Java program, we may have many threads working at the same time.

If we have:

```text
Thread 1 → Java
Thread 2 → Python
```

we need a way to identify which thread is currently executing.

Java provides a **name for every thread**.

For example:

```text
Java
Python
```

These names help us understand which thread is performing a particular activity.

---

### 2. Why Thread Names Are Needed

Suppose two threads are doing work:

```text
Thread 1 → Watching Java Session
Thread 2 → Watching Java Session
```

If both print the same message, we cannot easily identify which thread produced which output.

Instead, we can give them meaningful names:

```text
Java
Python
```

Then the output can clearly show:

```text
Java is watching Java Session
Python is watching Java Session
```

This is especially useful when debugging multithreaded applications.

---

### 3. `Thread`

`Thread` is a predefined Java class used for creating and working with threads.

In this topic, we are using the `Runnable` approach:

```java
class JavaSession implements Runnable
```

The `JavaSession` class represents the task.

The actual thread will execute that task.

---

### 4. `Runnable`

`Runnable` is a predefined Java interface.

When a class implements `Runnable`, it provides the `run()` method.

```java
class JavaSession implements Runnable {

    public void run() {

        // task

    }
}
```

Here:

```text
JavaSession
      ↓
implements Runnable
      ↓
run()
      ↓
Task performed by thread
```

---

### 5. `JavaSession`

`JavaSession` is our user-defined class.

```java
class JavaSession implements Runnable
```

It represents a task related to watching a Java session.

For example:

```java
class JavaSession implements Runnable {

    public void run() {

        System.out.println("Watching Java Session");

    }
}
```

The `run()` method contains the activity performed by the thread.

---

### 6. `Thread.currentThread()`

Java provides:

```java
Thread.currentThread()
```

This returns a reference to the **thread that is currently executing the code**.

Think of it like asking:

> "Which thread is doing this work right now?"

For example:

```java
Thread.currentThread()
```

may refer to:

```text
Java thread
```

or:

```text
Python thread
```

depending on which thread is currently executing.

---

### 7. Simple Real-World Analogy

Imagine two students are working in a classroom.

```text
Student 1 → Java
Student 2 → Python
```

You ask:

> "Who is currently writing?"

The answer depends on the student currently doing the work.

Similarly:

```java
Thread.currentThread()
```

asks Java:

> "Which thread is currently doing this work?"

---

### 8. `getName()`

After getting the current thread, we can obtain its name using:

```java
getName()
```

The combination is:

```java
Thread.currentThread().getName()
```

Meaning:

```text
Thread.currentThread()
        ↓
Find the currently executing thread
        ↓
getName()
        ↓
Get that thread's name
```

---

### 9. Understanding the Complete Statement

Consider:

```java
Thread.currentThread().getName()
```

Read it from left to right:

```text
Thread
   ↓
currentThread()
   ↓
get the currently executing thread
   ↓
getName()
   ↓
get its name
```

So if the current thread is named:

```text
Java
```

the result is:

```text
Java
```

If the current thread is named:

```text
Python
```

the result is:

```text
Python
```

---

### 10. Using the Thread Name in Output

We can write:

```java
System.out.println(
    Thread.currentThread().getName()
    + " is watching Java Session"
);
```

If the current thread is named `Java`, the output becomes:

```text
Java is watching Java Session
```

If the current thread is named `Python`, the output becomes:

```text
Python is watching Java Session
```

---

### 11. Complete `JavaSession` Task

```java
class JavaSession implements Runnable {

    public void run() {

        System.out.println(
            Thread.currentThread().getName()
            + " is watching Java Session"
        );

    }
}
```

The important part is:

```java
Thread.currentThread().getName()
```

It identifies the thread currently executing `run()`.

---

### 12. Creating the Task Object

In `main()`:

```java
JavaSession task = new JavaSession();
```

This creates a `JavaSession` object.

Because `JavaSession` implements `Runnable`, this object represents a runnable task.

```text
task
  ↓
JavaSession object
  ↓
Runnable task
```

---

### 13. Creating the First Thread

Now create a `Thread` object:

```java
Thread t1 = new Thread(task);
```

Here:

```text
task
 ↓
Runnable object
 ↓
passed to Thread
 ↓
t1
```

The thread `t1` is associated with the Java session task.

---

### 14. Creating the Second Thread

We can create another thread using the same Runnable task:

```java
Thread t2 = new Thread(task);
```

Now:

```text
t1 → JavaSession task

t2 → JavaSession task
```

Both threads can execute the same task.

This is an important concept:

> One Runnable task object can be given to multiple Thread objects.

---

### 15. Multiple Threads

Now we have:

```text
Thread t1
   ↓
JavaSession task

Thread t2
   ↓
JavaSession task
```

Both threads execute the `run()` method.

The difference will come from their **thread names**.

---

### 16. Giving a Name to `t1`

We can give a thread a name using the `Thread` constructor:

```java
Thread t1 = new Thread(task, "Java");
```

Now:

```text
t1
 ↓
Name = Java
```

The thread will identify itself as:

```text
Java
```

---

### 17. Giving a Name to `t2`

Similarly:

```java
Thread t2 = new Thread(task, "Python");
```

Now:

```text
t2
 ↓
Name = Python
```

Therefore:

```text
t1 → Java
t2 → Python
```

---

### 18. Why the Same Task Gives Different Output

Both threads execute:

```java
Thread.currentThread().getName()
```

But `currentThread()` returns the thread that is currently executing.

When `t1` executes:

```text
currentThread() → t1
getName()       → Java
```

When `t2` executes:

```text
currentThread() → t2
getName()       → Python
```

Therefore the same code can produce different names.

---

### 19. Starting `t1`

We start the first thread:

```java
t1.start();
```

The flow becomes:

```text
t1.start()
    ↓
t1 begins execution
    ↓
run()
    ↓
currentThread()
    ↓
t1
    ↓
getName()
    ↓
Java
```

Output:

```text
Java is watching Java Session
```

---

### 20. Starting `t2`

Then:

```java
t2.start();
```

The flow becomes:

```text
t2.start()
    ↓
t2 begins execution
    ↓
run()
    ↓
currentThread()
    ↓
t2
    ↓
getName()
    ↓
Python
```

Output:

```text
Python is watching Java Session
```

---

### 21. Complete Program

```java
class JavaSession implements Runnable {

    public void run() {

        System.out.println(
            Thread.currentThread().getName()
            + " is watching Java Session"
        );

    }
}


public class EclipseApps {

    public static void main(String[] args) {

        JavaSession task = new JavaSession();

        Thread t1 = new Thread(task, "Java");

        Thread t2 = new Thread(task, "Python");

        t1.start();

        t2.start();

    }
}
```

---

### 22. Complete Program Structure

The program can be visualized as:

```text
EclipseApps
     ↓
main()
     ↓
Create JavaSession task
     ↓
Create t1
Name = Java
     ↓
Create t2
Name = Python
     ↓
t1.start()
     ↓
run()
     ↓
currentThread()
     ↓
getName()
     ↓
Java
```

And:

```text
t2.start()
     ↓
run()
     ↓
currentThread()
     ↓
getName()
     ↓
Python
```

---

### 23. Expected Output

The expected messages are:

```text
Java is watching Java Session
Python is watching Java Session
```

However, because these are separate threads, the order of the two lines is not something we should generally depend on.

It could also appear as:

```text
Python is watching Java Session
Java is watching Java Session
```

The important thing is that the correct thread name appears with its execution.

---

### 24. Understanding `currentThread()` Deeply

Suppose `t1` is currently executing.

Java conceptually sees:

```text
Current executing thread
        ↓
       t1
        ↓
     getName()
        ↓
      Java
```

If `t2` is currently executing:

```text
Current executing thread
        ↓
       t2
        ↓
     getName()
        ↓
     Python
```

Therefore `currentThread()` does not always return the same thread.

It returns **whichever thread is executing the statement at that moment**.

---

### 25. Understanding `getName()` Deeply

`getName()` does not create a name.

It **retrieves the existing name** of a thread.

For example:

```java
Thread t1 = new Thread(task, "Java");
```

creates a thread with the name:

```text
Java
```

Then:

```java
t1.getName()
```

retrieves:

```text
Java
```

Similarly:

```java
Thread t2 = new Thread(task, "Python");
```

gives:

```text
Python
```

and:

```java
t2.getName()
```

returns:

```text
Python
```

---

### 26. Thread Name vs Task Name

This is an important distinction.

`JavaSession` is the **task class**:

```text
JavaSession
 ↓
Task
```

`Java` and `Python` are **thread names**:

```text
t1 → Java
t2 → Python
```

So:

```text
JavaSession ≠ Java thread name
```

The task is:

```text
JavaSession
```

while the thread names are:

```text
Java
Python
```

---

### 27. Same Runnable, Different Thread Names

Both threads can use the same task:

```text
             JavaSession
             Runnable task
               /      \
              /        \
             ↓          ↓
           t1           t2
           Java        Python
```

Therefore:

```text
t1 → executes JavaSession → name Java

t2 → executes JavaSession → name Python
```

This demonstrates why the thread name comes from the **current Thread**, not from the Runnable object.

---

### 28. Real-World Example

Imagine an online Java learning platform.

Two students are watching the same Java session:

```text
Student/Thread 1 → Java
Student/Thread 2 → Python
```

Both perform the same activity:

```text
Watching Java Session
```

But when the application records who is doing the work, it identifies the current thread.

The result:

```text
Java is watching Java Session
Python is watching Java Session
```

This is similar to using employee names to identify which worker is performing the same type of job.

---

### 29. Common Confusion: `currentThread()` vs `getName()`

Do not treat them as the same thing.

```java
Thread.currentThread()
```

means:

> Give me the currently executing thread.

Whereas:

```java
getName()
```

means:

> Give me the name of that thread.

Together:

```java
Thread.currentThread().getName()
```

means:

> Find the currently executing thread and tell me its name.

Memory trick:

```text
currentThread() → WHO?
getName()       → WHAT IS ITS NAME?
```

---

### 30. Common Mistake: Calling `run()` Directly

Do not write:

```java
t1.run();
t2.run();
```

when your goal is multithreaded execution.

Use:

```java
t1.start();
t2.start();
```

`start()` starts the thread.

Then the thread executes the associated `run()` method.

Remember:

```text
start()
  ↓
new thread execution
  ↓
run()
```

---

### 31. Important Rules

* `Runnable` represents the task.
* `Thread` represents the thread that executes the task.
* `Thread.currentThread()` returns the currently executing thread.
* `getName()` returns the name of a thread.
* `Thread.currentThread().getName()` obtains the name of the currently executing thread.
* Thread names can be supplied when creating a `Thread`.
* `new Thread(task, "Java")` creates a thread associated with `task` and gives it the name `Java`.
* `new Thread(task, "Python")` gives the second thread the name `Python`.
* Multiple threads can execute the same Runnable task.
* The same `run()` code can therefore produce different output depending on which thread executes it.
* `start()` should be used to begin thread execution.
* The order of concurrent output should not be assumed to be fixed.

---

### 32. Complete Execution Flow

```text
JavaSession
     ↓
implements Runnable
     ↓
run()
     ↓
Thread.currentThread()
     ↓
Find currently executing thread
     ↓
getName()
     ↓
Find its name
     ↓
Print message
```

For `t1`:

```text
t1
 ↓
Name = Java
 ↓
start()
 ↓
run()
 ↓
currentThread() = t1
 ↓
getName() = Java
 ↓
Java is watching Java Session
```

For `t2`:

```text
t2
 ↓
Name = Python
 ↓
start()
 ↓
run()
 ↓
currentThread() = t2
 ↓
getName() = Python
 ↓
Python is watching Java Session
```

---

### 33. Memory Picture

Keep this picture in mind:

```text
                 Runnable
                    ↓
              JavaSession
                    ↓
                 run()
                /     \
               /       \
              ↓         ↓
             t1         t2
             ↓          ↓
           Java       Python
             ↓          ↓
          start()     start()
             ↓          ↓
           run()       run()
             ↓          ↓
          getName()   getName()
             ↓          ↓
           Java       Python
```

The task is the same, but the executing threads are different.

---

### 34. Easy One-Line Understanding

The whole concept can be remembered as:

> **`Thread.currentThread()` finds who is working, and `getName()` tells us that worker's name.**

So:

```java
Thread.currentThread().getName()
```

means:

```text
Find current thread
        ↓
Find its name
        ↓
Use the name in the output
```

---

### 35. Interview Understanding

Thread names are used to identify individual threads in a multithreaded Java application. When using the `Runnable` approach, a class such as `JavaSession` implements `Runnable` and defines its task inside `run()`. Multiple `Thread` objects can use the same Runnable object, and each thread can have a different name. For example:

```java
Thread t1 = new Thread(task, "Java");
Thread t2 = new Thread(task, "Python");
```

When either thread executes `run()`, the statement:

```java
Thread.currentThread().getName()
```

first obtains the currently executing thread using `currentThread()` and then obtains that thread's name using `getName()`. Therefore, the same Runnable task can produce:

```text
Java is watching Java Session
Python is watching Java Session
```

The key distinction is that **`Runnable` defines the work, `Thread` executes the work, `currentThread()` identifies the executing thread, and `getName()` identifies that thread by name.**

---

### 36. Lifetime Memory Trick

```text
Runnable
   ↓
Task
   ↓
run()
   ↓
Thread
   ↓
start()
   ↓
currentThread()
   ↓
getName()
   ↓
Thread's name
```

For this topic:

```text
JavaSession
     ↓
Runnable task
     ↓
Two Threads
     ↓
Java + Python
     ↓
start()
     ↓
run()
     ↓
currentThread()
     ↓
getName()
     ↓
Java is watching Java Session
Python is watching Java Session
```

**Remember this forever:**

> **Task = what to do. Thread = who executes it. `currentThread()` = who is executing now. `getName()` = what is that thread called.**
