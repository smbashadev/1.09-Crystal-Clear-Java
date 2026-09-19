# 35. Star and Number Thread Program

This program is a practical example of **multithreading using the `Thread` class**.

Two different threads perform two different activities:

```text
StarThread
    ↓
Prints *

NumThread
    ↓
Prints numbers
```

Both threads are started from `PrintApp`, so their execution can happen **concurrently**.

The important point is that we should **not expect a fixed output order**. The thread scheduler decides when each thread gets CPU execution time.

---

## 35.1 StarThread

`StarThread` is a class that extends the predefined Java `Thread` class.

Its responsibility is to print a star pattern.

```java
class StarThread extends Thread {

    public void run() {

        for (int i = 1; i <= 4; i++) {

            for (int j = 1; j <= i; j++) {

                System.out.print("*");
            }

            System.out.println();

            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
```

### What is happening here?

```java
class StarThread extends Thread
```

means `StarThread` is a subclass of Java's `Thread` class.

Therefore, an object of `StarThread` can be used as a thread.

The actual activity of the thread is placed inside:

```java
public void run()
```

The `run()` method contains the work that this thread performs.

---

### Nested loops

The outer loop:

```java
for (int i = 1; i <= 4; i++)
```

controls the number of rows.

The inner loop:

```java
for (int j = 1; j <= i; j++)
```

controls how many stars are printed in each row.

Therefore:

```text
i = 1 → *
i = 2 → **
i = 3 → ***
i = 4 → ****
```

The pattern becomes:

```text
*
**
***
****
```

---

### Why is `Thread.sleep()` used?

After printing each row:

```java
Thread.sleep(1000);
```

temporarily pauses the currently executing thread for approximately 1000 milliseconds.

That means:

```text
Print row
   ↓
Sleep
   ↓
Become eligible again
   ↓
Continue
```

This makes the concurrent execution easier to observe.

---

## 35.2 NumThread

`NumThread` is another class that extends `Thread`.

Its responsibility is to print numbers.

```java
class NumThread extends Thread {

    public void run() {

        for (int i = 1; i <= 4; i++) {

            for (int j = 1; j <= i; j++) {

                System.out.print(j);
            }

            System.out.println();

            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
```

The output produced by this thread alone would be:

```text
1
12
123
1234
```

Again, the nested loops are responsible for the pattern.

---

### Number-thread execution

For:

```text
i = 1
```

the inner loop runs once:

```text
1
```

For:

```text
i = 2
```

it runs twice:

```text
12
```

For:

```text
i = 3
```

it runs three times:

```text
123
```

For:

```text
i = 4
```

it runs four times:

```text
1234
```

Therefore:

```text
1
12
123
1234
```

---

## 35.3 PrintApp

Now we create both thread objects.

```java
public class PrintApp {

    public static void main(String[] args) {

        StarThread st = new StarThread();

        NumThread nt = new NumThread();

        st.start();

        nt.start();
    }
}
```

The important part is:

```java
st.start();
nt.start();
```

We are starting **two separate threads**.

Conceptually:

```text
                 PrintApp
                    |
          ┌─────────┴─────────┐
          ↓                   ↓
     StarThread            NumThread
          ↓                   ↓
      print *             print numbers
          ↓                   ↓
       sleep                sleep
```

Both threads are now eligible for concurrent execution.

---

### Why `start()` and not `run()`?

This is extremely important.

Correct:

```java
st.start();
nt.start();
```

`start()` asks Java to start a new thread of execution, which will eventually invoke `run()`.

If we directly write:

```java
st.run();
nt.run();
```

we are simply calling methods normally; we are **not starting two independent threads through `start()`**.

Remember:

```text
start()
   ↓
Creates/starts thread execution
   ↓
run()
   ↓
Performs thread activity
```

---

## 35.4 Output Pattern

The two individual patterns are:

### StarThread

```text
*
**
***
****
```

### NumThread

```text
1
12
123
1234
```

Because both threads execute concurrently, their output can become interleaved.

One possible conceptual output is:

```text
*1
**12
***123
****1234
```

This gives the pattern mentioned in your notes:

```text
*1
**12
***123
****1234
```

But this is **only one possible arrangement**.

---

# Concurrent Execution

Suppose both threads are running.

The scheduler may execute:

```text
StarThread
 ↓
prints *
 ↓
sleep()
```

Then:

```text
NumThread
 ↓
prints 1
 ↓
sleep()
```

Then:

```text
StarThread
 ↓
prints **
```

Then:

```text
NumThread
 ↓
prints 12
```

So the output can appear as:

```text
*1
**12
***123
****1234
```

---

## Important: Output Is Not Guaranteed

Because thread scheduling is unpredictable, you should **not assume** that the output will always be exactly:

```text
*1
**12
***123
****1234
```

The scheduler may execute one thread more than the other at a particular moment.

For example, you could conceptually get output resembling:

```text
*
**
1
12
***
123
****
1234
```

Or another interleaving.

The exact appearance depends on thread scheduling and timing.

---

# Complete Program

