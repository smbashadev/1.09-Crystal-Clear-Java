# 29. Synchronized Method Example — Interview

This example combines the important concepts you have learned so far: **Runnable, multiple threads, thread names, `run()`, and synchronization**.

The idea is simple:

```text
Three interviewers/threads
        ↓
Java
Python
JavaScript
        ↓
All want to use the same interview resource
        ↓
synchronized
        ↓
Only one thread at a time
```

---

### 1. Basic Idea

Suppose an interview company has **one interview panel**.

Three candidates are waiting:

```text
Java
Python
JavaScript
```

All three want to attend the interview.

If the interview panel can interview only one candidate at a time, the candidates must wait for their turn.

In Java, we can represent the candidates using **threads**.

```text
Java Thread
Python Thread
JavaScript Thread
```

The synchronized method ensures that only one thread executes the protected method at a time for the same lock.

---

### 2. What Is `Runnable`?

`Runnable` is a predefined Java interface.

It represents a **task that a thread can execute**.

It provides:

```java
void run();
```

We implement `Runnable` when we want to define the work performed by a thread.

For example:

```java
class Interview implements Runnable {

    public void run() {

        // Interview work

    }
}
```

Here, the interview activity is placed inside `run()`.

---

### 3. Why Use `Runnable`?

We want to create multiple threads that perform the same type of activity:

```text
Interview
   ↓
Java
Python
JavaScript
```

The `Runnable` object defines the work, while `Thread` objects provide separate execution paths.

Conceptually:

```text
Runnable task
      ↓
Interview work

Thread 1 → Java
Thread 2 → Python
Thread 3 → JavaScript
```

---

### 4. Three Threads

Our program will create three threads:

```text
Thread 1 → Java
Thread 2 → Python
Thread 3 → JavaScript
```

All three threads will execute the same `run()` method.

But each thread will have a different name.

```text
Thread 1 → "Java"
Thread 2 → "Python"
Thread 3 → "JavaScript"
```

---

### 5. Thread Names

A thread can be given a name using:

```java
setName()
```

For example:

```java
t1.setName("Java");
```

This means:

```text
t1
 ↓
Thread name = Java
```

Similarly:

```java
t2.setName("Python");
t3.setName("JavaScript");
```

Now:

```text
t1 → Java
t2 → Python
t3 → JavaScript
```

---

### 6. Getting the Current Thread's Name

Inside `run()`, we can write:

```java
Thread.currentThread().getName()
```

This means:

```text
currentThread()
       ↓
Find the thread executing right now
       ↓
getName()
       ↓
Get its name
```

So when the Java thread is executing:

```text
Thread.currentThread().getName()
                ↓
              Java
```

When Python is executing:

```text
Thread.currentThread().getName()
                ↓
             Python
```

---

### 7. The `run()` Method

The thread's activity is written inside:

```java
run()
```

For our example:

```java
public void run() {

    System.out.println(
        Thread.currentThread().getName()
        + " interview"
    );
}
```

The thread prints its own name followed by:

```text
interview
```

---

### 8. Why Make `run()` Synchronized?

Normally we can have:

```java
public void run()
```

But your example uses:

```java
synchronized public void run()
```

The keyword:

```java
synchronized
```

controls access to the method through the object's lock.

For the same `Runnable` object, if multiple threads invoke this synchronized instance method, only one thread can hold that object's monitor and execute the method at a time.

The others have to wait for the lock.

---

### 9. Understanding This Line

```java
synchronized public void run()
```

Break it down:

```text
synchronized
      ↓
Use synchronization/locking

public
      ↓
Method can be accessed from anywhere allowed by Java access rules

void
      ↓
Method returns no value

run()
      ↓
Thread's task
```

Together:

```text
synchronized public void run()
        ↓
A synchronized run method
```

---

### 10. Real-World Analogy

Imagine one interview room:

```text
             Interview Room
                   ↓
                ONE ROOM
                   ↓
       ┌───────────┼───────────┐
       ↓           ↓           ↓
     Java        Python     JavaScript
```

Only one candidate can enter at a time.

If Java enters:

```text
Java
 ↓
Interview Room
 ↓
Interview
 ↓
Leaves
```

