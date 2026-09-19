# 28. Synchronization

Synchronization is one of the most important concepts in **Java Multithreading**.

When multiple threads work at the same time and try to access or modify the **same object/data**, problems can occur.

Synchronization provides a way to control that access so that **only one thread performs the synchronized operation at a time**.

---

## 1. Basic Idea

Imagine that two people are trying to use the **same ATM account** at exactly the same time.

```text
Thread 1 → Withdraw ₹5,000
Thread 2 → Withdraw ₹5,000
```

Suppose the account has only ₹7,000.

If both threads read the balance at the same time before either one updates it, incorrect results can occur.

This is called a **race condition**.

Synchronization helps control this situation.

```text
Thread 1
   ↓
Gets access
   ↓
Performs operation
   ↓
Releases access
   ↓
Thread 2
   ↓
Gets access
   ↓
Performs operation
```

So the basic idea is:

> **Synchronization controls multiple threads when they access shared data or a shared object.**

---

## 2. Why Do We Need Synchronization?

Without synchronization, multiple threads can enter the same critical section at the same time.

For example:

```text
Bank Balance = ₹10,000

Thread 1 → Withdraw ₹7,000
Thread 2 → Withdraw ₹7,000
```

Both threads might see:

```text
Balance = ₹10,000
```

before either updates the balance.

That can cause an incorrect result.

Synchronization makes the operation controlled:

```text
Thread 1
   ↓
Check balance
   ↓
Withdraw ₹7,000
   ↓
Update balance
   ↓
Finish
   ↓
Thread 2
   ↓
Check updated balance
   ↓
Cannot withdraw ₹7,000
```

---

## 3. Real-World Analogy — One Bathroom Key

Imagine a school has one bathroom and only **one key**.

There are many students:

```text
Student A
Student B
Student C
```

But only one student can use the bathroom at a time.

The key acts like a **lock**.

```text
Student A
   ↓
Gets key
   ↓
Uses bathroom
   ↓
Returns key
   ↓
Student B
   ↓
Gets key
```

The other students must wait.

Synchronization works similarly.

```text
Thread A
   ↓
Gets object lock
   ↓
Executes synchronized code
   ↓
Releases lock
   ↓
Thread B
   ↓
Gets object lock
```

---

# 4. Object Lock

Your notes state:

> Every Java object has a lock associated with it.

For understanding synchronization, think of every Java object as having an associated **monitor/lock**.

For example:

```java
Student s = new Student();
```

We can conceptually imagine:

```text
Student object
      +
Object lock
```

The lock is used when synchronized access is required.

---

## 5. What Is a Lock?

A lock is like a **permission token**.

If a thread owns the lock:

```text
Thread 1
   ↓
Owns lock
   ↓
Can enter synchronized section
```

Another thread trying to enter the same synchronized section must wait for the lock to become available.

```text
Thread 2
   ↓
Needs same lock
   ↓
Lock unavailable
   ↓
WAIT
```

---

# 6. `synchronized` Keyword

Java provides the keyword:

```java
synchronized
```

The `synchronized` keyword is used to control access to shared resources through locking.

It tells Java that a particular method or block should be executed under synchronization.

The basic idea is:

```text
synchronized
      ↓
Use locking mechanism
      ↓
Control thread access
```

---

# 7. Why Is `synchronized` Important?

Suppose two threads are doing this:

```text
Thread 1 → Access object
Thread 2 → Access same object
```

Without synchronization:

```text
Thread 1 ───────────────→
Thread 2 ───────────────→
        Both may enter
```

With synchronization:

```text
Thread 1
   ↓
LOCK
   ↓
Execute
   ↓
UNLOCK
   ↓
Thread 2
   ↓
LOCK
   ↓
Execute
```

So synchronization provides controlled access.

---

# 8. Synchronized Method

A method can be declared as:

```java
synchronized void withdraw() {
    
    // critical operation

}
```

Here:

