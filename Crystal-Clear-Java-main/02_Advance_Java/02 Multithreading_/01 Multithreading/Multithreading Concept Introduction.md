# 🧒 19. Multithreading

### 1. Thread

A **thread** is a single line of execution inside a program.

Think of a thread as **one worker doing one sequence of tasks**.

For example:

```text
Start
  ↓
Task 1
  ↓
Task 2
  ↓
Task 3
  ↓
End
```

The tasks are executed through one flow of execution.

---

### 2. Simple Real-World Example

Imagine one person working in an office.

```text
Person
 ↓
Read email
 ↓
Write report
 ↓
Check document
 ↓
Send report
```

One person follows one sequence.

Similarly, a single thread follows one execution path.

---

### 3. Why Threads Are Important

A program may need to perform different activities.

For example, an application may need to:

```text
Download a file
Play music
Accept user input
Update the screen
```

If everything uses only one execution path, one task may have to wait for another.

Threads allow different activities to make progress concurrently.

---

### 4. Single Line of Execution

The phrase **single line of execution** means that one thread follows one path through the program.

```text
main()
  ↓
Statement 1
  ↓
Statement 2
  ↓
Statement 3
  ↓
Statement 4
```

The thread moves from one statement to the next.

---

### 5. Multithreaded Application

A **multithreaded application** is an application that uses multiple threads.

Conceptually:

```text
Application
    ↓
 ┌───┴────┐
 ↓        ↓
Thread 1  Thread 2
 ↓        ↓
Task A    Task B
```

The different threads can make progress concurrently.

---

### 6. Multiple Sub-Processes

Your notes describe a multithreaded application as having multiple **sub-processes**.

A more precise Java understanding is that these are generally **multiple threads of execution within the same process**.

```text
Application / Process
        ↓
 ┌──────┼──────┐
 ↓      ↓      ↓
T1      T2      T3
```

Each thread provides its own execution path.

---

### 7. Concurrent Execution

**Concurrent execution** means multiple tasks are making progress during overlapping periods.

For example:

```text
Thread 1 → Task A → Task A → Task A
Thread 2 → Task B → Task B → Task B
```

The processor may switch between them very quickly.

To the user, the tasks can appear to happen at the same time.

---

### 8. Parallel Execution

**Parallel execution** means tasks are actually executing at the same time on different processor cores.

For example:

```text
Core 1 → Thread 1
Core 2 → Thread 2
```

So remember:

```text
Concurrency → overlapping progress
Parallelism → actual simultaneous execution
```

---

### 9. Multitasking

**Multitasking** means the operating system manages multiple applications so they can appear to run at the same time.

For example, on a computer you may have:

```text
Chrome
Music Player
Eclipse
File Explorer
```

all open and apparently running together.

---

### 10. Real-World Multitasking Example

Imagine a person using a computer:

```text
Chrome → browsing
Music  → playing
Eclipse → coding
```

You can move between these applications without manually stopping one before starting another.

The operating system manages their execution.

---

### 11. Multitasking vs Multithreading

These two concepts are related but not identical.

**Multitasking:**

```text
Operating System
      ↓
Application 1
Application 2
Application 3
```

**Multithreading:**

```text
One Application
      ↓
Thread 1
Thread 2
Thread 3
```

A simple memory rule:

```text
Multitasking → multiple applications
Multithreading → multiple execution paths within an application
```

---

### 12. Processor Concept

A processor executes instructions.

In the simplified model used in your notes, a processor executes one active process at a given instant and the operating system rapidly switches between processes.

```text
Processor
   ↓
Application A
   ↓
switch
   ↓
Application B
   ↓
switch
   ↓
Application C
```

The switching happens extremely quickly.

---

### 13. Operating System

The **Operating System (OS)** manages the computer's resources and decides which processes and threads get processor time.

Examples of operating systems include:

```text
Windows
Linux
macOS
Android
```

For this topic, remember:

```text
OS
 ↓
Manages execution
 ↓
Schedules processes/threads
```

---

### 14. Rapid Switching

Suppose three tasks need processor time:

```text
A → B → C → A → B → C
```

The processor switches between them rapidly.

