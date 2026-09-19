# 34. Deadlock

Deadlock is one of the most important and commonly confusing concepts in **Java multithreading and synchronization**.

The basic idea is simple:

> **Two or more threads are waiting for resources held by one another, so none of them can continue.**

The threads are not necessarily finished, and they are not necessarily doing useful work. They are stuck waiting.

---

## 34.1 Deadlock

Imagine two threads:

```text
Thor
Loki
```

And two resources:

```text
Java Book
Python Book
```

Suppose Thor gets the Java Book lock first:

```text
Thor
 ↓
Java Book LOCK
```

Then Loki gets the Python Book lock:

```text
Loki
 ↓
Python Book LOCK
```

Now Thor wants Python Book:

```text
Thor
 ↓
Holds Java Book
 ↓
Waiting for Python Book
```

But Python Book is already locked by Loki.

At the same time, Loki wants Java Book:

```text
Loki
 ↓
Holds Python Book
 ↓
Waiting for Java Book
```

Now we have:

```text
Thor holds Java
Thor waits for Python

Loki holds Python
Loki waits for Java
```

Neither thread can continue.

This situation is called **deadlock**.

---

## 34.2 Meaning of Deadlock

The word can be understood as:

```text
Dead
  +
Lock
```

The threads are effectively **stuck because of locks**.

They keep waiting for resources that the other threads are holding.

Conceptually:

```text
Thread 1
   ↓
holds Resource A
   ↓
waits for Resource B
          ↑
          │
holds Resource B
          │
Thread 2
   ↓
waits for Resource A
```

There is a circular dependency.

---

## 34.3 Why Does Deadlock Happen?

Deadlock generally happens when multiple threads:

* Share resources
* Acquire locks
* Hold one lock
* Wait for another lock
* And form a circular waiting relationship

For example:

```text
Thor → Java Book → wants Python Book

Loki → Python Book → wants Java Book
```

The problem is not simply "two threads are running."

The problem is:

> **Each thread is holding something that the other thread needs.**

---

## 34.4 Simple Real-World Analogy

Imagine two people have two keys.

Person A has:

```text
Key 1
```

Person B has:

```text
Key 2
```

Person A says:

> "I will give Key 1 only after I get Key 2."

Person B says:

> "I will give Key 2 only after I get Key 1."

Now:

```text
A → has Key 1 → wants Key 2
B → has Key 2 → wants Key 1
```

Neither person can proceed.

That is the real-world idea of deadlock.

---

## 34.5 Resource Dependency

A **resource dependency** exists when one thread needs a resource that another thread currently holds.

For example:

```text
Thor
 ↓
holds Java Book
 ↓
needs Python Book
```

But:

```text
Loki
 ↓
holds Python Book
```

Therefore Thor depends on Loki releasing Python Book.

At the same time:

```text
Loki
 ↓
needs Java Book
```

But:

```text
Thor
 ↓
holds Java Book
```

Therefore Loki depends on Thor releasing Java Book.

This creates:

```text
Thor → Loki
 ↑       ↓
 └───────┘
```

That circular dependency is the dangerous part.

---

## 34.6 Thread 1 Holds One Resource

Consider Thread 1:

```text
Thor
 ↓
Java Book
```

Thor acquires the Java Book lock:

```java
synchronized(javaBook) {

    // Thor has Java Book lock

}
```

While inside this block, Thor owns the monitor associated with `javaBook`.

Conceptually:

```text
Java Book
    ↓
LOCKED
    ↓
Thor
```

---

## 34.7 Thread 2 Holds Another Resource

Now Loki acquires the Python Book lock:

```java
synchronized(pythonBook) {

    // Loki has Python Book lock

}
```

Conceptually:

```text
Python Book
    ↓
LOCKED
    ↓
Loki
```

Now:

```text
Java Book → Thor
Python Book → Loki
```

---

## 34.8 Thor Waits for Loki

Thor now tries to acquire Python Book:

```java
synchronized(javaBook) {

    synchronized(pythonBook) {

        // Thor's operation

    }
}
```

But Loki already owns the Python Book monitor.

Therefore Thor cannot enter:

```text
Python Book
```

Thor must wait.

So:

```text
Thor
 ↓
holds Java Book
 ↓
waiting for Python Book
 ↓
Python Book held by Loki
```

---

## 34.9 Loki Waits for Thor

Now suppose Loki has:

```java
synchronized(pythonBook) {

    synchronized(javaBook) {

        // Loki's operation

    }
}
```

Loki already holds the Python Book lock.

He now tries to acquire the Java Book lock.

But Thor owns it.

Therefore Loki waits.

```text
Loki
 ↓
holds Python Book
 ↓
waiting for Java Book
 ↓
Java Book held by Thor
```

---

## 34.10 Circular Waiting

Now put both situations together:

```text
Thor
 │
 │ holds
 ↓
Java Book
 │
 │ wants
 ↓
Python Book
 │
 │ held by
 ↓
Loki
 │
 │ wants
 ↓
Java Book
 │
 └──────────────→ Thor
```