```text
synchronized
      ↓
Keyword

void
      ↓
Return type

withdraw()
      ↓
Method name
```

The method becomes a **synchronized method**.

---

# 9. Meaning of a Synchronized Method

When multiple threads attempt to execute a synchronized instance method on the **same object**, only one thread can hold that object's monitor and execute that method at a time.

The other thread must wait for the lock.

Example:

```java
class Bank {

    synchronized void withdraw() {

        System.out.println("Withdrawal started");

        System.out.println("Withdrawal completed");
    }
}
```

Suppose:

```text
Thread 1 → withdraw()
Thread 2 → withdraw()
```

Both use the same `Bank` object.

The execution is controlled:

```text
Thread 1
   ↓
gets object lock
   ↓
withdraw()
   ↓
completes
   ↓
releases lock

Thread 2
   ↓
gets object lock
   ↓
withdraw()
   ↓
completes
```

---

# 10. Why Do Other Threads Wait?

Suppose Thread 1 enters:

```java
synchronized void withdraw()
```

Thread 1 obtains the object's monitor.

While Thread 1 is executing:

```text
Object
  ↓
LOCKED by Thread 1
```

Now Thread 2 tries to enter the same synchronized method on that same object.

Thread 2 cannot obtain the lock.

Therefore:

```text
Thread 2
   ↓
Attempts to enter
   ↓
Lock unavailable
   ↓
Waits
```

When Thread 1 finishes:

```text
Thread 1
   ↓
Method completes
   ↓
Lock released
```

Then another waiting thread can acquire the lock.

---

# 11. One Thread at a Time

The important idea from your notes is:

> Only one thread enters/executes the synchronized method at a given point of time.

Visualize it like this:

```text
             Bank Object
                 |
              LOCK
                 |
       ┌─────────┴─────────┐
       ↓                   ↓
   Thread 1             Thread 2
       ↓                   ↓
    ENTER                WAIT
       ↓
   EXECUTE
       ↓
   COMPLETE
       ↓
 RELEASE LOCK
                           ↓
                        ENTER
                           ↓
                        EXECUTE
```

This prevents both threads from simultaneously executing the synchronized method under the same object's lock.

---

# 12. Simple Java Example

```java
class Bank {

    synchronized void display() {

        System.out.println("Transaction started");

        System.out.println("Transaction completed");
    }
}

class Test {

    public static void main(String[] args) {

        Bank b = new Bank();

        Thread t1 = new Thread(() -> b.display());
        Thread t2 = new Thread(() -> b.display());

        t1.start();
        t2.start();
    }
}
```

The two threads both call:

```java
b.display()
```

and both use the **same Bank object `b`**.

Because `display()` is synchronized, access to that method is controlled by the object's lock.

---

# 13. Understanding the `Bank` Object

This statement:

```java
Bank b = new Bank();
```

creates one Bank object.

Conceptually:

```text
b
 ↓
┌──────────────────┐
│   Bank object    │
│                  │
│   Object Lock    │
└──────────────────┘
```

Both threads use this same object:

```text
Thread 1 ──→ b.display()
Thread 2 ──→ b.display()
```

Therefore, they compete for the same object's monitor.

---

# 14. Understanding `t1`

```java
Thread t1 = new Thread(() -> b.display());
```

This creates a thread that will execute:

```java
b.display()
```

when started.

The important part is:

```text
t1
 ↓
calls b.display()
```

---

# 15. Understanding `t2`

```java
Thread t2 = new Thread(() -> b.display());
```

This creates another thread that also calls:

```java
b.display()
```

Therefore:

```text
t1 → b.display()
t2 → b.display()
```

Both are trying to access the same synchronized method on the same object.

---

# 16. `start()`

These statements:

```java
t1.start();
t2.start();
```

start the two threads.

Now both threads can become eligible to execute.

The exact first thread to obtain the lock is not something you should assume from the order of the two `start()` calls.

For example, either may get the lock first.

---

# 17. Possible Execution