```java
class StarThread extends Thread {

    public void run() {

        for (int i = 1; i <= 4; i++) {

            for (int j = 1; j <= i; j++) {

                System.out.print("*");
            }

            System.out.println();

            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


class NumThread extends Thread {

    public void run() {

        for (int i = 1; i <= 4; i++) {

            for (int j = 1; j <= i; j++) {

                System.out.print(j);
            }

            System.out.println();

            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


public class PrintApp {

    public static void main(String[] args) {

        StarThread st = new StarThread();

        NumThread nt = new NumThread();

        st.start();

        nt.start();
    }
}
```

---

# Complete Execution Flow

```text
PrintApp.main()
       ↓
Create StarThread object
       ↓
Create NumThread object
       ↓
st.start()
       ↓
StarThread becomes eligible
       ↓
nt.start()
       ↓
NumThread becomes eligible
       ↓
Thread Scheduler
       ↓
Chooses a thread
       ↓
run() executes
       ↓
Print pattern
       ↓
sleep()
       ↓
Thread becomes eligible again
       ↓
Scheduler chooses threads again
       ↓
Interleaved output
```

---

# Relationship With Previous Multithreading Concepts

This example combines several concepts you already studied:

```text
Thread
  ↓
Extending Thread
  ↓
run()
  ↓
start()
  ↓
Two threads
  ↓
Concurrent execution
  ↓
Thread.sleep()
  ↓
Scheduler
  ↓
Interleaved output
```

So this is not just a star-pattern program.

It is a practical demonstration of **concurrent execution using Java threads**.

---

# Important Rules

### Rule 1

A class can create a thread by extending:

```java
Thread
```

### Rule 2

The activity of the thread is written inside:

```java
run()
```

### Rule 3

Use:

```java
start()
```

to start the thread.

### Rule 4

Do not use:

```java
run()
```

as a replacement for `start()` when your goal is to create concurrent thread execution.

### Rule 5

`Thread.sleep()` pauses the **currently executing thread**.

### Rule 6

The order of concurrent thread execution cannot be assumed.

### Rule 7

Interleaving means output from different threads can appear mixed together.

---

# Common Confusion

### `sleep()` stops all threads?

No.

If `StarThread` executes:

```java
Thread.sleep(1000);
```

the StarThread sleeps.

It does not mean that NumThread must also stop.

Conceptually:

```text
StarThread → sleeping

NumThread → can execute
```

This is one reason the output can become interleaved.

---

# Common Confusion

### Does `start()` immediately execute the thread?

`start()` makes the thread eligible to run. The scheduler determines when it actually gets CPU execution.

Therefore:

```text
start()
  ↓
Runnable
  ↓
Scheduler selects
  ↓
run()
```

---

# Common Confusion

### Why does the output sometimes change?

Because:

```text
StarThread
       +
NumThread
       +
Thread Scheduler
       +
Timing
       ↓
Different interleavings
```

Multithreading does not guarantee that one thread will completely finish before another starts.

---

# Real-World Connection

Imagine a computer application doing two activities:

```text
Activity 1
Downloading/displaying images

Activity 2
Updating progress numbers
```

Instead of making one activity completely finish before starting the other, separate threads can perform the activities concurrently.

Our example represents the same basic idea:

```text
StarThread
    ↓
One activity

NumThread
    ↓
Another activity
```

The actual activities are simple printing operations, but the threading principle is the same.

---

# Memory Trick

Remember:

> **StarThread prints stars. NumThread prints numbers. `start()` starts both. `run()` contains their work. `sleep()` creates pauses. Scheduler decides the execution order.**

A compact memory chain:

```text
StarThread → *
NumThread  → Number
     ↓
   start()
     ↓
  Scheduler
     ↓
Concurrent execution
     ↓
Interleaved output
```

---

# Interview Understanding

A program containing `StarThread` and `NumThread` demonstrates **multithreading by extending the `Thread` class**. Each class overrides the `run()` method to define its activity. `StarThread` uses nested loops to print stars, while `NumThread` uses nested loops to print numbers. In `PrintApp`, objects of both thread classes are created and started using `start()`. Since the two threads execute concurrently, their outputs may be interleaved. `Thread.sleep()` temporarily pauses the currently executing thread, allowing the other thread to get an opportunity to execute. The exact output order is not guaranteed because thread scheduling is nondeterministic.

The complete concept is:

```text
                    PrintApp
                       ↓
             ┌─────────┴─────────┐
             ↓                   ↓
        StarThread            NumThread
             ↓                   ↓
          run()                 run()
             ↓                   ↓
       Nested loops         Nested loops
             ↓                   ↓
          *****               1234
             ↓                   ↓
          sleep()             sleep()
             └─────────┬─────────┘
                       ↓
                Thread Scheduler
                       ↓
              Concurrent execution
                       ↓
              Interleaved output
                       ↓
          *1 / **12 / ***123 / ****1234
```

**Core idea:** Two independent threads perform two independent activities concurrently, and because the scheduler controls their execution, their outputs can become interleaved rather than following one fixed order.
