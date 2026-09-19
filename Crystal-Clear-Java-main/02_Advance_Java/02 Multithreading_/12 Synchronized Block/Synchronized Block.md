# 30. Synchronized Block

A **synchronized block** is used when we want to make **only a particular part of a method/thread-safe**, instead of locking the entire method.

This is especially useful when a method contains several activities, but **only one activity actually needs synchronization**.

---

## 30.1 TicketNest Example

Imagine an online movie-ticket application called **TicketNest**.

Three users are using the application at the same time:

```text
Spider Man
Ant Man
Iron Man
```

Each user needs to perform three activities:

```text
1. View movie options
2. Select tickets
3. Make payment
```

Now the important question is:

**Should all three activities be restricted to one thread at a time?**

No.

Only **ticket selection** needs exclusive access in this example.

---

## 30.2 Three Activities

### Activity 1 — Viewing Movie Options

Suppose the application displays:

```text
Movie 1 → Avengers
Movie 2 → Spider-Man
Movie 3 → Iron Man
Movie 4 → Batman
```

Many users can view these options at the same time.

There is no need for one user to wait for another user just to look at movie names.

So:

```text
Spider Man → Viewing
Ant Man     → Viewing
Iron Man    → Viewing
```

can happen concurrently.

```text
Viewing
   ↓
Multiple threads allowed
```

---

### Activity 2 — Selecting Tickets

Now suppose there are only **2 seats remaining**.

```text
Seat A1
Seat A2
```

At the same moment:

```text
Spider Man → selects A1
Ant Man     → selects A1
```

If both threads access the seat-selection operation at the same time, they may both think that A1 is available.

That can create an incorrect booking.

Therefore, ticket selection must be protected.

```text
Selecting tickets
       ↓
Only one thread at a time
```

---

### Activity 3 — Making Payments

After selecting tickets, users can make payments.

For this example, payment processing is allowed to happen concurrently:

```text
Spider Man → Payment
Ant Man     → Payment
Iron Man    → Payment
```

So:

```text
Payment
   ↓
Multiple threads allowed
```

---

# 30.3 The Problem

Suppose we make the **entire method synchronized**:

```java
synchronized void bookTicket() {

    viewMovies();

    selectTickets();

    makePayment();
}
```

Now the entire method is protected by the lock.

That means:

```text
Thread 1
   ↓
viewMovies()
   ↓
selectTickets()
   ↓
makePayment()
   ↓
finish

Thread 2
   ↓
WAIT
```

Even though only ticket selection needs protection, the other activities also have to wait.

This unnecessarily reduces concurrency.

---

# 30.4 Why a Synchronized Block Is Better Here

Instead of synchronizing the entire method, we synchronize **only the ticket-selection section**.

Conceptually:

```text
viewMovies()
     ↓
No lock required
     ↓
Multiple threads

selectTickets()
     ↓
LOCK
     ↓
One thread at a time

makePayment()
     ↓
No lock required
     ↓
Multiple threads
```

This gives us a better balance between:

```text
Concurrency
     +
Safety
```

---

# 30.5 What Is a Synchronized Block?

A synchronized block is a specific block of code protected by a lock.

Basic syntax:

```java
synchronized(object) {

    // critical section

}
```

The important part is:

```java
synchronized(object)
```

It means that the block is synchronized using the lock associated with the specified object.

---

# 30.6 `synchronized(this)`

Your example uses:

```java
synchronized(this)
```

Here:

```text
synchronized
      ↓
Keyword for synchronization

this
      ↓
Current object
```

Therefore:

```java
synchronized(this) {

    // protected code

}
```

means that the block uses the **current object's monitor/lock**.

---

# 30.7 What Is `this`?

`this` is a Java keyword.

It represents the **current object**.

For example:

```java
class TicketNest {

    void book() {

        System.out.println(this);
    }
}
```

If an object calls:

```java
TicketNest t = new TicketNest();

t.book();
```

then inside `book()`:

```text
this
 ↓
t
```

So you can remember:

> **`this` means the current object.**

Therefore:

```java
synchronized(this)
```

means:

```text
Use the current object's lock.
```