One possible execution is:

```text
t1 starts
   ↓
t1 gets Bank object's lock
   ↓
t1 enters display()
   ↓
Transaction started
   ↓
Transaction completed
   ↓
t1 finishes method
   ↓
Lock released
   ↓
t2 gets lock
   ↓
t2 enters display()
   ↓
Transaction started
   ↓
Transaction completed
```

Another execution could have `t2` obtain the lock first.

The important guarantee is about synchronized access, not which thread necessarily goes first.

---

# 18. What Synchronization Does NOT Mean

Synchronization does **not** mean:

> "Only one thread exists."

There can still be many threads:

```text
Thread 1
Thread 2
Thread 3
Thread 4
```

Synchronization only controls access to the synchronized section associated with the relevant lock.

So:

```text
Multiple threads
      ↓
Still exist
      ↓
Compete for lock
      ↓
One gets lock
      ↓
Others wait
```

---

# 19. Thread-Safe

Your notes state:

> Synchronization is also called Thread Safe.

A more precise way to understand this is:

> **Using synchronization appropriately can make access to shared mutable data thread-safe.**

**Thread-safe** means that code behaves correctly when multiple threads use it concurrently, according to its intended design.

For example:

```text
Multiple threads
       ↓
Shared bank account
       ↓
Controlled access
       ↓
Correct result
```

Synchronization is one important technique for achieving thread safety.

---

# 20. What Is a Shared Resource?

A shared resource is something that multiple threads can access.

Examples:

```text
Bank balance
Ticket count
Inventory quantity
Shared object
Shared file
Counter
```

For example:

```text
Bank balance = ₹10,000
       ↑
       |
Thread 1
Thread 2
Thread 3
```

All threads may access the same balance.

That is where synchronization becomes important.

---

# 21. Race Condition

A **race condition** can occur when multiple threads access shared mutable data without appropriate coordination, and the result depends on the timing/order of their execution.

Example:

```text
Initial balance = ₹10,000

Thread 1 → withdraw ₹7,000
Thread 2 → withdraw ₹7,000
```

If both read the same old balance before either update is completed, the application can produce an incorrect result.

Synchronization can prevent this kind of unsafe concurrent access when applied to the correct critical section.

---

# 22. Critical Section

The part of the program that accesses or modifies shared data and must be protected from conflicting concurrent execution is commonly called a **critical section**.

Example:

```java
synchronized void withdraw() {

    // critical operation

}
```

Conceptually:

```text
Shared data
    ↓
Critical operation
    ↓
Protect with synchronization
```

---

# 23. ATM Analogy

Imagine an ATM system.

Two users somehow try to withdraw money from the same account simultaneously.

```text
User 1 → Withdraw ₹5,000
User 2 → Withdraw ₹5,000
```

The account balance is shared.

The withdrawal operation needs controlled access.

With synchronization:

```text
User 1
  ↓
Account lock
  ↓
Check balance
  ↓
Withdraw
  ↓
Update balance
  ↓
Release lock

User 2
  ↓
Gets lock
  ↓
Check updated balance
```

This is why synchronization is extremely important in banking-like systems.

---

# 24. Object Lock vs Thread

Do not confuse these two:

```text
Thread
 ↓
Does the work
```

and:

```text
Object lock
 ↓
Controls access
```

For example:

```text
Thread 1 ──────────→ wants lock
Thread 2 ──────────→ wants lock

             Object
               ↓
              LOCK
```

The lock belongs conceptually to the object/monitor being synchronized on; the thread temporarily owns that lock while executing the synchronized region.

---

# 25. The Complete Flow

For two threads using the same synchronized object:

```text
Thread 1
   ↓
Calls synchronized method
   ↓
Requests object's lock
   ↓
Gets lock
   ↓
Executes method
   ↓
Method completes
   ↓
Releases lock

Thread 2
   ↓
Was waiting
   ↓
Gets lock
   ↓
Executes method
   ↓
Method completes
   ↓
Releases lock
```

