# 32. States of a Thread / Thread Lifecycle

A **thread does not remain in one condition throughout its entire life**. From the moment a thread object is created until its execution finishes, it passes through different states.

Think of a thread like a person attending a job:

```text
Created
   ↓
Ready to work
   ↓
Gets an opportunity to work
   ↓
Working
   ↓
Temporarily stops / waits if necessary
   ↓
Ready again
   ↓
Works again
   ↓
Finishes
   ↓
Dead / Terminated
```

In Java, these conditions are commonly discussed as the **thread lifecycle**.

---

## 32.1 New State

The **New state** is the first state of a thread.

A thread enters the New state when its `Thread` object has been created but its `start()` method has **not yet been called**.

Example:

```java
Thread t1 = new Thread();
```

At this point:

```text
Thread object created
        ↓
Thread has not started
        ↓
NEW state
```

The thread exists as an object, but its execution has not started.

---

## 32.2 What Can Be Done in New State

While the thread is in the New state, we can configure its attributes.

For example:

```java
Thread t1 = new Thread();

t1.setName("Java");
t1.setPriority(5);
```

The thread has not started yet.

Conceptually:

```text
Create object
     ↓
Set name
     ↓
Set priority
     ↓
Set other required properties
     ↓
Call start()
```

This is why the New state is useful.

---

## 32.3 `start()` and Runnable State

When we call:

```java
t1.start();
```

the thread moves out of the New state.

It becomes eligible to execute.

Conceptually:

```text
NEW
 ↓
start()
 ↓
RUNNABLE
```

The important word is **eligible**.

Calling `start()` does not mean that the thread immediately gets the CPU.

It means:

> The thread is now ready and can be selected for execution by the thread scheduler.

---

## 32.4 Runnable State

The **Runnable state** means that the thread is ready or eligible to execute.

Example:

```java
Thread t1 = new Thread();

t1.start();
```

After `start()`:

```text
NEW
 ↓
RUNNABLE
```

The thread is now waiting for an opportunity to execute.

There may be many runnable threads:

```text
Java thread
Python thread
JavaScript thread
```

The system decides which thread gets CPU execution time.

---

## 32.5 Thread Scheduler

The **thread scheduler** is responsible for deciding which eligible thread gets CPU execution time.

Imagine:

```text
Runnable Threads

Java
Python
JavaScript
C++
```

The scheduler determines which thread gets an opportunity to execute.

Conceptually:

```text
Runnable threads
       ↓
Thread scheduler
       ↓
Selects a thread
       ↓
CPU
```

The exact scheduling behavior and order should not be assumed in ordinary Java programs.

---

## 32.6 Running State

When the scheduler selects a runnable thread and the thread actually gets CPU execution time, we commonly describe it as being in the **Running state**.

For example:

```text
RUNNABLE
    ↓
Scheduler selects thread
    ↓
CPU
    ↓
run() executes
```

Suppose:

```java
public void run() {
    System.out.println("Java");
}
```

When the thread gets CPU time, its `run()` method executes.

---

## 32.7 Important Technical Clarification About Running

There is an important Java terminology point.

Java's official `Thread.State` enum does **not** have a separate `RUNNING` state.

The official Java states are:

```text
NEW
RUNNABLE
BLOCKED
WAITING
TIMED_WAITING
TERMINATED
```

When teaching the lifecycle, people often separate:

```text
RUNNABLE → RUNNING
```

to make the CPU/scheduler concept easier to understand.

So your notes' **Running state** is a useful conceptual description, while technically a Java thread executing on the CPU is represented within the broader `RUNNABLE` state.

---

## 32.8 `run()` Method Execution

The actual activity of a thread is written inside:

```java
run()
```

For example:

```java
class MyThread extends Thread {

    public void run() {

        System.out.println("Thread is executing");
    }
}
```

When the thread is started:

```java
MyThread t = new MyThread();

t.start();
```

the JVM arranges for the thread's `run()` method to execute.

The conceptual flow is:

```text
start()
  ↓
Runnable
  ↓
Scheduler selects
  ↓
CPU
  ↓
run()
  ↓
Thread activity
```

---

## 32.9 Sleep State

A thread can temporarily stop executing for a specified amount of time using:

```java
Thread.sleep()
```

Example:

```java
Thread.sleep(3000);
```

This means approximately:

> Pause the current thread for 3000 milliseconds.

Since:

```text
1000 milliseconds = 1 second
```

then:

```text
3000 milliseconds = 3 seconds
```

Conceptually:

```text
Running
   ↓
sleep(3000)
   ↓
Timed waiting / sleep
   ↓
3 seconds pass
   ↓
Runnable
```