---

# 30.8 Simple TicketNest Program

```java
class TicketNest {

    void bookTicket() {

        // Activity 1
        System.out.println(
            Thread.currentThread().getName()
            + " is viewing movie options"
        );

        // Activity 2
        synchronized(this) {

            System.out.println(
                Thread.currentThread().getName()
                + " is selecting tickets"
            );

            System.out.println(
                Thread.currentThread().getName()
                + " completed ticket selection"
            );
        }

        // Activity 3
        System.out.println(
            Thread.currentThread().getName()
            + " is making payment"
        );
    }
}
```

The important part is:

```java
synchronized(this) {

    // Ticket selection

}
```

Only this section is synchronized.

---

# 30.9 Creating the Three Threads

We can create one `TicketNest` object:

```java
TicketNest ticketNest = new TicketNest();
```

Then create three threads:

```java
Thread t1 = new Thread(() -> ticketNest.bookTicket());
Thread t2 = new Thread(() -> ticketNest.bookTicket());
Thread t3 = new Thread(() -> ticketNest.bookTicket());
```

Give them names:

```java
t1.setName("Spider Man");
t2.setName("Ant Man");
t3.setName("Iron Man");
```

Then start them:

```java
t1.start();
t2.start();
t3.start();
```

---

# 30.10 Complete Example

```java
class TicketNest {

    void bookTicket() {

        // Activity 1: Viewing movie options
        System.out.println(
            Thread.currentThread().getName()
            + " is viewing movie options"
        );


        // Activity 2: Selecting tickets
        synchronized(this) {

            System.out.println(
                Thread.currentThread().getName()
                + " is selecting tickets"
            );

            System.out.println(
                Thread.currentThread().getName()
                + " completed ticket selection"
            );
        }


        // Activity 3: Making payment
        System.out.println(
            Thread.currentThread().getName()
            + " is making payment"
        );
    }
}


public class TicketNestApp {

    public static void main(String[] args) {

        TicketNest ticketNest = new TicketNest();

        Thread t1 =
            new Thread(() -> ticketNest.bookTicket());

        Thread t2 =
            new Thread(() -> ticketNest.bookTicket());

        Thread t3 =
            new Thread(() -> ticketNest.bookTicket());


        t1.setName("Spider Man");
        t2.setName("Ant Man");
        t3.setName("Iron Man");


        t1.start();
        t2.start();
        t3.start();
    }
}
```

---

# 30.11 Understanding the Program

There is **one TicketNest object**:

```java
TicketNest ticketNest = new TicketNest();
```

Conceptually:

```text
             TicketNest Object
                    ↓
                  LOCK
```

All three threads use this same object:

```text
Spider Man ──→ ticketNest
Ant Man    ──→ ticketNest
Iron Man   ──→ ticketNest
```

Therefore, when they reach:

```java
synchronized(this)
```

they compete for the same object's lock.

---

# 30.12 Activity 1 — Viewing

The first activity is outside the synchronized block:

```java
System.out.println(
    Thread.currentThread().getName()
    + " is viewing movie options"
);
```

There is no synchronization here.

Therefore:

```text
Spider Man → Viewing
Ant Man    → Viewing
Iron Man   → Viewing
```

can overlap in execution.

Conceptually:

```text
Spider Man ─────────→ Viewing
Ant Man    ─────────→ Viewing
Iron Man   ─────────→ Viewing
```

---

# 30.13 Activity 2 — Selecting

Now the thread reaches:

```java
synchronized(this) {
```

Suppose Spider Man gets the lock first.

```text
Spider Man
    ↓
Gets TicketNest lock
    ↓
Selects ticket
```

Meanwhile:

```text
Ant Man
    ↓
Needs same lock
    ↓
Waits

Iron Man
    ↓
Needs same lock
    ↓
Waits
```

After Spider Man completes:

```text
Spider Man
    ↓
Leaves synchronized block
    ↓
Lock released
```

Then another thread can acquire the lock.

---

# 30.14 Activity 3 — Payment

After leaving:

```java
synchronized(this) {
    ...
}
```

the thread reaches payment:

```java
System.out.println(
    Thread.currentThread().getName()
    + " is making payment"
);
```

Payment is outside the synchronized block.

Therefore other threads do not have to wait for this block's lock merely because one thread is making payment.

Conceptually:

```text
Spider Man → Payment
Ant Man    → Payment
Iron Man   → Payment
```

can execute concurrently.

---

# 30.15 The Big Difference

### Synchronized Method

```java
synchronized void bookTicket() {

    viewing();

    selecting();

    payment();
}
```

Entire method is protected.

```text
VIEWING
   ↓
LOCKED

SELECTING
   ↓
LOCKED

PAYMENT
   ↓
LOCKED
```

---

### Synchronized Block

```java
void bookTicket() {

    viewing();

    synchronized(this) {

        selecting();

    }

    payment();
}
```

Only the required part is protected.

```text
VIEWING
   ↓
CONCURRENT

SELECTING
   ↓
LOCKED

PAYMENT
   ↓
CONCURRENT
```

This is the central purpose of a synchronized block.

---

# 30.16 Why Not Synchronize Everything?

Imagine 100 users are viewing movies.

There is no reason for:

```text
User 1
User 2
User 3
...
User 100
```

to wait one by one just to read movie options.

Similarly, if the payment operation is designed to support concurrent processing, unnecessarily locking it would reduce concurrency.

We should protect the **critical section**, not automatically the entire method.

---

# 30.17 The Complete Execution Picture

```text
                 TicketNest Object
                       ↓
                      LOCK
                       ↓
      ┌────────────────┼────────────────┐
      ↓                ↓                ↓
 Spider Man         Ant Man          Iron Man
      ↓                ↓                ↓
   Viewing          Viewing          Viewing
      ↓                ↓                ↓
   Concurrent       Concurrent       Concurrent
      │                │                │
      └────────────────┼────────────────┘
                       ↓
              synchronized(this)
                       ↓
                One gets the lock
                       ↓
                 Selecting tickets
                       ↓
                 Lock released
                       ↓
                Another gets lock
                       ↓
                 Selecting tickets
                       ↓
                 Lock released
                       ↓
                Third gets lock
                       ↓
                 Selecting tickets
                       ↓
                 Lock released
                       ↓
                    Payment
                       ↓
                  Concurrent
```

---

# 30.18 Important Rule — Same Lock

The synchronized block:

```java
synchronized(this)
```

protects the block using the current object's lock.

Therefore, if multiple threads call the method on the **same object**, they compete for that same lock.

```text
Same object
    ↓
Same monitor
    ↓
Same synchronized(this)
    ↓
One thread at a time
```

---

# 30.19 Important Rule — Lock Is Released

When the thread finishes the synchronized block:

```java
synchronized(this) {

    // protected code

}
```

the monitor is released when execution leaves that block.

Then another eligible thread can acquire the lock.

So remember:

```text
Enter block
    ↓
Acquire lock
    ↓
Execute
    ↓
Leave block
    ↓
Release lock
```

---

# 30.20 Common Mistake — Synchronizing the Wrong Part

Suppose only ticket selection needs protection.

Do not unnecessarily write:

```java
synchronized(this) {

    viewing();

    selecting();

    payment();
}
```

because now all three activities are protected.

Instead:

```java
viewing();

synchronized(this) {

    selecting();

}

payment();
```

This protects only the required critical section.

---

# 30.21 Common Mistake — Thinking Everything Becomes Sequential

Incorrect:

> "Once I use a synchronized block, the whole application becomes single-threaded."

No.

Only threads trying to acquire the **same lock for that synchronized section** have to coordinate around that lock.

So:

```text
Viewing       → concurrent
Selecting     → one at a time
Payment       → concurrent
```

This is exactly why synchronized blocks are useful.

---

# 30.22 Common Mistake — Fixed Thread Order

Synchronization does not guarantee:

```text
Spider Man
   ↓
Ant Man
   ↓
Iron Man
```

every time.

The actual order of lock acquisition is not something you should assume.

For example, it could be:

```text
Ant Man
   ↓
Spider Man
   ↓
Iron Man
```

The important guarantee is:

```text
Selecting tickets
       ↓
One thread at a time
```

---

# 30.23 Real-World Examples

Synchronized blocks are useful when only a small critical operation needs protection.

Examples include:

```text
Movie ticket selection
Seat reservation
Bank balance update
Inventory update
Stock quantity update
Counter update
Shared collection modification
Order quantity update
```

For example:

```text
100 users viewing products
        ↓
Concurrent

2 users trying to buy the last item
        ↓
Protect stock update
        ↓
One at a time
```

---

# 30.24 Synchronized Method vs Synchronized Block

| Synchronized Method                           | Synchronized Block                         |
| --------------------------------------------- | ------------------------------------------ |
| Synchronizes the method                       | Synchronizes only selected code            |
| Larger protected area                         | Smaller protected area                     |
| Easy to write                                 | More precise                               |
| Can reduce concurrency unnecessarily          | Usually allows more concurrency            |
| Useful when the whole method needs protection | Useful when only one part needs protection |

Remember:

```text
Synchronized Method
       ↓
Protect whole method

Synchronized Block
       ↓
Protect required section
```

---

# 30.25 Memory Trick

Think about a **movie theatre**.

```text
Movie information screen
        ↓
Everyone can look
```

Then:

```text
Ticket counter
        ↓
Only one person can reserve a particular seat at a time
```

Then:

```text
Payment counters
        ↓
Multiple people can pay concurrently
```

Therefore:

```text
Viewing      → No lock
Ticket       → Lock
Payment      → No lock
```

That is a synchronized block.

---

# 30.26 Interview Understanding

A **synchronized block** is used when only a specific section of code needs synchronization. Instead of locking the entire method, Java allows us to synchronize only the critical section using syntax such as `synchronized(this)`. In the TicketNest example, viewing movie options and making payments can execute concurrently, while ticket selection is protected because multiple threads should not modify the shared ticket-selection resource simultaneously. Since all three threads use the same TicketNest object, `synchronized(this)` uses that object's monitor, allowing only one thread at a time to execute the protected ticket-selection section.

---

# 30.27 The Three Activities — Final Picture

```text
                 TICKETNEST
                     ↓
          Three different activities
                     ↓
       ┌─────────────┼─────────────┐
       ↓             ↓             ↓
    Viewing       Selecting      Payment
       ↓             ↓             ↓
  Concurrent       LOCKED      Concurrent
       ↓             ↓             ↓
 Many threads    One thread    Many threads
                 at a time
```

---

# 30.28 Why This Is Better

The synchronized block gives us two benefits at the same time:

```text
             Synchronization
                    ↓
        ┌───────────┴───────────┐
        ↓                       ↓
    Safety                  Concurrency
        ↓                       ↓
Ticket selection          Viewing/payment
one at a time              can continue
```

We don't unnecessarily stop all threads.

---

# 30.29 One-Line Rule

> **Use a synchronized block when you need to protect only a particular critical section instead of the entire method.**

For your TicketNest example:

```text
Viewing
   ↓
Multiple threads

Selecting
   ↓
synchronized(this)
   ↓
One thread at a time

Payment
   ↓
Multiple threads
```

---

# 30.30 Lifetime Memory

```text
                 SYNCHRONIZED BLOCK
                         ↓
                 Multiple Threads
                         ↓
             Spider Man / Ant Man /
                  Iron Man
                         ↓
                  Same Object
                         ↓
                 TicketNest Object
                         ↓
                    Its Lock
                         ↓
        ┌────────────────┼────────────────┐
        ↓                ↓                ↓
     Viewing         Selecting         Payment
        ↓                ↓                ↓
   No synchronization  synchronized   No synchronization
        ↓                ↓                ↓
   Concurrent         One at a time   Concurrent
        ↓                ↓                ↓
        └────────────────┼────────────────┘
                         ↓
                  Better concurrency
                         +
                    Safe critical
                      operation
```

### 🔑 Remember Forever

> **A synchronized method locks the whole method; a synchronized block locks only the important part. In TicketNest, everyone can view movies and make payments concurrently, but ticket selection is protected so only one thread at a time performs that critical operation on the same object.**