This is the fundamental synchronization flow.

---

# 26. Important Point — Same Object

Consider:

```java
Bank b = new Bank();

Thread t1 = new Thread(() -> b.display());
Thread t2 = new Thread(() -> b.display());
```

Both threads use:

```text
same object → b
```

Therefore they compete for the same object's monitor when calling the synchronized instance method.

But if two different objects are used:

```java
Bank b1 = new Bank();
Bank b2 = new Bank();
```

then:

```text
b1 → its own monitor
b2 → its own monitor
```

They are different objects with different locks.

This is an important concept.

---

# 27. Common Confusion

### Confusion 1: "synchronized means the whole program becomes single-threaded."

❌ Incorrect.

Only the relevant synchronized access is controlled.

Other threads can continue doing other work that does not require that same lock.

---

### Confusion 2: "Thread 1 always executes first."

❌ Incorrect.

Thread scheduling order cannot generally be guaranteed merely because:

```java
t1.start();
t2.start();
```

was written in that order.

---

### Confusion 3: "Creating a synchronized method automatically makes every operation in the application safe."

❌ Incorrect.

Synchronization must protect the **right shared state and critical sections**.

---

### Confusion 4: "Every thread has its own copy of the object."

❌ Not necessarily.

Multiple threads can reference the same object:

```text
        Bank b
          ↓
   ┌─────────────┐
   │ Bank object │
   └─────────────┘
       ↑       ↑
       │       │
     t1        t2
```

That is precisely where synchronization can matter.

---

# 28. Important Rules

Remember these rules:

1. Java objects have an associated monitor/lock used by synchronization.
2. `synchronized` is a Java keyword.
3. A synchronized instance method uses the object's monitor.
4. Multiple threads can exist at the same time.
5. Multiple threads can attempt to access the same synchronized method.
6. For the same object monitor, only one thread can hold the lock at a time.
7. Other threads attempting to acquire that lock must wait.
8. After the current thread exits the synchronized method, the lock becomes available.
9. Synchronization is primarily useful when threads share mutable state.
10. Synchronization is one technique for achieving thread safety.
11. Thread scheduling order should not be assumed.
12. Daemon status and synchronization are completely different concepts.

---

# 29. Memory Trick

Remember:

```text
SYNCHRONIZED
      ↓
SAME OBJECT
      ↓
SAME LOCK
      ↓
ONE THREAD AT A TIME
      ↓
OTHERS WAIT
      ↓
LOCK RELEASED
      ↓
NEXT THREAD
```

The easiest real-world memory trick is:

> **One bathroom → one key → one person at a time.**

```text
Bathroom = synchronized resource
Key      = object lock
Person   = thread
Waiting  = other threads
```

---

# 30. Interview Understanding

**Synchronization in Java** is a mechanism used to control concurrent access to shared resources. Java objects have associated monitors/locks, and the `synchronized` keyword can be used to require a thread to acquire the relevant lock before entering a synchronized method or block. When multiple threads call a synchronized instance method on the same object, only one thread can hold that object's lock and execute the synchronized method at a time; other threads attempting to acquire the same lock wait. This controlled access helps prevent race conditions and is an important technique for achieving thread safety.

### 🔑 Lifetime Memory

```text
Multiple Threads
       ↓
Same Shared Object/Data
       ↓
Possible Race Condition
       ↓
Use synchronized
       ↓
Object Lock / Monitor
       ↓
One Thread Gets Lock
       ↓
Thread Executes Critical Section
       ↓
Other Threads Wait
       ↓
Thread Completes
       ↓
Lock Released
       ↓
Another Thread Gets Lock
       ↓
Controlled Access
       ↓
Safer Concurrent Execution
       ↓
Thread Safety
```

**The one sentence to remember forever:**

> **Synchronization is like a single key to a shared room: many threads may want to enter, but for the same lock, only one thread can enter the synchronized section at a time while the others wait.**