Python must wait:

```text
Python
   ↓
WAIT
```

After Java leaves:

```text
Python
   ↓
Interview Room
```

Then JavaScript gets its turn.

That is the idea of synchronization.

---

### 11. Complete Example

```java
class Interview implements Runnable {

    synchronized public void run() {

        System.out.println(
            Thread.currentThread().getName()
            + " interview started"
        );

        System.out.println(
            Thread.currentThread().getName()
            + " interview completed"
        );
    }
}


public class InterviewApp {

    public static void main(String[] args) {

        Interview interview = new Interview();

        Thread t1 = new Thread(interview);
        Thread t2 = new Thread(interview);
        Thread t3 = new Thread(interview);

        t1.setName("Java");
        t2.setName("Python");
        t3.setName("JavaScript");

        t1.start();
        t2.start();
        t3.start();
    }
}
```

---

### 12. Creating the `Interview` Object

```java
Interview interview = new Interview();
```

This creates **one Interview object**.

Conceptually:

```text
interview
    ↓
┌─────────────────┐
│ Interview object│
│                 │
│ Object Lock     │
└─────────────────┘
```

This one object is important because all three threads will use it.

---

### 13. Creating Thread 1

```java
Thread t1 = new Thread(interview);
```

This creates a Thread object that uses the `interview` Runnable task.

```text
t1
 ↓
Interview task
```

Then:

```java
t1.setName("Java");
```

gives it the name:

```text
Java
```

So:

```text
t1 → Java
```

---

### 14. Creating Thread 2

```java
Thread t2 = new Thread(interview);
```

This creates another thread using the **same `interview` object**.

Then:

```java
t2.setName("Python");
```

gives it the name:

```text
Python
```

So:

```text
t2 → Python
```

---

### 15. Creating Thread 3

```java
Thread t3 = new Thread(interview);
```

Again, it uses the same `interview` object.

Then:

```java
t3.setName("JavaScript");
```

So:

```text
t3 → JavaScript
```

---

### 16. The Most Important Picture

All three threads point to the same Runnable object:

```text
                interview
                    ↓
             Interview Object
                    ↓
                 LOCK
              ↙    ↓    ↘
             ↙     ↓     ↘
           t1      t2      t3
         Java    Python  JavaScript
```

Because the synchronized `run()` is an instance method on the same object, the threads compete for that object's monitor.

---

### 17. Starting the Threads

We write:

```java
t1.start();
t2.start();
t3.start();
```

This makes the three threads eligible to execute.

Conceptually:

```text
t1.start() → Java thread starts
t2.start() → Python thread starts
t3.start() → JavaScript thread starts
```

But we cannot assume which one will obtain the lock first.

---

### 18. Why Java Can Execute First

Your expected execution says:

```text
Java interview first
JavaScript interview
Python interview
```

One possible execution is:

```text
Java
  ↓
Gets lock
  ↓
Interview
  ↓
Releases lock

JavaScript
  ↓
Gets lock
  ↓
Interview
  ↓
Releases lock

Python
  ↓
Gets lock
  ↓
Interview
  ↓
Releases lock
```

However, **synchronization does not guarantee that Java will always be first, JavaScript second, and Python third**.

The scheduler and lock acquisition determine the actual order.

---

### 19. What Synchronization Guarantees

Synchronization guarantees the important part:

```text
One thread
    ↓
Enters synchronized run()
    ↓
Executes
    ↓
Finishes
    ↓
Releases lock
    ↓
Another thread enters
```

It does **not** guarantee:

```text
Java → JavaScript → Python
```

every time.

The actual order may be:

```text
Java → Python → JavaScript
```

or:

```text
Python → Java → JavaScript
```

or another order.

---

### 20. Possible Output

One possible output is:

```text
Java interview started
Java interview completed
JavaScript interview started
JavaScript interview completed
Python interview started
Python interview completed
```

This matches your notes.

But another valid execution could be:

```text
Python interview started
Python interview completed
Java interview started
Java interview completed
JavaScript interview started
JavaScript interview completed
```

The synchronization requirement is **one-at-a-time execution**, not a fixed order.

---

### 21. Execution Flow