---

## 32.10 Why Sleep Is Used

Suppose a thread performs:

```java
for(int i = 1; i <= 5; i++) {

    System.out.println(i);

    Thread.sleep(1000);
}
```

The thread prints a value and then pauses for approximately one second before continuing.

This can be useful for simulations, timing demonstrations, periodic tasks, and similar situations.

---

## 32.11 Wait State

A thread can enter a **waiting state** using mechanisms such as:

```java
wait()
```

A thread that calls `wait()` on an object enters a waiting condition and releases that object's monitor.

It remains waiting until another thread performs an appropriate notification, such as:

```java
notify()
```

or:

```java
notifyAll()
```

Conceptually:

```text
Running
   ↓
wait()
   ↓
WAITING
   ↓
notify() / notifyAll()
   ↓
Runnable
```

---

## 32.12 Why `wait()` Is Different From `sleep()`

This is an important distinction.

### `sleep()`

```java
Thread.sleep(3000);
```

temporarily pauses the current thread for a specified time.

### `wait()`

```java
wait();
```

puts the thread into a waiting condition until it is appropriately notified.

A simple memory trick:

```text
sleep()
   ↓
Wait for time

wait()
   ↓
Wait for notification/condition
```

---

## 32.13 Blocked State

A thread can enter the **Blocked state** when it is waiting to acquire a monitor lock needed to enter a synchronized section.

For example:

```java
synchronized(this) {

    // critical section

}
```

Suppose Thread 1 already owns the lock.

Then Thread 2 reaches the same lock:

```text
Thread 1
   ↓
Owns lock
   ↓
Executing synchronized block

Thread 2
   ↓
Needs same lock
   ↓
BLOCKED
```

Thread 2 must wait until the lock becomes available.

---

## 32.14 Real-World Analogy for Blocked

Imagine a room with one key.

```text
Interview Room
      ↓
One key
```

Spider Man enters:

```text
Spider Man
     ↓
Gets key
     ↓
Enters room
```

Ant Man arrives:

```text
Ant Man
   ↓
Needs key
   ↓
Key unavailable
   ↓
Waits
```

That is similar to the idea of a thread being blocked while trying to acquire a monitor.

---

## 32.15 Three Different Temporary Conditions

The three important temporary situations from your notes can be visualized as:

```text
Running
   │
   ├── sleep() ──→ Timed Waiting
   │
   ├── wait() ───→ Waiting
   │
   └── lock unavailable
                ↓
             Blocked
```

These are different reasons why a thread may temporarily stop being able to execute.

---

## 32.16 Returning From Sleep

Suppose:

```java
Thread.sleep(3000);
```

is executed.

The thread temporarily enters timed waiting.

After the sleep duration expires:

```text
Sleep
  ↓
Time expires
  ↓
Runnable
```

It does **not** automatically become the currently executing CPU thread.

It first becomes eligible to run again.

---

## 32.17 Returning From Wait

Suppose:

```java
wait();
```

is executed.

The thread enters:

```text
WAITING
```

Another thread can perform:

```java
notify();
```

or:

```java
notifyAll();
```

After the appropriate monitor conditions are satisfied, the waiting thread becomes eligible to continue.

Conceptually:

```text
WAITING
   ↓
notify()
   ↓
Runnable
```

There can be additional synchronization details, including reacquiring the monitor before the thread can proceed beyond the `wait()` call.

---

## 32.18 Returning From Blocked

Suppose Thread 1 owns a lock:

```text
Thread 1
   ↓
LOCK
```

Thread 2 wants the same lock:

```text
Thread 2
   ↓
BLOCKED
```

When Thread 1 leaves the synchronized section:

```text
Lock released
      ↓
Thread 2 can acquire the lock
      ↓
Runnable / eligible to execute
```

The scheduler then determines when Thread 2 actually gets CPU execution time.

---

## 32.19 Runnable Does Not Mean Running

This is one of the most important concepts.

A Runnable thread is:

> **Ready/eligible to execute.**

A Running thread is conceptually:

> **Actually receiving CPU execution time.**

For example:

```text
Thread A → Runnable
Thread B → Runnable
Thread C → Runnable
```

The CPU cannot execute all of them on one CPU core at exactly the same instant.

The scheduler selects one:

```text
Runnable
   ↓
Scheduler
   ↓
Thread B
   ↓
CPU
   ↓
Running
```

Therefore:

```text
Runnable ≠ necessarily Running
```

---

## 32.20 Running Can Return to Runnable

A running thread does not necessarily continue running until its `run()` method completely finishes.