Because these switches happen so quickly, the user may feel:

```text
A + B + C
```

are happening simultaneously.

---

### 15. Simple Analogy for Rapid Switching

Imagine one teacher helping three students.

```text
Teacher → Student A
Teacher → Student B
Teacher → Student C
Teacher → Student A
...
```

The teacher is switching very quickly.

Each student sees the teacher helping them repeatedly, making it feel as though everyone is being helped at the same time.

---

### 16. Multithreading Inside an Application

Consider an application with three activities:

```text
Application
   ├── Download file
   ├── Play music
   └── Accept user input
```

These activities can be assigned to different threads:

```text
Application
   ├── Thread 1 → Download
   ├── Thread 2 → Music
   └── Thread 3 → User input
```

This is the basic idea behind multithreading.

---

### 17. Why Multithreading Is Useful

Multithreading can help an application remain responsive while different tasks make progress.

For example:

```text
Main/UI Thread
      ↓
User interface remains responsive

Worker Thread
      ↓
Performs lengthy operation
```

The application does not necessarily have to wait for every operation to finish sequentially.

---

### 18. Single Thread Program

A **single-threaded program** has one main execution path.

For example:

```text
Start
 ↓
Task 1
 ↓
Task 2
 ↓
Task 3
 ↓
End
```

One task follows another.

---

### 19. EclipseApp Example

Consider an imaginary application called:

```text
EclipseApp
```

A programmer is typing Java code.

The application may perform activities such as:

```text
Typing code
 ↓
Syntax checking
 ↓
Displaying errors/warnings
```

In a simple single-threaded model, these activities follow one execution sequence.

---

### 20. Typing Code

When the programmer types:

```java
int number = 10;
```

the application receives keyboard input.

The program/editor processes that input.

```text
Keyboard
   ↓
EclipseApp
   ↓
Code appears
```

---

### 21. Syntax Checking

The editor can check the Java code for syntax problems.

For example:

```java
int number = ;
```

contains an incomplete statement.

The editor can identify the problem and show an error indication.

Conceptually:

```text
Code entered
    ↓
Syntax checking
    ↓
Problem detected
```

---

### 22. `Thread.sleep()`

Java provides:

```java
Thread.sleep()
```

to pause the currently executing thread for a specified amount of time.

For example:

```java
Thread.sleep(3000);
```

means the current thread is requested to sleep for approximately **3000 milliseconds**, which is about **3 seconds**.

---

### 23. Understanding Milliseconds

Java's `Thread.sleep()` uses milliseconds.

```text
1000 milliseconds = 1 second
2000 milliseconds = 2 seconds
3000 milliseconds = 3 seconds
```

Therefore:

```java
Thread.sleep(3000);
```

means:

```text
Current thread
     ↓
Pause for about 3 seconds
     ↓
Continue execution
```

---

### 24. What Happens During `sleep()`?

Suppose:

```java
System.out.println("A");

Thread.sleep(3000);

System.out.println("B");
```

The flow is:

```text
Print A
  ↓
Sleep
  ↓
Wait approximately 3 seconds
  ↓
Print B
```

The thread does not continue to the next statement during the sleep period.

---

### 25. Why `Thread.sleep()` Is Related to Multithreading

`Thread.sleep()` acts on the **currently executing thread**.

If a program has multiple threads:

```text
Thread 1
Thread 2
Thread 3
```

and Thread 1 sleeps:

```text
Thread 1 → sleeping
Thread 2 → can continue
Thread 3 → can continue
```

This is one reason `sleep()` is useful for understanding thread behavior.

---

### 26. Sequential Execution

**Sequential execution** means tasks happen one after another.

```text
Task A
  ↓
Task B
  ↓
Task C
  ↓
Task D
```

Task B waits for Task A's execution to reach the appropriate point, and Task C follows afterward.

---

### 27. Single Thread + Sleep

Consider:

```java
class EclipseApp {

    public static void main(String[] args)
            throws InterruptedException {

        System.out.println("Typing code");

        Thread.sleep(3000);

        System.out.println("Syntax checking");

        Thread.sleep(3000);

        System.out.println("Execution completed");
    }
}
```