This forms a circle:

```text
Thor
 ↓
Loki
 ↓
Thor
```

Therefore neither can move forward.

This is called **circular waiting**.

---

## 34.11 Library Deadlock Scenario

Our Library contains:

```text
Library
│
├── Java Book
├── Python Book
└── JavaScript Book
```

Threads:

```text
Thor
Loki
```

Suppose Thor follows:

```text
Java → Python → JavaScript
```

and Loki follows:

```text
JavaScript → Python → Java
```

The nested synchronization creates multiple lock dependencies.

Conceptually:

```text
Thor:
Lock Java
   ↓
Lock Python
   ↓
Lock JavaScript
```

while:

```text
Loki:
Lock JavaScript
   ↓
Lock Python
   ↓
Lock Java
```

The different lock order can create a situation where each thread holds locks that the other thread needs.

---

## 34.12 Library Deadlock Example

A simplified example is:

```java
class Library {

    Object javaBook = new Object();
    Object pythonBook = new Object();
    Object javaScriptBook = new Object();


    void thorReads() {

        synchronized(javaBook) {

            System.out.println("Thor locked Java Book");

            synchronized(pythonBook) {

                System.out.println("Thor locked Python Book");

                synchronized(javaScriptBook) {

                    System.out.println(
                        "Thor locked JavaScript Book"
                    );
                }
            }
        }
    }


    void lokiReads() {

        synchronized(javaScriptBook) {

            System.out.println(
                "Loki locked JavaScript Book"
            );

            synchronized(pythonBook) {

                System.out.println(
                    "Loki locked Python Book"
                );

                synchronized(javaBook) {

                    System.out.println(
                        "Loki locked Java Book"
                    );
                }
            }
        }
    }
}
```

Notice the order:

```text
Thor:
Java → Python → JavaScript
```

```text
Loki:
JavaScript → Python → Java
```

This is an unsafe lock-ordering design.

---

## 34.13 Possible Deadlock Flow

A possible situation can look like this:

```text
Thor
 ↓
Locks Java Book
 ↓
Tries to lock Python Book
```

At the same time:

```text
Loki
 ↓
Locks JavaScript Book
 ↓
Locks Python Book
```

If Loki gets Python before Thor does:

```text
Thor → holds Java → waits for Python

Loki → holds Python → waits for Java
```

Now:

```text
Thor waits for Loki
Loki waits for Thor
```

Neither can complete.

---

## 34.14 Why Java Cannot Simply Continue?

A thread cannot simply enter a synchronized block whose monitor is already held by another thread.

For example:

```java
synchronized(pythonBook) {
}
```

requires the thread to acquire the monitor of `pythonBook`.

If another thread already owns that monitor:

```text
Python Book
     ↓
Monitor
     ↓
Owned by Loki
```

Thor has to wait.

This is what makes the resource dependency meaningful.

---

## 34.15 Deadlock vs Normal Waiting

Not every waiting situation is deadlock.

### Normal waiting

```text
Thor
 ↓
waiting for Python Book
 ↓
Loki finishes
 ↓
Loki releases Python Book
 ↓
Thor continues
```

This is normal synchronization.

### Deadlock

```text
Thor
 ↓
waiting for Loki

Loki
 ↓
waiting for Thor
```

Neither can release what the other needs.

That is deadlock.

---

## 34.16 Normal Blocking vs Deadlock

A thread can be blocked temporarily:

```text
Thread A
 ↓
Waiting
 ↓
Resource becomes available
 ↓
Continues
```

This is not necessarily a deadlock.

Deadlock requires a circular dependency such as:

```text
A waits for B
B waits for A
```

With more threads:

```text
A waits for B
B waits for C
C waits for A
```

That is also circular waiting.

---

## 34.17 Deadlock With Three Resources

Our example contains three books:

```text
Java
Python
JavaScript
```

A more complex dependency could be:

```text
Thor:
holds Java
needs Python

Loki:
holds Python
needs JavaScript

Another thread:
holds JavaScript
needs Java
```

Then:

```text
Thor
 ↓
Python
 ↓
JavaScript
 ↓
Java
 ↓
Thor
```

Again, a circular dependency is formed.

---

## 34.18 Main Cause in This Library Example

The important problem is not simply:

```text
Thor
Loki
```

The important problem is:

```text
Multiple threads
        +
Multiple shared resources
        +
Multiple locks
        +
Different lock acquisition order
        ↓
Potential circular waiting
        ↓
Deadlock
```

This is why the previous topic on **nested synchronization/resource locking** is directly connected to deadlock.

---

## 34.19 How to Prevent This Problem

One common strategy is to use a **consistent lock order**.

For example, decide:

```text
1. Java Book
2. Python Book
3. JavaScript Book
```

Every thread must follow:

```text
Java → Python → JavaScript
```

So:

```text
Thor:
Java → Python → JavaScript

Loki:
Java → Python → JavaScript
```

Instead of:

```text
Thor:
Java → Python → JavaScript

Loki:
JavaScript → Python → Java
```

Consistent ordering makes circular waiting much less likely.