The scheduler may switch CPU execution to another eligible thread.

Conceptually:

```text
Thread A
   ↓
Running
   ↓
Scheduler switches
   ↓
Runnable
```

Then:

```text
Thread B
   ↓
Running
```

This is one reason multithreading can appear simultaneous.

---

## 32.21 Context Switching

When CPU execution switches from one thread to another, the operating system/JVM scheduling machinery performs the necessary context-switching work.

Conceptually:

```text
Thread A
   ↓
Running
   ↓
Switch
   ↓
Thread B
   ↓
Running
```

The rapid switching can make several tasks appear to execute simultaneously, especially on systems where scheduling and multiple CPU cores are involved.

---

## 32.22 Dead / Terminated State

A thread's execution ends when its `run()` method completes normally.

For example:

```java
class TestThread extends Thread {

    public void run() {

        System.out.println("Hello");
    }
}
```

After:

```text
run()
 ↓
Hello
 ↓
run() finishes
 ↓
Thread terminates
```

The thread reaches the conceptual **Dead state**.

Technically, Java calls this:

```text
TERMINATED
```

---

## 32.23 Thread Cannot Be Restarted

This is an important rule.

Once a thread has been started and its execution has terminated, you cannot call `start()` on that same `Thread` object again.

For example:

```java
Thread t = new Thread();

t.start();

// later
t.start();   // Illegal
```

The second `start()` attempt results in:

```text
IllegalThreadStateException
```

A new `Thread` object is required if you want another thread execution.

---

## 32.24 Complete Basic Lifecycle

The simplified lifecycle from your notes is:

```text
NEW
 ↓
start()
 ↓
RUNNABLE
 ↓
Scheduler selects
 ↓
RUNNING
 ↓
run() executes
 ↓
TERMINATED
```

This is the basic path.

---

## 32.25 Lifecycle With Temporary States

A more complete conceptual picture is:

```text
                  NEW
                   ↓
                 start()
                   ↓
                RUNNABLE
                   ↓
              Scheduler
                   ↓
                RUNNING
              ↙    ↓     ↘
          sleep() wait()  lock unavailable
             ↓      ↓          ↓
      TIMED_WAITING WAITING  BLOCKED
             ↓      ↓          ↓
             └──────┴──────────┘
                    ↓
                RUNNABLE
                    ↓
                Scheduler
                    ↓
                 RUNNING
                    ↓
              run() finishes
                    ↓
               TERMINATED
```

This is the most useful mental model for the topic.

---

## 32.26 Why Temporary States Exist

Why doesn't a thread simply remain running?

Because sometimes it cannot or should not continue executing.

### Sleep

It needs to pause for a period.

```text
sleep()
```

### Wait

It needs another thread or condition to allow it to continue.

```text
wait()
```

### Blocked

It needs a monitor lock that another thread currently owns.

```text
synchronized
```

So the thread lifecycle naturally involves temporary states.

---

## 32.27 Sleep vs Wait vs Blocked

| Condition     | Reason                             | Typical mechanism |
| ------------- | ---------------------------------- | ----------------- |
| Timed Waiting | Waiting for a specified time       | `sleep()`         |
| Waiting       | Waiting for notification/condition | `wait()`          |
| Blocked       | Waiting to acquire a monitor lock  | `synchronized`    |

Memory:

```text
sleep() → TIME
wait()  → NOTIFICATION
lock    → RESOURCE/MONITOR
```

---

## 32.28 The Important Return Rule

Your notes contain an important rule:

```text
Sleep / Wait / Blocked
          ↓
       Runnable
          ↓
      Scheduler
          ↓
       Running
```

A thread that becomes eligible again does not simply jump directly into CPU execution.

It first becomes **Runnable/eligible**.

Then the scheduler can select it.

---

## 32.29 Why It Goes Through Runnable

Imagine three people waiting for a bus.

```text
Person A
Person B
Person C
```

When Person A becomes ready, that doesn't mean the bus automatically picks Person A.

The person becomes:

```text
Ready
 ↓
Waits for opportunity
 ↓
Selected
 ↓
Gets opportunity
```

Similarly:

```text
Sleep finishes
      ↓
Runnable
      ↓
Scheduler
      ↓
CPU
      ↓
Running
```

This explains why **Runnable comes before Running**.

---

## 32.30 Real-World Thread Lifecycle

Consider a food-delivery application.

A delivery thread might go through:

```text
New
 ↓
Delivery thread object created
 ↓
Runnable
 ↓
Scheduler gives CPU
 ↓
Running
 ↓
Needs network response
 ↓
Waiting
 ↓
Response available
 ↓
Runnable
 ↓
Scheduler selects it
 ↓
Running
 ↓
Task completed
 ↓
Terminated
```