The complete flow is:

```text
Interview object created
        ↓
Thread t1 created
        ↓
Thread t2 created
        ↓
Thread t3 created
        ↓
Names assigned
        ↓
t1.start()
        ↓
t2.start()
        ↓
t3.start()
        ↓
Threads compete for object lock
        ↓
One thread obtains lock
        ↓
Synchronized run() executes
        ↓
Thread completes run()
        ↓
Lock released
        ↓
Another thread obtains lock
        ↓
Its run() executes
        ↓
Third thread eventually executes
```

---

### 22. Without Synchronization

If we used:

```java
public void run()
```

instead of:

```java
synchronized public void run()
```

then the three threads could enter `run()` concurrently.

Conceptually:

```text
Java
 ↓
run() ───────────────

Python
 ↓
run() ───────────────

JavaScript
 ↓
run() ───────────────
```

Their output could become interleaved if the method contains multiple operations.

---

### 23. With Synchronization

With:

```java
synchronized public void run()
```

the execution becomes controlled for the same object:

```text
Java
 ↓
LOCK
 ↓
run()
 ↓
FINISH
 ↓
UNLOCK

Python
 ↓
LOCK
 ↓
run()
 ↓
FINISH
 ↓
UNLOCK

JavaScript
 ↓
LOCK
 ↓
run()
 ↓
FINISH
 ↓
UNLOCK
```

Only one thread holds the relevant object lock at a time.

---

### 24. Why the Same Object Matters

This is extremely important.

We created:

```java
Interview interview = new Interview();
```

only once.

Then:

```java
new Thread(interview)
```

was used three times.

Therefore:

```text
t1 → same interview object
t2 → same interview object
t3 → same interview object
```

So all three threads are synchronized through the same object's monitor when executing the synchronized instance method.

---

### 25. What If We Created Three Objects?

Suppose we did:

```java
Interview i1 = new Interview();
Interview i2 = new Interview();
Interview i3 = new Interview();
```

Now there are three different objects:

```text
i1 → Lock 1
i2 → Lock 2
i3 → Lock 3
```

If each thread uses a different object, they do not all compete for the same instance lock.

Therefore, simply writing `synchronized` does not mean **all threads everywhere in the program become one-at-a-time**.

The lock being used matters.

---

### 26. Thread Name Flow

Let's follow the Java thread:

```text
t1
 ↓
setName("Java")
 ↓
start()
 ↓
run()
 ↓
Thread.currentThread()
 ↓
t1 / Java thread
 ↓
getName()
 ↓
Java
```

So it can print:

```text
Java interview
```

For Python:

```text
Python interview
```

For JavaScript:

```text
JavaScript interview
```

---

### 27. Why `currentThread()` Is Used

Inside the common `run()` method, we do not hard-code:

```java
System.out.println("Java interview");
```

because the same `run()` method is used by all three threads.

Instead:

```java
Thread.currentThread().getName()
```

automatically identifies whoever is currently executing.

Therefore the same code works for:

```text
Java
Python
JavaScript
```

This is a very useful multithreading technique.

---

### 28. Common Confusion — `Runnable` vs `Thread`

Remember:

```text
Runnable
   ↓
Defines the task

Thread
   ↓
Executes the task
```

In our example:

```text
Interview
   ↓
Runnable task

t1
   ↓
Java execution

t2
   ↓
Python execution

t3
   ↓
JavaScript execution
```

---

### 29. Common Confusion — `run()` vs `start()`

Do not directly call:

```java
t1.run();
```

when you want a new thread.

Normally use:

```java
t1.start();
```

`start()` asks Java to start a new thread of execution, which then invokes that thread's `run()` method.

Remember:

```text
start()
   ↓
Starts thread
   ↓
run()
   ↓
Performs task
```

---

### 30. Common Confusion — Synchronization Does Not Decide Order

This is one of the most important interview points.

Wrong:

> "`synchronized` makes Java always execute first."

Correct:

> "`synchronized` controls access so that only one thread at a time can execute the synchronized instance method using the same object's lock. It does not guarantee which thread gets the lock first."

So:

```text
synchronized
      ↓
ONE AT A TIME
```

not:

```text
synchronized
      ↓
FIXED ORDER
```

---

### 31. Common Confusion — Thread Safe

Synchronization can help make shared mutable operations thread-safe.

But simply declaring any method `synchronized` does not automatically make an entire application thread-safe.

The shared state and synchronization design must be correct.

For this interview example, synchronization ensures that the interview method is entered by one thread at a time for the same `Interview` object.

---

### 32. Important Rules

* `Runnable` is an interface.
* `Runnable` provides `void run()`.
* `run()` contains the task performed by the thread.
* `Thread` is a predefined Java class.
* Multiple `Thread` objects can use the same `Runnable` object.
* `setName()` changes a thread's name.
* `Thread.currentThread()` obtains the currently executing thread.
* `getName()` obtains that thread's name.
* `synchronized` provides lock-based access control.
* A synchronized instance method uses the object's monitor.
* For the same object, only one thread can hold that monitor at a time.
* Other threads trying to acquire the same monitor wait.
* Synchronization does not guarantee which thread executes first.
* Synchronization does not guarantee `Java → JavaScript → Python`.
* `start()` starts a new thread; directly calling `run()` does not provide the same new-thread behavior.
* Synchronization is an important technique for protecting shared mutable state and achieving thread safety.

---

### 33. Easy Memory Trick

Think about **one interview room**:

```text
One Interview Room
        ↓
One Lock
        ↓
Java enters
        ↓
Java finishes
        ↓
Python/JavaScript gets a chance
        ↓
One enters
        ↓
Finishes
        ↓
Next enters
```

Remember:

> **One room + one key = one person at a time.**

In Java:

```text
Room       → synchronized method
Key        → object lock
Candidate  → thread
Interview  → run() work
```

---

### 34. Interview Understanding

A synchronized method example can use `Runnable` to define an interview task and create three threads named **Java, Python, and JavaScript**. All three threads can use the same `Runnable` object. When the `run()` method is declared `synchronized`, a thread must acquire the object's monitor before executing it. If one thread is executing the synchronized method, other threads attempting to execute the same synchronized instance method on that object must wait for the lock. After the first thread completes, another thread can acquire the lock and execute. Synchronization therefore provides **one-at-a-time access**, but it does not guarantee a particular order such as Java first, JavaScript second, and Python third.

---

### 35. Complete Mental Picture

```text
                  Interview Object
                        ↓
                      LOCK
                        ↓
              synchronized run()
                        ↓
       ┌────────────────┼────────────────┐
       ↓                ↓                ↓
     Java             Python         JavaScript
    Thread             Thread            Thread
       ↓                ↓                ↓
       └──────── Compete for Lock ───────┘
                        ↓
                 ONE GETS LOCK
                        ↓
                  Executes run()
                        ↓
                     FINISH
                        ↓
                  Releases Lock
                        ↓
               NEXT THREAD
                        ↓
                  Executes run()
                        ↓
                     FINISH
                        ↓
                  NEXT THREAD
```

---

### 36. Lifetime Memory

```text
                    SYNCHRONIZATION
                           ↓
                    Create Runnable
                           ↓
                     Interview task
                           ↓
                 Create ONE Interview object
                           ↓
          ┌────────────────┼────────────────┐
          ↓                ↓                ↓
        Thread 1         Thread 2         Thread 3
          ↓                ↓                ↓
        Java             Python         JavaScript
          ↓                ↓                ↓
       start()           start()           start()
          └────────────────┼────────────────┘
                           ↓
                  Same Interview object
                           ↓
                    Same object lock
                           ↓
                  synchronized run()
                           ↓
                   One thread gets lock
                           ↓
                    Executes interview
                           ↓
                    Finishes run()
                           ↓
                    Releases lock
                           ↓
                 Another thread gets lock
                           ↓
                    Executes interview
                           ↓
                 Third thread gets lock
                           ↓
                    Executes interview
                           ↓
                  All interviews complete
```

### 🔑 Remember Forever

> **Three threads can compete for the same synchronized method, but when they use the same object lock, only one thread can execute that synchronized instance method at a time. The others wait, and after the lock is released, another thread gets its turn. Synchronization controls “one at a time,” not “who goes first.”**