---

## 34.20 Safe Locking Mental Model

Think of multiple locks as doors.

Always enter the doors in the same order:

```text
Door 1
 ↓
Door 2
 ↓
Door 3
```

Never allow one person to enter:

```text
Door 1 → Door 2
```

while another enters:

```text
Door 2 → Door 1
```

because they could each hold one door and wait forever for the other.

---

## 34.21 Important Rules

**Rule 1:** Deadlock occurs because threads are waiting for resources held by one another.

**Rule 2:** Holding one lock while waiting for another lock increases the possibility of deadlock.

**Rule 3:** Multiple resource locks make lock ordering important.

**Rule 4:** Different lock acquisition orders can create circular waiting.

**Rule 5:** Consistent lock ordering is a common strategy for preventing this type of deadlock.

**Rule 6:** Normal blocking is not automatically deadlock.

**Rule 7:** Deadlock means the involved threads cannot make progress because of the circular dependency.

---

## 34.22 Common Confusion

### "Blocked means deadlock."

Not necessarily.

A thread can be blocked because another thread temporarily owns a lock.

```text
A owns resource
B waits
A finishes
A releases resource
B continues
```

That is normal synchronization.

Deadlock is different:

```text
A waits for B
B waits for A
```

and neither can progress.

---

## 34.23 Common Confusion

### "Starting two threads creates deadlock."

No.

This:

```java
t1.start();
t2.start();
```

does not itself create deadlock.

Deadlock requires an appropriate resource/lock dependency.

---

## 34.24 Common Confusion

### "Synchronization always causes deadlock."

No.

Synchronization is used to control concurrent access and can make programs thread-safe.

Deadlock is a **possible problem caused by an unsafe locking design**, particularly when multiple locks are acquired in inconsistent orders.

---

## 34.25 Common Confusion

### "The CPU is responsible for deadlock."

No.

The CPU/thread scheduler determines which thread gets execution time, but the deadlock comes from the **resource dependency between threads**.

The scheduler cannot make progress for a thread that is waiting for a monitor held by another thread.

---

## 34.26 Real-World Examples

The same concept can appear in many systems.

### Banking

```text
Thread 1:
Account A → Account B

Thread 2:
Account B → Account A
```

### Databases

```text
Transaction 1:
Row A → Row B

Transaction 2:
Row B → Row A
```

### Files

```text
Process 1:
File A → File B

Process 2:
File B → File A
```

### Ticket systems

```text
Thread 1:
Ticket resource → Payment resource

Thread 2:
Payment resource → Ticket resource
```

The resource names change, but the fundamental dependency is the same.

---

## 34.27 Memory Trick

Remember:

> **"I have what you need, and you have what I need."**

Thor:

```text
"I have Java.
I need Python."
```

Loki:

```text
"I have Python.
I need Java."
```

Therefore:

```text
Thor ←→ Loki
```

Both wait.

**Deadlock = Hold + Wait + Circular Dependency.**

---

## 34.28 Complete Conceptual Flow

```text
Multiple Threads
       ↓
Shared Resources
       ↓
Synchronization
       ↓
Multiple Locks
       ↓
Thread 1 acquires Resource A
       ↓
Thread 2 acquires Resource B
       ↓
Thread 1 requests Resource B
       ↓
Resource B is held by Thread 2
       ↓
Thread 1 waits
       ↓
Thread 2 requests Resource A
       ↓
Resource A is held by Thread 1
       ↓
Thread 2 waits
       ↓
Circular Waiting
       ↓
DEADLOCK
```

---

## 34.29 Library Example — Complete Mental Picture

```text
                       LIBRARY
                          │
          ┌───────────────┼───────────────┐
          ↓               ↓               ↓
      Java Book       Python Book     JavaScript Book
          │               │               │
        LOCK              LOCK            LOCK
          │               │               │
          └───────────────┼───────────────┘
                          │
                 Nested Synchronization
                          │
             ┌────────────┴────────────┐
             ↓                         ↓
           THOR                       LOKI
             │                         │
     Java → Python → JS        JS → Python → Java
             │                         │
             └──────────┬──────────────┘
                        ↓
                Different lock order
                        ↓
               Resource dependency
                        ↓
                Circular waiting
                        ↓
                    DEADLOCK
```

---

## 34.30 Interview Understanding

**Deadlock is a situation in multithreading where two or more threads become permanently unable to proceed because each thread is waiting for a resource/lock held by another thread.**

In the Library example, Thor and Loki access Java, Python, and JavaScript Book resources using nested synchronization. If Thor acquires one resource and waits for another while Loki holds the second resource and waits for the first, a circular dependency can occur. Neither thread can proceed because each is waiting for the other to release a required resource.

The key relationship is:

```text
Thread 1
    holds A
    waits for B

Thread 2
    holds B
    waits for A
```

Therefore:

```text
Hold + Wait
     +
Circular Dependency
     ↓
Deadlock
```

**The most important interview point:** when multiple locks are required, acquiring them in a **consistent order** is a common way to reduce the risk of deadlock.