The program uses one main execution thread.

---

### 28. Understanding the Program

First:

```java
System.out.println("Typing code");
```

prints:

```text
Typing code
```

Then:

```java
Thread.sleep(3000);
```

pauses the current thread for about 3 seconds.

After that:

```java
System.out.println("Syntax checking");
```

executes.

---

### 29. Continuing the Program

After the second:

```java
Thread.sleep(3000);
```

the current thread pauses again.

After approximately 3 seconds, this executes:

```java
System.out.println("Execution completed");
```

So the complete sequence is:

```text
Typing code
     ↓
sleep ~3 seconds
     ↓
Syntax checking
     ↓
sleep ~3 seconds
     ↓
Execution completed
```

---

### 30. Why Is This Sequential?

There is only one execution path.

```text
main()
 ↓
Typing code
 ↓
sleep
 ↓
Syntax checking
 ↓
sleep
 ↓
Execution completed
```

Nothing in this example creates additional application threads.

Therefore, it demonstrates a simple single-threaded sequence.

---

### 31. `main()` and Thread

When a Java application starts, the JVM begins execution by invoking the `main()` method.

The initial execution occurs on the **main thread**.

Conceptually:

```text
JVM
 ↓
main thread
 ↓
main()
 ↓
program statements
```

So when we write:

```java
Thread.sleep(3000);
```

inside `main()`, the **main thread** sleeps.

---

### 32. What Does "Current Thread" Mean?

Suppose:

```java
Thread.sleep(3000);
```

is executed by Thread A.

Then Thread A sleeps.

```text
Thread A
   ↓
sleep
```

If Thread B exists, sleeping Thread A does not mean Thread B automatically sleeps.

```text
Thread A → sleeping
Thread B → may continue
```

This becomes especially important in multithreaded programs.

---

### 33. Single Thread vs Multiple Threads

**Single thread:**

```text
Application
    ↓
 Thread 1
    ↓
Task A
    ↓
Task B
    ↓
Task C
```

**Multiple threads:**

```text
Application
    ↓
 ┌──┴───┐
 ↓      ↓
T1      T2
 ↓      ↓
Task A  Task B
```

Multiple threads provide multiple execution paths.

---

### 34. Multitasking vs Multithreading vs Parallelism

Keep these three concepts separate:

| Concept        | Basic meaning                                                               |
| -------------- | --------------------------------------------------------------------------- |
| Multitasking   | Multiple applications are managed so they can make progress                 |
| Multithreading | Multiple threads execute within an application                              |
| Parallelism    | Multiple tasks actually execute simultaneously on different processor cores |

---

### 35. Important Rules

* A thread is a single line/path of execution.
* A Java application can contain multiple threads.
* Multithreading provides multiple execution paths within an application.
* Multitasking refers to managing multiple applications/tasks.
* The OS schedules processes and threads for processor time.
* Rapid switching can make execution appear simultaneous.
* Concurrent execution means activities can make progress during overlapping periods.
* Parallel execution means actual simultaneous execution on multiple cores.
* `Thread.sleep()` pauses the currently executing thread for the requested duration.
* `3000` milliseconds is approximately 3 seconds.
* A simple program containing only `main()` demonstrates a single execution path.
* `Thread.sleep()` does not create a new thread.

---

### 36. Memory Trick

Remember the whole concept with:

```text
THREAD
   ↓
One execution path

MULTITHREADING
   ↓
Multiple execution paths
   ↓
Within one application

MULTITASKING
   ↓
Multiple applications/tasks

PROCESSOR
   ↓
Executes instructions

OS
   ↓
Schedules and switches execution

SLEEP
   ↓
Pause current thread
```

And for the EclipseApp example:

```text
Typing code
     ↓
Sleep
     ↓
Syntax checking
     ↓
Sleep
     ↓
Execution completed
```

**Core memory rule:**

> **A thread is one line of execution. Multithreading gives an application multiple execution paths, while multitasking deals with multiple applications or tasks. The operating system schedules execution, and rapid switching can make concurrent activities appear simultaneous. In a single-threaded program, the statements execute sequentially, and `Thread.sleep()` simply pauses the currently executing thread.**