This demonstrates why a thread can move through several states during its lifetime.

---

## 32.31 Example Program

```java
class MyThread extends Thread {

    public void run() {

        System.out.println("Thread is running");

        try {
            Thread.sleep(3000);
        }
        catch (InterruptedException e) {
            System.out.println("Thread interrupted");
        }

        System.out.println("Thread completed");
    }
}


public class ThreadLifeCycle {

    public static void main(String[] args) {

        MyThread t = new MyThread();

        System.out.println("Thread object created");

        t.start();

        System.out.println("Thread started");
    }
}
```

Conceptually:

```text
MyThread object created
        ↓
NEW
        ↓
start()
        ↓
RUNNABLE
        ↓
Scheduler
        ↓
RUNNING
        ↓
run()
        ↓
sleep(3000)
        ↓
TIMED_WAITING
        ↓
3 seconds complete
        ↓
RUNNABLE
        ↓
Scheduler
        ↓
RUNNING
        ↓
run() finishes
        ↓
TERMINATED
```

---

## 32.32 Important Point About `sleep()`

When a thread executes:

```java
Thread.sleep(3000);
```

it enters the timed-waiting condition.

Also remember:

> `sleep()` does **not** release a monitor lock that the thread already owns.

This is an important distinction from `wait()`.

For example, if a thread is inside a synchronized method and calls `sleep()`, it continues to hold that object's monitor while sleeping.

---

## 32.33 Important Point About `wait()`

When a thread executes `wait()` on an object's monitor, it releases that monitor and waits.

Conceptually:

```text
Thread owns lock
      ↓
wait()
      ↓
Releases monitor
      ↓
WAITING
```

When appropriately notified, it must reacquire the monitor before continuing.

This is one of the major differences between `wait()` and `sleep()`.

---

## 32.34 Important Point About `notify()`

`notify()` does not directly mean:

```text
WAITING
   ↓
RUNNING
```

Instead, a waiting thread becomes eligible to compete for the monitor again.

The simplified lifecycle is:

```text
WAITING
   ↓
notify()
   ↓
Runnable / eligible
   ↓
Scheduler
   ↓
Running
```

Similarly:

```java
notifyAll();
```

can wake all threads waiting on that monitor, after which they compete to reacquire the monitor.

---

## 32.35 Official Java States

For interview purposes, remember Java's official `Thread.State` values:

```text
NEW
RUNNABLE
BLOCKED
WAITING
TIMED_WAITING
TERMINATED
```

There is **no official separate `RUNNING` enum value**.

The conceptual classroom lifecycle often represents:

```text
RUNNABLE → RUNNING
```

to explain when the scheduler actually gives CPU time.

This distinction is valuable in interviews because it shows that you understand both the simplified lifecycle diagram and Java's actual API terminology.

---

## 32.36 Final Mental Model

Keep this complete picture in your memory:

```text
                         THREAD LIFECYCLE

                              NEW
                               ↓
                         Thread object
                            created
                               ↓
                            start()
                               ↓
                           RUNNABLE
                               ↓
                      Thread Scheduler
                               ↓
                            RUNNING
                               ↓
                    ┌──────────┼──────────┐
                    ↓          ↓          ↓
                 sleep()     wait()    Lock busy
                    ↓          ↓          ↓
             TIMED_WAITING  WAITING   BLOCKED
                    ↓          ↓          ↓
                    │       notify()      │
                    │      /notifyAll()   │
                    │          ↓          │
                    └──────────┼──────────┘
                               ↓
                           RUNNABLE
                               ↓
                      Thread Scheduler
                               ↓
                            RUNNING
                               ↓
                        run() finishes
                               ↓
                         TERMINATED
```

### 🔑 Final Memory Trick

Remember the lifecycle as:

> **Create → Ready → Run → Temporarily Stop if Necessary → Ready Again → Run Again → Finish**

And remember the three temporary conditions:

```text
sleep()            → Time-based pause
wait()             → Notification/condition-based waiting
Blocked            → Waiting for a monitor lock
```

Most importantly:

```text
NEW
 ↓ start()
RUNNABLE
 ↓ scheduler
RUNNING
 ↓
sleep / wait / blocked
 ↓
RUNNABLE
 ↓ scheduler
RUNNING
 ↓ run() finishes
TERMINATED
```

**The key interview point:** a thread does not jump directly from `sleep`, `wait`, or `blocked` to actual CPU execution. Conceptually, it first becomes **Runnable/eligible**, and then the scheduler may select it to execute.
