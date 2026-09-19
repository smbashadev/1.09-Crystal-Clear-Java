# 🧒 21. Achieving Multithreading

### 1. Basic Idea

**Multithreading** means allowing one Java application to have multiple independent execution paths called **threads**.

A normal single-threaded program looks like:

```text
Application
    ↓
One Thread
    ↓
Task 1
    ↓
Task 2
    ↓
Task 3
```

A multithreaded program can have:

```text
Application
       ↓
 ┌─────┼─────┐
 ↓     ↓     ↓
T1    T2     T3
 ↓     ↓     ↓
Task 1 Task 2 Task 3
```

The different threads can make progress concurrently.

---

### 2. Why Do We Need to Achieve Multithreading?

An application may have many activities that do not need to wait for one another.

For example, a media application may need to:

```text
Play music
Buffer data
Accept user input
Update the screen
```

If everything is handled through one execution path, one activity can delay another.

Multithreading provides multiple execution paths so that different activities can make progress.

---

### 3. Efficient Processor Utilization

**Processor utilization** means making useful use of the CPU's available execution capacity.

Suppose one thread is waiting:

```text
Thread 1
   ↓
Waiting for input
```

Another runnable thread may be able to execute:

```text
Thread 2
   ↓
Performing calculation
```

This can help the application use processor time more effectively.

The goal is not simply "use the CPU all the time," but to avoid unnecessary idle time when useful work is available.

---

### 4. Concurrent Execution

**Concurrent execution** means multiple tasks can make progress during overlapping periods.

For example:

```text
Thread 1 → Downloading
Thread 2 → Displaying
Thread 3 → Accepting input
```

The processor and operating system manage when each thread executes.

On a single processor core, execution can involve rapid switching:

```text
T1 → T2 → T1 → T3 → T2
```

On multiple cores, some threads may actually execute at the same time.

---

### 5. Efficient CPU Usage

Consider a program with two activities:

```text
Task A → Waiting
Task B → Ready to execute
```

If Task A is the only execution path, the application may have limited useful progress while A waits.

With multiple threads:

```text
Thread A → Waiting
Thread B → Working
```

Thread B can potentially use processor time.

This is one important reason multithreading is used.

---

### 6. Two Ways to Create a Thread in Java

Java commonly teaches two basic approaches for creating thread-based execution:

```text
Way 1
 ↓
Extend Thread class

Way 2
 ↓
Implement Runnable interface
```

Both approaches allow you to define work that can be executed by a thread.

---

## Way 1 — Extend the `Thread` Class

### 7. `Thread` Class

`Thread` is a predefined Java class.

It belongs to:

```java
java.lang.Thread
```

Because `java.lang` is automatically available, you normally do not need to write an import statement for `Thread`.

Conceptually:

```text
Java
 ↓
Thread class
 ↓
Your class extends Thread
```

---

### 8. Extending `Thread`

A class can inherit from `Thread`:

```java
class Test extends Thread {

}
```

Here:

```text
Test
 ↓
extends
 ↓
Thread
```

`Test` becomes a subclass of the predefined `Thread` class.

---

### 9. Why `extends` Is Used

`extends` establishes an **inheritance relationship** between a child class and a parent class.

```java
class Test extends Thread
```

means:

```text
Thread
  ↑
  |
Test
```

The `Test` class inherits capabilities from `Thread`.

This allows an object of `Test` to be used as a thread object.

---

### 10. `run()` Method

When creating a thread, the activity that the thread should perform is normally placed inside the:

```java
run()
```

method.

Example:

```java
class Test extends Thread {

    public void run() {

        System.out.println("Task is running");

    }
}
```

The `run()` method contains the thread's work.

---

### 11. What Does `run()` Represent?

Think of `run()` as the **work instructions given to a worker**.

Real-world example:

```text
Worker
   ↓
"Download this file"
```

Java:

```text
Thread
   ↓
run()
   ↓
"Perform these instructions"
```

So the code inside `run()` represents the activity performed by that thread.

---

### 12. Why Put Code Inside `run()`?

Suppose we write:

```java
class Test extends Thread {

    public void run() {

        System.out.println("Hello");

    }
}
```

The statement:

```java
System.out.println("Hello");
```

is the work assigned to the thread.

Without putting the intended thread activity inside `run()`, you have not defined the normal task that the thread is supposed to perform.

---

### 13. Simple `Thread` Program

```java
class Test extends Thread {

    public void run() {

        System.out.println("Child thread running");

    }

    public static void main(String[] args) {

        Test t = new Test();

        t.start();

    }
}
```

Important parts:

```text
Test extends Thread
        ↓
run()
        ↓
Thread activity
        ↓
t.start()
        ↓
Thread begins execution
```

---

### 14. Creating the Thread Object

This statement:

```java
Test t = new Test();
```

creates an object of the `Test` class.

Because:

```java
class Test extends Thread
```

the object also has the behavior associated with a `Thread`.

Conceptually:

```text
new Test()
    ↓
Test object
    ↓
Thread object behavior
```

---

### 15. `start()` Method

To start a new thread of execution, we normally call:

```java
t.start();
```

`start()` is a method provided by the `Thread` class.

It asks the JVM/runtime to begin execution of the thread, after which the thread's `run()` method is invoked as part of that new thread's execution.

---

### 16. `start()` vs `run()`

This is one of the most important concepts.

Correct:

```java
t.start();
```

The thread is started, and its `run()` method is executed by that thread.

If you directly write:

```java
t.run();
```

you are simply making a normal method call.

It does **not** start a separate thread.

Remember:

```text
start()
  ↓
Starts thread execution
  ↓
run()
```

Whereas:

```text
run()
  ↓
Normal method call
```

---

## Way 2 — Implement the `Runnable` Interface

### 17. `Runnable`

`Runnable` is a predefined Java **interface**.

It represents a task that can be run.

Its essential method is:

```java
void run();
```

Conceptually:

```text
Runnable
   ↓
run()
   ↓
Task to execute
```

---

### 18. Why Is `Runnable` an Interface?

An interface can define a contract that a class agrees to follow.

When a class implements `Runnable`, it agrees to provide the required `run()` method.

Example:

```java
class Test implements Runnable {

    public void run() {

        System.out.println("Task is running");

    }
}
```

Here:

```text
Test
 ↓
implements
 ↓
Runnable
```

---

### 19. `implements` Keyword

The keyword:

```java
implements
```

is used when a class implements an interface.

Example:

```java
class Test implements Runnable
```

means:

```text
Runnable
   ↑
   |
 Test
```

The class must provide the required `run()` implementation.

---

### 20. `void run()`

The `Runnable` interface defines:

```java
void run();
```

Breaking this down:

```text
void
 ↓
The method does not return a value

run
 ↓
Method name

()
 ↓
No parameters
```

So:

```java
void run();
```

means a method named `run` that accepts no arguments and returns no value.

---

### 21. Runnable Program

```java
class Test implements Runnable {

    public void run() {

        System.out.println("Runnable task running");

    }

    public static void main(String[] args) {

        Test obj = new Test();

        Thread t = new Thread(obj);

        t.start();

    }
}
```

Here the `Test` object represents the task, while the `Thread` object provides the thread that executes that task.

---

### 22. Understanding the Runnable Program

First:

```java
Test obj = new Test();
```

creates the object containing the task.

Then:

```java
Thread t = new Thread(obj);
```

creates a `Thread` and associates the `Runnable` object with it.

Then:

```java
t.start();
```

starts the thread.

The thread eventually executes:

```java
obj.run();
```

as its task.

Conceptually:

```text
Test object
   ↓
Runnable task
   ↓
Thread object
   ↓
start()
   ↓
run()
```

---

### 23. Why Are There Two Approaches?

Java provides both approaches because they serve somewhat different design needs.

**Extending `Thread`:**

```java
class Test extends Thread
```

The class itself becomes a specialized thread.

**Implementing `Runnable`:**

```java
class Test implements Runnable
```

The class represents a task that can be given to a thread.

This separation between **task** and **thread** is often more flexible.

---

### 24. Important Difference Between the Two

| Feature                | Extend `Thread`                   | Implement `Runnable`           |
| ---------------------- | --------------------------------- | ------------------------------ |
| Relationship           | Class extends `Thread`            | Class implements `Runnable`    |
| Main purpose           | Create a specialized thread class | Define a runnable task         |
| `run()`                | Override/define it                | Implement it                   |
| Thread object          | Your object is a `Thread`         | Create a separate `Thread`     |
| Inheritance limitation | Already extends `Thread`          | Can still extend another class |

The last point is important because Java supports **single inheritance for classes**.

---

### 25. Single Inheritance Problem

Suppose:

```java
class Test extends Thread
```

Then `Test` already has a class parent:

```text
Test
 ↓
Thread
```

It cannot also extend another class:

```java
class Test extends Thread, Student
```

Java does not allow multiple class inheritance.

With `Runnable`:

```java
class Test extends Student implements Runnable
```

is possible.

Conceptually:

```text
Student
   ↑
 Test
   ↑
implements Runnable
```

This is one reason `Runnable` is often preferred when you want to separate the task from the thread.

---

### 26. Thread and Runnable Relationship

A useful mental model is:

```text
Runnable
   ↓
"What work should be done?"

Thread
   ↓
"Which execution mechanism runs that work?"
```

For example:

```text
Runnable → Download a file
Thread   → Executes the download task
```

This separation makes the design easier to understand.

---

### 27. Multiple Threads Example

Suppose we create two tasks:

```java
class Task1 extends Thread {

    public void run() {

        System.out.println("Task 1");

    }
}

class Task2 extends Thread {

    public void run() {

        System.out.println("Task 2");

    }
}
```

Then:

```java
Task1 t1 = new Task1();
Task2 t2 = new Task2();

t1.start();
t2.start();
```

Conceptually:

```text
Application
    ↓
 ┌──┴──┐
 ↓     ↓
T1     T2
 ↓     ↓
Task1  Task2
```

The scheduler determines when each runnable thread gets processor execution time.

---

### 28. Concurrent Output

If two threads print:

```java
System.out.println("Task 1");
System.out.println("Task 2");
```

you should not generally assume a fixed order.

Possible output:

```text
Task 1
Task 2
```

or:

```text
Task 2
Task 1
```

The exact order can depend on scheduling and runtime conditions.

---

### 29. Why Output Order Can Change

After:

```java
t1.start();
t2.start();
```

both threads may become eligible to run.

The scheduler controls their execution opportunities.

Conceptually:

```text
T1 → ready
T2 → ready
     ↓
Scheduler
     ↓
CPU
```

Therefore, the programmer should not assume that `t1` will always finish before `t2`.

---

### 30. `run()` Must Contain the Activity

For example:

```java
class DownloadTask extends Thread {

    public void run() {

        System.out.println("Downloading...");
        System.out.println("Download completed");

    }
}
```

The activity assigned to the thread is inside `run()`.

```text
DownloadTask
     ↓
run()
     ↓
Downloading
     ↓
Download completed
```

---

### 31. `Thread.sleep()` Inside `run()`

A thread can also pause itself:

```java
class Test extends Thread {

    public void run() {

        System.out.println("Started");

        try {

            Thread.sleep(3000);

        }
        catch (InterruptedException e) {

            System.out.println("Thread interrupted");

        }

        System.out.println("Completed");
    }
}
```

Here the thread:

```text
Starts
 ↓
Prints Started
 ↓
Sleeps approximately 3 seconds
 ↓
Prints Completed
```

The sleeping thread is not actively executing its task during the sleep interval.

---

### 32. Complete Comparison

Think of the two approaches this way:

```text
EXTEND THREAD
     ↓
Your class IS-A Thread
     ↓
class Test extends Thread
     ↓
override run()
     ↓
create Test object
     ↓
start()
```

and:

```text
IMPLEMENT RUNNABLE
     ↓
Your class IS-A Runnable task
     ↓
class Test implements Runnable
     ↓
implement run()
     ↓
create Test object
     ↓
create Thread with Test
     ↓
start()
```

---

### 33. Common Mistakes

**Mistake 1: Calling `run()` directly**

```java
t.run();
```

This is a normal method call and does not create a new thread.

Use:

```java
t.start();
```

when you want to start thread execution.

**Mistake 2: Forgetting `run()`**

If you create a `Thread` subclass, the thread's task is normally defined in `run()`.

**Mistake 3: Confusing `Runnable` with `Thread`**

`Runnable` is an interface representing a task.

`Thread` is a class representing a thread of execution.

---

### 34. Important Rules

* `Thread` is a predefined Java class.
* `Runnable` is a predefined Java interface.
* A class can create a thread by extending `Thread`.
* A class can define a runnable task by implementing `Runnable`.
* The activity of a thread is placed inside `run()`.
* `Runnable` declares `void run()`.
* `start()` starts a thread's execution.
* Calling `run()` directly is only a normal method call.
* A class extending `Thread` cannot extend another class because Java supports single class inheritance.
* A class implementing `Runnable` can extend another class.
* A `Runnable` object can be passed to a `Thread` object.
* Multiple threads can execute concurrently.
* The scheduler determines when runnable threads receive processor execution time.
* Thread execution order should not be assumed unless the program establishes synchronization/order explicitly.

---

### 35. Memory Trick

Remember the entire topic using:

```text
                 MULTITHREADING
                       ↓
              Multiple execution paths
                       ↓
             ┌─────────┴─────────┐
             ↓                   ↓
       EXTEND THREAD       IMPLEMENT RUNNABLE
             ↓                   ↓
    class Test extends     class Test implements
          Thread                 Runnable
             ↓                   ↓
           run()                run()
             ↓                   ↓
          start()          Thread + Runnable
                                 ↓
                               start()
```

And remember the most important relationship:

```text
Thread
 ↓
Execution mechanism

Runnable
 ↓
Task / work to perform

run()
 ↓
Code containing the work

start()
 ↓
Starts thread execution
```

---

### 36. Interview Understanding

Java can achieve multithreading primarily by **extending the `Thread` class** or **implementing the `Runnable` interface**. `Thread` is a predefined Java class, while `Runnable` is a predefined interface containing the `void run()` method. The work that a thread should perform is defined inside `run()`. When a class extends `Thread`, its object can be started directly using `start()`. When a class implements `Runnable`, its object represents the task, and a separate `Thread` object is created with that `Runnable` before calling `start()`. `start()` is important because it begins a new thread of execution; directly calling `run()` merely invokes the method normally. Multithreading allows multiple execution paths to make progress concurrently and can improve application responsiveness and processor utilization.
